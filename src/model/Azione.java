package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Azione extends Bean implements Serializable {
    private int id_azione;
    private String nome;
    private int punteggio;

    public int getId_azione() {
        return id_azione;
    }

    public void setId_azione(int id_azione) {
        this.id_azione = id_azione;
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

    @Override
    public List<String> getKey() {
        ArrayList<String> keys = new ArrayList<>();
        keys.add(nome);
        return keys;
    }

    //TODO L
    @Override
    public int compareKey(Bean otherBean) {
        return 0;
    }

    //TODO L
    @Override
    public String getBeanName() {
        return null;
    }
}
