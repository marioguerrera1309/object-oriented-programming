/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Attori;

import Monitor.RegistroGara;
import Subscription.Under18;

/**
 *
 * @author p7qna
 */
public class Produttore implements Runnable {
    private RegistroGara buffer;
    private Under18 map;

    public Produttore(RegistroGara buffer, Under18 map) {
        this.buffer = buffer;
        this.map = map;
    }
    
    @Override
    public void run() {
        int x;
        while(true) {
            x=(int)(Math.random()*50);
            try {
                while(!(map.getUnder18().containsKey(x))) {
                    x=(int)(Math.random()*50);
                }
                buffer.insert(map.getUnder18().get(x), (int)(Math.random()*2));
                Thread.sleep((long)((Math.random()*200)+100));
            } catch(InterruptedException e) {
                System.err.println("Errore");
            }
        }
    }
}
