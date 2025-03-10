package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Issue;

@Repository
public class IssueRepositoryImpl implements IssueRepository {

    private List<Issue> issues = List.of(
        new Issue(1, "title", "description-1", "photo1"),
        new Issue(2, "title", "description-2", "photo2"),
        new Issue(3, "title", "description-3", "photo3")
    );

    public IssueRepositoryImpl(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public List<Issue> findAll() {
        return issues;
    }

    @Override
    public Optional<Issue> findById(int id) {
        return issues.stream().filter(issue -> issue.id() == id).findFirst();
    }

    @Override
    public Issue save(Issue issue) {
        issues.add(issue);
        return issue;
    }

    @Override
    public Issue update(Issue issue) {
        
        Optional<Issue> optionalIssueToUpdate = findById(issue.id());
        if (optionalIssueToUpdate.isEmpty()) {
            throw new IllegalArgumentException("Issue with id " + issue.id() + " not found");
        }

        Issue issueToUpdate = optionalIssueToUpdate.get();
        Issue updatedIssue = new Issue(issueToUpdate.id(), issueToUpdate.title(), issueToUpdate.description(), issueToUpdate.photo());
        save(updatedIssue);
        return updatedIssue;
    }

    @Override
    public void deleteById(int id) {
        issues.removeIf(issue -> issue.id() == id);
    }
    
}
