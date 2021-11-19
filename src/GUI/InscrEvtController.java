/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ConnexionDB.Connexion;
import Service.EvtEnfantService;
import Service.EvenementService;
import Service.ExcurtionService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import entity.EvtEnfant;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InscrEvtController implements Initializable {
     private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    

      private entity.Parent p;
    @FXML
    private JFXButton Inscrire;
    @FXML
    private JFXButton Annuler;
    @FXML
    private JFXComboBox<String> txtEvt;
     ObservableList <String>listEvt;
//      ObservableList <Integer>listID;
    @FXML
    private ImageView imageview;
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         con=Connexion.getInstance().getCnx();
        listEvt=FXCollections.observableArrayList();
        
        try {
            pst=con.prepareStatement("select nom from evenement ");
               rs=pst.executeQuery();
        while(rs.next())
        {
        listEvt.add(rs.getString(1));
        
        
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(InscrEvtController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtEvt.setItems(listEvt);
        // TODO
    }    

    @FXML
    private void inscrire(ActionEvent event) {
        int pc=-1,enfantid=-1;
        pc=p.getId_User();
        
        String req="select id_enfant from enfant where id_parent='"+pc+"'";
         try {
             pst=con.prepareStatement(req);
             rs=pst.executeQuery();
             if (rs.first())
             {
                 enfantid=rs.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(InscrEvtController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       EvtEnfantService EV=new EvtEnfantService();
    EvenementService ES=new EvenementService();
    
        System.out.println(ES);
       int i=-1;
          i= ES.retourid(txtEvt.getValue());
          String url="";
       
             
            EV.insert(new EvtEnfant(i, enfantid));
    }

    @FXML
    private void Annuler(ActionEvent event) {
        EvenementService ES=new EvenementService();
        int i=-1;
        int pc=-1,enfantid=-1;
        pc=p.getId_User();
          i= ES.retourid(txtEvt.getValue());
         String req1="select id_enfant from enfant where id_parent='"+pc+"'";
         try {
             pst=con.prepareStatement(req1);
             rs=pst.executeQuery();
             if (rs.first())
             {
                 enfantid=rs.getInt(1);
             }
             
         }catch (SQLException ex) {
             Logger.getLogger(InscrEvtController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         String req2="delete from inscrevt where   id='"+i+"' and id_enfant='"+enfantid+"'";
         try {
             pst=con.prepareStatement(req1);
               rs=pst.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(InscrEvtController.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
  
}
