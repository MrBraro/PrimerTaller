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

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.2
 * 25/09/2025
 * La clase controlProveedores ha sido creada para manejar la logica de estos
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
}
