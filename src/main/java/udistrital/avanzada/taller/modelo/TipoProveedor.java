
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Enumeración para los tipos de Proveedores que se usarán 
 * @author Juan Estevan Ariza Ortiz
 * @version 1.0
 * 25/09/2025
 */
public enum TipoProveedor {
    PARQUEADERO("Parqueadero"),
    LAVADERO("Lavadero"), 
    TALLER("Taller"),
    VENTA_PARTES("Venta de Partes");
    
    private final String descripcion;
    
    private TipoProveedor(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
}