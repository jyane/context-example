package jp.jyane.grpc.example;

import static jp.jyane.grpc.example.Keys.CONTEXT_ID_KEY;
import static jp.jyane.grpc.example.Keys.METADATA_ID_KEY;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

public class ContextInterceptor implements ServerInterceptor {

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(
      ServerCall<ReqT, RespT> call,
      Metadata headers,
      ServerCallHandler<ReqT, RespT> next) {
    String id = headers.get(METADATA_ID_KEY);
    Context ctx = Context.current().withValue(CONTEXT_ID_KEY, id);

    return Contexts.interceptCall(ctx, call, headers, next);
  }
}
