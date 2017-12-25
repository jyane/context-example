package jp.jyane.grpc.example;

import io.grpc.examples.helloworld.GreeterGrpc.GreeterImplBase;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder()
        .setMessage("name = " + request.getName() + ", id = " + Keys.CONTEXT_ID_KEY.get())
        .build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
