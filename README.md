# grpc-java context example

## Run Server

```
bazel build //:example
./bazel-bin/example
```

## Call the method

```
$ grpc_cli call localhost:8080 Greeter.SayHello 'name: "uuu"' --metadata=id:f
connecting to localhost:8080
Sending client initial metadata:
id : f
message: "name = uuu, id = f"
```
