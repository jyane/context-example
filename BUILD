load("@grpc_java//:java_grpc_library.bzl", "java_grpc_library")

java_binary(
    name = "example",
    main_class = "jp.jyane.grpc.example.Main",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = [
        ":helloworld_java_grpc",
        ":helloworld_java_proto",
        "@grpc_java//core",
        "@grpc_java//context",
        "@grpc_java//protobuf",
        "@grpc_java//stub",
        "@grpc_java//netty",
        "//third_party/grpc-services",
    ]
)

proto_library(
    name = "helloworld_proto",
    srcs = ["src/main/proto/helloworld.proto"],
)

java_proto_library(
    name = "helloworld_java_proto",
    deps = [":helloworld_proto"],
)

java_grpc_library(
    name = "helloworld_java_grpc",
    srcs = [":helloworld_proto"],
    deps = [":helloworld_java_proto"],
)
