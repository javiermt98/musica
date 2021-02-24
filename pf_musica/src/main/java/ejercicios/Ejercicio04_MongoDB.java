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
		MongoCollection<Document> collectiongrupo = database.getCollection("grupo");
		MongoCollection<Document> collectioncompany = database.getCollection("company");
		

		
		//*********************************************************************************
		//APARTADO A - CODIGO Y NOMBRE DE LOS GRUPOS DE UN PAIS INTRODUCIDO POR EL USUARIO
		//*********************************************************************************
		System.out.println("******************* Apartado A *******************");
		Scanner p = new Scanner(System.in);
		System.out.println("Pais: ");
		String pais = p.nextLine();
		List<Document> documentos = new ArrayList<Document>();
		collectiongrupo.find(regex("pais", pais)).into(documentos);
		System.out.println("Grupos de "+pais+": ");
		for(Document grupo: documentos) {
			System.out.println(grupo.getString("nombre_grupo")+" - "+grupo.getInteger("cod_grupo"));
		}
	
		
		//***************************************************************************************
		//APARTADO B - TITULO Y DURACION DE LAS CANCIONES DE UN GRUPO INTRODUCIDO POR EL USUARIO
		//***************************************************************************************
		System.out.println("\n******************* Apartado B *******************");
		Scanner a = new Scanner(System.in);
		System.out.print("Grupo: ");
		String gr = a.nextLine();
		documentos = new ArrayList<Document>();
		collectiongrupo.find(regex("nombre_grupo",gr)).into(documentos);
		System.out.println("Canciones de "+gr+": ");
		for(Document grupo: documentos) {
			
			List<Document> listadiscos = (List<Document>) grupo.get("disco");
			for(Document disco:listadiscos) {
				List<Document> listacanciones = (List<Document>) disco.get("canciones");
				
				for(Document cancion: listacanciones) {
					System.out.println(cancion.get("titulo_cancion")+": "+cancion.get("duracion")+"min");
				}
			}
			
		}
		
		
		
		
		//*********************************************************************************************************
		//APARTADO C - LISTA DE DISCOS (NOMBRE Y FECHA DE LANZAMIENTO) DE UNA COMPANYIA INTRODUCIDA POR EL USUARIO
		//*********************************************************************************************************
		
		System.out.println("\n******************* Apartado C *******************");

		Scanner c = new Scanner(System.in);
		System.out.println("Companyia: ");
		String com = a.nextLine();
		documentos = new ArrayList<Document>();
		collectioncompany.find(regex("nombre_company",com)).into(documentos);
		
		List<Document>grupos = new ArrayList<Document>();
		collectiongrupo.find().into(grupos);
		int cod_comp=-1;
		for(Document companyia: documentos) {
			cod_comp = companyia.getInteger("cod_company");
		}
		for(Document grupo: grupos) {
			List<Document> discos = (List<Document>) grupo.get("disco");
			for(Document disc: discos) {
				if(disc.getInteger("cod_company") == cod_comp) {
					System.out.println(disc.get("nombre_disco")+": "+disc.get("fecha_disco"));
				}
			}
		}
		
		
		
		//**************************************************************************************************************
		//APARTADO D - MOSTRAR TITULO, DURACION Y DISCO (NOMBRE Y FECHA DE LANZAMIENTO) DE LAS CANCIONES DE MAS DE 4MIN
		//**************************************************************************************************************
		System.out.println("\n******************* Apartado D *******************");
		documentos = new ArrayList<Document>();
		collectiongrupo.find().into(documentos);
		System.out.println("Canciones de mas de 4 min: ");
		for(Document grupo: documentos) {
			
			List<Document> listadiscos = (List<Document>) grupo.get("disco");
			for(Document disco:listadiscos) {
				List<Document> listacanciones = (List<Document>) disco.get("canciones");
				
				for(Document cancion: listacanciones) {
					if(cancion.getDouble("duracion")>4) {
					System.out.println(cancion.get("titulo_cancion")+": "+cancion.get("duracion")+"min");
					}
				}
			}
			
		}
		
		
		
		
		
		//**************************************************************************************************************
		//APARTADO E - MOSTRAR DE CADA GRUPO, SU NOMBRE, EL DE SUS DISCOS Y LA COMPANYIA DONDE PUBLICARON CADA DISCO
		//**************************************************************************************************************
		System.out.println("\n******************* Apartado E *******************");
		documentos = new ArrayList<Document>();
		collectiongrupo.find().into(documentos);
		
		List<Document> companyias = new ArrayList<Document>();
		collectioncompany.find().into(companyias);
		
		for(Document grupo: documentos) {
			System.out.println("\nGrupo: "+grupo.get("nombre_grupo"));
			List<Document> listadiscos = (List<Document>) grupo.get("disco");
			for(Document disco:listadiscos) {
				System.out.println("Disco: "+disco.get("nombre_disco"));
				for(Document comp: companyias) {
					if(disco.getInteger("cod_company") == comp.getInteger("cod_company")) {
						System.out.println("Companyia: "+comp.get("nombre_company"));
					}
				}
				
			}
			
		}
		
		
		
		
	}

}
