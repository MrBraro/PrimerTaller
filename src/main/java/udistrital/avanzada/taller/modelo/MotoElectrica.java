/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 * Representa un vehículo de tipo motocicleta eléctrica dentro del sistema.
 * 
 * <p>Extiende la clase {@link Vehiculo} y define el tipo específico de
 * vehículo como "Moto Eléctrica".</p>
 * 
 * @author Juan Sebastián Bravo Rojas
 * @version 1.5
 * 26/09/2025
 */
public class MotoElectrica extends Vehiculo {

    /**
     * Construye una nueva motocicleta eléctrica con los datos especificados.
     * 
     * @param marca marca de la moto
     * @param modelo modelo de la moto
     * @param autonomia autonomía de la moto en kilómetros
     */
    public MotoElectrica(String marca, String modelo, int autonomia) {
        super(marca, modelo, autonomia);
    }

    /**
     * Retorna el tipo de vehículo.
     * 
     * @return "Moto Eléctrica"
     */
    @Override
    public String getTipo() {
        return "Moto Eléctrica";
    }
}

