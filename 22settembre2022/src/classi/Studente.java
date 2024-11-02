/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * @author filip
 */
public class Studente extends Persona{
    
    public Studente(String nome, String DataNascita, String codiceFiscale) {
        super(nome, DataNascita, codiceFiscale);
    }

    
    @Override
    public String toString() {
        return "Studente: "+super.toString(); 
    }
    
    
    
}
