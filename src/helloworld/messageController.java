package helloworld;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Personne;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class messageController implements Initializable	
{

	    @FXML
	    private Label msg;
	    @FXML
	    private ImageView logo;
	    @FXML
	    private Button btn;
	


	    private Personne prs;
	    
	    public void initData(Personne personne, int degree) {
	    	File file;
	    	switch (degree) {
			case 0:
				 file = new File("src/helloworld/imgs/info.jpg");
				break;
				
			case 1:
				 file = new File("src/helloworld/imgs/warning.jpg");
				break;	

			default:
				 file = new File("src/helloworld/imgs/error.jpg");
				break;
			}
	    	
	    	 
	         Image image = new Image(file.toURI().toString());
	         logo.setImage(image);
	    	
	    	prs = personne;
	    	msg.setText(prs.getNom()+" "+prs.getPrenom()+". Mon email est: "+prs.getEmail());
	    	
	    }
	    
	    
	    public void appuisSurBouton(ActionEvent event) throws IOException{
	    	
	    	System.out.println("button ok");
	    	Parent prt = FXMLLoader.load(getClass().getResource("premier_test.fxml"));
	    	Scene helloCtr = new Scene(prt);
	    	
	    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(helloCtr);
	    	window.show();
	    }
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			 assert btn != null : "fx:id=\"button\" was not injected: check your FXML file 'premier_test.fxml'.";
			 
			         if (btn != null) {
			        	 btn.setOnAction(new EventHandler<ActionEvent>() {
			                 @Override
			                 public void handle(ActionEvent event) {
			                 	
			                	System.out.println("button ok");
			         	    	Parent prt;
								try {
									prt = FXMLLoader.load(getClass().getResource("premier_test.fxml"));
									Scene helloCtr = new Scene(prt);
				         	    	
				         	    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				         	    	window.setScene(helloCtr);
				         	    	window.show();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			         	    	
			                 	
			                 }
			             });
			         }
		}

		public Personne getPrs() {
			return prs;
		}

		public void setPrs(Personne prs) {
			this.prs = prs;
		}
	    
		
	    
}
