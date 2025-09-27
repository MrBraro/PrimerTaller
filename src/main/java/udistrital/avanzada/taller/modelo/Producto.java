/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Representa un producto ofrecido por un proveedor dentro del sistema.
 * 
 * <p>Extiende la clase {@link Item} e implementa el tipo específico de ítem
 * como "producto".</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class Producto extends Item {

    /**
     * Construye un nuevo producto con los datos especificados.
     * 
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precio precio del producto
     */
    public Producto(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }

    /**
     * Retorna el tipo de ítem.
     * 
     * @return "producto"
     */
    @Override
    public String getTipo() {
        return "producto";
    }    
}

