package com.BeTek.Aerolinea_EveryOneFlies.ChatBot;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.*;

import io.opencensus.resource.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@Configuration
public class DialogflowConfig {

    @Bean
    public SessionsClient sessionsClient() throws IOException {

        String jsonUrl = "https://storage.googleapis.com/everyone_flies_bucket/everyoneflies-ewlv-bb71cf9941cb.json";

        try (InputStream inputStream = new URL(jsonUrl).openStream()){

            GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
            return SessionsClient.create(SessionsSettings.newBuilder()
                    .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                    .build());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
