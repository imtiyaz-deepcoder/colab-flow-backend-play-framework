package controllers;

import akka.actor.ActorSystem;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import play.mvc.Controller;
import play.mvc.WebSocket;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class WebSocketController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public WebSocketController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    public WebSocket socket() {
        return WebSocket.Text.accept(request -> createAkkaFlow());
    }

    private Flow<String, String, ?> createAkkaFlow() {
        // Sink to consume messages from client
        Sink<String, ?> in = Sink.foreach(message -> {
            System.out.println("Client: " + message);
        });

        // Source to send a new message every 5 seconds with updated timestamp
        Source<String, ?> out = Source.tick(
                Duration.create(0, TimeUnit.SECONDS),
                Duration.create(5, TimeUnit.SECONDS),
                "tick"
        ).map(tick -> "Server time: " + LocalDateTime.now());

        return Flow.fromSinkAndSource(in, out);
    }
}
