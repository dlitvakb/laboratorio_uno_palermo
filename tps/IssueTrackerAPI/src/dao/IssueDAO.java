package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Issue;
import models.Status;

public class IssueDAO extends DAO<Issue> {
    @Override
    protected Issue parseResults(ResultSet rs) throws SQLException {
        Issue issue = new Issue();
        issue.setId(rs.getLong("id"));
        issue.setName(rs.getString("name"));
        issue.setUser_id(rs.getLong("user_id"));
        issue.setAssignee_user_id(rs.getLong("assignee_user_id"));
        issue.setDescription(rs.getString("description"));
        issue.setStatus(rs.getInt("status"));

        return issue;
    }

    @Override
    public String getTable() {
        return "issue";
    }

    public List<Issue> byStatus(long statusId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getStatus() == statusId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Issue> byStatusAndAssignee(long statusId, long assigneeId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getStatus() == statusId
                    && issue.getAssignee_user_id() == assigneeId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Issue> byAssignee(long assigneeId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getAssignee_user_id() == assigneeId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Issue> byReporter(long reporterId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getUser_id() == reporterId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Issue> byStatusAndReporter(long statusId, long reporterId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getStatus() == statusId
                    && issue.getUser_id() == reporterId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Issue> byAssigneeAndReporter(long assigneeId, long reporterId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getAssignee_user_id() == assigneeId
                    && issue.getUser_id() == reporterId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public List<Issue> byStatusAndAssigneeAndReporter(long statusId,
            long assigneeId, long reporterId) {
        List<Issue> issues = new ArrayList<Issue>();
        for (Issue issue : this.all()) {
            if (issue.getStatus() == statusId
                    && issue.getAssignee_user_id() == assigneeId
                    && issue.getUser_id() == reporterId) {
                issues.add(issue);
            }
        }

        return issues;
    }

    public Map<String, List<Issue>> statusSummary() {
        Map<String, List<Issue>> map = new HashMap<String, List<Issue>>();
        List<Status> statuses = new StatusDAO().all();

        for (Status s : statuses) {
            map.put(s.getName(), new ArrayList<Issue>());
        }

        List<Issue> issues = this.all();

        for (Issue i : issues) {
            map.get(i.getStatusName()).add(i);
        }

        return map;
    }
}
