package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Issue;
import com.example.demo.repository.IssueRepositoryImpl;

@RestController("/api/v1/issues")
public class IssuesController {

    @Autowired
    IssueRepositoryImpl issueRepositoryImpl;

    // constructor
    public IssuesController(IssueRepositoryImpl issueRepositoryImpl) {
        this.issueRepositoryImpl = issueRepositoryImpl;
    }

    @GetMapping
    public List<Issue> getIssues() {
      /* return ResponseEntity.ok()
        .header("Content-Type", "application/json")
        .body(issueRepositoryImpl.findAll());  // body() method is terminal and returns the built ResponseEntity, so .build() is not needed and would cause a compilation error.
        // .build();  */

        return issueRepositoryImpl.findAll();
    }

    @GetMapping("/{id}")
    public Issue getIssueById(int id) {
        return issueRepositoryImpl.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Issue with id " + id + " not found"));
    }

    @PutMapping("/{id}")
    public Issue updateIssue(Issue issue) {
        return issueRepositoryImpl.update(issue);
    }

    @DeleteMapping("/{id}")
    public void deleteIssue(int id) {
        issueRepositoryImpl.deleteById(id);
    }
}
