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
public class Statista implements Runnable {
    private RegistroGara buffer;

    public Statista(RegistroGara buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        while(true) {    
            try {
                buffer.Statista();
                Thread.sleep((long)((Math.random()*2000)+1000));
            } catch(InterruptedException e) {
                System.err.println("Errore");
            }
        }
    }
}
