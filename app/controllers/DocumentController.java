package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Document;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.LogQueue;

public class DocumentController extends Controller {

     private final JPAApi jpaApi;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    public DocumentController(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public CompletableFuture<Result> createDocument(Http.Request request) {
        LogQueue.logs.add("Creating a new document");
        return CompletableFuture.supplyAsync(() -> {
            JsonNode body = request.body().asJson();
            Document doc = Json.fromJson(body, Document.class);
            jpaApi.withTransaction(em -> {
                em.persist(doc);
            });
            LogQueue.logs.add("Document created successfully");
            return created(Json.toJson(doc));

        });
    }

    public CompletableFuture<Result> getAllDocuments() {
        LogQueue.logs.add("Getting all documents");
        return CompletableFuture.supplyAsync(() ->
                jpaApi.withTransaction(em -> {
                    List<Document> docs = em.createQuery("FROM Document", Document.class)
                            .getResultList();
                    return ok(Json.toJson(docs));
                })
        );
     }
    }
