/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author 王竹青
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label pantalla;
    @FXML
    private GridPane gridpane;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         String css = this.getClass().getResource("botonEstilo2.css").toExternalForm();
         gridpane.getStylesheets().add(css);
        
    }    

    @FXML
    private void clic6(ActionEvent event) {
        resPantalla("6");
    }

    @FXML
    private void clic9(ActionEvent event) {
        resPantalla("9");
    }

    @FXML
    private void clic8(ActionEvent event) {
        resPantalla("8");
    }

    @FXML
    private void clic0(ActionEvent event) {
        resPantalla("0");
    }

    @FXML
    private void clic1(ActionEvent event) {
        resPantalla("1");
    }

    @FXML
    private void clic4(ActionEvent event) {
        resPantalla("4");
    }

    @FXML
    private void clic7(ActionEvent event) {
        resPantalla("7");
    }

    @FXML
    private void clic2(ActionEvent event) {
        resPantalla("2");
    }

    @FXML
    private void clic3(ActionEvent event) {
        resPantalla("3");
    }

    @FXML
    private void clic5(ActionEvent event) {
        resPantalla("5");
    }
    
    private boolean digito = false;
    private boolean punto = false;
    private int suma = 0;
    private int numOperandos = 0;
    private double Operador1,Operador2;
    private char Operador = ' ';
    
    private void resPantalla(String numero){
         if(!digito && numero.equals("0")){   //ver si esta presionando un digito o un numero
              return;
         }
         if(!digito){
             pantalla.setText("");
             punto = false;
         }
         String valorActual = pantalla.getText();
         pantalla.setText(valorActual + numero);
         digito = true;
    }

    @FXML
    private void clicpunto(ActionEvent event) {
        if(!punto && !digito){
        pantalla.setText("0.");
        digito = true;        
        }
        else if(!punto){
            String valorActual = pantalla.getText();
            pantalla.setText(valorActual + ".");
        }
        punto = true;
    }    

    @FXML
    private void clicValor(ActionEvent event) {
        if(digito){
        pantalla.setText("-" + pantalla.getText());
        }
    }

    @FXML
    private void clicPorcentaje(ActionEvent event) {
        if(numOperandos == 0){
         pantalla.setText("0");
         return;
        }
        
        double valor = Double.parseDouble(pantalla.getText());
        double porcentaje = (Operador1 * valor) / 100;
        pantalla.setText(String.valueOf(porcentaje));
        digito = true;
        punto = true;
    }

    @FXML
    private void clicIgual(ActionEvent event) {
        evaluarOperador("=");
    }

    @FXML
    private void clicSuma(ActionEvent event) {
        evaluarOperador("+");
    }

    @FXML
    private void clicBorrar(ActionEvent event) {
        digito = false;
        punto = false;
        numOperandos = 0;
        Operador1 = 0;
        Operador2 = 0;
        Operador = ' ';
        pantalla.setText("");
    }

    @FXML
    private void clicMenos(ActionEvent event) {
        evaluarOperador("-");
    }

    @FXML
    private void clicPor(ActionEvent event) {
        evaluarOperador("x");
    }

    @FXML
    private void clicDividir(ActionEvent event) {
        evaluarOperador("÷");
    }
    
    public void evaluarOperador(String Operador){
       if(digito){
          numOperandos ++;
               }  
       if(numOperandos == 1 ){
          Operador1 = Double.parseDouble(pantalla.getText());
       }  
       if(numOperandos == 2){
          Operador2 = Double.parseDouble(pantalla.getText());
          
          switch(this.Operador)
          {
              case '+':
              Operador1 = Operador1 + Operador2;
              break;
                case '-':
              Operador1 = Operador1 - Operador2;
              break;
                case '÷':
              Operador1 = Operador1 / Operador2;
              break;
                case 'x':
              Operador1 = Operador1 * Operador2;
              break;
                case '=':
              Operador1 = Operador2;
              break;
              
          }
           pantalla.setText(String.valueOf(Operador1));
           numOperandos = 1;
           punto = false;
       }
       digito = false;
       this.Operador = Operador.charAt(0);

    }

   
}
