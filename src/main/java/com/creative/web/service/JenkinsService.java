package com.creative.web.service;

import com.creative.web.model.JenkinsGlobalRoleData;
import com.creative.web.model.JenkinsItemRoleData;
import com.creative.web.model.JenkinsRolesData;
import com.creative.web.model.JenkinsUserData;
import com.creative.web.repository.JenkinsGlobalRoleRepository;
import com.creative.web.repository.JenkinsItemRoleRepository;
import com.creative.web.repository.JenkinsRolesRepository;
import com.creative.web.repository.JenkinsUserRepository;
import com.creative.web.util.JenkinsAPIManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JenkinsService {

    public JenkinsCreateConfigFile jenkinsCreateConfigFile = new JenkinsCreateConfigFile();

    @Autowired
    public JenkinsGlobalRoleRepository jenkinsGlobalRoleRepository;

    @Autowired
    public JenkinsItemRoleRepository jenkinsItemRoleRepository;

    @Autowired
    public JenkinsUserRepository jenkinsUserRepository;

    @Autowired
    public JenkinsRolesRepository jenkinsRolesRepository;


    public int runJenkinsJob(String jobName) throws IOException {
        // Jenkins Job History has to update
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.runJenkinsJob(jobName);
        return 1;
    }

//    public int deleteJenkinsUser(String userName) throws IOException {
//        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
//        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(userName);
//        if(jenkinsUserData != null){
//            jenkinsAPIManager.deleteJenkinsUser(userName);
//            jenkinsUserData.setStatus("Inactive");
//        }
//        return 1;
//    }

    public int getJenkinsStatus() throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.getJenkinsStatusData();
        return 1;
    }

