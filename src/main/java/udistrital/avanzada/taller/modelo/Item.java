/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Clase abstracta que representa un ítem dentro del sistema.
 * 
 * <p>Un ítem puede ser un producto o un servicio ofrecido por un proveedor. 
 * Contiene atributos comunes como nombre, descripción y precio.</p>
 * 
 * <p>Aunque inicialmente se pensó en manejar estos atributos como constantes,
 * se decidió mantenerlos modificables en posibles subclases, ya que un
 * proveedor podría requerir actualizarlos.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public abstract class Item {
    private String nombre;
    private String descripcion;
    private double precio;

    /**
     * Constructor de la clase Item.
     * 
     * @param nombre nombre del ítem
     * @param descripcion descripción del ítem
     * @param precio precio asociado al ítem
     */
    public Item(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * Obtiene la descripción del ítem.
     * 
     * @return descripción del ítem
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el nombre del ítem.
     * 
     * @return nombre del ítem
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del ítem.
     * 
     * @return precio del ítem
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve el tipo de ítem (producto o servicio).
     * 
     * <p>Debe ser implementado por las subclases.</p>
     * 
     * @return tipo del ítem
     */
    public abstract String getTipo();
}

