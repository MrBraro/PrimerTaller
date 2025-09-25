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
 * La clase Item ha sido creada, estableciendo su funcionamiento 
 */
public abstract class Item {
    //TODO: creo que no es necesario dejar estas como constantes, ya que un proveedor podria editarlo no?
    private final String nombre;
    private final String descripcion;
    private final double precio;

    public Item(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public abstract String getTipo();
}
