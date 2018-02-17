package com.sda.stock;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;


import java.util.function.Consumer;

public class FindBySpecificAuthor {

    public static void mainh(String[] args) {

        try(MongoClient client = new MongoClient("localhost", 27017)) {
            MongoDatabase db = client.getDatabase("products");
            MongoCollection<Document> products = db.getCollection("products");
            products.find(Filters.all("authors", "Michael Nielsen"))
                    .forEach((Consumer<? super Document>) Utils::displayDoc);
        }
    }
}
