package controllers;

import akka.NotUsed;
import akka.stream.Materializer;
import akka.stream.OverflowStrategy;
import akka.stream.javadsl.*;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.WebSocket;
import play.mvc.Http;
import akka.Done;
import akka.japi.Pair;
import akka.stream.javadsl.Flow;


import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CompletionStage;

public class DocumentWebSocketController extends Controller {

    private final Materializer materializer;
    private final List<SourceQueueWithComplete<String>> allClients = new CopyOnWriteArrayList<>();

    @Inject
    public DocumentWebSocketController(Materializer materializer) {
        this.materializer = materializer;
    }

    public WebSocket documentSocket() {
        return WebSocket.Text.acceptOrResult(request -> {
            Source<String, SourceQueueWithComplete<String>> source =
                    Source.queue(10, OverflowStrategy.dropHead());

            Pair<SourceQueueWithComplete<String>, Source<String, NotUsed>> pair =
                    source.preMaterialize(materializer);

            SourceQueueWithComplete<String> clientQueue = pair.first();
            Source<String, NotUsed> clientSource = pair.second();

            allClients.add(clientQueue);
            clientQueue.watchCompletion().thenRun(() -> allClients.remove(clientQueue));

            Sink<String, CompletionStage<Done>> sink = Sink.foreach((String rawMsg) -> {
                //Simple protocol: we expect the client to send valid JSON with type, content, and username
                try {
                    //No JSON parser for now, just broadcast as-is
                    for (SourceQueueWithComplete<String> q : allClients) {
                        q.offer(rawMsg); // Expecting rawMsg to already be a JSON string
                    }
                } catch (Exception e) {
                    System.out.println("Invalid message: " + rawMsg);
                }
            });

            Flow<String, String, NotUsed> flow = Flow.fromSinkAndSource(sink, clientSource);
            return CompletableFuture.completedFuture(F.Either.Right(flow));
        });
    }



}
