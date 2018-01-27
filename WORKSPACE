workspace(name = "context_example")

http_archive(
    name = "grpc_java",
    strip_prefix = "grpc-java-1.9.0",
    urls = ["https://github.com/grpc/grpc-java/archive/v1.9.0.zip"],
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

maven_jar(
    name = "grpc_services",
    artifact = "io.grpc:grpc-services:1.9.0",
)
