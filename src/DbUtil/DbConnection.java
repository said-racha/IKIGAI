package DbUtil;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DbConnection {

	private static final String SQCONN="jdbc:sqlite:IKIGAI.sqlite";
	private static Connection connection=null;
	
	//cette methode nous permet d'obtenir une connection a la base de donn�e
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(SQCONN);
		
		} catch (ClassNotFoundException ex) {
			System.out.println("vous avez un probleme avec la classe Dbconnection");
			ex.printStackTrace();
			
		}
		
		return null;	
	}
	
	
	//cette methode est pour connecter connection a notre base de donn�e
	public static void dbConnect() {
		
		try {
			
			connection=DbConnection.getConnection();
		
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec DbConnection/ dbConnect :Erreur de connection avec la base de donn�e");
			e.printStackTrace();
		}
		
		if(connection==null)
		{
			System.out.println("Vous avez un probleme avec DbConnection/ dbConnect :Erreur de connection avec la base de donn�e");
			System.exit(1);
		}
	}
	
	
	//cette methode sert a fermer la connection � la base de donn�e
	public static void dbDisconnect() throws SQLException{
		try {
			
			if(connection !=null && !connection.isClosed())
				connection.close();
			
		}catch (Exception e) {
			System.out.println("Vous avez un probleme avec DbConnection/ dbDisconnect");
			throw e;
		}
	}
	
	
	//cette methode nous permet d'executer les commandes Inserer supprimer modifier ou n'importe qu'elle commande Sql qui ne retourne rien
	public static void dbExcecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException{
		
		Statement stmt =null;
		
		try {
			dbConnect();
			stmt = connection.createStatement();
			stmt.executeUpdate(sqlStmt);
			
		}catch(SQLException e) {
			System.out.println("Vous avez un probleme dans DBConnection/dbExcecuteQuery");
			throw e;
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
			
			dbDisconnect();	
		}		
	}
	
	//cette methode est pour recuperer les donn�es de notre base de donn�e
	public static ResultSet dbExecute(String sqlQuery)throws ClassNotFoundException, SQLException{
		Statement stmt=null;
		ResultSet rs=null; 
		CachedRowSetImpl crs=null;//c'est l'objet qu'on va retourner CachedRowSetImpl est une classe fille de ResultSet
		
		try {
			dbConnect();
			stmt=connection.createStatement();
			rs= stmt.executeQuery(sqlQuery);
			crs=new CachedRowSetImpl(); //permet de stocker des donn�es provenant d'une base de donn�es en m�moire 
			crs.populate(rs);//remplir l'objet des donn�es lanc�s par le rs, ca m'evite de passer par un preparedStatement, j'execute le toue en une ligne de code
			
			
		}catch (SQLException e) {
			System.out.println("Vous avez une erreur de connection dans DbConnection/dbExecute ");
			throw e;
		}
		finally {
			if(rs !=null)
				rs.close();
			
			if(stmt !=null)
				stmt.close();
			
			dbDisconnect();
		}
		
		return crs;
		
	}
	
	


}
