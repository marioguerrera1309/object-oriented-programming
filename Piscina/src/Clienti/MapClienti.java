/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clienti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author p7qna
 */
public class MapClienti {
    private HashMap<String, Clienti> mapClienti;

    public MapClienti() {
        mapClienti=new HashMap<>();
    }
    
    public int addCliente(Clienti cliente) {
        if(mapClienti.containsKey(cliente.getEmail())) {
            return -1;
        }
        mapClienti.put(cliente.getEmail(), cliente);
        return 1;
    }
    
    public ArrayList<Clienti> getListaClienti() {
        ArrayList<Clienti> lista=new ArrayList<>();
        for(String email: mapClienti.keySet()) {
            lista.add(mapClienti.get(email));
        }
        return lista;
    }
    
    public ArrayList<Clienti> getListaClientiOrdinati() {
        ArrayList<Clienti> listaordinata=new ArrayList<>();
        for(String email: mapClienti.keySet()) {
            listaordinata.add(mapClienti.get(email));
        }
        Collections.sort(listaordinata, new Order());
        return listaordinata;
    }
    
    public Clienti getClienti(String key) {
        if(mapClienti.containsKey(key)) {
            return mapClienti.get(key);
        }
        return null;
    }
    
}
