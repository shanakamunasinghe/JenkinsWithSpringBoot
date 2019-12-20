package com.creative.web.util;

import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.model.JenkinsAPITokenData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
    List<NameValuePair> formParams;
    ObjectMapper objectMapper ;
//    String jenkinsURL = "http://localhost:8080/";

    public JenkinsAPIManager(){
        formParams = new ArrayList<NameValuePair>();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "11be180ad7282a21ca74bc2c589257e6dd");
        provider.setCredentials(AuthScope.ANY, credentials);
        client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        objectMapper = new ObjectMapper();
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

        formParams.add(new BasicNameValuePair("json", "{}"));
        formParams.add(new BasicNameValuePair("Submit", "Yes"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/user/"+user+"/doDelete");
        httppost.setEntity(entity);

        HttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
    }

    public void createJenkinsUser(JenkinsUserDataDTO jenkinsUserDataDTO) throws IOException {


        formParams.add(new BasicNameValuePair("username", jenkinsUserDataDTO.getUserName()));
        formParams.add(new BasicNameValuePair("password1", jenkinsUserDataDTO.getPassword()));
        formParams.add(new BasicNameValuePair("password2", jenkinsUserDataDTO.getPassword()));
        formParams.add(new BasicNameValuePair("fullname", jenkinsUserDataDTO.getUserName()));
        formParams.add(new BasicNameValuePair("email", jenkinsUserDataDTO.getEmail()));

// Create Inner JSON Object
        JsonObject json = new JsonObject();
        json.addProperty("username", jenkinsUserDataDTO.getPassword());
        json.addProperty("password1", jenkinsUserDataDTO.getPassword());
        json.addProperty("$redact", "[\"password1\",\"password2\"]");
        json.addProperty("password2", jenkinsUserDataDTO.getPassword());
        json.addProperty("fullname", jenkinsUserDataDTO.getUserName());
        json.addProperty("email", jenkinsUserDataDTO.getEmail());
        System.out.println(json.toString());


        formParams.add(new BasicNameValuePair("json", json.toString()));
        formParams.add(new BasicNameValuePair("Submit", "Create User"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/createAccountByAdmin");
        httppost.setEntity(entity);

        HttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
    }

    public String generateJenkinsUserAPIToken(String userName) throws IOException {
        formParams.add(new BasicNameValuePair("newTokenName", ""));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/user/"+userName+"/descriptorByName/jenkins.security.ApiTokenProperty/generateNewToken");
        httppost.setEntity(entity);

        HttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());

        HttpEntity httpEntity = response.getEntity();
        Gson g = new Gson();
        //JenkinsAPITokenData myObject = g.fromJson(EntityUtils.toString(httpEntity, "UTF-8"),JenkinsAPITokenData.class);

        JenkinsAPITokenData myObject = objectMapper.readValue(httpEntity.getContent(), JenkinsAPITokenData.class);
        //String responseString = EntityUtils.toString(httpEntity, "UTF-8");
        String res = myObject.getData().getTokenValue();
        System.out.println("responseString  :"+res);
//        System.out.println("res   "+res);
        return res;
    }
}
