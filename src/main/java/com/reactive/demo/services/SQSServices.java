package com.reactive.demo.services;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SQSServices {

    public SQSServices() {
    }

    public void saveSQS(String message) {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("AKIAIE5226GEXHNRGWKQ", "1AvUAU4YJoNrS2FlShnJLpxNyLgGA4bUuUilWbgC")
                )
        ).withRegion("us-east-2").build();

        final SendMessageRequest sendMessageRequest = new SendMessageRequest("https://sqs.us-east-2.amazonaws.com/327582245832/pruebas-colas-uno",message);
        amazonSQS.sendMessage(sendMessageRequest);
        amazonSQS.shutdown();
    }
}
