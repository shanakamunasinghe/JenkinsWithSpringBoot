package com.creative.web.service;
import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.dto.UserDataDTO;
import com.creative.web.util.JenkinsAPIManager;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class JenkinsService {

    public JenkinsCreateConfigFile jenkinsCreateConfigFile = new JenkinsCreateConfigFile();

    public int runJenkinsJob() throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.runJenkinsJob("HelloWorld");
        return 1;
    }
    public int deleteJenkinsUser() throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.deleteJenkinsUser("isuru");
        return 1;
    }
    public int getJenkinsStatus() throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.getJenkinsStatusData();
        return 1;
    }
    public int createJenkinsUser(UserDataDTO user) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        JenkinsUserDataDTO jenkinsUserDataDTO = new JenkinsUserDataDTO(user.getName(),user.getJenkinsPassword(),user.getName()+"@gmail.com");
        jenkinsAPIManager.createJenkinsUser(jenkinsUserDataDTO);
        return 1;
    }
    public String generateJenkinsUserAPIToken(String userName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        String apiToken = jenkinsAPIManager.generateJenkinsUserAPIToken(userName);
        return apiToken;
    }

    public Integer createJenkinsJob(String jobName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.createJenkinsJob(jobName);
        return 1;
    }

}
