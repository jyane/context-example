package jp.jyane.grpc.example;

import io.grpc.Context;
import io.grpc.Metadata;

public class Keys {
  public final static Metadata.Key<String> METADATA_ID_KEY =
      Metadata.Key.of("id", Metadata.ASCII_STRING_MARSHALLER);
  public final static Context.Key<String> CONTEXT_ID_KEY =
      Context.key("id");
}
