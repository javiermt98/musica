package ejercicios;

import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;



public class Ejercicio05_MongoDB {
	public static void main(String[]args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
		MongoDatabase database = mongoClient.getDatabase("musica");
		MongoCollection<Document> collectiongrupo = database.getCollection("grupo");
		MongoCollection<Document> collectioncompany = database.getCollection("company");
		
		//************************************************************************************************
		//APARTADO A - INSERTAR A UN GRUPO EXISTENTE, UN DISCO CON UNA CANCION INTRODUCIDOS POR EL USUARIO
		//************************************************************************************************
		
		System.out.println("\n******************* Apartado A *******************");
		
		System.out.println("************ CREANDO UN DISCO ************");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nombre_d = sc.nextLine();
		System.out.print("Fecha (YYYY-MM-AA): ");
		String fecha = sc.nextLine();
		
		System.out.println("************ CREANDO UNA CANCION ************");
		Scanner c = new Scanner(System.in);
		System.out.print("Titulo: ");
		String nombre_c = c.nextLine();
		System.out.print("Duracion: ");
		Double duracion = c.nextDouble();
		
		System.out.println("************ GRUPO Y DISCOGRAFICA ************");
		Scanner d = new Scanner(System.in);
		System.out.print("Grupo al que pertenecer�: ");
		String g = d.nextLine();
		System.out.print("Discografica: ");
		String disc = d.nextLine();


		List<Document>companyias = new ArrayList<Document>();
		collectioncompany.find(regex("nombre_company",disc)).into(companyias);
		
		List<Document>grupos = new ArrayList<Document>();
		collectiongrupo.find(regex("nombre_grupo",g)).into(grupos);
		List<Document> discos = new ArrayList<Document>();

		int cod_c = -1;
		if(!companyias.isEmpty()) {
			for(Document company: companyias) {
				cod_c = company.getInteger("cod_company");
			}
			if(!grupos.isEmpty()) {
				
				for(Document grupo: grupos) {
					discos = (List<Document>) grupo.get("disco");
				}
				
				Document cancion = new Document()
						.append("titulo_cancion", nombre_c)
						.append("duracion", duracion);
				List<Document> canciones = new ArrayList<Document>();
				canciones.add(cancion);
				Document disco = new Document()
						.append("nombre_disco", nombre_d)
						.append("fecha_disco", fecha)
						.append("canciones", canciones)
						.append("cod_company", cod_c);
				
				discos.add(disco);
				
				collectiongrupo.updateOne(eq("nombre_grupo",g),set("disco",discos));
				System.out.println("El proceso ha finalizado sin errores");
				
				
			}
			else {
				System.out.println("No existe ese grupo");

			}
		}
		else {
			System.out.println("No existe esa discografica");
		}
		
		
		
		//************************************************************************************************
		//APARTADO B - ACTUALIZAR FUNCION DE ARTISTA POR DOL�AINER POR CODIGO DE GRUPO Y DNI ARTISTA
		//************************************************************************************************
		
	
	
	
	}

}
