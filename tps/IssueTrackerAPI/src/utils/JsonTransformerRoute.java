package utils;

import java.util.Map;

import spark.Response;
import spark.ResponseTransformerRoute;

import com.google.gson.Gson;

public abstract class JsonTransformerRoute extends ResponseTransformerRoute {
    private Gson gson = new Gson();

    protected JsonTransformerRoute(String path) {
        super(path, "application/json");
    }

    @Override
    public String render(Object model) {
        return this.gson.toJson(model);
    }

    @SuppressWarnings("unchecked")
    public Object render(Object model, Response response) {
        if (model instanceof Map<?, ?>) {
            Map<String, Object> map = (Map<String, Object>) model;
            response.status((int) map.get("code"));
        }
        response.type("application/json");
        return model;
    }
}