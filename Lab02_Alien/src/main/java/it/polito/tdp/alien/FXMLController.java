package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary alienDictionary = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lblTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	lblTesto.clear();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String riga=lblTesto.getText().toLowerCase();
    	if((riga==null)||(riga.length()==0)) {
    		txtResult.setText("Inserire una parola valida");
    		return;
    	}
    	StringTokenizer st= new StringTokenizer(riga," ");
    	String parolaAliena=st.nextToken();
    	if(st.hasMoreTokens()) { //ho piu di un elemento
    		String parolaTradotta=st.nextToken();
    		if((!parolaAliena.matches("[a-zA-Z]*"))||(!parolaTradotta.matches("[a-zA-Z]*"))) {
    			txtResult.setText("Inserire una parola con caratteri alfabetici");
    			return;
    		}
    		else {
    			alienDictionary.addWord(parolaAliena, parolaTradotta);
    			txtResult.setText("Parola e traduzione inserite correttamente");
    			return;
    		}
    	}
    	else {
    		String s=alienDictionary.translateWord(parolaAliena);
    		if(s==null) {
    			txtResult.setText("Traduzione di questa parola inesistente");
    			return;
    		}
    		else {
    			txtResult.setText("La traduzione corrispondente alla parola: "+parolaAliena+" e': "+s);
    			return;
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Untitled'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Untitled'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Untitled'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Untitled'.";

    }
}
