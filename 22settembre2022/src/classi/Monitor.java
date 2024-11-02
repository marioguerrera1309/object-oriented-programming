/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import classi.Course.Corso;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author filip
 */
public class Monitor {
    private HashMap<String, Course> iscritti;
    private int count=0;

    public Monitor(HashMap<String, Course> iscritti) {
        this.iscritti = iscritti;
    }
    private boolean TrovaInscritti(Course course1, Course course2){
        return iscritti.containsValue(course1) || iscritti.containsValue(course2);
    }
    private boolean TrovaInscritto(Course course){
        return iscritti.containsValue(course);
    }

    public synchronized  int getCount() {
        return count;
    }

    public synchronized  HashMap<String, Course> getIscritti() {
        return iscritti;
    }
    
    
   public synchronized void AggiungiStudente(String nome, int numero, Course corso) throws InterruptedException{
       while(numero>corso.getCorso().getMaxCapacity()){
           wait();
       }
       count++;
       iscritti.put(nome, corso);
       System.out.println("Lo studente "+nome+" si è iscritto al corso"+corso.getCorso());
       notifyAll();
   }
    public synchronized void RimuoviStudente(Course corso1, Course corso2) throws InterruptedException{
        while (!TrovaInscritti(corso1, corso2)) {
            wait();
        }
        String ris = "";
        for (String sub : iscritti.keySet()){
            if (iscritti.get(sub) == corso1 || iscritti.get(sub) == corso2){
                ris = sub;
            }
        }
        Course course = iscritti.remove(ris);
        if (course != null) {
            count--;
            System.out.println("Lo studente"+ris+ "è stato rimosso dal corso" + course.getCorso());
        }
        notifyAll();
    }
    
    public synchronized void removeAllSubs(Course c) throws InterruptedException{
        while (!TrovaInscritto(c)){
            wait();
        }
        ArrayList<String> founded = new ArrayList<>();
        for (String key: iscritti.keySet()){
            if(iscritti.get(key).equals(c)) founded.add(key);
        }
        for (String key: founded){
            count--;
            iscritti.remove(key);
            System.out.println(key + "rimosso dal corso" + iscritti.get(key).getCorso());
        }
        notifyAll();
    }
    
    public synchronized void printbyCourses(Course c1, Course c2) throws InterruptedException{
        while (!TrovaInscritti(c1, c2)) {
            wait();
        }
        for (String key: iscritti.keySet()){
            if(iscritti.get(key).equals(c1) || iscritti.get(key).equals(c1)){
                System.out.println(key + "iscritto al corso" + iscritti.get(key).getCorso());
            }
        }
       
        notifyAll();
    }
    
    public synchronized void printbyCourse(Course course) throws InterruptedException{
        while (!TrovaInscritto(course)) {
            wait();
        }
        for (String key: iscritti.keySet()){
            if(iscritti.get(key).equals(course)){
                System.out.println(key + "iscritto al corso" + iscritti.get(key).getCorso());
            }
        }
       
        notifyAll();
    }
   
   
   
}
