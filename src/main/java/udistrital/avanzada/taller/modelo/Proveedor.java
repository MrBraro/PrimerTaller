
package udistrital.avanzada.taller.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.3
 * 25/09/2025
 * La clase Proveedor ha sido modificada eliminando lsos System.out del paquete control y programando el contenido de sus métodos
 */
public class Proveedor extends Persona {
    
    private ArrayList<Item> items;
    private ArrayList<Evento> eventos;
    
    public Proveedor(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.items = new ArrayList<>();
        this.eventos= new ArrayList<>();
    }
    
    
    public boolean actualizarItem(String nombre, Item nuevoItem){
        for(int i=0; i<this.items.size(); i++){
            if(this.items.get(i).getNombre().equalsIgnoreCase(nombre)){
                this.items.set(i, nuevoItem);
                return true;
            }
        }
        return false;
    }
    public boolean agregarItem(Item item){
        return this.items.add(item);
    }
    
    public boolean eliminarItem(String nombre){
        return this.items.removeIf(i ->i.getNombre().equalsIgnoreCase(nombre));
    }
    
    public List<Item> getItems(){
        return Collections.unmodifiableList(this.items);
    }
    
    public boolean publicarEvento(Evento evento){
        return this.eventos.add(evento);
    }
    
    public boolean actualizarEvento(String titulo, Evento nuevoEvento){
        for(int i=0; i<this.eventos.size();i++){
            if(this.eventos.get(i).getTitulo().equalsIgnoreCase(titulo)){
                eventos.set(i, nuevoEvento);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarEvento(String titulo){
        return this.eventos.removeIf(e -> e.getTitulo().equalsIgnoreCase(titulo));
    }
    
    public List<Evento> getEventos(){
        return Collections.unmodifiableList(this.eventos);
    }
}
