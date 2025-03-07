package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Issue;
import com.example.demo.repository.IssueRepositoryImpl;

@Controller
public class IssuesController {

    @Autowired
    IssueRepositoryImpl issueRepositoryImpl;

    @GetMapping("/issues")
    public ResponseEntity<List<Issue>> getIssues() {
        return ResponseEntity.ok()
        .header("Content-Type", "application/json")
        .body(issueRepositoryImpl.findAll());  // body() method is terminal and returns the built ResponseEntity, so .build() is not needed and would cause a compilation error.
        // .build(); 
    }

}
