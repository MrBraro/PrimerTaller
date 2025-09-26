
package udistrital.avanzada.taller.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author Juan Estevan Ariza Ortiz
 * @version 1.4
 * 25/09/2025
 * La clase Proveedor fue modificada para establecer tipo de proveedor e información referente
 */
public class Proveedor extends Persona {
    
    private ArrayList<Item> items;
    private ArrayList<Evento> eventos;
    private TipoProveedor tipoProveedor;
    
    public Proveedor(String nombre, String contraseña, String correo, String id, TipoProveedor tipoProveedor) {
        super(nombre, contraseña, correo, id);
        this.items = new ArrayList<>();
        this.eventos= new ArrayList<>();
        this.tipoProveedor = tipoProveedor;
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
    
        // Getters y setters para los nuevos campos
    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }
    
        /**
     * Método para obtener información completa del proveedor
     * @return String con toda la información del proveedor
     */
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Proveedor: ").append(getNombre()).append("\n");
        info.append("Tipo: ").append(tipoProveedor.getDescripcion()).append("\n");
        info.append("ID: ").append(getId()).append("\n");
        info.append("Correo: ").append(getCorreo()).append("\n");
      
        
        info.append("Items disponibles: ").append(items.size()).append("\n");
        info.append("Eventos publicados: ").append(eventos.size());
        
        return info.toString();
    }
}
