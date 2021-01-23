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

public class InfoApprises  extends RubriqueEcrite {
	private IntegerProperty   idfInfoApprise ;
	private StringProperty infoApprise;
	private int numSeq=0;
	
	
	public InfoApprises(String info) {
		this.infoApprise =  new SimpleStringProperty(info);
	    numSeq++;
	}

	public int getidfInfoApprise() {
		return this.idfInfoApprise.get();
	}

	public void setidfInfoApprise(int idfInfoApprise) {
		this.idfInfoApprise = new SimpleIntegerProperty(idfInfoApprise);
	}

	public String getInfoApprise() {
		return this.infoApprise.get();
	}

	public void setInfoApprise(String infoApprise) {
		this.infoApprise =  new SimpleStringProperty(infoApprise);
	}

	public int getNumSeq() {
		return this.numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}
	
	
	public InfoApprises() {
		   super();
		   idfInfoApprise =new SimpleIntegerProperty();
		   infoApprise= new SimpleStringProperty();
	       
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
			public  boolean Insertion(int id,String Info) {
				DbConnection db = new DbConnection();
				
				
				int rst=-1;
				String query="INSERT INTO RubriqueInfoApprises (idfInfoApprise,infoApprise ) VALUES (?, ?)";
				   try (PreparedStatement pr = this.connection.prepareStatement(query)) {
			            pr.setInt(1, id);
			            pr.setString(2, Info);
			           rst= pr.executeUpdate();
			         
			            return true;
			    
				   
				   
				   }catch (SQLException e) {
			            System.out.println("Vous avez un probleme dans la classe InfoApprise/ Insertion"+e);
			        return false;
			        } 	}
			
			
			
			
	    //========FONCTION QUI PERMET DE TROUVER LE POINT POSITIF DANS LA BDD
		    public InfoApprises ChercherInfoApprise(int idinfoApprise ) throws  Exception{
		    	InfoApprises p = new InfoApprises();
		    	PreparedStatement pr=null;
		        ResultSet rs=null;
		        String sql="select infoApprise from RubriqueInfoApprises where idfInfoApprise= ?";//On utilise le numero de telephone du patient car c'est la seul donnée de la table qui est obligatoirement unique
		        try{
		            pr=this.connection.prepareStatement(sql);
		            pr.setInt(1,idinfoApprise);
		            rs = pr.executeQuery();
		            if (rs.next()){
		            	
		            	p.setidfInfoApprise(idinfoApprise);
		            	p.setInfoApprise(rs.getString("infoApprise"));
		                return p;// dans le cas ou le point existe dans la BDD on retourne son vrai
		            }
		            else{
		                return null;// sinon on retourne faux
		            }
		        }
		        catch (SQLException e)
		        {

		            System.out.println("Vous avez un probleme dans la classe InfoApprise/ChercherInfoApprise");
		            return null;
		        }
		        finally {
		            assert pr != null;
		            pr.close();
		            assert rs!= null;
		            rs.close();
		        }

		    }
		    //****=============FONCTION QUI PERMET DE MODIFIER LINFO========================
		    public boolean ModifierInfo(String NouvelleInfo,int IdInfo) {

		        String query ="UPDATE  RubriqueInfoApprises SET infoApprise = ? WHERE idfInfoApprise = ? ";

		        try (PreparedStatement pr = this.connection.prepareStatement(query)) {
		            pr.setString(1, NouvelleInfo);
		          pr.setInt(2, IdInfo);
		            System.out.println(IdInfo);
		            
		       
		            
		        pr.executeUpdate();
		        return true;
		     
		       
		        } catch (SQLException e) {
		            System.out.println("Vous avez un probleme dans la classe Infoapp/ModifierInfo");
		        return false;
		        }

		    }
		    



}
