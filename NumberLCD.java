/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberlcd;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author - Astrid Vanegas Chinchilla
 */
public class NumberLCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena =JOptionPane.showInputDialog(null,"Ingrese la cadena que desea procesar: (2,12345 3,67890 0,0)");
        PrintLCD num;
        String[] procesar  = cadena.split(" ");
        
        for(int i=0; i<procesar.length; i++){
            String[] aux  = procesar[i].split(",");
            if(Integer.parseInt(aux[0]) != 0){
                num = new PrintLCD(Integer.parseInt(aux[0]), aux[1]);          
                if(num.validarEntrada(Integer.parseInt(aux[0]))){
                    num.numbers();
                    System.out.println(" ");
                }else{
                    System.out.println(" La entrada no es correcta! "+Integer.parseInt(aux[0])+" - "+aux[1]);
                }
            }else{
                System.out.println(" TERMINADO ");
                return ;
            }
        } 
     
      
      
    }
    
}
