import com.example.demo.model.Issue;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

interface IssueRepository {
    List<Issue> findAll();
    Optional<Issue> findById(int id);
    Issue save(Issue issue);
    Issue update(Issue issue);
    void deleteById(int id);
}