/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.0
 * 21/09/2025
 * La clase Producto ha sido creada, estableciendo su funcionamiento 
 */
public class Producto extends Item {

    public Producto(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }

    @Override
    public String getTipo() {
        return "producto";
    }

    
}
