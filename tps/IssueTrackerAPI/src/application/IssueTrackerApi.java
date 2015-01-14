package application;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import routes.CommentRoutes;
import routes.IssueRoutes;
import routes.ReportRoutes;
import routes.StatusRoutes;
import routes.UserRoutes;
import routes.UtilsRoutes;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.AuthenticationException;
import utils.AuthenticationParser;

import com.google.gson.Gson;

public class IssueTrackerApi {
    public static void main(String[] args) throws Exception {
        Spark.externalStaticFileLocation(System.getProperty("user.dir")
                + "/static");
        Spark.setPort(5000);

        Spark.before(new Filter() {
            @Override
            public void handle(Request request, Response response) {
                try {
                    if (!new AuthenticationParser(request
                            .headers("Authorization")).isAuthenticated()) {
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("code", 401);
                        map.put("message", "Access Forbidden");

                        response.header("WWW-Authenticate",
                                "Basic realm=\"issues\"");

                        response.type("application/json");
                        halt(401, new Gson().toJson(map));
                    }

                    request.session(true);
                    request.session().attribute(
                            "user",
                            new AuthenticationParser(request
                                    .headers("Authorization")).getUser());
                } catch (AuthenticationException | NoSuchAlgorithmException
                        | UnsupportedEncodingException e) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("code", 401);
                    map.put("message", "Access Forbidden");

                    response.header("WWW-Authenticate",
                            "Basic realm=\"issues\"");

                    halt(401, new Gson().toJson(map));
                }
            }
        });

        UtilsRoutes.routes();
        IssueRoutes.routes();
        CommentRoutes.routes();
        StatusRoutes.routes();
        UserRoutes.routes();
        ReportRoutes.routes();
    }
}
