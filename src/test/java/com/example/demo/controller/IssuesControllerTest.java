package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

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
        var issue1 = new Issue(1, "title", "description-1", "photo1");
        var issue2 = new Issue(2, "title", "description-2", "photo2");
        var issue3 = new Issue(3, "title", "description-3", "photo3");
        issues = List.of(
            issue1, issue2, issue3
        );
    }

    @Test
    void givenAListOfIssues_whenGetIssues_thenReturnsListOfIssues() {

        // Mock the repository behavior, usually called "given"
        when(issueRepositoryImpl.findAll()).thenReturn(issues); 

        // when
        var result = issuesController.getIssues();
                
        // then and verify
        assertEquals(result, issues);
        verify(issueRepositoryImpl).findAll();
    }

    @Test
    void givenAnExistingIssue_whenGetIssueById_thenReturnsAnIssue() {

        // Mock the repository behavior, usually called "given"
        int issueId = 1;
        when(issueRepositoryImpl.findById(issueId)).thenReturn(Optional.of(issues.get(issueId)));

        // when
        var result = issuesController.getIssueById(issueId);
                
        // then and verify
        assertEquals(result, issues.get(issueId));
        verify(issueRepositoryImpl).findById(anyInt());
    }

    @Test 
    void givenAnExistingIssue_whenUpdateIssue_thenReturnsAnIssue() {

        // Mock the repository behavior, usually called "given"
        int issueId = 1;
        when(issueRepositoryImpl.update(issues.get(issueId))).thenReturn(issues.get(issueId));

        // when
        var result = issuesController.updateIssue(issues.get(issueId));
                
        // then and verify
        assertEquals(result, issues.get(issueId));
        verify(issueRepositoryImpl).update(issues.get(issueId));
    }

    @Test
    void givenAnExistingIssue_whenDeleteIssue_thenReturnsVoid() {
     
        // Mock the repository behavior, usually called "given"
        int issueId = 1;
        doNothing().when(issueRepositoryImpl).deleteById(issueId);

        // when
        issuesController.deleteIssue(issueId);

        // then and verify
        verify(issueRepositoryImpl, times(1)).deleteById(issueId);
    }
}
