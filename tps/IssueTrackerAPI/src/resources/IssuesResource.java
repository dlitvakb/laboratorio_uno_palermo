package resources;

import java.util.HashMap;
import java.util.Map;

import models.Issue;
import dao.DAO;
import dao.IssueDAO;

public class IssuesResource extends APIResource<Issue> {
    @Override
    protected DAO<Issue> getDAO() {
        return new IssueDAO();
    }

    public Map<String, Object> byStatus(long statusId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).byStatus(statusId));
        return map;
    }

    public Map<String, Object> byStatusAndAssignee(long statusId,
            long assigneeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).byStatusAndAssignee(
                statusId, assigneeId));
        return map;
    }

    public Map<String, Object> byAssignee(long assigneeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).byAssignee(assigneeId));
        return map;
    }

    public Map<String, Object> byReporter(long reporterId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).byReporter(reporterId));
        return map;
    }

    public Map<String, Object> byStatusAndReporter(long statusId,
            long reporterId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).byStatusAndReporter(
                statusId, reporterId));
        return map;
    }

    public Map<String, Object> byStatusAndAssigneeAndReporter(long statusId,
            long assigneeId, long reporterId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO())
                .byStatusAndAssigneeAndReporter(statusId, assigneeId,
                        reporterId));
        return map;
    }

    public Map<String, Object> statusSummary() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).statusSummary());
        return map;
    }

    public Object byAssigneeAndReporter(long assigneeId, long reporterId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((IssueDAO) this.getDAO()).byAssigneeAndReporter(
                assigneeId, reporterId));
        return map;
    }
}
