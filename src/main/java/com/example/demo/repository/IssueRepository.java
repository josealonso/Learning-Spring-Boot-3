package com.example.demo.repository;

import com.example.demo.model.Issue;

import java.util.List;
import java.util.Optional;

interface IssueRepository {
    List<Issue> findAll();
    Optional<Issue> findById(int id);
    Issue save(Issue issue);
    Issue update(Issue issue);
    void deleteById(int id);
}