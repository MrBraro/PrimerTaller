/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import udistrital.avanzada.taller.modelo.Proveedor;
import udistrital.avanzada.taller.modelo.Item;
/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.3
 * 25/09/2025
 * La clase ControlGaleria ha sido creada
 */
public class ControlGaleria {
    private ArrayList<Proveedor> proveedores;

    public ControlGaleria(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    public List<Item> listarItems(){
        ArrayList<Item> todos = new ArrayList<>();
        for(Proveedor proveedor : this.proveedores){
            todos.addAll(proveedor.getItems());
        }
        return Collections.unmodifiableList(todos);
    }
    
    public List<Item> filtrarPorTipo(String tipo){
        ArrayList<Item> filtrados = new ArrayList<>();
        for (Proveedor proveedor : this.proveedores){
            for(Item item : proveedor.getItems()){
                if(item.getTipo().equalsIgnoreCase(tipo)){
                    filtrados.add(item);
                }
            }
        }
        return filtrados;
    }
    
    public List<Item> filtrarPorProveedor(String nombreProveedor){
        for(Proveedor proveedor : this.proveedores){
            if(proveedor.getNombre().equalsIgnoreCase(nombreProveedor)){
                return proveedor.getItems();
            }
        }
        return new ArrayList<>();
    }
    
    public List<Item> filtrarPorPrecioAscendente(){
        List<Item> todos = new ArrayList<>(listarItems());
        todos.sort(Comparator.comparingDouble(Item::getPrecio));
        return todos;
    }
    
    public List<Item> filtrarPorPrecioDescendente(){
        List<Item> todos = new ArrayList<>(listarItems());
        todos.sort(Comparator.comparingDouble(Item::getPrecio).reversed());
        return todos;
    }
}
