/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ExcurtionService;
import Service.FeteService;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import entity.Excurtion;
import entity.Fete;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterFeteController implements Initializable {
    List <String>firstfile;

    @FXML
    private JFXTextField txtNom;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtImg;
    @FXML
    private ComboBox<String> txtCapacite;
    ObservableList<String> listC=FXCollections.observableArrayList("25","50","75");
    @FXML
    private ComboBox<String> txtType;
    ObservableList<String> list=FXCollections.observableArrayList("Fête");
    @FXML
    private JFXTextField txtLieu;
    @FXML
    private JFXDatePicker txtDate;
    @FXML
    private JFXTimePicker txtHeure;
    @FXML
    private Button ajouter;
    @FXML
    private Button select;
    @FXML
    private Button backEVT;
    @FXML
    private Button AffFete;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtType.setItems(list);
        txtCapacite.setItems(listC);
        firstfile=new ArrayList<>();
        firstfile.add("*.JPG");
        firstfile.add("*.PNG");
        firstfile.add("*.JPEG");
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        FeteService FS = new FeteService();
                FS.insert(new Fete(txtLieu.getText(),txtCapacite.getValue(), txtNom.getText(),txtHeure.getValue().toString(), txtDescription.getText(), txtDate.getValue().toString(), txtImg.getText(), txtType.getValue()));
                JOptionPane.showMessageDialog(null, "ajout termine");
        
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
         AnchorPane pane=FXMLLoader.load(getClass().getResource("Evenements.fxml"));
        Scene s2=new Scene(pane);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(s2);
        Window.show();
    }

    @FXML
    private void AffFete(ActionEvent event) throws IOException {
         AnchorPane pane=FXMLLoader.load(getClass().getResource("AfficherFete.fxml"));
        Scene s2=new Scene(pane);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(s2);
        Window.show();
        
    }
    
}
