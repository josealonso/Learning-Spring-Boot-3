package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Issue;
import com.example.demo.repository.IssueRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class IssuesControllerTest {

    @Mock
    IssueRepositoryImpl issueRepositoryImpl;

    @InjectMocks
    IssuesController issuesController;

    @Test
    void givenAListOfIssues_whenGetIssues_thenReturnsListOfIssues() {

        // given
        var issues = List.of(
            new Issue(1, "title", "description", "photo"),
            new Issue(2, "title", "description", "photo"),
            new Issue(3, "title", "description", "photo")
        );

        // issueRepositoryImpl = new IssueRepositoryImpl(issues);
        // Mock the repository behavior
        when(issueRepositoryImpl.findAll()).thenReturn(issues); 

        // when
        var result = issuesController.getIssues();
        // var issuesController = new IssuesController(issueRepositoryImpl);
        
        // then and verify
        assertEquals(result, issues);
        verify(issueRepositoryImpl).findAll();
    }
}
