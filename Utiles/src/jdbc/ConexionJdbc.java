package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import excepciones.ConnectionException;

public class ConexionJdbc {

	//Atributo para guardar la conexi�n que se obtiene al conectar
	private static Connection con; 
	
	//Atributos para almacenar los datos con los que se ha conectado
	private String driver;
	private String url;
	private String usr;
	private String pwd;
	
	//Atributo para almacenar el nombre del fichero de configuraci�n con el que se ha conectado
	private String ficheroConfiguracion; 
	
	//Recibe cuatro par�metros con los datos de la conexi�n
	private void conectar(String driver, String url, String usr, String pwd) throws ConnectionException{
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(usr);
		ds.setPassword(pwd);
		
			
		
	}
	
	
	
	// recibe el nombre del fichero de configuraci�n (properties) que contiene los datos de la conexi�n.
	public void conectar(String ficheroConfiguracion) throws ConnectionException{
		
		this.ficheroConfiguracion = ficheroConfiguracion;
		
	}
		  
	
	
	/**
	* Constructor: Crea el objeto conocidos el driver,url,usr y pwd, que se almacenan
	* en atributos privados
	*/
	public ConexionJdbc (String driver, String url, String usr, String pwd){
	 this.driver = driver;
	 this.url = url;
	 this.usr = usr;
	 this.pwd = pwd;
	 
	 
	 
	}
	
	
	/**
	* Constructor: Crea el objeto conocido el nombre del fichero de configuraci�n y lo almacena
	* en un atributo privado.
	*/
	public ConexionJdbc (String ficheroConfiguracion){
	 this.ficheroConfiguracion = ficheroConfiguracion;
	 conectar(ficheroConfiguracion);
	} 
	
	/**
	* Conecta con la base de datos.
	* Si el atributo ficheroConfiguracion tiene valor (no nulo), lo utilizar� para conectar.
	* En caso de que ficheroConfiguracion sea nulo, conecta utilizando los atributos driver,url, usr y
	* pwd.
	* Una vez establecida la conexi�n, �sta se almacena en el atributo con
	* Para conectar har� uso de los m�todos privados implementados anteriormente
	*/
	public void conectar() {
		
		if (this.ficheroConfiguracion != null) {
			try {
				
				Properties propiedades = new Properties();
				propiedades.load(new FileInputStream(ficheroConfiguracion));
				
				DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
				con = ds.getConnection();
				System.out.println("Conexion realizada");
			
			}catch(FileNotFoundException e){
				e.printStackTrace();
				System.out.println("Archivo no encontrado");
				Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "No se encuentra el fichero de configuraci�n", e);
				
			}catch(IOException e) {
				e.printStackTrace();
				Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "No se puede leer el fichero de configuraci�n", e);
			}catch(Exception e) {
				e.printStackTrace();
				Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "Error de conexi�n", e);
			}
			
			
		}
		
		else {
			
			try {
				
				Class.forName(driver).newInstance();
				System.out.println("Registrado");
				
				con = DriverManager.getConnection(url, usr, pwd);
				System.out.println("Conectado");
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
			
			
	}
		
		
		
		
	
	/**
	* M�todo consultor. Devuelve el atributo con
	*/
	public static Connection getConnection(){
		return con;
		
	} 
	
	/**
	* Cierra la conexi�n almacenada en el atributo con (si no es null y est� abierta)
	*/
	public void desconectar(){
		try {
			if(con!=null && !con.isClosed()) {
				con.close();
			}
			System.out.println("Desconectado");
		}catch(SQLException f) {
			f.printStackTrace();
			
			}
	}
	
	
	
	/**
	* Cierra un ResultSet (si no es null y est� abierto)
	*/
	public static void cerrar(ResultSet rs){
		
		try {
			if(rs!=null && !rs.isClosed()) {
				rs.close();
			}
			System.out.println("ResultSet Desconectado");
		}catch(SQLException f) {
			f.printStackTrace();
			
			}
			
		
	}
	
	
	/**
	* Cierra un Statement(si no es null y est� abierto)
	* Este m�todo servir� tanto para cerrar Statemen como para PreparedStatement ya que
	* el segundo es subclase del primero.
	*/
	public static void cerrar(Statement stm){
		
		try {
			if(stm!=null && !stm.isClosed()) {
				stm.close();
			}
			System.out.println("Statement / PreparedStatement Desconectado");
		}catch(SQLException f) {
			f.printStackTrace();
			
			}
			
		
		
	} 

	

}
