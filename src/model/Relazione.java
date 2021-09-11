package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Relazione extends Bean implements Serializable {
    private int id_relazione;
    private String nome;
    private int punteggio;

    public int getId_relazione() {
        return id_relazione;
    }

    public void setId_relazione(int id_relazione) {
        this.id_relazione = id_relazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public List<String> getKey() {
        ArrayList<String> keys = new ArrayList<String>();
        keys.add(nome);
        return keys;
    }


    //TODO
    @Override
    public int compareKey(Bean otherBean) {
        return 0;
    }

    //TODO
    @Override
    public String getBeanName() {
        return null;
    }
}
