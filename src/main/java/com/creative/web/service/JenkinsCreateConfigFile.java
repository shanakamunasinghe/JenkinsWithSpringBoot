package com.creative.web.service;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.creative.web.model.JenkinsJobXMLData;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class JenkinsCreateConfigFile {
    public static final String xmlFilePath = "D:\\xmlfile.xml";

    public JenkinsCreateConfigFile(){

    }
    public static String toString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }
    public String createXML(JenkinsJobXMLData jenkinsJobXMLData) {
        String postData = new String();
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("project");
            document.appendChild(root);
            Element actions = document.createElement("actions");
            root.appendChild(actions);
            Element description = document.createElement("description");
            root.appendChild(description);
            Element keepDependencies = document.createElement("keepDependencies");
            keepDependencies.appendChild(document.createTextNode("false"));
            root.appendChild(keepDependencies);

/// -------------------------- properties ------------------------------------------
            Element properties = document.createElement("properties");
            root.appendChild(properties);
            if(jenkinsJobXMLData.getJenkinsJobXMLPropertiesData().getStatus() == "Active"){
                // ------------ github properties -----------------------------------------------
                Element githubProjectProperty = document.createElement("com.coravy.hudson.plugins.github.GithubProjectProperty");
                Attr githubProjectPropertyAttr1 = document.createAttribute("plugin");
                githubProjectPropertyAttr1.setValue("github@1.29.5");
                githubProjectProperty.setAttributeNode(githubProjectPropertyAttr1);
                properties.appendChild(githubProjectProperty);
                Element projectUrl = document.createElement("projectUrl");
                projectUrl.appendChild(document.createTextNode(jenkinsJobXMLData.getJenkinsJobXMLPropertiesData().getProjectUrl()));
                githubProjectProperty.appendChild(projectUrl);
                Element displayName = document.createElement("displayName");
                if(jenkinsJobXMLData.getJenkinsJobXMLPropertiesData().getDisplayName() != null){
                    displayName.appendChild(document.createTextNode(jenkinsJobXMLData.getJenkinsJobXMLPropertiesData().getDisplayName()));
                }
                else{
                    displayName.appendChild(document.createTextNode("None"));
                }
                githubProjectProperty.appendChild(displayName);
                // ------------------------------------------------------------------------------
            }

            // ------------ notification -----------------------------------------------------
            Element notification = document.createElement("com.tikal.hudson.plugins.notification.HudsonNotificationProperty");
            Attr notificationAttr1 = document.createAttribute("plugin");
            notificationAttr1.setValue("notification@1.13");
            notification.setAttributeNode(notificationAttr1);
            Element endpoints = document.createElement("endpoints");
            Element notificationEndpoint = document.createElement("com.tikal.hudson.plugins.notification.Endpoint");
            Element notificationProtocol = document.createElement("protocol");
            notificationProtocol.appendChild(document.createTextNode("HTTP"));
            notificationEndpoint.appendChild(notificationProtocol);
            Element notificationFormat = document.createElement("format");
            notificationFormat.appendChild(document.createTextNode("JSON"));
            notificationEndpoint.appendChild(notificationFormat);
            Element notificationUrlInfo = document.createElement("urlInfo");
            Element notificationUrlOrId = document.createElement("urlOrId");
            notificationUrlOrId.appendChild(document.createTextNode("http://localhost:8081/jobNotification"));
            notificationUrlInfo.appendChild(notificationUrlOrId);
            Element notificationUrlType = document.createElement("urlType");
            notificationUrlType.appendChild(document.createTextNode("PUBLIC"));
            notificationUrlInfo.appendChild(notificationUrlType);
            notificationEndpoint.appendChild(notificationUrlInfo);
            Element notificationEvent = document.createElement("event");
            notificationEvent.appendChild(document.createTextNode("all"));
            notificationEndpoint.appendChild(notificationEvent);
            Element notificationTimeout = document.createElement("timeout");
            notificationTimeout.appendChild(document.createTextNode("30000"));
            notificationEndpoint.appendChild(notificationTimeout);
            Element notificationLoglines = document.createElement("loglines");
            notificationLoglines.appendChild(document.createTextNode("0"));
            notificationEndpoint.appendChild(notificationLoglines);
            Element notificationBuildNotes = document.createElement("buildNotes");
            notificationEndpoint.appendChild(notificationBuildNotes);
            Element notificationRetries = document.createElement("retries");
            notificationRetries.appendChild(document.createTextNode("0"));
            notificationEndpoint.appendChild(notificationRetries);
            endpoints.appendChild(notificationEndpoint);
            notification.appendChild(endpoints);
            properties.appendChild(notification);





            // ------------------- end notification -----------------------------------------------

///------------------------------ end properties -------------------------------------------------------------------------

///------------------------------ scm ------------------------------------------------------------------------------------
            Element scm = document.createElement("scm");
            Attr scmAttr1 = document.createAttribute("class");
            // -------- if not selected --------------------------------------------------
            if(jenkinsJobXMLData.getJenkinsJobXMLSCMData().getStatus() == "Inactive"){
                scmAttr1.setValue("hudson.scm.NullSCM");
                scm.setAttributeNode(scmAttr1);
                root.appendChild(scm);
            }

            if(jenkinsJobXMLData.getJenkinsJobXMLSCMData().getStatus() == "Active"){
                // --------- this only for git ----------------------------------------------
                scmAttr1.setValue("hudson.plugins.git.GitSCM");
                Attr scmAttr2 = document.createAttribute("plugin");
                scmAttr2.setValue("git@4.0.0");
                scm.setAttributeNode(scmAttr1);
                scm.setAttributeNode(scmAttr2);
                root.appendChild(scm);

                // ------------------------- UserRemoteConfig ---------------------------------------------------------------
                Element scmConfigVersion = document.createElement("configVersion");
                scmConfigVersion.appendChild(document.createTextNode("2"));
                scm.appendChild(scmConfigVersion);
                Element scmUserRemoteConfigs = document.createElement("userRemoteConfigs");
                scm.appendChild(scmUserRemoteConfigs);
                Element scmGitUserRemoteConfig = document.createElement("hudson.plugins.git.UserRemoteConfig");
                scmUserRemoteConfigs.appendChild(scmGitUserRemoteConfig);

                Element scmGitUserRemoteConfigUrl = document.createElement("url");
                scmGitUserRemoteConfigUrl.appendChild(document.createTextNode(jenkinsJobXMLData.getJenkinsJobXMLSCMData().getUserRemoteConfigUrl()));
                scmGitUserRemoteConfig.appendChild(scmGitUserRemoteConfigUrl);
                Element scmGitUserRemoteConfigCredentialsId = document.createElement("credentialsId");

                // in here credentials are not applied
                //scmGitUserRemoteConfigCredentialsId.appendChild(document.createTextNode("6a9a389a-2e67-4135-a1f7-16a29d0df21e"));
                scmGitUserRemoteConfig.appendChild(scmGitUserRemoteConfigCredentialsId);
                Element scmBranches = document.createElement("branches");
                scm.appendChild(scmBranches);
                Element scmGitBranches = document.createElement("hudson.plugins.git.BranchSpec");
                scmBranches.appendChild(scmGitBranches);
                Element scmGitBranchesName = document.createElement("name");
                // use as example "*/master"
                scmGitBranchesName.appendChild(document.createTextNode(jenkinsJobXMLData.getJenkinsJobXMLSCMData().getBranches()));
                scmGitBranches.appendChild(scmGitBranchesName);

                Element scmDoGenerateSubmoduleConfigurations = document.createElement("doGenerateSubmoduleConfigurations");
                scmDoGenerateSubmoduleConfigurations.appendChild(document.createTextNode("false"));
                scm.appendChild(scmDoGenerateSubmoduleConfigurations);
                Element scmSubmoduleCfg = document.createElement("submoduleCfg");
                Attr scmSubmoduleCfgAttr1 = document.createAttribute("class");
                scmSubmoduleCfgAttr1.setValue("list");
                scmSubmoduleCfg.setAttributeNode(scmSubmoduleCfgAttr1);
                scm.appendChild(scmSubmoduleCfg);
                Element scmExtensions = document.createElement("extensions");
                scm.appendChild(scmExtensions);
                // --------------------------------------------------------------------------------------------------------------
            }
///------------------------------ end scm -----------------------------------------------------------------------------------
/// -------------------------------------------------------------------------------------------------------------------------
            Element canRoam = document.createElement("canRoam");
            canRoam.appendChild(document.createTextNode("true"));
            root.appendChild(canRoam);

            Element proDisabled = document.createElement("disabled");
            proDisabled.appendChild(document.createTextNode("false"));
            root.appendChild(proDisabled);

            Element proDown = document.createElement("blockBuildWhenDownstreamBuilding");
            proDown.appendChild(document.createTextNode("false"));
            root.appendChild(proDown);

            Element proUp = document.createElement("blockBuildWhenUpstreamBuilding");
            proUp.appendChild(document.createTextNode("false"));
            root.appendChild(proUp);
/// --------------------------------------------------------------------------------------------------------------
/// --------------------------------------------- triggers -------------------------------------------------------
            Element proTriggers = document.createElement("triggers");
            root.appendChild(proTriggers);
            if(jenkinsJobXMLData.getJenkinsJobXMLTiggersData().getStatus() == "Active"){
                if(jenkinsJobXMLData.getJenkinsJobXMLTiggersData().getScmTriggerSpec() == "GitHubPushTrigger"){
                    // ----------------------------- GitHubPushTrigger ----------------------------------------------
                    Element gitTriggers = document.createElement("com.cloudbees.jenkins.GitHubPushTrigger");
                    Attr triggersAttr1 = document.createAttribute("plugin");
                    triggersAttr1.setValue("github@1.29.5");
                    gitTriggers.setAttributeNode(triggersAttr1);
                    proTriggers.appendChild(gitTriggers);
                    Element proTriggersSpec = document.createElement("spec");
                    gitTriggers.appendChild(proTriggersSpec);
                    // ---------------------------------------------------------------------------------------------
                }
                if(jenkinsJobXMLData.getJenkinsJobXMLTiggersData().getScmTriggerSpec() == "SCMTrigger") {
                    // ----------------------------- SCMTrigger ---------------------------------------------------
                    Element scmTrigger = document.createElement("hudson.triggers.SCMTrigger");
                    proTriggers.appendChild(scmTrigger);
                    Element scmTriggerSpec = document.createElement("spec");
                    scmTriggerSpec.appendChild(document.createTextNode("* * * * *"));
                    scmTrigger.appendChild(scmTriggerSpec);
                    Element scmTriggerIgnorePostCommitHooks = document.createElement("ignorePostCommitHooks");
                    scmTriggerIgnorePostCommitHooks.appendChild(document.createTextNode("false"));
                    scmTrigger.appendChild(scmTriggerIgnorePostCommitHooks);
                    // --------------------------------------------------------------------------------------------
                }

            }


///-----------------------------------------------------------------------------------------------------
            Element concurrentBuild = document.createElement("concurrentBuild");
            concurrentBuild.appendChild(document.createTextNode("false"));
            root.appendChild(concurrentBuild);
/// ------------------------------------------------------------------------------------------------------
///------------------ builders --------------------------------------------------------------------

            Element proBuild = document.createElement("builders");
            root.appendChild(proBuild);
            if(jenkinsJobXMLData.getJenkinsJobXMLBuilderData().getStatus() == "Active"){
                if(jenkinsJobXMLData.getJenkinsJobXMLBuilderData().getType() == "Execute Windows batch command"){
                    // --------------------- Execute Windows batch command ------------------------------
                    Element proBuildBatchFile = document.createElement("hudson.tasks.BatchFile");
                    proBuild.appendChild(proBuildBatchFile);
                    Element proBuildBatchFileCommand = document.createElement("command");
                    proBuildBatchFileCommand.appendChild(document.createTextNode("javac Hello.java&#xd;\n" + "java Hello"));
                    proBuildBatchFile.appendChild(proBuildBatchFileCommand);
                    // ----------------------------------------------------------------------------------
                }
                if(jenkinsJobXMLData.getJenkinsJobXMLBuilderData().getType() == "Maven"){
                    // --------------------- Maven ------------------------------------------------------
                    Element proBuildMaven = document.createElement("hudson.tasks.Maven");
                    proBuild.appendChild(proBuildMaven);

                    Element mavenTargets = document.createElement("targets");
                    mavenTargets.appendChild(document.createTextNode("clean install"));
                    proBuildMaven.appendChild(mavenTargets);
                    Element mavenPom = document.createElement("pom");
                    mavenPom.appendChild(document.createTextNode("pom.xml"));
                    proBuildMaven.appendChild(mavenPom);
                    Element mavenUsePrivateRepository = document.createElement("usePrivateRepository");
                    mavenUsePrivateRepository.appendChild(document.createTextNode("false"));
                    proBuildMaven.appendChild(mavenUsePrivateRepository);

                    Element mavenSettings = document.createElement("settings");
                    Attr mavenSettingsAttr2 = document.createAttribute("class");
                    mavenSettingsAttr2.setValue("jenkins.mvn.DefaultSettingsProvider");
                    mavenSettings.setAttributeNode(mavenSettingsAttr2);
                    proBuildMaven.appendChild(mavenSettings);
                    Element mavenGlobalSettings = document.createElement("globalSettings");
                    Attr mavenGlobalSettingsAttr2 = document.createAttribute("class");
                    mavenGlobalSettingsAttr2.setValue("jenkins.mvn.DefaultGlobalSettingsProvider");
                    mavenGlobalSettings.setAttributeNode(mavenGlobalSettingsAttr2);
                    proBuildMaven.appendChild(mavenGlobalSettings);

                    Element mavenInjectBuildVariables = document.createElement("injectBuildVariables");
                    mavenInjectBuildVariables.appendChild(document.createTextNode("false"));
                    proBuildMaven.appendChild(mavenInjectBuildVariables);
                    // ----------------------------------------------------------------------------------
                }


            }


/// ---------------------end of builders -----------------------------------------------------------

/// --------------------start of publisher --------------------------------------------------------
            Element publishers = document.createElement("publishers");
            root.appendChild(publishers);
            // --------------------- DeployPublisher ------------------------------------------------
            Element deployPublisher = document.createElement("hudson.plugins.deploy.DeployPublisher");
            publishers.appendChild(deployPublisher);
            Attr deployPublisherAttr2 = document.createAttribute("plugin");
            deployPublisherAttr2.setValue("deploy@1.15");
            publishers.setAttributeNode(deployPublisherAttr2);
            Element deployPublisherAdapters = document.createElement("adapters");
            publishers.appendChild(deployPublisherAdapters);
            if(jenkinsJobXMLData.getJenkinsJobXMLPublisherData().getType() == "tomcat8"){
                // --------------------- for tomcat 8 -----------------------------------------
                Element deployPublisherAdaptersTomcat8xAdapter = document.createElement("hudson.plugins.deploy.tomcat.Tomcat8xAdapter");
                deployPublisherAdapters.appendChild(deployPublisherAdaptersTomcat8xAdapter);

                Element tomcat8xAdapterCredentialsId = document.createElement("credentialsId");
                tomcat8xAdapterCredentialsId.appendChild(document.createTextNode("e92cfccc-bcc0-470e-83c2-96f62c7a930b"));
                deployPublisherAdaptersTomcat8xAdapter.appendChild(tomcat8xAdapterCredentialsId);

                Element tomcat8xAdapterUrl = document.createElement("url");
                tomcat8xAdapterUrl.appendChild(document.createTextNode("http://localhost:9090/"));
                deployPublisherAdaptersTomcat8xAdapter.appendChild(tomcat8xAdapterUrl);

                Element tomcat8xAdapterPath = document.createElement("path");
                deployPublisherAdaptersTomcat8xAdapter.appendChild(tomcat8xAdapterPath);
                // -----------------------------------------------------------------------------
            }
            // ------------------------------------------------------------------------------------
/// --------------------- end of publisher ---------------------------------------------------------
/// --------------------- buildWrappers ----------------------------------------------------------
            Element buildWrappers = document.createElement("buildWrappers");
            root.appendChild(buildWrappers);
            if(jenkinsJobXMLData.getJenkinsJobXMLBuilderWrapperData().getStatus() == "Active") {
                if(jenkinsJobXMLData.getJenkinsJobXMLBuilderWrapperData().getOption() == "clearDir"){
                    // ----------------- PreBuildCleanup ------------------------------------------------
                    Element PreBuildCleanup = document.createElement("hudson.plugins.ws__cleanup.PreBuildCleanup");
                    buildWrappers.appendChild(PreBuildCleanup);
                    Attr preBuildCleanupAttr2 = document.createAttribute("plugin");
                    preBuildCleanupAttr2.setValue("ws-cleanup@0.38");
                    PreBuildCleanup.setAttributeNode(preBuildCleanupAttr2);
                    // ---------------------------------- delete work space---------------------------------------------------------------
                    Element PreBuildCleanupDeleteDirs = document.createElement("deleteDirs");
                    PreBuildCleanupDeleteDirs.appendChild(document.createTextNode("false"));
                    PreBuildCleanup.appendChild(PreBuildCleanupDeleteDirs);
                    Element PreBuildCleanupCleanupParameter = document.createElement("cleanupParameter");
                    PreBuildCleanup.appendChild(PreBuildCleanupCleanupParameter);
                    Element PreBuildCleanupExternalDelete = document.createElement("externalDelete");
                    PreBuildCleanup.appendChild(PreBuildCleanupExternalDelete);
                    Element PreBuildCleanupDisableDeferredWipeout = document.createElement("disableDeferredWipeout");
                    PreBuildCleanupDisableDeferredWipeout.appendChild(document.createTextNode("false"));
                    PreBuildCleanup.appendChild(PreBuildCleanupDisableDeferredWipeout);
                    // ----------------------------------------------------------------------------------
                }
            }

/// -------------------------------------------------------------------------------------------------------------------------

            postData = toString(document);
            // create the xml file
            //transform the DOM Object to an XML File
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource domSource = new DOMSource(document);
//            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

//            transformer.transform(domSource, streamResult);
            System.out.println(postData);
            System.out.println("Done creating XML File");


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        return postData;
    }
}
