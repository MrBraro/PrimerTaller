/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import udistrital.avanzada.taller.modelo.Proveedor;
import udistrital.avanzada.taller.modelo.Evento;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import udistrital.avanzada.taller.modelo.TipoProveedor;

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.4
 * 25/09/2025
 * La clase controlProveedores ha sido Modificada para guardar métodos de consulta de información
 */

public class ControlProveedores {
    private ArrayList<Proveedor> proveedores;

    public ControlProveedores() {
        this.proveedores= new ArrayList<>();
    }
    
    public boolean registrarProveedor(Proveedor proveedor){
        if(!this.proveedores.contains(proveedor)){
            this.proveedores.add(proveedor);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean eliminarProveedor(Proveedor proveedor){
        return this.proveedores.remove(proveedor);
    }
    
    public Proveedor buscarProveedorPorId(String id){
        for(Proveedor proveedor : this.proveedores){
            if(proveedor.getId().equals(id)){
                return proveedor;
            }
        }
        return null;
    }
    
    public boolean publicarEventoProveedor(String idProveedor, Evento evento){
        Proveedor proveedor = buscarProveedorPorId(idProveedor);
        if(proveedor!=null){
            proveedor.publicarEvento(evento);
            return true;
        }else{
            return false;
        }
    }
    
    public List<Proveedor> getProveedores(){
        return Collections.unmodifiableList(this.proveedores);
    }
    
        /**
     * Busca proveedores por tipo específico (parqueadero, lavadero, taller, venta de partes)
     * @param tipoProveedor Tipo de proveedor a buscar
     * @return Lista de proveedores del tipo especificado
     */
    public List<Proveedor> buscarProveedoresPorTipo(TipoProveedor tipoProveedor) {
        return this.proveedores.stream()
                .filter(proveedor -> proveedor.getTipoProveedor() == tipoProveedor)
                .collect(Collectors.toList());
    }
    
     /**
     * Obtiene información detallada de proveedores por tipo
     * @param tipoProveedor Tipo de proveedor
     * @return Lista con información de proveedores del tipo especificado
     */
    public List<String> getInformacionProveedoresPorTipo(TipoProveedor tipoProveedor) {
        return buscarProveedoresPorTipo(tipoProveedor).stream()
                .map(Proveedor::getInformacionCompleta)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene información detallada de todos los proveedores
     * @return Lista con la información completa de cada proveedor
     */
    public List<String> getInformacionProveedores() {
        return this.proveedores.stream()
                .map(Proveedor::getInformacionCompleta)
                .collect(Collectors.toList());
    }
}
