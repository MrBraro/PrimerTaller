/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller.modelo;

/**
 *
 * @author juans
 */
public class MotoElectrica extends Vehiculo{

    public MotoElectrica(String marca, String modelo, int autonomia) {
        super(marca, modelo, autonomia);
    }

    @Override
    public String getTipo() {
        return "Moto Electrica";
    }
    
}
