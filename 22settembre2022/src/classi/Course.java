/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.util.HashMap;

/**
 *
 * @author filip
 */
public class Course {
    public enum Corso{
        Musica(4), Pittura(4), Potenziamento(4);
        private final int MaxCapacity;

        private Corso(int MaxCapacity) {
            this.MaxCapacity = MaxCapacity;
        }

        public int getMaxCapacity() {
            return MaxCapacity;
        }
        
    }
    private Corso corso;

    public Course(Corso corso) {
        this.corso = corso;
    }

    public Corso getCorso() {
        return corso;
    }
    
    
    
}
