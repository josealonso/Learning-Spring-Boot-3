package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Issue;
import com.example.demo.repository.IssueRepositoryImpl;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // this annotation allows to use static methods
public class IssuesControllerTest {

    private List<Issue> issues;

    @Mock
    IssueRepositoryImpl issueRepositoryImpl;

    @InjectMocks
    IssuesController issuesController;


    @BeforeAll
    public void setup() {
        // given
        issues = List.of(
            new Issue(1, "title", "description-1", "photo1"),
            new Issue(2, "title", "description-2", "photo2"),
            new Issue(3, "title", "description-3", "photo3")
        );
    
    }

    @Test
    void givenAListOfIssues_whenGetIssues_thenReturnsListOfIssues() {

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
