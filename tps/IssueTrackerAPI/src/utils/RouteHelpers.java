package utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import models.User;
import spark.Request;
import spark.Response;

import com.google.gson.Gson;

public class RouteHelpers {
    public static void requireAdmin(User user) {
        if (!user.isAdmin()) {
            throw new AuthenticationException();
        }
    }

    public static Object notAllowedResponse(Response response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 403);
        map.put("message", "You are not allowed");
        response.status((int) map.get("code"));
        response.type("application/json");
        return new Gson().toJson(map);
    }

    public static Object requireAdmin(Request request, Response response,
            ReturningRunnable closure) {
        try {
            requireAdmin(new AuthenticationParser(
                    request.headers("Authorization")).getUser());
            return closure.run();
        } catch (AuthenticationException | NoSuchAlgorithmException
                | UnsupportedEncodingException e) {
            return notAllowedResponse(response);
        }
    }
}
