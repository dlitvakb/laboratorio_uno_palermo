package routes;

import net.pontamedia.brandcaptcha.BrandCaptcha;
import net.pontamedia.brandcaptcha.BrandCaptchaFactory;
import net.pontamedia.brandcaptcha.BrandCaptchaResponse;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class UtilsRoutes {
    public static void routes() {
        Spark.get(new Route("/api/captcha") {
            @Override
            public Object handle(final Request request, final Response response) {
                response.type("text/html");
                String html = "<html><body><form method='post' action='/api/captcha'>";
                html += BrandCaptchaFactory.newBrandCaptcha(
                        "ed4000df387ff01d9d6dba368bfa08fff3b06a80",
                        "9403a27094980a2421b2e29b5eccd7489b243725", false)
                        .createBrandCaptchaHtml(null, null);
                html += "<input type='submit' /></form></body>";
                return html;
            }
        });

        Spark.post(new Route("/api/captcha") {
            @Override
            public Object handle(final Request request, final Response response) {
                response.type("text/html");
                BrandCaptcha captcha = BrandCaptchaFactory.newBrandCaptcha(
                        "ed4000df387ff01d9d6dba368bfa08fff3b06a80",
                        "9403a27094980a2421b2e29b5eccd7489b243725", false);
                BrandCaptchaResponse answer = captcha.checkAnswer(
                        request.host(),
                        request.queryParams("brand_cap_challenge"),
                        request.queryParams("brand_cap_answer"));
                if (answer.isValid()) {
                    return "Woohoo!";
                }
                return answer.getErrorMessage();
            }
        });
    }
}
