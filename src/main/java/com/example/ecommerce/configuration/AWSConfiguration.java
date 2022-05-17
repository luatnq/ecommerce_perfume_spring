package com.example.ecommerce.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfiguration {
    @Value("${aws.access_key_id}")
    private String accessKeyId;

    @Value("${aws.secret_access_key}")
    private String secretAccessKey;

    @Value("${aws.s3.region}")
    private String region;

    @Bean
    public AmazonS3 getAmazonS3Cient() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("AKIARWBH4GY3FLTHRSGX", "dnPOe8efRCgS9lKboxA4K5Sg5dcucbNkWjUjH17c");
        // Get AmazonS3 client and return the s3Client object.
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .withRegion(region)
                .build();
//        return null;
    }
}
