/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.jose.ignacio.garcia.rivas;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class Tienda {
    private static String[] DIAS = {
    "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
};
    private int numProductos;
    private String[] nombresProductos;
    private int[][] ventas;
    private int[] totalPorProducto;
    private int[] totalPorDia;   
    
        public Tienda(int numProductos) {
    this.numProductos = numProductos;
    this.nombresProductos = new String[numProductos];
    this.ventas = new int[DIAS.length][numProductos];
    this.totalPorProducto = new int[numProductos];
    this.totalPorDia = new int[DIAS.length];
    
    
}
   public void ingresarNombresProductos() {
        for (int i = 0; i < numProductos; i++) {
            String nombre = JOptionPane.showInputDialog(
                "Nombre del producto " + (i + 1) + ":"
            );
            nombresProductos[i] = nombre;
        }
    } 
    public void generarVentasAleatorias() {
        Random random = new Random();
        for (int dia = 0; dia < DIAS.length; dia++) {
            for (int producto = 0; producto < numProductos; producto++) {
                ventas[dia][producto] = random.nextInt(10); // 0 a 9
            }
        }
    }
     public void calcularTotalPorProducto() {
        for (int producto = 0; producto < numProductos; producto++) {
            int suma = 0;
            for (int dia = 0; dia < DIAS.length; dia++) {
                suma += ventas[dia][producto];
            }
            totalPorProducto[producto] = suma;
        }
    }
     public void calcularTotalPorDia() {
        for (int dia = 0; dia < DIAS.length; dia++) {
            int suma = 0;
            for (int producto = 0; producto < numProductos; producto++) {
                suma += ventas[dia][producto];
            }
            totalPorDia[dia] = suma;
        }
    }
     public int obtenerIndiceDiaConMayorVenta() {
        int indiceMayor = 0;
        for (int dia = 1; dia < DIAS.length; dia++) {
            if (totalPorDia[dia] > totalPorDia[indiceMayor]) {
                indiceMayor = dia;
            }
        }
        return indiceMayor;
    }
     public int obtenerIndiceProductoMasVendido() {
        int indiceMayor = 0;
        for (int producto = 1; producto < numProductos; producto++) {
            if (totalPorProducto[producto] > totalPorProducto[indiceMayor]) {
                indiceMayor = producto;
            }
        }
        return indiceMayor;
    }
     public void mostrarResultados() {
        StringBuilder mensaje = new StringBuilder();
 
        mensaje.append("--- Matriz de ventas semanales ---\n");
        mensaje.append("Día\t");
        for (String nombre : nombresProductos) {
            mensaje.append(nombre).append("\t");
        }
        mensaje.append("\n");
 
        for (int dia = 0; dia < DIAS.length; dia++) {
            mensaje.append(DIAS[dia]).append("\t");
            for (int producto = 0; producto < numProductos; producto++) {
                mensaje.append(ventas[dia][producto]).append("\t");
            }
            mensaje.append("\n");
        }
 
        mensaje.append("\n--- Total de ventas por producto ---\n");
        for (int producto = 0; producto < numProductos; producto++) {
            mensaje.append(nombresProductos[producto]).append(": ")
                   .append(totalPorProducto[producto]).append("\n");
        }
 
        int diaMayor = obtenerIndiceDiaConMayorVenta();
        mensaje.append("\nDía con mayores ventas totales: ").append(DIAS[diaMayor])
               .append(" (con un total de ").append(totalPorDia[diaMayor]).append(" ventas).\n");
 
        int productoMayor = obtenerIndiceProductoMasVendido();
        mensaje.append("Producto más vendido: ").append(nombresProductos[productoMayor]);
 
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
     public void ejecutar() {
        ingresarNombresProductos();
        generarVentasAleatorias();
        calcularTotalPorProducto();
        calcularTotalPorDia();
        mostrarResultados();
     }
}