//    public int createJenkinsUser(UserDataDTO user) throws IOException {
//        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
//        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(user.getJenkinsName());
//        if(jenkinsUserData != null){
//            // cant create from the same name
//        }else{
//            JenkinsUserDataDTO jenkinsUserDataDTO = new JenkinsUserDataDTO(user.getName(), user.getJenkinsPassword(), user.getName() + "@gmail.com");
//            jenkinsAPIManager.createJenkinsUser(jenkinsUserDataDTO);
//            JenkinsUserData jUD = new JenkinsUserData();
//            jUD.setName(user.getName());
//            jUD.setJenkinsName(user.getJenkinsName());
//            jUD.setJenkinsPassword(user.getJenkinsPassword());
//            jUD.setStatus("Active");
//            String apiToken = this.generateJenkinsUserAPIToken(user.getJenkinsName());
//            if(apiToken != null){
//                jUD.setJenkinsAPIToken(apiToken);
//            }
//
//            jenkinsUserRepository.save(jUD);
//        }
//
//        return 1;
//    }

    public String generateJenkinsUserAPIToken(String userName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        String apiToken = jenkinsAPIManager.generateJenkinsUserAPIToken(userName);
        return apiToken;
    }

    // has to change according to Object
    public Integer createJenkinsJob(String jobName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.createJenkinsJob(jobName);

        return 1;
    }

    // roles services <-------
    public void getAllRolesByType(String type) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.getParticularRoles(type);
    }

    public Integer createJenkinsGlobalRole(JenkinsGlobalRoleData jenkinsGlobalRoleData) throws IOException {
        JenkinsGlobalRoleData jGData = jenkinsGlobalRoleRepository.findByName(jenkinsGlobalRoleData.getName());
        // check whether there is existing one
        if(jGData == null){
            JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
            jenkinsAPIManager.createJenkinsGlobalRole(jenkinsGlobalRoleData);
            jenkinsGlobalRoleRepository.save(jenkinsGlobalRoleData);
        }else if(jGData.getStatus().equals("Inactive")){
            jGData.setStatus("Active");
            jenkinsGlobalRoleRepository.save(jGData);
        }
        return 1;
    }

    public Integer createJenkinsItemRole(JenkinsItemRoleData jenkinsItemRoleData) throws IOException {
        JenkinsItemRoleData jIData = jenkinsItemRoleRepository.findByName(jenkinsItemRoleData.getName());
        // check whether there is existing one
        if(jIData == null){
            JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
            jenkinsAPIManager.createJenkinsItemRole(jenkinsItemRoleData);
            jenkinsItemRoleRepository.save(jenkinsItemRoleData);
        }else if(jIData.getStatus().equals("Inactive")){
            jIData.setStatus("Active");
            jenkinsItemRoleRepository.save(jIData);
        }

        return 1;
    }

    public Integer deleteJenkinsRoles(String roleName, String type) throws IOException {
//        globalRoles, projectRoles
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        if (type.equals("globalRoles")) {
            JenkinsGlobalRoleData jenkinsGlobalRoleData = jenkinsGlobalRoleRepository.findByName(roleName);
            if (jenkinsGlobalRoleData != null) {
                jenkinsAPIManager.deleteJenkinsRole(roleName, type);
                jenkinsGlobalRoleRepository.delete(jenkinsGlobalRoleData);
            }
        } else if (type.equals("projectRoles")) {
            JenkinsItemRoleData jenkinsItemRoleData = jenkinsItemRoleRepository.findByName(roleName);
            if (jenkinsItemRoleData != null) {
                jenkinsAPIManager.deleteJenkinsRole(roleName, type);
                jenkinsItemRoleRepository.delete(jenkinsItemRoleData);
            }
        }
        return 1;
    }

    public Integer assignRoleToJenkinsUser(String roleName, String type, String userName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(userName);
        if (type.equals("globalRoles")) {
            JenkinsGlobalRoleData jenkinsGlobalRoleData = jenkinsGlobalRoleRepository.findByName(roleName);

            if(jenkinsUserData != null && jenkinsGlobalRoleData != null){
                jenkinsAPIManager.assignRole(roleName,type,userName);
                JenkinsRolesData jenkinsRolesData = new JenkinsRolesData();
                // has to check whether it already assigned in font end
                JenkinsRolesData jOld = jenkinsRolesRepository.findByJenkinsUserIdAndJenkinsGlobalRoleId(jenkinsUserData.getId(),jenkinsGlobalRoleData.getId());
                if(jOld != null){
                    // if there where old record that make as inactive
                    jOld.setStatus("Active");
                    jenkinsRolesRepository.save(jOld);
                }else {
                    jenkinsRolesData.setJenkinsGlobalRoleData(jenkinsGlobalRoleData);
                    jenkinsRolesData.setJenkinsUserData(jenkinsUserData);
                    jenkinsRolesData.setStatus("Active");
                    jenkinsRolesData.setType("globalRoles");
                    jenkinsRolesRepository.save(jenkinsRolesData);
                }
            }
        } else if (type.equals("projectRoles")) {
            JenkinsItemRoleData jenkinsItemRoleData = jenkinsItemRoleRepository.findByName(roleName);
            if(jenkinsUserData != null && jenkinsItemRoleData != null){
                jenkinsAPIManager.assignRole(roleName,type,userName);
                JenkinsRolesData jenkinsRolesData = new JenkinsRolesData();
                JenkinsRolesData jOld = jenkinsRolesRepository.findByJenkinsUserIdAndJenkinsItemRoleId(jenkinsUserData.getId(),jenkinsItemRoleData.getId());
                if(jOld != null){
                    // if there where old record that make as inactive
                    jOld.setStatus("Active");
                    jenkinsRolesRepository.save(jOld);
                }else {
                    jenkinsRolesData.setJenkinsItemRoleData(jenkinsItemRoleData);
                    jenkinsRolesData.setJenkinsUserData(jenkinsUserData);
                    jenkinsRolesData.setStatus("Active");
                    jenkinsRolesData.setType("projectRoles");
                    jenkinsRolesRepository.save(jenkinsRolesData);
                }
            }
        }
        return 1;
    }

    public Integer deleteUserFromAllRoles(String type, String userName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(userName);
        if (type.equals("globalRoles")) {
            // has to inactive all jenkins records
            jenkinsAPIManager.deleteUserFromAllRoles(type,userName);
            List<JenkinsRolesData> jenkinsRolesDataArray = jenkinsRolesRepository.findByJenkinsUserIdAndType(jenkinsUserData.getId(),"globalRoles");
            for(JenkinsRolesData jRD : jenkinsRolesDataArray){
                jRD.setStatus("Inactive");
                jenkinsRolesRepository.save(jRD);
            }
            jenkinsAPIManager.deleteUserFromAllRoles(type,userName);

        } else if(type.equals("projectRoles")){
            // has to inactive all jenkins records
            jenkinsAPIManager.deleteUserFromAllRoles(type,userName);
            List<JenkinsRolesData> jenkinsRolesDataArray = jenkinsRolesRepository.findByJenkinsUserIdAndType(jenkinsUserData.getId(),"projectRoles");
            for(JenkinsRolesData jRD : jenkinsRolesDataArray){
                jRD.setStatus("Inactive");
                jenkinsRolesRepository.save(jRD);
            }
            jenkinsAPIManager.deleteUserFromAllRoles(type,userName);
        }


        return 1;
    }

}
