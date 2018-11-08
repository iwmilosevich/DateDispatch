package com.ivan;

import com.ivan.database.Database;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.Optional;

public class Main {
    private static final String BASE_URI;
    private static final String protocol;
    private static final Optional<String> host;
    private static final String path;
    private static final Optional<String> port;

    static{
        protocol = "http://";
        host = Optional.ofNullable(System.getenv("HOSTNAME"));
        port = Optional.ofNullable(System.getenv("PORT"));
        path = "datedispatch";
        BASE_URI = protocol + host.orElse("localhost") + ":" + port.orElse("8080") + "/" + path + "/";
    }

    private static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.ivan");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws Exception {
        final HttpServer server = startServer();
        Database db = new Database();
        System.out.println(String.format("Jersey app started with WADL available at %sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
        db.closeDb();
    }
}

