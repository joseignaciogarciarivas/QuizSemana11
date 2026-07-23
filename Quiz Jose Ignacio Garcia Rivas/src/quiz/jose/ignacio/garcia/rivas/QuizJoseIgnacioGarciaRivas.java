/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz.jose.ignacio.garcia.rivas;

import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class QuizJoseIgnacioGarciaRivas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here       
        String entrada = JOptionPane.showInputDialog("¿Cuántos productos vende la tienda?");
        int numProductos = Integer.parseInt(entrada);
 
        Tienda tienda = new Tienda(numProductos);
        tienda.ejecutar();
    }
}
    
    

