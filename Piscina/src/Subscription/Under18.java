/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;

/**
 *
 * @author p7qna
 */
public class Under18 {
    private TreeMap<Integer, Subscription> under18;
    private int j=1;
    
    public Under18(MapSubscription map) {
        under18= new TreeMap<>();
        Subscription sub;
        for(int i: map.getMapSubscription().keySet()) {
            if((sub=map.Ricerca(i))!=null) {
                if(sub.getCliente().getData_nascita().getYear()<2005 && sub.getLivello()>0) {
                    under18.put(j, sub);
                    j++;
                }
            }
        }
    }
    public void printAll() {
        for(int i:under18.keySet()) {
            System.out.println(under18.get(i));
        }
    }

    public TreeMap<Integer, Subscription> getUnder18() {
        return under18;
    }
    
    
}

