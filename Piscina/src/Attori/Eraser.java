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
public class Eraser implements Runnable {
    private RegistroGara buffer;

    public Eraser(RegistroGara buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        while(true) {    
            try {
                buffer.Eraser((int)(Math.random()*2));
                Thread.sleep((long)((Math.random()*3000)+2000));
            } catch(InterruptedException e) {
                System.err.println("Errore");
            }
        }
    }
}
