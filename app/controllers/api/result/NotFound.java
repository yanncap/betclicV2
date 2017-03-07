package controllers.api.result;

import play.mvc.Http;
import play.mvc.results.Result;

import java.io.IOException;

public class NotFound extends Result {

    private String message;

    public NotFound(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public void apply(Http.Request request, Http.Response response) {
        response.status = 404; // 404 - Not Found
        try {
            String encoding = getEncoding();
            setContentTypeIfNotSet(response, "application/json; charset=" + encoding);
            response.out.write(("{\"code\": 404, \"message\": \"" + message + "\"}").getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
