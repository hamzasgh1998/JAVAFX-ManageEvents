/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ConnexionDB.Connexion;
import Service.ExcurtionService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.WriterException;
import com.jfoenix.controls.JFXButton;
import com.qoppa.pdfViewerFX.PDFToolBar;
import entity.Excurtion;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.annotations.Property;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherExcursionController implements Initializable {
    private ObservableList<Excurtion> data;

    @FXML
    private Button Afficher;
    private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    @FXML
    private TableView<Excurtion> table;
    @FXML
    private TableColumn<Excurtion,String > capacite;
    @FXML
    private TableColumn<Excurtion, String> nom;
    @FXML
    private TableColumn<Excurtion, String> heure;
    @FXML
    private TableColumn<Excurtion, String> description;
    @FXML
    private TableColumn<Excurtion, String> date;
    @FXML
    private TableColumn<Excurtion, String> image;
    @FXML
    private TableColumn<Excurtion, String> type;
    @FXML
    private TableColumn<Excurtion, String> depart;
    @FXML
    private TableColumn<Excurtion, String> destination;
    @FXML
    private TextField txtRech;
    @FXML
    private ComboBox<Integer> txtSupp;
    @FXML
    private Button supprimer;
     private ObservableList <Integer>listsupp;
    @FXML
    private Button backAjout;
    @FXML
    private Button Modifier;
    @FXML
    private Button download;
    
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con=Connexion.getInstance().getCnx();
        data =FXCollections.observableArrayList();
        setCellTable();
        listsupp=FXCollections.observableArrayList();
        try {
            pst=con.prepareStatement("select id from evenement where type='excursion'");
               rs=pst.executeQuery();
        while(rs.next())
        {
        listsupp.add(rs.getInt(1));
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtSupp.setItems(listsupp);
     
        
        
        // TODO
    }  
    
    private void setCellTable(){
   // id.setCellValueFactory(new PropertyValueFactory<>("id"));
     capacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
      nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       heure.setCellValueFactory(new PropertyValueFactory<>("heure_d"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
         date.setCellValueFactory(new PropertyValueFactory<>("date_evt"));
          image.setCellValueFactory(new PropertyValueFactory<>("image"));
          type.setCellValueFactory(new PropertyValueFactory<>("type"));
          depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
          destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
               
       



}
    @FXML
    private void Afficher(ActionEvent event) {
        try {
            data.clear();
            pst=con.prepareStatement("select * from evenement where type='excursion'");
            rs=pst.executeQuery();
        while(rs.next()){
       data.add(new Excurtion(rs.getString(9), rs.getString(10),rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));               
        
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      table.setItems(data);
        
    }


    private void modifier(ActionEvent event) {
          try {
            data.clear();
            pst=con.prepareStatement("select * from evenement where type='excursion' ");
            rs=pst.executeQuery();
        while(rs.next()){
       data.add(new Excurtion(rs.getString(9), rs.getString(10),rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));               
        
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      table.setItems(data);
        
        

    }

    @FXML
    private void recherche(KeyEvent event) {
          try {
            data.clear();
            pst=con.prepareStatement("select * from evenement where type='excursion' and id='"+txtRech.getText()+"' ");
            rs=pst.executeQuery();
        while(rs.next()){
       data.add(new Excurtion(rs.getString(9), rs.getString(10),rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));               
        
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      table.setItems(data);
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ExcurtionService ES=new ExcurtionService();
        int val=-1;
        try {
            pst=con.prepareStatement("select id from evenement where id=?");
            pst.setInt(1, txtSupp.getValue());
            rs=pst.executeQuery();
            while(rs.next()){
                val=rs.getInt(1);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ES.delete(val);
        listsupp.clear();
        
        try {
            pst=con.prepareStatement("select id from evenement where type='excursion'");
               rs=pst.executeQuery();
        while(rs.next())
        {
        listsupp.add(rs.getInt(1));
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtSupp.setItems(listsupp);
     
        
    }

    @FXML
    private void backAjout(ActionEvent event) throws IOException {
         AnchorPane pane=FXMLLoader.load(getClass().getResource("AjouterEvt.fxml"));
        Scene s2=new Scene(pane);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(s2);
        Window.show();
        
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        
         AnchorPane pane=FXMLLoader.load(getClass().getResource("ModifierExcursion.fxml"));
        Scene s2=new Scene(pane);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(s2);
        Window.show();
        
        
    }

    @FXML
    private void download(ActionEvent event) throws DocumentException, SQLException  {
       
        try {
             String filename="D:\\pdf\\db.pdf";
            Document doucment = new Document();
            PdfWriter.getInstance(doucment, new FileOutputStream(filename));
            
            doucment.open();
            String req="select * from evenement where type='Excursion'";
        int i=0;
            pst=con.prepareStatement(req);
            rs=pst.executeQuery();
             rs=pst.executeQuery();
              while(rs.next()){
                  i++;
        Paragraph para=new Paragraph("* "+i+" *"+"Depart: "+rs.getString(9)+"----->Destination:"+rs.getString(10)+" /// Id:"+rs.getInt(1)+" /// Capacite:"+rs.getString(2)+" /// Nom: "+rs.getString(3)+" /// Heure Debut:"+rs.getString(4)+" /// Description:"+rs.getString(5)+" /// Date Evt:"+rs.getString(6)+" ///Chemindu photo:"+rs.getString(7)+" /// Type:"+rs.getString(8)+"\n"+"\n");
        doucment.add(para);
       
        }
            doucment.close();
            JOptionPane.showMessageDialog(null, "ajout termine");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherExcursionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
    }

    
            
    }





   

   
  

    

