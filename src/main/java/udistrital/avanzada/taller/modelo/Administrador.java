/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

import udistrital.avanzada.taller.control.ControlProveedores;

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.2
 * 25/09/2025
 * La clase Administrador ha sido modificada para establecer el funcionamiento de sus metodos 
 */
public class Administrador extends Persona{
    private ControlProveedores gestor;
    
    
    public Administrador(String nombre, String contraseña, String correo, ControlProveedores gestor, String id) {
        super(nombre, contraseña, correo, id);
        this.gestor=gestor;
    }
    
    public boolean registrarProveedor(Proveedor proveedor){
        return this.gestor.registrarProveedor(proveedor);
    }
    
    public boolean eliminarProveedor(Proveedor proveedor){
        return this.gestor.eliminarProveedor(proveedor);
    }
    
    public void listarProveedores(){
        //TODO: aun me quedas dudas sobre si dejar este sysout acá o no, si quieren modificarlo, haganlo
        for(Proveedor proveedor:this.gestor.getProveedores()){
            System.out.println("Proveedor: "+proveedor.getNombre()+" - ID: "+proveedor.getId());
        }
    }
}
