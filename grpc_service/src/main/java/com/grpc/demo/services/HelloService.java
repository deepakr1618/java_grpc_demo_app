package com.grpc.demo.services;

import com.grpc.demo.HelloRequest;
import com.grpc.demo.HelloResponse;
import com.grpc.demo.HelloServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("First name received :: "+request.getFirstName());
        System.out.println("Last name received :: "+request.getLastName());
        HelloResponse response = HelloResponse.newBuilder().setGreeting(String.format("Hello %s, the server greets you!",request.getFirstName())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
