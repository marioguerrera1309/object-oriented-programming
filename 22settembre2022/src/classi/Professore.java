/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.util.Set;
import eccezioni.*;
import interfacce.Stipendio;
/**
 *
 * @author filip
 */
public class Professore extends Persona implements Stipendio{
    private double stipendioBase;
    private Set<CompitoDidattico> compiti;
    private int oreStraordinario=0;
    private int anzianitàLavorativa;
    
    public Professore(double stipendioBase, Set<CompitoDidattico> compiti, int anzianitàLavorativa, String nome, String DataNascita, String codiceFiscale){
        super(nome, DataNascita, codiceFiscale);
        this.stipendioBase = stipendioBase;
        this.compiti = compiti;
        this.anzianitàLavorativa = anzianitàLavorativa;
        
    }
    
    public void Supplenza(int numero)throws OreMaggioriDi2Exception, OreMaggioriDi25Exception{
        if(numero>2){
            throw new OreMaggioriDi2Exception("eRRORE! Ore maggiori di 2");
        }
        else{
            if(oreStraordinario+numero>25){
                throw new OreMaggioriDi25Exception("Ore di straordinario superate(il max era 25)");
            }
            else oreStraordinario=oreStraordinario+numero;
        }
    }

    @Override
    public double CalcoloStipendio() {
        return stipendioBase+(anzianitàLavorativa*stipendioBase/50)+(oreStraordinario*20);
    }
    
    public void Riscuoti(){
        oreStraordinario=0;
    }
    
    public void AddCompito(CompitoDidattico compito){
        if(compiti.contains(compito)){
            System.out.println("Compito già presente");
        }
        else compiti.add(compito);
    }
    public void RemoveCompito(CompitoDidattico compito){
        if(compiti.contains(compito)){
            compiti.remove(compito);
        }
        else System.out.println("Impossibile rimuovere il compito perchè non è presente");
    }
    
    public void StampaCompiti(){
        compiti.toString();
    }
    
    public void ModificaNumeroStudenti(int numero, CompitoDidattico compito){
        if(compiti.contains(compito)){
            if(numero<compito.getNumMaxStudenti()){
                compito.setNumeroStudenti(numero);
            }
            else System.out.println("Errore. Il numero di studenti che vuoi aggiungere supera il numero massimo");
        }
        else System.out.println("Errore. Il compito non è contenuto nel set");
        
    }

    @Override
    public String toString() {
        return "Professore, "+super.toString()+" Stipendio Base: "+stipendioBase+", Compiti: "+compiti+", Anzianità lavorativa: "+anzianitàLavorativa; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
