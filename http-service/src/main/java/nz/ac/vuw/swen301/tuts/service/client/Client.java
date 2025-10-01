package nz.ac.vuw.swen301.tuts.service.client;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.sql.SQLOutput;

public class Client {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            String ret = httpClient.execute(new HttpGet("http://localhost:8080/odd?number=100"),
                    response -> {
                        String bodyAsString = EntityUtils.toString(response.getEntity());

                        return bodyAsString;
                    }
            );

            System.out.println(ret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
