/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monitor;
import Classi.Utenti;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author p7qna
 */
public class Buffer {
    private final TreeMap<Utenti, Seat> buffer;
    private int readcount;
    private boolean writelock;
    static final int MaxFirst=10;
    static final int MaxGallery=10;
    static final int MaxNormal=10;
    
    public Buffer() {
        readcount=0;
        buffer=new TreeMap<>();
        writelock=false;
    }
    
    public enum Seat {
        First(MaxFirst),
        Gallery(MaxGallery),
        Normal(MaxNormal);
        
        final int maxseat;
        int availableSeat;

        Seat(int maxseat) {
            this.maxseat=maxseat;
            availableSeat=maxseat;
        }
        
        int ticket=0;
        
        public int postiRiservati() {
            if(availableSeat==0) {
                return -1;
            }
            availableSeat--;
            ticket++;
            return ticket;
        }
        
    }
    
    private synchronized int WriteLock(Seat seat) throws InterruptedException {
        int posto;
        while(readcount>0 || (posto=seat.postiRiservati())==-1) {
            wait();
        }
        writelock=true;
        return posto;
    }
    
    private synchronized void WriteUnlock() {
        writelock=false;
        notifyAll();
    }
    
    public synchronized void ReadLock() throws InterruptedException {
        while(writelock) {
            wait();
        }
        readcount++;
    }
    
    public boolean insert(Utenti utente, Seat seat) {
        int posto;
        try {
            posto=WriteLock(seat);
        } catch (InterruptedException e) {
            System.out.println("Errore");
        }
        if(buffer.containsKey(utente)==true) {
            return Boolean.FALSE;
        }
        buffer.put(utente, seat);
        WriteUnlock();
        return Boolean.TRUE;
    }
    
    public synchronized void remove(Seat seat) throws InterruptedException {
        while(readcount>0 || seat.availableSeat==seat.maxseat) {
            wait();
        }
        buffer.remove(buffer.firstKey());
        WriteUnlock();
    }
    
    public void read(Seat seat) {
        
    }
    
}

