package application;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import models.Issue;
import models.User;
import resources.IssuesResource;
import resources.UsersResource;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import utils.AuthenticationException;
import utils.AuthenticationParser;
import utils.ReturningRunnable;

import com.google.gson.Gson;

public class IssueTrackerApi {
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

	public static void main(String[] args) throws Exception {
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
				} catch (AuthenticationException e) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("code", 401);
					map.put("message", "Access Forbidden");

					response.header("WWW-Authenticate",
							"Basic realm=\"issues\"");

					halt(401, new Gson().toJson(map));
				}
			}
		});

		Spark.get(new Route("/api/issues") {
			@Override
			public Object handle(Request request, Response response) {
				Map<String, Object> result = new IssuesResource().all();
				response.status((int) result.get("code"));
				response.type("application/json");
				return new Gson().toJson(result);
			}
		});

		Spark.get(new Route("/api/issues/:id") {
			@Override
			public Object handle(Request request, Response response) {
				Map<String, Object> result = new IssuesResource().fetch(Long
						.parseLong(request.params(":id")));
				response.status((int) result.get("code"));
				response.type("application/json");
				return new Gson().toJson(result);
			}
		});

		Spark.put(new Route("/api/issues/:id", "application/json") {
			@Override
			public Object handle(Request request, Response response) {
				Issue issue = new Issue().fromJson(
						Long.parseLong(request.params(":id")), request.body());
				Map<String, Object> result = new IssuesResource().save(issue);
				response.status((int) result.get("code"));
				response.type("application/json");
				return new Gson().toJson(result);
			}
		});

		Spark.post(new Route("/api/issues", "application/json") {
			@Override
			public Object handle(Request request, Response response) {
				Issue issue = new Issue().fromJson(request.body());
				Map<String, Object> result = new IssuesResource().save(issue);
				response.status((int) result.get("code"));
				response.type("application/json");
				return new Gson().toJson(result);
			}
		});

		Spark.delete(new Route("api/issues/:id", "application/json") {
			@Override
			public Object handle(Request request, Response response) {
				Map<String, Object> result = new IssuesResource().remove(Long
						.parseLong(request.params(":id")));
				response.status((int) result.get("code"));
				response.type("application/json");
				return new Gson().toJson(result);
			}
		});

		Spark.get(new Route("/api/users") {
			@Override
			public Object handle(final Request request, final Response response) {
				return requireAdmin(request, response, new ReturningRunnable() {
					@Override
					public Object run() {
						Map<String, Object> result = new UsersResource().all();
						response.status((int) result.get("code"));
						response.type("application/json");
						return new Gson().toJson(result);
					}
				});
			}
		});

		Spark.get(new Route("/api/users/:id") {
			@Override
			public Object handle(final Request request, final Response response) {
				return requireAdmin(request, response, new ReturningRunnable() {
					@Override
					public Object run() {
						Map<String, Object> result = new UsersResource()
								.fetch(Long.parseLong(request.params(":id")));
						response.status((int) result.get("code"));
						response.type("application/json");
						return new Gson().toJson(result);
					}
				});
			}
		});

		Spark.put(new Route("/api/users/:id", "application/json") {
			@Override
			public Object handle(final Request request, final Response response) {
				return requireAdmin(request, response, new ReturningRunnable() {
					@Override
					public Object run() {
						User user = new User().fromJson(
								Long.parseLong(request.params(":id")),
								request.body());
						Map<String, Object> result = new UsersResource()
								.save(user);
						response.status((int) result.get("code"));
						response.type("application/json");
						return new Gson().toJson(result);
					}
				});
			}
		});

		Spark.post(new Route("/api/users", "application/json") {
			@Override
			public Object handle(final Request request, final Response response) {
				return requireAdmin(request, response, new ReturningRunnable() {
					@Override
					public Object run() {
						User user = new User().fromJson(request.body());
						Map<String, Object> result = new UsersResource()
								.save(user);
						response.status((int) result.get("code"));
						return new Gson().toJson(result);
					}
				});
			}
		});

		Spark.delete(new Route("api/users/:id", "application/json") {
			@Override
			public Object handle(final Request request, final Response response) {
				return requireAdmin(request, response, new ReturningRunnable() {
					@Override
					public Object run() {
						Map<String, Object> result = new UsersResource()
								.remove(Long.parseLong(request.params(":id")));
						response.status((int) result.get("code"));
						response.type("application/json");
						return new Gson().toJson(result);
					}
				});
			}
		});
	}
}
