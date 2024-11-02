/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monitor;

import Subscription.Subscription;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author p7qna
 */
public class RegistroGara {
    private ArrayList<Subscription> garadifficile;//0
    private ArrayList<Subscription> garafacile;//1
    private int readcount0=0;
    private int readcount1=0;
    private boolean writelock0=false;
    private boolean writelock1=false;
    
    public RegistroGara() {
        garadifficile=new ArrayList<>(8);
        garafacile=new ArrayList<>(8);
    }
    
    public synchronized void WriteLock(int gara) throws InterruptedException {
        if(gara==0) {
            while(readcount0>0 || garadifficile.size()==8) {
                wait();
            }
            writelock0=true;
        } else if(gara==1) {
            while(readcount1>0 || garafacile.size()==8) {
                wait();
            }
            writelock1=true;
        }
    }
    
    public synchronized void WriteUnlock(int gara) throws InterruptedException {
        if(gara==0) {
            writelock0=false;
        } else if(gara==1){
            writelock1=false;
        }
        notifyAll();
    }
    
    public int insert(Subscription sub, int gara) {
        if(gara==0) {
            if(sub.getLivello()<3 || garadifficile.contains(sub)) {
                System.err.println(sub.getCliente() + " non puo iscriversi alla gara");
                return -1;
            }
        } else if(gara==1) {
            if(sub.getLivello()==0 || garafacile.contains(sub)) {
                System.err.println(sub.getCliente() + " non puo iscriversi alla gara");
                return -1;
            }
        }
        try {
            WriteLock(gara);
        } catch(InterruptedException e) {
            System.err.println("Errore");
        }
        if(gara==0) {
            garadifficile.add(sub);
            System.out.println(sub.getCliente()+ "si e iscritto a gara difficile");
        } else if(gara==1) {
            garafacile.add(sub);
            System.out.println(sub.getCliente()+ "si e iscritto a gara facile");
        }
        try {
            WriteUnlock(gara);
        } catch(InterruptedException e) {
            System.err.println("Errore");
        }
        return 1;
    }
    
    public synchronized int remove(Subscription sub, int gara) throws InterruptedException {
        int x=-1;
        if(gara==0) {
            while(readcount0>0 || garadifficile.isEmpty()) {
                wait();
            }
            writelock0=true;
            if(garadifficile.contains(sub)) {
                garadifficile.remove(sub);
                x=1;
            }
            writelock0=false;
            notifyAll();
        } else if(gara==1) {
            while(readcount1>0 || garafacile.isEmpty()) {
                wait();
            }
            writelock1=true;
            if(garafacile.contains(sub)) {
                garafacile.remove(sub);
                x=1;
            }
            writelock1=false;
            notifyAll();
        }
        return x;
    }
    
    public synchronized void ReadLock(int gara) throws InterruptedException {
        if(gara==0) {
            while(writelock0) {
                wait();
            }
            readcount0++;
        } else if(gara==1) {
            while(writelock1) {
                wait();
            }
            readcount1++;
        }
    }
    
    public synchronized void ReadUnlock(int gara) throws InterruptedException {
        if(gara==0) {
            readcount0--;
        } else if(gara==1) {
            readcount1--;
        }
        notifyAll();
    }
    
    public synchronized void Eraser(int gara) throws InterruptedException {
        if(gara==0) {
            while(readcount0>0 || garadifficile.isEmpty()) {
                wait();
            }
            writelock0=true;
            garadifficile.clear();
            writelock0=false;
            notifyAll();
        } else if(gara==1) {
            while(readcount1>0 || garafacile.isEmpty()) {
                wait();
            }
            writelock1=true;
            garafacile.clear();
            writelock1=false;
            notifyAll();
        }
    }
    
    public void Segreteria() {
        try {
            ReadLock(0);
        } catch(InterruptedException e) {
            System.err.println("Errore");
        }
        System.out.println("Gara difficile");
        for(Subscription sub: garadifficile) {
            System.out.println(sub.toString());
        }
        System.out.println("\n");
        try {
            ReadUnlock(0);
        } catch (InterruptedException e) {
            System.err.println("Errore");
        }
        try {
            ReadLock(1);
        } catch(InterruptedException e) {
            System.err.println("Errore");
        }
        System.out.println("Gara facile");
        for(Subscription sub: garafacile) {
            System.out.println(sub.toString());
        }
        System.out.println("\n");
        try {
            ReadUnlock(1);
        } catch (InterruptedException e) {
            System.err.println("Errore");
        }
    }
    
    public void Statista() {
        float x=0;
        int y=0;
        try {
            ReadLock(0);
        } catch(InterruptedException e) {
            System.err.println("Errore");
        }
        for(Subscription sub: garadifficile) {
            x+=LocalDate.now().getYear()-sub.getCliente().getData_nascita().getYear();
            y++;
        }
        try {
            ReadUnlock(0);
        } catch (InterruptedException e) {
            System.err.println("Errore");
        }
        if(y>0) {
            System.out.println("Eta media gara difficile: " + x/y);
        }
        x=0;
        y=0;
        try {
            ReadLock(1);
        } catch(InterruptedException e) {
            System.err.println("Errore");
        }
        for(Subscription sub: garafacile) {
            x+=LocalDate.now().getYear()-sub.getCliente().getData_nascita().getYear();
            y++;
        }
        try {
            ReadUnlock(1);
        } catch (InterruptedException e) {
            System.err.println("Errore");
        }
        if(y>0) {
            System.out.println("Eta media gara facile: " + x/y);
        }
    }
}
