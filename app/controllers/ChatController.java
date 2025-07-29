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

public class ChatController extends Controller {

    private final Materializer materializer;
    private final List<SourceQueueWithComplete<String>> chatClients = new CopyOnWriteArrayList<>();

    @Inject
    public ChatController(Materializer materializer) {
        this.materializer = materializer;
    }

    public WebSocket chatSocket() {
        return WebSocket.Text.acceptOrResult(request -> {
            Source<String, SourceQueueWithComplete<String>> source =
                    Source.queue(10, OverflowStrategy.dropHead());

            Pair<SourceQueueWithComplete<String>, Source<String, NotUsed>> pair =
                    source.preMaterialize(materializer);

            SourceQueueWithComplete<String> clientQueue = pair.first();
            Source<String, NotUsed> clientSource = pair.second();

            chatClients.add(clientQueue);
            clientQueue.watchCompletion().thenRun(() -> chatClients.remove(clientQueue));

            Sink<String, CompletionStage<Done>> sink = Sink.foreach(rawMsg -> {
                for (SourceQueueWithComplete<String> q : chatClients) {
                    q.offer(rawMsg);
                }
            });

            Flow<String, String, NotUsed> flow = Flow.fromSinkAndSource(sink, clientSource);
            return CompletableFuture.completedFuture(F.Either.Right(flow));
        });
    }
}
