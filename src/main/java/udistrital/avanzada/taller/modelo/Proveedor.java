
package udistrital.avanzada.taller.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.2
 * 25/09/2025
 * La clase Proveedor ha sido modificada para establecer el funcionamiento de sus metodos 
 */
public class Proveedor extends Persona {
    
    private ArrayList<Item> items;
    private ArrayList<Evento> eventos;
    
    public Proveedor(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.items = new ArrayList<>();
        this.eventos= new ArrayList<>();
    }
    
    public void agregarItem(Item item){
        this.items.add(item);
    }
    
    public void eliminarItem(Item item){
        this.items.remove(item);
    }
    
    public List<Item> getItems(){
        return Collections.unmodifiableList(this.items);
    }
    
    public void publicarEvento(Evento evento){
        this.eventos.add(evento);
    }
    
    public List<Evento> getEventos(){
        return Collections.unmodifiableList(this.eventos);
    }
}
