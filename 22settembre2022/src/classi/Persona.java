/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * @author filip
 */
public class Persona {
    private String nome;
    private String DataNascita;
    private String codiceFiscale;

    public Persona(String nome, String DataNascita, String codiceFiscale) {
        this.nome = nome;
        this.DataNascita = DataNascita;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascita() {
        return DataNascita;
    }

    public void setDataNascita(String DataNascita) {
        this.DataNascita = DataNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public String toString() {
        return "{Nome=" + nome + ", DataNascita=" + DataNascita + ", codiceFiscale=" + codiceFiscale + '}';
    }
    
    
    
    
    
}
