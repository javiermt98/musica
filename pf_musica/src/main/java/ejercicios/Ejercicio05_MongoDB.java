package ejercicios;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejercicio05_MongoDB {
	public static void main(String[]args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
		MongoDatabase database = mongoClient.getDatabase("musica");
		MongoCollection<Document> collectiongrupo = database.getCollection("grupo");
		MongoCollection<Document> collectioncompany = database.getCollection("company");
	
	
	
	}

}