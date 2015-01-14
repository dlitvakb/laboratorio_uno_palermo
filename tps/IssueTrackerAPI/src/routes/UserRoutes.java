package routes;

import java.util.Map;

import models.User;
import resources.UsersResource;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.JsonTransformerRoute;
import utils.ReturningRunnable;
import utils.RouteHelpers;

public class UserRoutes {
    public static void routes() {
        Spark.get(new JsonTransformerRoute("/api/users") {
            @Override
            public Object handle(final Request request, final Response response) {
                response.type("application/json");
                return this.render(new UsersResource().all(), response);
            }
        });

        Spark.get(new JsonTransformerRoute("/api/users/:id") {
            @Override
            public Object handle(final Request request, final Response response) {
                return RouteHelpers.requireAdmin(request, response,
                        new ReturningRunnable() {
                            @Override
                            public Object run() {
                                Map<String, Object> result = new UsersResource()
                                        .fetch(Long.parseLong(request
                                                .params(":id")));
                                response.status((int) result.get("code"));
                                return result;
                            }
                        });
            }
        });

        Spark.put(new JsonTransformerRoute("/api/users/:id") {
            @Override
            public Object handle(final Request request, final Response response) {
                return RouteHelpers.requireAdmin(request, response,
                        new ReturningRunnable() {
                            @Override
                            public Object run() {
                                User user = new User().fromJson(
                                        Long.parseLong(request.params(":id")),
                                        request.body());
                                Map<String, Object> result = new UsersResource()
                                        .save(user);
                                response.status((int) result.get("code"));
                                return result;
                            }
                        });
            }
        });

        Spark.post(new JsonTransformerRoute("/api/users") {
            @Override
            public Object handle(final Request request, final Response response) {
                return RouteHelpers.requireAdmin(request, response,
                        new ReturningRunnable() {
                            @Override
                            public Object run() {
                                User user = new User().fromJson(request.body());
                                Map<String, Object> result = new UsersResource()
                                        .save(user);
                                response.status((int) result.get("code"));
                                return result;
                            }
                        });
            }
        });

        Spark.delete(new JsonTransformerRoute("api/users/:id") {
            @Override
            public Object handle(final Request request, final Response response) {
                return RouteHelpers.requireAdmin(request, response,
                        new ReturningRunnable() {
                            @Override
                            public Object run() {
                                Map<String, Object> result = new UsersResource()
                                        .remove(Long.parseLong(request
                                                .params(":id")));
                                response.status((int) result.get("code"));
                                return result;
                            }
                        });
            }
        });
    }
}
