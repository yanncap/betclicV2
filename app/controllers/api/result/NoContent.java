package controllers.api.result;

import play.mvc.Http;
import play.mvc.results.Result;

public class NoContent extends Result {

    public NoContent() {
        super("No Content");
    }

    @Override
    public void apply(Http.Request request, Http.Response response) {
        response.status = 204; // 204 - No Content
    }

}
