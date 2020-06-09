package Server;

import LinkData.LinkCache;
import eu.bitwalker.useragentutils.UserAgent;
import io.vertx.core.*;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;



public class ServerApplicationVertical extends AbstractVerticle {

    final String REQUEST_PARAM = "showStatus";


    // Convenience method so i can run it in my IDE
    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();
        DeploymentOptions options = new DeploymentOptions().setWorker(true);
        vertx.deployVerticle(ServerApplicationVertical.class,options);
    }

    @Override
    public void start() {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);
        router.get("/*").handler(routingContext -> handleRequest(routingContext));
        UrlRequestHandler.setUp();

        server.requestHandler(router).listen(8002);
        System.out.println("serverv is up");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }



    private void handleRequest(RoutingContext routingContext) {
        HttpServerResponse response;
        System.out.println("req arrived - url = "+  routingContext);
        System.out.println(routingContext.normalizedPath());
        String originalUrl = routingContext.normalizedPath();
        originalUrl = originalUrl.substring(1, originalUrl.length());

        UserAgent userAgent = UserAgent.parseUserAgentString(routingContext.request().getHeader("User-Agent"));

        String status = routingContext.request().getParam(REQUEST_PARAM);
        String urlToReturn = "*";
        if (status != null && status.equals("true")) {
            urlToReturn = StaticticRequestHandler.handleStatisticReq(originalUrl, userAgent);
        } else {
            urlToReturn = UrlRequestHandler.handleNewReq(originalUrl, userAgent);
        }
        routingContext.redirect(urlToReturn);
        response = routingContext.response();
        response.end();
    }
}
