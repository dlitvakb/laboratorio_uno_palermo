package resources;

import models.Issue;
import dao.DAO;
import dao.IssueDAO;

public class IssuesResource extends APIResource<Issue> {

	@Override
	protected DAO<Issue> getDAO() {
		return new IssueDAO();
	}
}
