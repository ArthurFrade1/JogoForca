import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn[0]=btn1;
        btn[1]=btn2;
        btn[2]=btn3;
        btn[3]=btn4;
        btn[4]=btn5;
        btn[5]=btn6;
        btn[6]=btn7;
        btn[7]=btn8;
        btn[8]=btn9;
        btn[9]=btn10;
        btn[10]=btn11;
        btn[11]=btn12;
        btn[12]=btn13;
        btn[13]=btn14;
        btn[14]=btn15;
        btn[15]=btn16;
        btn[16]=btn17;
        btn[17]=btn18;
        btn[18]=btn19;
        btn[19]=btn20;
        btn[20]=btn21;
        btn[21]=btn22;
        btn[22]=btn23;
        btn[23]=btn24;
        btn[24]=btn25;
        btn[25]=btn26;
        btn[26]=btn27;


        txt[0]=txt1;
        txt[1]=txt2;
        txt[2]=txt3;
        txt[3]=txt4;
        txt[4]=txt5;
        txt[5]=txt6;
        txt[6]=txt7;     
    }

    @FXML
    private Button btnSair;

    @FXML
    private Button btnConferir;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btn1;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn13;

    @FXML
    private Button btn14;

    @FXML
    private Button btn15;

    @FXML
    private Button btn16;

    @FXML
    private Button btn17;

    @FXML
    private Button btn18;

    @FXML
    private Button btn19;

    @FXML
    private Button btn2;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private Button btn23;

    @FXML
    private Button btn24;

    @FXML
    private Button btn25;

    @FXML
    private Button btn26;

    @FXML
    private Button btn27;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Label lbl;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt6;

    @FXML
    private TextField txt7;

    private Button[] btn=new Button[27]; 
    private TextField[] txt= new TextField[7];
    private Adm control;
    private int tentativas=15;
    private boolean acabou=false;

    public Controller()  throws IOException{
        control= new Adm();
    }

    @FXML
    void btnclic(ActionEvent event) {

        if(event.getSource()==btnSair){
            System.exit(0);
        }

        if(event.getSource()==btnConferir){
           for(int cont=0; cont<7; cont++){
                txt[cont].setText(control.confere(cont));
                txt[cont].setAlignment(Pos.CENTER);
           }
           if(acabou==false){
            JOptionPane.showMessageDialog(null, "Derrota", "Resulcontroldo", 0);
            acabou=true;
           }
        }

        if(event.getSource()==btnNovo){
            for(int cont=0; cont<7; cont++){
                tentativas=16;
                txt[cont].setText("");
                control.limpar(cont);   
            }
            for(int cont=0; cont<27; cont++){
                btn[cont].setDisable(false);
            }
            acabou=false;
        }

        if(acabou==false){
            for(int cont=0; cont<27; cont++){
                if(event.getSource()==btn[cont]){
                    
                    String letra=btn[cont].getText();
                    btn[cont].setDisable(true);
                    boolean acerto=false;

                    for(int cont2=0; cont2<7; cont2++){           
                        if(control.verifica(cont2, letra)){
                            acerto=true;
                            txt[cont2].setAlignment(Pos.CENTER);
                            txt[cont2].setText(letra);
                        }
                    }
                    if(acerto==false){
                        JOptionPane.showMessageDialog(null, "Errou!", "Mensagem", 0);
                    }
                }
            }
            if(control.olhaFim()==1){
                JOptionPane.showMessageDialog(null, "Vitória", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                acabou=true;
            }
            tentativas--;
            lbl.setText("Você tem "+tentativas+" tentativas");
            if(tentativas==0){
                JOptionPane.showMessageDialog(null, "Derrota", "Resultado", 0);
                acabou=true;
            }
        }
    }

}
