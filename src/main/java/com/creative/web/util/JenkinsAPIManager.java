package com.creative.web.util;

import com.creative.web.dto.JenkinsGlobalRoleDataDTO;
import com.creative.web.dto.JenkinsItemRoleDataDTO;
import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.model.*;
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

import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class JenkinsAPIManager {
    CredentialsProvider provider = new BasicCredentialsProvider();
    CloseableHttpClient client;
    List<NameValuePair> formParams;
    ObjectMapper objectMapper;
    JenkinsCreateConfigFile jenkinsCreateConfigFile = new JenkinsCreateConfigFile();
//    String jenkinsURL = "http://localhost:8080/";

    public JenkinsAPIManager() {
        formParams = new ArrayList<NameValuePair>();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("shanaka", "110e01148408450d02387432110acdb775");
        provider.setCredentials(AuthScope.ANY, credentials);
        client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        objectMapper = new ObjectMapper();
    }

    // Jenkins get all the job data <---

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

    // Jenkins Build Job <---

    public void runJenkinsJob(String job) throws IOException {
        CloseableHttpResponse response = client.execute(new HttpPost("http://localhost:8080/job/" + job + "/build?delay=0sec"));
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    // Jenkins User <--

    public void deleteJenkinsUser(String user) throws IOException {

        formParams.add(new BasicNameValuePair("json", "{}"));
        formParams.add(new BasicNameValuePair("Submit", "Yes"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/securityRealm/user/" + user + "/doDelete");
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
        String passwordLabels[] = {"password1", "password2"};
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
        HttpPost httppost = new HttpPost("http://localhost:8080/user/" + userName + "/descriptorByName/jenkins.security.ApiTokenProperty/generateNewToken");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());

        HttpEntity httpEntity = response.getEntity();
        JenkinsAPITokenData myObject = objectMapper.readValue(httpEntity.getContent(), JenkinsAPITokenData.class);
        String res = myObject.getData().getTokenValue();
        System.out.println("responseString  :" + res);
        response.close();
        client.close();
        return res;
    }

    // Jenkins Roles <----

// these are the type that are available in Jenkins globalRoles, projectRoles, slaveRoles
    /* These are the permission code that used in the Jenkins
    ** ------------------------
    [hudson.model.Hudson.Administer][hudson.model.Hudson.Read][com.cloudbees.plugins.credentials.CredentialsProvider.Create][com.cloudbees.plugins.credentials.CredentialsProvider.Delete]
    [com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains][com.cloudbees.plugins.credentials.CredentialsProvider.Update]
    [com.cloudbees.plugins.credentials.CredentialsProvider.View][hudson.model.Computer.Build][hudson.model.Computer.Configure][hudson.model.Computer.Connect]
    [hudson.model.Computer.Create][hudson.model.Computer.Delete][hudson.model.Computer.Disconnect][hudson.model.Computer.Provision]
    [hudson.model.Item.Build][hudson.model.Item.Cancel][hudson.model.Item.Configure][hudson.model.Item.Create][hudson.model.Item.Delete]
    [hudson.model.Item.Discover][hudson.model.Item.Move][hudson.model.Item.Read][hudson.model.Item.Workspace][hudson.model.Run.Delete]
    [hudson.model.Run.Replay][hudson.model.Run.Update][hudson.model.View.Configure][hudson.model.View.Create]
    [hudson.model.View.Delete][hudson.model.View.Read][hudson.scm.SCM.Tag]
    ** ----------------------------
    * */

    //    create global rule
    public void createJenkinsGlobalRole(JenkinsGlobalRoleDataDTO jenkinsGlobalRoleData) throws IOException {
        StringBuilder permissionIds = new StringBuilder();
        formParams.add(new BasicNameValuePair("type", "globalRoles"));
        formParams.add(new BasicNameValuePair("roleName", jenkinsGlobalRoleData.getName()));
        if(jenkinsGlobalRoleData.isOverallAdminister()){
            permissionIds.append("hudson.model.Hudson.Administer,");
        }
        if(jenkinsGlobalRoleData.isOverallRead()){
            permissionIds.append("hudson.model.Hudson.Read,");
        }
        if(jenkinsGlobalRoleData.isCredentialsCreate()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.Create,");
        }
        if(jenkinsGlobalRoleData.isCredentialsDelete()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.Delete,");
        }
        if(jenkinsGlobalRoleData.isCredentialsManageDomains()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains,");
        }
        if(jenkinsGlobalRoleData.isCredentialsUpdate()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.Update,");
        }
        if(jenkinsGlobalRoleData.isCredentialsView()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.View,");
        }
        if(jenkinsGlobalRoleData.isAgentBuild()){
            permissionIds.append("hudson.model.Computer.Build,");
        }
        if(jenkinsGlobalRoleData.isAgentConfigure()){
            permissionIds.append("hudson.model.Computer.Configure,");
        }
        if(jenkinsGlobalRoleData.isAgentConnect()){
            permissionIds.append("hudson.model.Computer.Connect,");
        }
        if(jenkinsGlobalRoleData.isAgentCreate()){
            permissionIds.append("hudson.model.Computer.Create,");
        }
        if(jenkinsGlobalRoleData.isAgentDelete()){
            permissionIds.append("hudson.model.Computer.Delete,");
        }
        if(jenkinsGlobalRoleData.isAgentDisconnect()){
            permissionIds.append("hudson.model.Computer.Disconnect,");
        }
        if(jenkinsGlobalRoleData.isAgentProvision()){
            permissionIds.append("hudson.model.Computer.Provision,");
        }
        if(jenkinsGlobalRoleData.isJobBuild()){
            permissionIds.append("hudson.model.Item.Build,");
        }
        if(jenkinsGlobalRoleData.isJobCancel()){
            permissionIds.append("hudson.model.Item.Cancel,");
        }
        if(jenkinsGlobalRoleData.isJobConfigure()){
            permissionIds.append("hudson.model.Item.Configure,");
        }
        if(jenkinsGlobalRoleData.isJobCreate()) {
            permissionIds.append("hudson.model.Item.Create,");
        }
        if(jenkinsGlobalRoleData.isJobDelete()){
            permissionIds.append("hudson.model.Item.Delete,");
        }
        if(jenkinsGlobalRoleData.isJobDiscover()){
            permissionIds.append("hudson.model.Item.Discover,");
        }
        if(jenkinsGlobalRoleData.isJobMove()){
            permissionIds.append("hudson.model.Item.Move,");
        }
        if(jenkinsGlobalRoleData.isJobRead()){
            permissionIds.append("hudson.model.Item.Read,");
        }
        if(jenkinsGlobalRoleData.isJobWorkSpace()){
            permissionIds.append("hudson.model.Item.Workspace,");
        }
        if(jenkinsGlobalRoleData.isRunDelete()){
            permissionIds.append("hudson.model.Run.Delete,");
        }
        if(jenkinsGlobalRoleData.isRunReplay()){
            permissionIds.append("hudson.model.Run.Replay,");
        }
        if(jenkinsGlobalRoleData.isRunUpdate()){
            permissionIds.append("hudson.model.Run.Update,");
        }
        if(jenkinsGlobalRoleData.isViewConfigure()){
            permissionIds.append("hudson.model.View.Configure,");
        }
        if(jenkinsGlobalRoleData.isViewCreate()){
            permissionIds.append("hudson.model.View.Create,");
        }
        if(jenkinsGlobalRoleData.isViewDelete()){
            permissionIds.append("hudson.model.View.Delete,");
        }
        if(jenkinsGlobalRoleData.isViewRead()){
            permissionIds.append("hudson.model.View.Read,");
        }
        if(jenkinsGlobalRoleData.isScmTag()){
            permissionIds.append("hudson.scm.SCM.Tag,");
        }
        if(jenkinsGlobalRoleData.isLockResReserve()){
            permissionIds.append("org.jenkins.plugins.lockableresources.LockableResourcesManager.Reserve,");
        }
        if(jenkinsGlobalRoleData.isLockResUnlock()){
            permissionIds.append("org.jenkins.plugins.lockableresources.LockableResourcesManager.Unlock,");
        }
        if(jenkinsGlobalRoleData.isLockResView()){
            permissionIds.append("org.jenkins.plugins.lockableresources.LockableResourcesManager.View,");
        }

        String permissionStr = permissionIds.toString();
        formParams.add(new BasicNameValuePair("permissionIds", permissionStr));
        formParams.add(new BasicNameValuePair("overwrite", "true"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/addRole");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine());
        response.close();
        client.close();
    }

    // create item rule
    public void createJenkinsItemRole(JenkinsItemRoleDataDTO jenkinsItemRoleData) throws IOException {
        StringBuilder permissionIds = new StringBuilder();

        formParams.add(new BasicNameValuePair("type", "projectRoles"));
        formParams.add(new BasicNameValuePair("roleName", jenkinsItemRoleData.getName()));
        formParams.add(new BasicNameValuePair("pattern",jenkinsItemRoleData.getPattern()));

        if(jenkinsItemRoleData.isCredentialsCreate()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.Create,");
        }
        if(jenkinsItemRoleData.isCredentialsDelete()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.Delete,");
        }
        if(jenkinsItemRoleData.isCredentialsManageDomains()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains,");
        }
        if(jenkinsItemRoleData.isCredentialsUpdate()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.Update,");
        }
        if(jenkinsItemRoleData.isCredentialsView()){
            permissionIds.append("com.cloudbees.plugins.credentials.CredentialsProvider.View,");
        }
        if(jenkinsItemRoleData.isJobBuild()){
            permissionIds.append("hudson.model.Item.Build,");
        }
        if(jenkinsItemRoleData.isJobCancel()){
            permissionIds.append("hudson.model.Item.Cancel,");
        }
        if(jenkinsItemRoleData.isJobConfigure()){
            permissionIds.append("hudson.model.Item.Configure,");
        }
        if(jenkinsItemRoleData.isJobCreate()) {
            permissionIds.append("hudson.model.Item.Create,");
        }
        if(jenkinsItemRoleData.isJobDelete()){
            permissionIds.append("hudson.model.Item.Delete,");
        }
        if(jenkinsItemRoleData.isJobDiscover()){
            permissionIds.append("hudson.model.Item.Discover,");
        }
        if(jenkinsItemRoleData.isJobMove()){
            permissionIds.append("hudson.model.Item.Move,");
        }
        if(jenkinsItemRoleData.isJobRead()){
            permissionIds.append("hudson.model.Item.Read,");
        }
        if(jenkinsItemRoleData.isJobWorkSpace()){
            permissionIds.append("hudson.model.Item.Workspace,");
        }
        if(jenkinsItemRoleData.isRunDelete()){
            permissionIds.append("hudson.model.Run.Delete,");
        }
        if(jenkinsItemRoleData.isRunReplay()){
            permissionIds.append("hudson.model.Run.Replay,");
        }
        if(jenkinsItemRoleData.isRunUpdate()){
            permissionIds.append("hudson.model.Run.Update,");
        }
        if(jenkinsItemRoleData.isScmTag()){
            permissionIds.append("hudson.scm.SCM.Tag,");
        }
        if(jenkinsItemRoleData.isLockResReserve()){
            permissionIds.append("org.jenkins.plugins.lockableresources.LockableResourcesManager.Reserve,");
        }
        if(jenkinsItemRoleData.isLockResUnlock()){
            permissionIds.append("org.jenkins.plugins.lockableresources.LockableResourcesManager.Unlock,");
        }
        if(jenkinsItemRoleData.isLockResView()){
            permissionIds.append("org.jenkins.plugins.lockableresources.LockableResourcesManager.View,");
        }


        String permissionStr = permissionIds.toString();
        formParams.add(new BasicNameValuePair("permissionIds", permissionStr));
        formParams.add(new BasicNameValuePair("overwrite", "true"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/addRole");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine());
        response.close();
        client.close();
    }

    public void deleteJenkinsRole(String roleName, String type) throws IOException {
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

    public void assignRole(String roleName, String type, String username) throws IOException {

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

    public void deleteUserFromAllRoles(String type, String username) throws IOException {

        formParams.add(new BasicNameValuePair("type", type));
        formParams.add(new BasicNameValuePair("username", username));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost httppost = new HttpPost("http://localhost:8080/role-strategy/strategy/deleteSid");
        httppost.setEntity(entity);

        CloseableHttpResponse response = client.execute(httppost);
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
        client.close();
    }

    public void unassignedUserRole(String roleName, String type, String username) throws IOException {
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
        CloseableHttpResponse response = client.execute(new HttpGet("localhost:8080/role-strategy/strategy/getAllRoles?type=" + type));
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        System.out.println(content);
        response.close();
        client.close();
    }

    // Jenkins Job creation <--

    public void createJenkinsJob(String jobName) throws IOException {
        //Define a postRequest request
        HttpPost postRequest = new HttpPost("http://localhost:8080/createItem?name=" + jobName);
        JenkinsJobXMLData jenkinsJobXMLData = new JenkinsJobXMLData();
        // --- make 6 times -------------
        JenkinsJobXMLPropertiesData jenkinsJobXMLPropertiesData = new JenkinsJobXMLPropertiesData();
        JenkinsJobXMLBuilderData jenkinsJobXMLBuilderData = new JenkinsJobXMLBuilderData();
        JenkinsJobXMLBuilderWrapperData jenkinsJobXMLBuilderWrapperData = new JenkinsJobXMLBuilderWrapperData();
        JenkinsJobXMLSCMData jenkinsJobXMLSCMData = new JenkinsJobXMLSCMData();
        JenkinsJobXMLPublisherData jenkinsJobXMLPublisherData = new JenkinsJobXMLPublisherData();
        JenkinsJobXMLTiggersData jenkinsJobXMLTiggersData = new JenkinsJobXMLTiggersData();

        jenkinsJobXMLPropertiesData.setStatus("Active");
        jenkinsJobXMLPropertiesData.setProjectUrl("https://github.com/tejasgawali4/SpringBoot.git");
        jenkinsJobXMLPropertiesData.setDisplayName("Spring Boot Repo");

        jenkinsJobXMLBuilderData.setStatus("Active");
        jenkinsJobXMLBuilderData.setType("Maven");

        jenkinsJobXMLBuilderWrapperData.setStatus("Active");
        jenkinsJobXMLBuilderWrapperData.setOption("clearDir");

        jenkinsJobXMLSCMData.setStatus("Active");
        jenkinsJobXMLSCMData.setBranches("*/master");
        jenkinsJobXMLSCMData.setUserRemoteConfigUrl("https://github.com/tejasgawali4/SpringBoot.git");

        jenkinsJobXMLPublisherData.setStatus("Active");
        jenkinsJobXMLPublisherData.setType("tomcat8");

        jenkinsJobXMLTiggersData.setStatus("Active");
        jenkinsJobXMLTiggersData.setScmTriggerSpec("GitHubPushTrigger");



        jenkinsJobXMLData.setJenkinsJobXMLPropertiesData(jenkinsJobXMLPropertiesData);
        jenkinsJobXMLData.setJenkinsJobXMLBuilderData(jenkinsJobXMLBuilderData);
        jenkinsJobXMLData.setJenkinsJobXMLBuilderWrapperData(jenkinsJobXMLBuilderWrapperData);
        jenkinsJobXMLData.setJenkinsJobXMLSCMData(jenkinsJobXMLSCMData);
        jenkinsJobXMLData.setJenkinsJobXMLPublisherData(jenkinsJobXMLPublisherData);
        jenkinsJobXMLData.setJenkinsJobXMLTiggersData(jenkinsJobXMLTiggersData);


        String file = jenkinsCreateConfigFile.createXML(jenkinsJobXMLData);
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
