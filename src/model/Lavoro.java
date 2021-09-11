package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lavoro extends Bean implements Serializable {

    private int id_lavoro;
    private String nome;
    private int punteggio;

    public int getId_lavoro() {
        return id_lavoro;
    }

    public void setId_lavoro(int id_lavoro) {
        this.id_lavoro = id_lavoro;
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
        ArrayList<String> keys = new ArrayList<String>();
        keys.add(nome);
        return keys;
    }

    @Override
    public int compareKey(Bean otherBean) {
        return 0;
    }

    @Override
    public String getBeanName() {
        return null;
    }
}
