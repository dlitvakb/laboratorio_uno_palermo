package routes;

import resources.IssuesResource;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.JsonTransformerRoute;

public class ReportRoutes {
    public static void routes() {
        Spark.get(new JsonTransformerRoute("/api/issues/status/summary") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().statusSummary(),
                        response);
            }
        });

        Spark.get(new JsonTransformerRoute("/api/issues/status/:status_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().byStatus(Long
                        .parseLong(request.params(":status_id"))), response);
            }
        });

        Spark.get(new JsonTransformerRoute("/api/issues/assignee/:assignee_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().byAssignee(Long
                        .parseLong(request.params(":assignee_id"))), response);
            }
        });

        Spark.get(new JsonTransformerRoute("/api/issues/reporter/:reporter_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().byReporter(Long
                        .parseLong(request.params(":reporter_id"))), response);
            }
        });

        Spark.get(new JsonTransformerRoute(
                "/api/issues/status/:status_id/assignee/:assignee_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().byStatusAndAssignee(
                        Long.parseLong(request.params(":status_id")),
                        Long.parseLong(request.params(":assignee_id"))),
                        response);
            }
        });

        Spark.get(new JsonTransformerRoute(
                "/api/issues/status/:status_id/reporter/:reporter_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().byStatusAndReporter(
                        Long.parseLong(request.params(":status_id")),
                        Long.parseLong(request.params(":reporter_id"))),
                        response);
            }
        });

        Spark.get(new JsonTransformerRoute(
                "/api/issues/assignee/:assignee_id/reporter/:reporter_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new IssuesResource().byAssigneeAndReporter(
                        Long.parseLong(request.params(":assignee_id")),
                        Long.parseLong(request.params(":reporter_id"))),
                        response);
            }
        });
        Spark.get(new JsonTransformerRoute(
                "/api/issues/status/:status_id/assignee/:assignee_id/reporter/:reporter_id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(
                        new IssuesResource().byStatusAndAssigneeAndReporter(
                                Long.parseLong(request.params(":status_id")),
                                Long.parseLong(request.params(":assignee_id")),
                                Long.parseLong(request.params(":reporter_id"))),
                        response);
            }
        });
    }
}
