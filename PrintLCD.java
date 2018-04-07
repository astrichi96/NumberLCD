/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberlcd;

import java.util.ArrayList;

/**
 *
 * @author - Astrid Vanegas Chinchilla
 */
public class PrintLCD {
    
    private int size;                           ////////// Variable que indica el tamaño ingresado por el usuario
    private String cadenaNum;                   ////////// Variable que contiene los numeros que se deben imprimir
    private String matrizPrint[][];             ////////// Matriz auxiliar que permitira identificar numero por numero
    private int fila;                           ////////// Variable que indica el numero de filas para cada numero que se imprimirá
    private int columna;                        ////////// Variable que indica el numero de columnas para cada numero que se imprimirá
    
////////////////////////////////////////////////////////// Matriz donde se almacenara el resultado final, es decir, la que 
                                               /////////// que permitira ver los numeros en la pantalla
    private ArrayList<ArrayList<String>> matrizRespuesta = new ArrayList<>();
    
    public PrintLCD(int size, String cadenaNum){
        this.size = size;
        this.cadenaNum = cadenaNum;
        this.fila = (2*(this.size)) + 3;        ////////// El tamaño se determina de acuerdo al ingresado y los criterios establecidos en el ejercio
        this.columna = this.size +2;
        this.matrizPrint = new String[this.fila][this.columna]; // Iniciarlizar la matriz de acuerdo a las dimensiones anteriormente definidas
        iniciarMatriz();                        ////////// Iniciar la matriz anteriormente definida con campos vacios y inicializar el
                                                ////////// Arraylist para que cada posicion contenga un ArrayList de String
    }
    
    public void numbers(){                      //// Funcion Inicial donde se obtendra cada numero ingresado y se enviará para que sea
                                                //// enviado como parametro a la funcion writeNumbers
        for(int i=0; i<this.cadenaNum.length(); i++){
            int numero = Integer.parseInt(""+cadenaNum.charAt(i));
            writeNumbers(numero);               ////  Funcion que permitira ir almacenando en la matriz resultado la impresion final
        }
        printMatriz();                          ////  Funcion que permite mostrar en pantalla el resultado final
    }
    
    public void writeNumbers(int numero){       //// Esta funcion evaluara cada uno de los casos (numeros de 0-9) para formar el 
                                                //// el resultado final que sera impreso en pantalla
        switch(numero){
            case 0:
                printHorizontal(0, 1);          /// Funcion que imprimira los segmentos horizontales del numero, recibe las coordenadas desde donde se comenzara a escribir
                printVertical(1, 0);            /// Funcion que imprimira los segmentos verticales del numero, recibe las coordenadas desde donde se comenzara a escribir
                printVertical(this.columna, 0);
                printHorizontal(this.fila - 1, 1);
                printVertical(1, this.columna - 1);
                printVertical(this.columna, 1+this.size);
                llenarMatriz(this.fila,this.columna);   //// Para este punto, el numero debe estar totalmente escrito en la matriz, 
                                                        //// en esta funcion se almacenara ese resultado en la matriz final
                iniciarMatriz();                        /// Se inicializa la matriz para reiniciar la escritura de un nuevo numero
                break;
            case 1:
                printVertical(1, this.columna - 1);
                printVertical(this.columna, this.columna - 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 2:
                printHorizontal(0, 1);               
                printVertical(1, this.columna - 1);
                printHorizontal(this.columna - 1 , 1);
                printVertical(this.columna, 0);
                printHorizontal(this.fila - 1 , 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 3:
                printHorizontal(0, 1);               
                printVertical(1, this.columna - 1);
                printHorizontal(this.columna -1 , 1);
                printVertical(this.columna , this.columna - 1);
                printHorizontal(this.fila - 1 , 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 4:
                printVertical(1, 0);             
                printVertical(1, this.columna - 1);
                printHorizontal(this.columna - 1 , 1);
                printVertical(this.columna, this.columna - 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 5:
                printHorizontal(0, 1);               
                printVertical(1, 0);
                printHorizontal(this.columna - 1 , 1);
                printVertical(this.columna, this.columna - 1);
                printHorizontal(this.fila - 1 , 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            
            case 6:
                printHorizontal(0, 1);               
                printVertical(1, 0);
                printHorizontal(this.columna - 1 , 1);
                printVertical(this.columna, 0);
                printVertical(this.columna, this.columna - 1);
                printHorizontal(this.fila - 1 , 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 7:
                printHorizontal(0, 1);               
                printVertical(1,this.columna - 1);
                printVertical(this.columna, this.columna - 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 8:
                printHorizontal( 0, 1);               
                printVertical(1, 0);
                printVertical(1, this.columna - 1);
                printHorizontal(this.columna - 1 , 1);
                printVertical(this.columna, 0);
                printVertical(this.columna, this.columna - 1);
                printHorizontal(this.fila - 1 , 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
            case 9:
                printHorizontal(0, 1);               
                printVertical(1, 0);
                printVertical(1, this.columna - 1);
                printHorizontal(this.columna - 1 , 1);
                printVertical(this.columna, this.columna - 1);
                printHorizontal(this.fila - 1, 1);
                llenarMatriz(this.fila,this.columna);
                iniciarMatriz();
                break;
        }        
    }
    
    public void printVertical(int i, int j){
        for(int k=i; k<i+this.size; k++){
            this.matrizPrint[k][j] = "|";
        }
    }
    public void printHorizontal(int i, int j){
        for(int k=j; k<j+this.size; k++){
            this.matrizPrint[i][k] = "-";
        }
    }
    
    public void llenarMatriz(int i, int j){
        for(int k=0; k<i; k++){
            for(int p=0; p<j; p++){
                this.matrizRespuesta.get(k).add(this.matrizPrint[k][p]);
            }
            this.matrizRespuesta.get(k).add(" ");
        }
    }
    
    public void printMatriz(){
        for(int i=0; i<this.fila; i++){
            for(int j=0; j<this.matrizRespuesta.get(i).size(); j++){
                System.out.print(this.matrizRespuesta.get(i).get(j)); 
            }
            System.out.println("");
        }
    }
    
   
    public void iniciarMatriz(){
        for(int i=0; i<this.fila; i++){
            for(int j=0; j<this.columna; j++){
                matrizPrint[i][j]= " ";
            }
            matrizRespuesta.add(new ArrayList<String>());
        }
    }
    
    public boolean validarEntrada(int numero){
        boolean opcion;
        if(numero >= 0 && numero <=10){
            opcion = true;
        }else{
            opcion = false;
        }
        return opcion;
    }
    
    
}
