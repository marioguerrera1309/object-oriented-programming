/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import eccezioni.*;
import interfacce.Stipendio;
/**
 *
 * @author filip
 */
public class Amministrativi extends Persona implements Stipendio{
    private String ruolo;
    private double stipendioBase;
    private int oreStraordinario=0;
    public Amministrativi(String ruolo, double stipendioBase, String nome, String DataNascita, String codiceFiscale) throws OreMaggioriDi30Exception{
        super(nome, DataNascita, codiceFiscale);
        this.ruolo = ruolo;
        this.stipendioBase = stipendioBase;
        
    }
    public void attivitàPomeridiana(int numero) throws OreMaggioriDi3Exception, OreMaggioriDi30Exception{
        if(numero>3){
            throw new OreMaggioriDi3Exception("Il numero di ore dell'attività pomeridiana è maggiore di 3");
            
        }
        else{
            if(numero+oreStraordinario>30){
            throw new OreMaggioriDi30Exception("Ore Straordinario maggiori di 30");
            }
            else oreStraordinario=oreStraordinario+numero;
        }
        
    }

    @Override
    public double CalcoloStipendio() {
        return stipendioBase+((oreStraordinario)*10);
    }

    public void Riscuoti(){
        oreStraordinario=0;
    }
    
    
    @Override
    public String toString() {
        return "Amministrativo: "+super.toString()+ "Ruolo: "+ruolo+", Stipendio Base: "+stipendioBase+", Ore Straordinario: "+oreStraordinario; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    

        
    
    
}
