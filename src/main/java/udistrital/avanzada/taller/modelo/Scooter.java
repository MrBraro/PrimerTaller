/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Representa un vehículo de tipo scooter dentro del sistema.
 * 
 * <p>Extiende la clase {@link Vehiculo} y define el tipo específico de
 * vehículo como "Scooter".</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class Scooter extends Vehiculo {

    /**
     * Construye un nuevo scooter con los datos especificados.
     * 
     * @param marca marca del scooter
     * @param modelo modelo del scooter
     * @param autonomia autonomía del scooter en kilómetros
     */
    public Scooter(String marca, String modelo, int autonomia) {
        super(marca, modelo, autonomia);
    }

    /**
     * Retorna el tipo de vehículo.
     * 
     * @return "Scooter"
     */
    @Override
    public String getTipo() {
        return "Scooter";
    }
}

