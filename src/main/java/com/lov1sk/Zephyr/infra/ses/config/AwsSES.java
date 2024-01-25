package com.lov1sk.Zephyr.infra.ses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

/**
 * Classe de configuração, que o spring rodará antes de inicializar a aplicação
 */
@Configuration
public class AwsSES{
    /**
     * Pega credenciais do IAM para ter acesso ao 
     * serviço SES
     */
    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.accessKeyId}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        // Cria uma instancia para as credenciais da AWS IAM
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        /**
         * Retona uma instancia para o serviço SES
         */
        return AmazonSimpleEmailServiceClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsRegion)
                .build();
    }
}
