package com.creative.web.util;

import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.model.JenkinsAPITokenData;
import com.creative.web.service.JenkinsCreateConfigFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class JenkinsAPIManager {
    CredentialsProvider provider = new BasicCredentialsProvider();
    CloseableHttpClient client;
    List<NameValuePair> formParams;
    ObjectMapper objectMapper ;
    JenkinsCreateConfigFile jenkinsCreateConfigFile = new JenkinsCreateConfigFile();
//    String jenkinsURL = "http://localhost:8080/";

    public JenkinsAPIManager(){
        formParams = new ArrayList<NameValuePair>();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("shanaka", "110e01148408450d02387432110acdb775");
        provider.setCredentials(AuthScope.ANY, credentials);
        client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        objectMapper = new ObjectMapper();
    }

    public void getJenkinsStatusData() throws IOException {
        CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:8080/api/json?pretty=true"));
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);
        response.close();
        client.close();
    }
    public void runJenkinsJob(String job) throws IOException {
        CloseableHttpResponse response = client.execute(new HttpPost("http://localhost:8080/job/"+job+"/build?delay=0sec"));
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void deleteJenkinsUser(String user) throws IOException {

        formParams.add(new BasicNameValuePair("json", "{}"));
        formParams.add(new BasicNameValuePair("Submit", "Yes"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/user/"+user+"/doDelete");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void createJenkinsUser(JenkinsUserDataDTO jenkinsUserDataDTO) throws IOException {


        formParams.add(new BasicNameValuePair("username", jenkinsUserDataDTO.getUserName()));
        formParams.add(new BasicNameValuePair("password1", jenkinsUserDataDTO.getPassword()));
        formParams.add(new BasicNameValuePair("password2", jenkinsUserDataDTO.getPassword()));
        formParams.add(new BasicNameValuePair("fullname", jenkinsUserDataDTO.getUserName()));
        formParams.add(new BasicNameValuePair("email", jenkinsUserDataDTO.getEmail()));

// Create Inner JSON Object
        JsonObject json = new JsonObject();
        json.addProperty("username", jenkinsUserDataDTO.getUserName());
        json.addProperty("password1", jenkinsUserDataDTO.getPassword());
        String passwordLabels[] = {"password1","password2"};
        JsonArray data = new JsonArray();
        Stream.of(passwordLabels)
                .forEach(data::add);
        json.add("$redact", data);
        json.addProperty("password2", jenkinsUserDataDTO.getPassword());
        json.addProperty("fullname", jenkinsUserDataDTO.getUserName());
        json.addProperty("email", jenkinsUserDataDTO.getEmail());
        System.out.println(json.toString());


        formParams.add(new BasicNameValuePair("json", json.toString()));
        formParams.add(new BasicNameValuePair("Submit", "Create User"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/createAccountByAdmin");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine());
        response.close();
        client.close();
    }

    public String generateJenkinsUserAPIToken(String userName) throws IOException {
        formParams.add(new BasicNameValuePair("newTokenName", ""));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/user/"+userName+"/descriptorByName/jenkins.security.ApiTokenProperty/generateNewToken");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());

        HttpEntity httpEntity = response.getEntity();
        JenkinsAPITokenData myObject = objectMapper.readValue(httpEntity.getContent(), JenkinsAPITokenData.class);
        String res = myObject.getData().getTokenValue();
        System.out.println("responseString  :"+res);
        response.close();
        client.close();
        return res;
    }

    public void createJenkinsRole(String roleName,String type) throws IOException {
        String permissionIds= "hudson.model.Item.Discover,hudson.model.Item.ExtendedRead";
        formParams.add(new BasicNameValuePair("type", type));
        formParams.add(new BasicNameValuePair("roleName", roleName));
        formParams.add(new BasicNameValuePair("permissionIds", permissionIds));
        formParams.add(new BasicNameValuePair("overwrite", "true"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/addRole");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine());
        response.close();
        client.close();
    }

    public void deleteJenkinsRole(String roleName,String type) throws IOException{
        formParams.add(new BasicNameValuePair("type", type));
        formParams.add(new BasicNameValuePair("roleName", roleName));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/removeRoles");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void assignRole(String roleName,String type,String username) throws IOException {

        formParams.add(new BasicNameValuePair("type", type));
        formParams.add(new BasicNameValuePair("roleName", roleName));
        formParams.add(new BasicNameValuePair("username", username));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/assignRole");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void deleteUserFromAllRoles(String roleName,String type,String username) throws IOException {

        formParams.add(new BasicNameValuePair("type", type));
        formParams.add(new BasicNameValuePair("roleName", roleName));
        formParams.add(new BasicNameValuePair("username", username));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/deleteSid");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void unassignedUserRole(String roleName,String type,String username) throws IOException {
        formParams.add(new BasicNameValuePair("type", type));
        formParams.add(new BasicNameValuePair("roleName", roleName));
        formParams.add(new BasicNameValuePair("username", username));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/unassignRole");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void getAllRoles() throws IOException {
        CloseableHttpResponse response = client.execute(new HttpGet("localhost:8080/role-strategy/strategy/getAllRoles"));
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);
        response.close();
        client.close();
    }

    public void getParticularRoles(String type) throws IOException {
        CloseableHttpResponse response = client.execute(new HttpGet("localhost:8080/role-strategy/strategy/getAllRoles?type="+type));
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);
        response.close();
        client.close();
    }



    public void createJenkinsJob(String jobName) throws IOException {
//        curl -s -XPOST 'http://example.com/createItem?name=yourJobName' -u username:API_TOKEN --data-binary @mylocalconfig.xml -H "Content-Type:text/xml"
        //Define a postRequest request
        HttpPost postRequest = new HttpPost("http://localhost:8080/createItem?name="+jobName);
        String file = jenkinsCreateConfigFile.createXML();
        //Set the API media type in http content-type header
        postRequest.addHeader("content-type", "application/xml");

        //Set the request post body
        StringEntity userEntity = new StringEntity(file);
        postRequest.setEntity(userEntity);
        CloseableHttpResponse response = client.execute(postRequest);
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);
        response.close();
        client.close();
    }

}
