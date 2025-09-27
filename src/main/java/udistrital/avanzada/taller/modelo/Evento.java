/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

import java.util.Date;

/**
 * Representa un evento publicado en el sistema por un proveedor.
 * 
 * <p>Cada evento tiene un título, una descripción y una fecha asociada. 
 * Esta clase permite la creación de eventos y la modificación de sus atributos.</p>
 * 
 * <p>Versión actualizada para eliminar el método que se encargaba de dar "like".</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class Evento {
    private String titulo;
    private String descripcion;
    private Date fecha;

    /**
     * Crea un nuevo evento con los datos especificados.
     * 
     * @param titulo título del evento
     * @param descripcion descripción detallada del evento
     * @param fecha fecha de realización del evento
     */
    public Evento(String titulo, String descripcion, Date fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    /**
     * Obtiene el título del evento.
     * 
     * @return título del evento
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la descripción del evento.
     * 
     * @return descripción del evento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la fecha del evento.
     * 
     * @return fecha del evento
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Modifica el título del evento.
     * 
     * @param titulo nuevo título del evento
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Modifica la descripción del evento.
     * 
     * @param descripcion nueva descripción del evento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Modifica la fecha del evento.
     * 
     * @param fecha nueva fecha del evento
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
