package routes;

import models.Status;
import resources.StatusResource;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.JsonTransformerRoute;

public class StatusRoutes {
    public static void routes() {
        Spark.get(new JsonTransformerRoute("/api/status") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new StatusResource().all(), response);
            }
        });

        Spark.get(new JsonTransformerRoute("/api/status/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new StatusResource().fetch(Long
                        .parseLong(request.params(":id"))), response);
            }
        });

        Spark.put(new JsonTransformerRoute("/api/status/:id") {
            @Override
            public Object handle(Request request, Response response) {
                Status status = new Status().fromJson(
                        Long.parseLong(request.params(":id")), request.body());
                return this.render(new StatusResource().save(status), response);
            }
        });

        Spark.post(new JsonTransformerRoute("/api/status") {
            @Override
            public Object handle(Request request, Response response) {
                Status status = new Status().fromJson(request.body());
                return this.render(new StatusResource().save(status), response);
            }
        });

        Spark.delete(new JsonTransformerRoute("api/status/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return this.render(new StatusResource().remove(Long
                        .parseLong(request.params(":id"))), response);
            }
        });
    }
}
