package com.creative.web.util;

import com.google.gson.JsonObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JenkinsAPIManager {
    CredentialsProvider provider = new BasicCredentialsProvider();
    HttpClient client;
    public JenkinsAPIManager(){

        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "11be180ad7282a21ca74bc2c589257e6dd");
        provider.setCredentials(AuthScope.ANY, credentials);
        client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
    }

    public void getJenkinsStatusData() throws IOException {


        HttpResponse response = client.execute(new HttpGet("http://localhost:8080/api/json?pretty=true"));
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);

    }
    public void runJenkinsJob(String job) throws IOException {


        HttpResponse response = client.execute(new HttpPost("http://localhost:8080/job/"+job+"/build?delay=0sec"));
        System.out.println(response.getStatusLine().getStatusCode());
    }

    public void deleteJenkinsUser(String user) throws IOException {

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("json", "{}"));
        formparams.add(new BasicNameValuePair("Submit", "Yes"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/user/"+user+"/doDelete");
        httppost.setEntity(entity);

        HttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
    }

    public void createJenkinsUser() throws IOException {

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("username", "isuru"));
        formparams.add(new BasicNameValuePair("password1", "12"));
        formparams.add(new BasicNameValuePair("password2", "12"));
        formparams.add(new BasicNameValuePair("fullname", "isuru"));
        formparams.add(new BasicNameValuePair("email", "isuru@gmail.com"));

// Create Inner JSON Object
        JsonObject json = new JsonObject();
        json.addProperty("username", "isuru");
        json.addProperty("password1", "12");
        json.addProperty("$redact", "[\"password1\",\"password2\"]");
        json.addProperty("password2", "12");
        json.addProperty("fullname", "isuru");
        json.addProperty("email", "isuru@gmail.com");
        System.out.println(json.toString());


        formparams.add(new BasicNameValuePair("json", json.toString()));
        formparams.add(new BasicNameValuePair("Submit", "Create User"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/createAccountByAdmin");
        httppost.setEntity(entity);

        HttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}
