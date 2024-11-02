/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Attori.Consumatore;
import Attori.Eraser;
import Attori.Produttore;
import Attori.Segreteria;
import Attori.Statista;
import Clienti.Clienti;
import Clienti.MapClienti;
import Monitor.RegistroGara;
import Subscription.MapSubscription;
import Subscription.Subscription;
import Subscription.Under18;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author p7qna
 */

public class Main {
    public static void main(String[] args) {
        MapClienti mappa=new MapClienti();
        MapSubscription iscritti= new MapSubscription();
        RegistroGara gare=new RegistroGara();
        Clienti cliente;
        Subscription sub;
        ArrayList<Clienti> aux;
        char email;
        int x;
        for(int i=0;i<50;i++) {
            email=crea();
            cliente=new Clienti("Cliente"+i, LocalDate.of(2002, 03, 10), ""+email);
            x=mappa.addCliente(cliente);
            if(x==-1) {
                System.err.println("Errore email esistente");
            } else {
                System.out.println("Cliente aggiunto");
            }
        }
        aux=mappa.getListaClienti();
        System.out.println("Clienti:");
        for(Clienti c: aux) {
            System.out.println(c.toString());
        }
        aux=mappa.getListaClientiOrdinati();
        System.out.println("Clienti ordinati");
        for(Clienti c: aux) {
            System.out.println(c.toString());
        }
        for(int i=0;i<200;i++) {
            x=iscritti.addSubscription(mappa.getClienti(""+crea()), (int)(Math.random()*4));
            if(x==-1) {
                System.err.println("Cliente gia iscritto");
            }
        }
        iscritti.printAll();
        sub=iscritti.Ricerca((long)(Math.random()*5)+1);
        if(sub==null) {
            System.out.println("Iscrizione non esistente");
        } else {
            System.out.println("Iscrizione cercata: "+ sub.toString());
        }
        cliente=new Clienti("Pippo", LocalDate.now(), "L");
        if(iscritti.Remove(cliente)==1) {
            System.out.println("Cliente rimosso");
        } else {
            System.err.println("Cliente inesistente");
        }
        Under18 under18=new Under18(iscritti);
        System.out.println("\nUnder18:");
        under18.printAll();
        /*
        Thread produttore=new Thread(new Produttore(gare, under18));
        Thread consumatore=new Thread(new Consumatore(gare, under18));
        Thread eraser=new Thread(new Eraser(gare));
        Thread statista=new Thread(new Statista(gare));
        Thread segreteria=new Thread(new Segreteria(gare));
        produttore.start();
        consumatore.start();
        eraser.start();
        statista.start();
        segreteria.start();
        */
    }
    
    private static char crea() {
        char email;
        long x=(long)((Math.random()*25)+66);
        email=(char)x;
        return email;
    }
}
