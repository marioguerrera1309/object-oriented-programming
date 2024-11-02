/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subscription;

import Clienti.Clienti;

/**
 *
 * @author p7qna
 */
public class Subscription {
    private Clienti cliente;
    private int codice_cliente;
    private int livello;
    
    public Subscription(Clienti cliente, int codice_cliente, int livello) {
        this.cliente = cliente;
        this.codice_cliente=codice_cliente;
        this.livello = livello;
    }

    public Clienti getCliente() {
        return cliente;
    }

    public void setCliente(Clienti cliente) {
        this.cliente = cliente;
    }

    public int getCodice_cliente() {
        return codice_cliente;
    }

    public void setCodice_cliente(int codice_cliente) {
        this.codice_cliente = codice_cliente;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    @Override
    public String toString() {
        return "\nSubscription{" + "cliente=" + cliente + ", codice_cliente=" + codice_cliente + ", livello=" + livello + '}';
    }
    
    
}
