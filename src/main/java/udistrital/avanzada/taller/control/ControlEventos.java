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
 *
 * @author Juan Sebastián Bravo Rojas
 * @version 1.3
 * 25/09/2025
 * La clase ControlEventos ha sido creada y diseñada
 */
public class ControlEventos {
    private ArrayList<Evento> eventos;

    public ControlEventos() {
        this.eventos = new ArrayList<>();
    }
    
    public void publicarEvento(Evento evento){
        this.eventos.add(evento);
    }
    
    public List<Evento> listarEventos(){
        return Collections.unmodifiableList(this.eventos);
    }
    
    public Evento buscarEvento(String titulo){
        for(Evento evento : this.eventos){
            if(evento.getTitulo().equalsIgnoreCase(titulo)){
                return evento;
            }
        }
        return null;
    }
    
    
}
