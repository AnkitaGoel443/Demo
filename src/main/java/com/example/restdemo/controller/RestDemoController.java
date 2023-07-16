package com.example.restdemo.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caseStudy")
public class RestDemoController {

    private static AmazonSNSClient amazonSNSClient = null;
    private static String SNS_TOPIC_ARN = "arn:aws:sns:ap-southeast-2:548453444712:TestTopic";
    private static String EMAIL_SUBJECT = "Unsubscribe Email!!";
    private static String EMAIL_BODY = "Please click Here to unsubscribe from emails. http://localhost:3000/";

    @GetMapping ("/generateMassEmail")
    public String generateMassEmail(){
        amazonSNSClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
        amazonSNSClient.publish(SNS_TOPIC_ARN, EMAIL_BODY, EMAIL_SUBJECT);

        return "Success";
    }

    @GetMapping ("/generateEmailForUser/{email}")
    public String generateEmailForUser(String email){
        amazonSNSClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
        amazonSNSClient.publish(SNS_TOPIC_ARN, EMAIL_BODY, EMAIL_SUBJECT);

        return "Success";
    }
}
