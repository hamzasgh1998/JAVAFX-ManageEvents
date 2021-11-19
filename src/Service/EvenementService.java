/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import ConnexionDB.Connexion;
import entity.Evenements;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EvenementService implements IServiceEvt<Evenements>{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public EvenementService() {
            cnx=Connexion.getInstance().getCnx();

    }
    
    @Override
    public void insert(Evenements t) {

        String req="insert into evenement (capacite,nom,heure_d,description,date_evt,image,type,depart,destination,lieu) values('"+t.getCapacite()+"','"+t.getNom()+"','"+t.getHeure_d()+"','"+t.getDescription()+"','"+t.getDate_evt()+"','"+t.getImage()+"','"+t.getType()+"',"+null+","+null+","+null+")";
        try {
            st=cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void update(Evenements t) {
        int test=0;
 String req = "UPDATE evenement SET capacite=?,nom=?,heure_d=?,description=?,date_evt=?,image=?,type=?  WHERE id=?";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1,t.getCapacite());
            pst.setString(2,t.getNom());
            pst.setString(3,t.getHeure_d());
            
            pst.setString(4,t.getDescription());
            pst.setString(5,t.getDate_evt());
            pst.setString(6,t.getImage());
            pst.setString(7,t.getType());
            pst.setInt(8,t.getId());

         test= pst.executeUpdate();
            if (test!=0) {
                System.out.println("c bn");
                }
            else {System.out.println("erreur");}
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public boolean delete(int id) {
 int test = 0;
        String req="delete from evenement where id="+id+"";
        try {
            st=cnx.createStatement();
          test= st.executeUpdate(req);
         
        
            
        } catch (SQLException ex) {
            Logger.getLogger(Service.EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
       if (test!=0){
          return true;
          } 
       return false;    }
    
    public int retourid(String nom)
    {
      int i=-1;
    String req="select id from evenement where nom='"+nom+"'";
        try {  
            st=cnx.createStatement();
            
             rs=st.executeQuery(req);
            
             if (rs.first())
            {
                
            i= rs.getInt(1);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    
    }

    @Override
    public List<Evenements> displayAll() {

         String req="select * from evenement";
        List<Evenements> list =new ArrayList<>();
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while(rs.next())
            {
 list.add(new Evenements(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
