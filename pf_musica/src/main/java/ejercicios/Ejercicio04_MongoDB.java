package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import hibernate.UtilesHibernate;

import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import static com.mongodb.client.model.Filters.*;

public class Ejercicio04_MongoDB {
	
	public static void main(String[]args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
		MongoDatabase database = mongoClient.getDatabase("musica");
		MongoCollection<Document> collection = database.getCollection("grupo");
		MongoCollection<Document> collectioncompany = database.getCollection("company");
		

		
		//*********************************************************************************
		//APARTADO A - CODIGO Y NOMBRE DE LOS GRUPOS DE UN PAIS INTRODUCIDO POR EL USUARIO
		//*********************************************************************************
		System.out.println("******************* Apartado A *******************");
		Scanner p = new Scanner(System.in);
		System.out.println("Pais: ");
		String pais = p.nextLine();
		List<Document> documentos = new ArrayList<Document>();
		collection.find(regex("pais", pais)).into(documentos);
		System.out.println("Grupos de "+pais+": ");
		for(Document grupo: documentos) {
			System.out.println(grupo.getString("nombre_grupo")+" - "+grupo.getInteger("cod_grupo"));
		}
	
		
		//***************************************************************************************
		//APARTADO B - TITULO Y DURACION DE LAS CANCIONES DE UN GRUPO INTRODUCIDO POR EL USUARIO
		//***************************************************************************************
		System.out.println("\n******************* Apartado B *******************");
		Scanner a = new Scanner(System.in);
		System.out.println("Pais: ");
		String gr = a.nextLine();
		documentos = new ArrayList<Document>();
		collection.find().into(documentos);
		System.out.println("Canciones de "+gr+": ");
		for(Document grupo: documentos) {
			
			List<Document> listadiscos = (List<Document>) grupo.get("disco");
			for(Document disco:listadiscos) {
				List<Document> listacanciones = (List<Document>) disco.get("canciones");
				
				for(Document cancion: listacanciones) {
					
				}
			}
			
		}
		
		
		
		
		//*********************************************************************************************************
		//APARTADO C - LISTA DE DISCOS (NOMBRE Y FECHA DE LANZAMIENTO) DE UNA COMPANYIA INTRODUCIDA POR EL USUARIO
		//*********************************************************************************************************
		
		System.out.println("\n******************* Apartado C *******************");

		
		
		
		
		//**************************************************************************************************************
		//APARTADO D - MOSTRAR TITULO, DURACION Y DISCO (NOMBRE Y FECHA DE LANZAMIENTO) DE LAS CANCIONES DE MAS DE 4MIN
		//**************************************************************************************************************
		System.out.println("\n******************* Apartado D *******************");

		
		
		
		
		
		//**************************************************************************************************************
		//APARTADO E - MOSTRAR DE CADA GRUPO, SU NOMBRE, EL DE SUS DISCOS Y LA COMPANYIA DONDE PUBLICARON CADA DISCO
		//**************************************************************************************************************
		System.out.println("\n******************* Apartado E *******************");

		
		
		
		
		
	}

}
