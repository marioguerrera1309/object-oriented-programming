/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

import Clienti.Clienti;
import java.util.HashMap;

/**
 *
 * @author p7qna
 */
public class MapSubscription {
    private HashMap<Integer, Subscription> mapSubscription;
    private Subscription sub;
    private int i=0;
    
    public MapSubscription() {
        mapSubscription=new HashMap<>();
    }
   
    public int addSubscription(Clienti cliente, int lvl) {
        if(cliente==null) {
            System.err.println("Cliente non esistente");
            return -1;
        }
        else {
            sub=new Subscription(cliente, i, lvl);
            for(int index: mapSubscription.keySet()) {
                if(mapSubscription.get(index).getCliente().getEmail().equals(cliente.getEmail())) {
                    return -1;
                }
            }
            i++;
            mapSubscription.put(sub.getCodice_cliente(), sub);
            return 1;
        }
    }
    
    public void printAll() {
        for(int i:mapSubscription.keySet()) {
            System.out.println(mapSubscription.get(i));
        }
    }
    
    public Subscription Ricerca(long key) {
        if(mapSubscription.containsKey((int)key)) {
            return mapSubscription.get((int)key);
        } else {
            return null;
        }
    }
    
    public int Remove(Clienti cliente) {
        Subscription sub;
        for(Integer i: mapSubscription.keySet()) {
            sub=mapSubscription.get(i);
            if(sub.getCliente().getEmail().compareTo(cliente.getEmail())==0) {
                mapSubscription.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public HashMap<Integer, Subscription> getMapSubscription() {
        return mapSubscription;
    }
    
}
