/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * @author filip
 */
public class CompitoDidattico {
    private String nomeClasse;
    private int numeroStudenti;
    private int numMaxStudenti;
    private String NomeInsegnamento;

    public CompitoDidattico(String nomeClasse, int numeroStudenti, int numMaxStudenti, String NomeInsegnamento) {
        this.nomeClasse = nomeClasse;
        this.numeroStudenti = numeroStudenti;
        this.numMaxStudenti = numMaxStudenti;
        this.NomeInsegnamento = NomeInsegnamento;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public int getNumeroStudenti() {
        return numeroStudenti;
    }

    public void setNumeroStudenti(int numeroStudenti) {
        this.numeroStudenti = numeroStudenti;
    }

    public int getNumMaxStudenti() {
        return numMaxStudenti;
    }

    public void setNumMaxStudenti(int numMaxStudenti) {
        this.numMaxStudenti = numMaxStudenti;
    }

    public String getNomeInsegnamento() {
        return NomeInsegnamento;
    }

    public void setNomeInsegnamento(String NomeInsegnamento) {
        this.NomeInsegnamento = NomeInsegnamento;
    }

    @Override
    public String toString() {
        return "CompitoDidattico{" + "nomeClasse=" + nomeClasse + ", numeroStudenti=" + numeroStudenti + ", numMaxStudenti=" + numMaxStudenti + ", NomeInsegnamento=" + NomeInsegnamento + '}';
    }
    
    
    
    
}

