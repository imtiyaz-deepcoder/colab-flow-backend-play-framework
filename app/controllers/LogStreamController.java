package controllers;

import akka.stream.javadsl.Source;
import akka.util.ByteString;
import play.mvc.Controller;
import play.mvc.Result;
import utility.LogQueue;

import java.time.Duration;

public class LogStreamController extends Controller {

    public Result streamLogs() {
        Source<ByteString, ?> source =
                Source.tick(Duration.ofSeconds(0), Duration.ofSeconds(1), "tick")
                        .map(tick -> {
                            StringBuilder sb = new StringBuilder();
                            while (!LogQueue.logs.isEmpty()) {
                                sb.append("data: ").append(LogQueue.logs.poll()).append("\n\n");
                            }
                            String output = sb.toString();
                            if (output.isEmpty()) {
                                return ByteString.fromString("data: ...\n\n");
                            }
                            return ByteString.fromString(output);
                        });

        return ok().chunked(source).as("text/event-stream");
    }
}
