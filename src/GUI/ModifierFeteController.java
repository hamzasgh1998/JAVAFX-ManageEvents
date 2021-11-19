/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ConnexionDB.Connexion;
import Service.ExcurtionService;
import Service.FeteService;
import com.jfoenix.controls.JFXTimePicker;
import entity.Excurtion;
import entity.Fete;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierFeteController implements Initializable {
    private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    List <String>firstfile;

       private ObservableList<Integer> list;

    @FXML
    private ComboBox<Integer> idModifier;
    @FXML
    private TextField txtCapacite;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtImg;
    @FXML
     private ComboBox<String> txtType;
    ObservableList<String> list1=FXCollections.observableArrayList("Fête");
    @FXML
    private JFXTimePicker txtHeure;
    @FXML
    private DatePicker txtDate;
    @FXML
    private Button modifier;
    @FXML
    private TextField txtLieu;
    @FXML
    private Button select;
    @FXML
    private Button backEVT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         firstfile=new ArrayList<>();
        firstfile.add("*.JPG");
        firstfile.add("*.PNG");
        firstfile.add("*.JPEG");
         con=Connexion.getInstance().getCnx();
        list=FXCollections.observableArrayList();
          txtType.setItems(list1);
        try {
            pst=con.prepareStatement("select id from evenement where type='fête'");
            rs=pst.executeQuery();
            while (rs.next())
            {
                
                list.add(rs.getInt(1));
            
            }
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ModifierExcursionController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        idModifier.setItems(list);
    }    

    @FXML
    private void modifier(ActionEvent event) {
        
        FeteService FS=new FeteService();
        try {
            int val=-1;
            String val2="";
            pst=con.prepareStatement("select id from evenement where id=? and type='fête'");
            pst.setInt(1,idModifier.getValue());
            rs=pst.executeQuery();
            while(rs.next())
            {
            val=rs.getInt(1);
            val2=rs.getString(4);
            txtLieu.setPromptText(val2);
            }
            FS.update(new Fete( txtLieu.getText(),val, txtCapacite.getText(), txtNom.getText(), txtHeure.getValue().toString(), txtDescription.getText() , txtDate.getValue().toString(), txtImg.getText(), txtType.getValue()));
            JOptionPane.showMessageDialog(null, "Modif termine");
        } catch (SQLException ex) {
            Logger.getLogger(ModifierFeteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void select(ActionEvent event) {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", firstfile));
        File F=fc.showOpenDialog(null);
        if (F!=null)
            txtImg.setText(F.getAbsolutePath());
    }

    @FXML
    private void backEVT(ActionEvent event) throws IOException {
           AnchorPane pane=FXMLLoader.load(getClass().getResource("AjouterFete.fxml"));
        Scene s2=new Scene(pane);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(s2);
        Window.show();
    }
    
}
