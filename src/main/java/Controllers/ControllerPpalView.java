package Controllers;

import Logic.Calculadora;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerPpalView {

    //PARTES DE LA VISTA
    @FXML
    private TextArea areaMatriz;

    @FXML
    private TextField txtCantNodos;

    @FXML
    private TextArea areaResultado;


    //PARTES DE LA LOGICA

    private Calculadora calculadora = new Calculadora();

    //CODIGO
    @FXML
    public void warshall(){

        String matriz = areaMatriz.getText();
        String s = matriz.replaceAll("\n", "");
        int nodos = Integer.parseInt(txtCantNodos.getText());

        if(verificar(s,1)){
            int[][] matrizx = transformar(s,nodos);
            String respuesta = calculadora.resolverWarshal(nodos, matrizx);
            areaResultado.setText("");
            areaResultado.setText(respuesta);
        }else{
            areaResultado.setText("");
            areaResultado.setText("ERROR A LA HORA DE INGRESAR LA MATRIZ");
        }
    }

    @FXML
    public void conexidad(){
        int nodos = Integer.parseInt(txtCantNodos.getText());
        String matriz = areaMatriz.getText();
        String s = matriz.replaceAll("\n", "");

        if(verificar(s,1)){
            int[][] matrizx = transformar(s,nodos);
            String respuesta = calculadora.resolverConexidad(nodos,matrizx);
            areaResultado.setText("");
            areaResultado.setText(respuesta);
        }else{
            areaResultado.setText("");
            areaResultado.setText("ERROR A LA HORA DE INGRESAR LA MATRIZ");
        }
    }

    @FXML
    public void productoLogico(){
        int nodos = Integer.parseInt(txtCantNodos.getText());
        String matriz = areaMatriz.getText();
        String s = matriz.replaceAll("\n", "");

        if(verificar(s,1)){
            int[][] matrizx = transformar(s, nodos);
            String respuesta = calculadora.resolverProductoLogico(nodos,matrizx);
            areaResultado.setText("");
            areaResultado.setText(respuesta);
        }
    }

    @FXML
    public void productoLogicoSimple(){
        int nodos = Integer.parseInt(txtCantNodos.getText());
        String matriz = areaMatriz.getText();
        String s = matriz.replaceAll("\n", "");
        if(verificar(s,1)){
            int[][] matrizx = transformar(s, nodos);
            String respuesta = calculadora.resolverProductoLogicoSimple(nodos,matrizx);
            areaResultado.setText("");
            areaResultado.setText(respuesta);
        }
    }

    @FXML
    public void Shumbell(){
        int nodos = Integer.parseInt(txtCantNodos.getText());
        String matriz = areaMatriz.getText();
        String s = matriz.replaceAll("\n", "");
        if(verificar(s,2)){

        }
    }

    //METODOS AUXILIARES

    public boolean verificar(String content,int opcion){
        boolean verificacion = true;
        switch (opcion){
            case 1:
                for(int i=0; i<content.length(); i++){
                    if(content.charAt(i)!='1' && content.charAt(i)!='0'){
                        verificacion=false;
                        break;
                    }
                }
                break;
            case 2:
                for(int i=0; i<content.length(); i++){
                    if(Character.getNumericValue(content.charAt(i))<0){
                        verificacion=false;
                        break;
                    }
                }
                break;
            default:
                verificacion = false;
        }

        return verificacion;
    }

    public int[][] transformar(String content, int nodos){
        int[][] matriz = new int[nodos][nodos];
        String aux = content;
        int contador = 0;
        for(int i = 0; i<nodos; i++){
            for(int j = 0; j<nodos; j++){
                matriz[i][j]=Character.getNumericValue(aux.charAt(contador));
                contador++;
            }
        }
        return matriz;
    }

}
