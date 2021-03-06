package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import hibernate.UtilesHibernate;

import pojos.*;
public class llenar_bbdd_mongodb {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost/27017");
		MongoDatabase database = mongoClient.getDatabase("musica");
		MongoCollection<Document> collection = database.getCollection("grupo");
		MongoCollection<Document> collectioncompany = database.getCollection("company");
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();
		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT g FROM Grupo g");
		List<Grupo> listagrupos = (List<Grupo>)q.list();
		for(Grupo a:listagrupos) {
			List<Club> listaclubs = a.getClubsTocado();
			List<Pertenece> listaartistas = a.getArtistas();
			List<Disco> listadiscos = a.getDiscos();
			
			List<Document> clubs = new ArrayList<Document>();
			List<Document> artistas = new ArrayList<Document>();
			List<Document> discos = new ArrayList<Document>();


			
			Document d = new Document();
			for(Club c : listaclubs) {
				 d = new Document()
				.append("cod_club", c.getCod_club())
				.append("nombre_club", c.getNombre())
				.append("sede", c.getSede())
				.append("num_disco", c.getNum());
				 clubs.add(d);
				}
			for(Pertenece p: listaartistas) {
				d = new Document()
				.append("dni", p.getArtista().getDni())
				.append("nombre_artista", p.getArtista().getNombre())
				.append("funcion", p.getFuncion());
				artistas.add(d);
			}
			for(Disco disc: listadiscos) {
				List<Esta> canciones = disc.getCanciones();
				List<Document> cancionesdoc = new ArrayList<Document>();
				for(Esta c: canciones) {
					Document docum = new Document()
					.append("cod_cancion", c.getCancion_disco().getCod_cancion())
					.append("titulo_cancion", c.getCancion_disco().getTitulo())
					.append("duracion", c.getCancion_disco().getDuracion());
					cancionesdoc.add(docum);
					
				}
				d = new Document()
				.append("cod_disco", disc.getCod_disco())
				.append("nombre_disco", disc.getNombre())
				.append("fecha_disco", disc.getFecha())
				.append("canciones", cancionesdoc)
				.append("cod_company", disc.getCompany_disco().getCod_company());
				discos.add(d);
			}
			
					Document doc = new Document()
					.append("cod_grupo", a.getCod_grupo())
					.append("nombre_grupo", a.getNombre())
					.append("fecha_grupo", a.getFecha())
					.append("pais", a.getPais())
					.append("clubs", clubs)
					.append("artistas", artistas)
					.append("disco", discos);
					
					collection.insertOne(doc);
					
			}
		
		
		Query w = sesion.createQuery("SELECT g FROM Companyia g");
		List<Company> listacompanias = (List<Company>)w.list();
		for(Company c: listacompanias) {
			Document d = new Document()
			.append("cod_company", c.getCod_company())
			.append("nombre_company", c.getNombre())
			.append("dir_company", c.getDir())
			.append("fax", c.getFax())
			.append("tfno", c.getTfno());
			collectioncompany.insertOne(d);
		}
		
		System.out.println("Base de Datos Musica Creada !");
			
			
		}

}


