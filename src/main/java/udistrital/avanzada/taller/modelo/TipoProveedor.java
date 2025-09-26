/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Enumeración que define los diferentes tipos de proveedores disponibles en el sistema.
 * 
 * <p>Cada tipo tiene asociada una descripción legible que puede utilizarse
 * en la interfaz de usuario y en los reportes generados.</p>
 * 
 * <ul>
 *   <li>{@code PARQUEADERO} → Proveedor de servicios de estacionamiento.</li>
 *   <li>{@code LAVADERO} → Proveedor de servicios de lavado de vehículos.</li>
 *   <li>{@code TALLER} → Proveedor de servicios de mantenimiento y reparación.</li>
 *   <li>{@code VENTA_PARTES} → Proveedor especializado en la venta de partes y repuestos.</li>
 * </ul>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public enum TipoProveedor {
    PARQUEADERO("Parqueadero"),
    LAVADERO("Lavadero"), 
    TALLER("Taller"),
    VENTA_PARTES("Venta de Partes");
    
    private final String descripcion;

    /**
     * Constructor privado para asignar la descripción de cada tipo.
     * 
     * @param descripcion descripción legible del tipo de proveedor
     */
    private TipoProveedor(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción legible del tipo de proveedor.
     * 
     * @return descripción del tipo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Retorna la descripción como representación en texto.
     * 
     * @return descripción legible del tipo
     */
    @Override
    public String toString() {
        return descripcion;
    }
}
