package udistrital.avanzada.taller.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
<<<<<<< HEAD
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.3
 * 25/09/2025
 * La clase Proveedor ha sido modificada eliminando lsos System.out del paquete control y programando el contenido de sus métodos
=======
 * Representa a un proveedor dentro del sistema.
 * 
 * <p>Un proveedor puede ofrecer distintos {@link Item} (productos o servicios)
 * y publicar {@link Evento}s. Además, está clasificado por un 
 * {@link TipoProveedor} específico que indica su categoría (ej. taller,
 * parqueadero, lavadero, etc.).</p>
 * 
 * <p>La clase permite registrar, actualizar y eliminar ítems y eventos,
 * así como consultar información detallada del proveedor.</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
>>>>>>> ce6ab0c005683ed04df5b602a5d7414eaba217e4
 */
public class Proveedor extends Persona {
    
    private ArrayList<Item> items;
    private ArrayList<Evento> eventos;
<<<<<<< HEAD
    
    public Proveedor(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.items = new ArrayList<>();
        this.eventos= new ArrayList<>();
=======
    private TipoProveedor tipoProveedor;

    /**
     * Construye un proveedor con los datos especificados.
     * 
     * @param nombre nombre del proveedor
     * @param contraseña contraseña de acceso
     * @param correo correo electrónico
     * @param id identificador único
     * @param tipoProveedor tipo de proveedor
     */
    public Proveedor(String nombre, String contraseña, String correo, String id, TipoProveedor tipoProveedor) {
        super(nombre, contraseña, correo, id);
        this.items = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.tipoProveedor = tipoProveedor;
>>>>>>> ce6ab0c005683ed04df5b602a5d7414eaba217e4
    }

    /**
     * Actualiza un ítem existente en la lista del proveedor.
     * 
     * @param nombre nombre del ítem a buscar
     * @param nuevoItem nuevo ítem que reemplaza al existente
     * @return true si se actualizó exitosamente, false si no se encontró
     */
    public boolean actualizarItem(String nombre, Item nuevoItem) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getNombre().equalsIgnoreCase(nombre)) {
                this.items.set(i, nuevoItem);
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega un nuevo ítem a la lista del proveedor.
     * 
     * @param item ítem a agregar
     * @return true si se agregó exitosamente
     */
    public boolean agregarItem(Item item) {
        return this.items.add(item);
    }

    /**
     * Elimina un ítem por su nombre.
     * 
     * @param nombre nombre del ítem a eliminar
     * @return true si se eliminó exitosamente, false si no existía
     */
    public boolean eliminarItem(String nombre) {
        return this.items.removeIf(i -> i.getNombre().equalsIgnoreCase(nombre));
    }

    /**
     * Retorna la lista de ítems del proveedor.
     * 
     * @return lista inmutable de ítems
     */
    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    /**
     * Publica un nuevo evento del proveedor.
     * 
     * @param evento evento a publicar
     * @return true si se publicó exitosamente
     */
    public boolean publicarEvento(Evento evento) {
        return this.eventos.add(evento);
    }

    /**
     * Actualiza un evento publicado por el proveedor.
     * 
     * @param titulo título del evento a actualizar
     * @param nuevoEvento nuevo evento que reemplaza al existente
     * @return true si se actualizó exitosamente, false si no se encontró
     */
    public boolean actualizarEvento(String titulo, Evento nuevoEvento) {
        for (int i = 0; i < this.eventos.size(); i++) {
            if (this.eventos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                eventos.set(i, nuevoEvento);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un evento publicado por su título.
     * 
     * @param titulo título del evento a eliminar
     * @return true si se eliminó exitosamente, false si no existía
     */
    public boolean eliminarEvento(String titulo) {
        return this.eventos.removeIf(e -> e.getTitulo().equalsIgnoreCase(titulo));
    }

    /**
     * Retorna la lista de eventos del proveedor.
     * 
     * @return lista inmutable de eventos
     */
    public List<Evento> getEventos() {
        return Collections.unmodifiableList(this.eventos);
    }
<<<<<<< HEAD
=======
    /**
     * Obtiene el tipo de proveedor.
     * 
     * @return tipo de proveedor
     */
    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    /**
     * Obtiene información detallada del proveedor, incluyendo sus datos
     * principales, cantidad de ítems y eventos publicados.
     * 
     * @return cadena con la información completa del proveedor
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
>>>>>>> ce6ab0c005683ed04df5b602a5d7414eaba217e4
}

