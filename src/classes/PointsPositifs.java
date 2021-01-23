package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PointsPositifs extends RubriqueEcrite {

	private IntegerProperty idfPointsPos ;
	private StringProperty pointPos;
	private int numSeq=0;
	
	
	public PointsPositifs(String pointPos) {
		this.pointPos =  new SimpleStringProperty(pointPos);
	    numSeq++;
	}

	public int getIdfPointsPos() {
		return this.idfPointsPos.get();
	}

	public void setIdfPointsPos(int idfPointsPos) {
		this.idfPointsPos = new SimpleIntegerProperty(idfPointsPos);
	}

	public String getPointPos() {
		return this.pointPos.get();
	}

	public void setPointPos(String pointPos) {
		this.pointPos =  new SimpleStringProperty(pointPos);
	}

	public int getNumSeq() {
		return this.numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}
	
	
	public PointsPositifs() {
		   super();
		   idfPointsPos =new SimpleIntegerProperty();
		   pointPos= new SimpleStringProperty();
	       
	       }
	
	
	 //****=============FONCTION QUI PERMET DE NOUS CONNECTER A LA BDD===========
    Connection connection;



    public boolean isDataBaseConnected() {
        try {

            this.connection= DbConnection.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection != null;
    }
	//=======================================AJOUTER Point Positif============================*/
			public  boolean Insertion(int id,String PointPositif) {
				DbConnection db = new DbConnection();
			
				String query="INSERT INTO RubriquePointsPos (idfPointsPos,pointPos) VALUES (?, ?)";
				   try (PreparedStatement pr = this.connection.prepareStatement(query)) {
			            pr.setInt(1, id);
			            pr.setString(2, PointPositif);
			    
			            pr.executeUpdate();
			            return true;
			        }catch (SQLException e) {
			            System.out.println("Vous avez un probleme dans la classe PointPositif/ Insertion"+e);
			        return false;
			        } 	}
			
			
			
			
	    //========FONCTION QUI PERMET DE TROUVER LE POINT POSITIF DANS LA BDD
		    public PointsPositifs ChercherPointPositif(int idPointPos) throws  Exception{
		     PointsPositifs p = new PointsPositifs();
		    	PreparedStatement pr=null;
		        ResultSet rs=null;
		        String sql="select pointPos  from RubriquePointsPos where idfPointsPos = ?";//On utilise le numero de telephone du patient car c'est la seul donnée de la table qui est obligatoirement unique
		        try{
		            pr=this.connection.prepareStatement(sql);
		            pr.setInt(1,idPointPos);
		            rs = pr.executeQuery();
		            if (rs.next()){
		            	p.setIdfPointsPos(idPointPos);
		            	p.setPointPos(rs.getString("pointPos"));
		                return p;// dans le cas ou le point existe dans la BDD on retourne son vrai
		            }
		            else{
		                return null;// sinon on retourne faux
		            }
		        }
		        catch (SQLException e)
		        {

		            System.out.println("Vous avez un probleme dans la classe PointsPositifs/ChercherPointPositif");
		            return null;
		        }
		        finally {
		            assert pr != null;
		            pr.close();
		            assert rs!= null;
		            rs.close();
		        }

		    }


}