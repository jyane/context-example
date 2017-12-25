package jp.jyane.grpc.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getName());

  private Server server;

  private void start() throws IOException {
    server = ServerBuilder.forPort(8080)
        .addService(ProtoReflectionService.newInstance())
        .addService(new GreeterImpl()).intercept(new ContextInterceptor())
        .build()
        .start();
    logger.info("server start");
    Runtime.getRuntime().addShutdownHook(new Thread(Main.this::stop));
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  private void awaitTermination() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  private void shutdownNow() {
    if (server != null) {
      server.shutdownNow();
    }
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.start();

    try {
      main.awaitTermination();
    } catch (InterruptedException e) {
      main.shutdownNow();
    }
  }
}
