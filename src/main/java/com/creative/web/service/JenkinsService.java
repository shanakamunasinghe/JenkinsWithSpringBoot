package com.creative.web.service;

import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.util.JenkinsAPIManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JenkinsService {
    public JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();

    public int runJenkinsJob() throws IOException {
        jenkinsAPIManager.runJenkinsJob("HelloWorld");
        return 1;
    }
    public int deleteJenkinsUser() throws IOException {
        jenkinsAPIManager.deleteJenkinsUser("isuru");
        return 1;
    }
    public int getJenkinsStatus() throws IOException {
        jenkinsAPIManager.getJenkinsStatusData();
        return 1;
    }
    public int createJenkinsUser() throws IOException {
        JenkinsUserDataDTO jenkinsUserDataDTO = new JenkinsUserDataDTO("isuru","password","isuru@gmail.com");
        jenkinsAPIManager.createJenkinsUser(jenkinsUserDataDTO);
        return 1;
    }
}
