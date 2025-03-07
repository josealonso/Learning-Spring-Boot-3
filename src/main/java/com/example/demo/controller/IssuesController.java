package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.IssueRepositoryImpl;

@Controller
public class IssuesController {

    @Autowired
    IssueRepositoryImpl issueRepositoryImpl;

    @GetMapping("/issues")
    public String getIssues() {
        return issueRepositoryImpl.findAll().toString();
    }

}
