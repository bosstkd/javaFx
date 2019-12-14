/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package helloworld;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Personne;
import helloworld.verif.verification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




/**
 * Controller class of the HelloWorld sample.
 */
public class HelloWorldController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML //  fx:id="button"
    private Button button; // Value injected by FXMLLoader
    
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField mail;

    /**
     * Initializes the controller class.
     */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
       // assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'HelloWorld.fxml'.";
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'premier_test.fxml'.";

    }

/*
    public void appuisSurBouton(ActionEvent event) throws IOException{
    	Parent prt = FXMLLoader.load(getClass().getResource("message.fxml"));
    	Scene helloCtr = new Scene(prt);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(helloCtr);
    	window.show();
    }
    */
    
    public void changeSceneToDetailsMessage(ActionEvent event) throws IOException{
    	
    	verification ver = new verification();
    	
    	System.out.println("Hello World "+nom.getText()+ ". prenom : " +prenom.getText()+ ".  du mail : "+mail.getText() );
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("message.fxml"));    	
    	Parent prt = loader.load();
    	
    	Scene helloCtr = new Scene(prt);
    	
    	//access the controller and call a method
    	messageController msgCtr = loader.getController();
			    
    				Personne prs = new Personne();
			    	prs.setNom(nom.getText());
			    	prs.setPrenom(prenom.getText());
			    	prs.setEmail(mail.getText());
			    	
			    	
			    	if(nom.getText().length()<2 || prenom.getText().length()<2) {
			    		prs.setNom("Veuillez vérifier le nom et le prénom svp !!");
				    	prs.setPrenom("");
			    		msgCtr.initData(prs, 2);
			    	}else if(!ver.isMail(mail.getText())) {
			    		prs.setNom("Fausse adresse mail");
				    	prs.setPrenom("");
			    		msgCtr.initData(prs, 1);
			    	}else {
			    		msgCtr.initData(prs, 0);
			    	}
			    	
			    	
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(helloCtr);
    	window.show();
    }
    
    
}
