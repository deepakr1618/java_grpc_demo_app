package com.grpc.demo.client;

import com.grpc.demo.HelloRequest;
import com.grpc.demo.HelloResponse;
import com.grpc.demo.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest helloRequest = HelloRequest.newBuilder().setFirstName("Jon").setLastName("Doe").build();

        HelloResponse helloResponse = stub.hello(helloRequest);

        System.out.println("Server response is :: "+helloResponse.getGreeting());
    }
}
