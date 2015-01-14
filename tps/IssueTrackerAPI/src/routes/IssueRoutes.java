package routes;

import models.Issue;
import models.User;
import resources.IssuesResource;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.JsonTransformerRoute;

public class IssueRoutes {
    public static void routes() {
        Spark.get(new JsonTransformerRoute("/api/issues") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().all(), response);
            }
        });

        Spark.get(new JsonTransformerRoute("/api/issues/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().fetch(Long
                        .parseLong(request.params(":id"))), response);
            }
        });

        Spark.put(new JsonTransformerRoute("/api/issues/:id") {
            @Override
            public Object handle(Request request, Response response) {
                Issue issue = new Issue().fromJson(
                        Long.parseLong(request.params(":id")), request.body());
                issue.setUser_id(((User) request.session().attribute("user"))
                        .getId());
                return this.render(new IssuesResource().save(issue), response);
            }
        });

        Spark.post(new JsonTransformerRoute("/api/issues") {
            @Override
            public Object handle(Request request, Response response) {
                Issue issue = new Issue().fromJson(request.body());
                issue.setUser_id(((User) request.session().attribute("user"))
                        .getId());
                return this.render(new IssuesResource().save(issue), response);
            }
        });

        Spark.delete(new JsonTransformerRoute("api/issues/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().remove(Long
                        .parseLong(request.params(":id"))), response);
            }
        });
    }
}
