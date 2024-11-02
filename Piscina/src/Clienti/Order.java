/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clienti;

import java.util.Comparator;

/**
 *
 * @author p7qna
 */
public class Order implements Comparator<Clienti> {

    @Override
    public int compare(Clienti o1, Clienti o2) {
        if(o1==null) {
            return 1;
        }
        if(o2==null) {
            return -1;
        }
        return o1.getEmail().compareTo(o2.getEmail());
    }
    
}
