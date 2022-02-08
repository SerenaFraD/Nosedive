package model;

import java.io.Serializable;
import java.util.List;

public class ProdottoBean extends Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id_prodotto;
    private String nome;
    private String descrizione;
    private String img;
    private double costo;
    private int categoria;
    private int punteggio_min;

    public ProdottoBean() {
        id_prodotto = 0;
        nome = "";
        descrizione = "";
        img = null;
        costo = 0;
        categoria = 0;
        punteggio_min = 0;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getPunteggio_min() {
        return punteggio_min;
    }

    public void setPunteggio_min(int punteggio_min) {
        this.punteggio_min = punteggio_min;
    }

    @Override
    public String toString() {
        return "ProdottoBean{" +
                "id_prodotto=" + id_prodotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", img=" + img +
                ", costo=" + costo +
                ", categoria=" + categoria +
                ", punteggio_min=" + punteggio_min +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdottoBean)) return false;
        ProdottoBean that = (ProdottoBean) o;
        return getId_prodotto() == that.getId_prodotto() && Double.compare(that.getCosto(), getCosto()) == 0 && getCategoria() == that.getCategoria() && getPunteggio_min() == that.getPunteggio_min() && getNome().equals(that.getNome()) && getDescrizione().equals(that.getDescrizione()) && getImg().equals(that.getImg());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public List<String> getKey() {
        return null;
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
