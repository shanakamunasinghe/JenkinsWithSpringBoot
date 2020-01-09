package com.creative.web.controller;

import com.creative.web.dto.ProjectDataDTO;
import com.creative.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/projectsData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectDataDTO>> getAllProjectsData() {
        return new ResponseEntity<List<ProjectDataDTO>>(projectService.findALLUProjects(), HttpStatus.OK);
    }
    @RequestMapping(value = "/projectData/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDataDTO> getProjectData(@PathVariable("id") Integer id) {
        return new ResponseEntity<ProjectDataDTO>(projectService.findById(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/projectData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createProject(@RequestBody ProjectDataDTO project) {
        projectService.createProject(project);
        return new ResponseEntity<Integer>(01, HttpStatus.OK);
    }
    @RequestMapping(value = "/projectData",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateProject(@RequestBody ProjectDataDTO project) {
        projectService.updateProject(project);
        return new ResponseEntity<Integer>(project.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteProjectData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteProject(@RequestBody ProjectDataDTO project) {
        projectService.deleteProject(project);
        return new ResponseEntity<Integer>(project.getId(), HttpStatus.OK);
    }
}
