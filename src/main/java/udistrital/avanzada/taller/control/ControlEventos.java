/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import udistrital.avanzada.taller.modelo.Evento;

/**
 * Controlador encargado de gestionar los eventos dentro del sistema.
 * Permite a los proveedores publicar eventos y a los usuarios listarlos o buscarlos.
 * 
 * Se utiliza como repositorio central para que los eventos sean accesibles
 * a todos los usuarios sin depender de un proveedor específico.
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class ControlEventos {
    
    private ArrayList<Evento> eventos;
    
    /**
    * Constructor por defecto
    * Inicializa la lista vacia de elementos
    */
    public ControlEventos() {
        this.eventos = new ArrayList<>();
    }
    /**
     * Publica un evento nuevo en el sistema
     * @param evento Evento a registrar
     */
    public void publicarEvento(Evento evento){
        this.eventos.add(evento);
    }
    /**
     * Lista todos los eventos registrados en el Sistema
     * Retorna una lista inmutable para proteger la colección interna
     * @return Lista inmutable con los eventos
     */
    public List<Evento> listarEventos(){
        return Collections.unmodifiableList(this.eventos);
    }
    /**
     * Busca un evento en el sistema a partir de su titulo
     * La búsqueda no distingue entre Mayus y Minus
     * @param titulo Titulo del evento a buscar
     * @return Evento encontrado o null si no existe
     */
    public Evento buscarEvento(String titulo){
        for(Evento evento : this.eventos){
            if(evento.getTitulo().equalsIgnoreCase(titulo)){
                return evento;
            }
        }
        return null;
    }
    
    
}
