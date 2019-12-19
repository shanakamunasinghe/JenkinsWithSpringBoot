package com.creative.web.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.*;


public class JenkinsAPIManager {

    public void getJenkinsStatusData() throws IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "11d60d3f8a414767b263341998105920f8");
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

        HttpResponse response = client.execute(new HttpGet("http://localhost:8080/api/json?pretty=true"));
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);

    }
    public void runJenkinsJob(String job) throws IOException {
        CredentialsProvider provider;
        provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "11d60d3f8a414767b263341998105920f8");
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

        HttpResponse response = client.execute(new HttpPost("http://localhost:8080/job/"+job+"/build?delay=0sec"));
        System.out.println(response.getStatusLine().getStatusCode());
    }
    
}
