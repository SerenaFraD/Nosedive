package model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformazioniUtenteBean extends Bean implements Serializable, Cloneable {

    private int id_utente;
    private String compleanno;
    private int punteggio;
    private int id_relazione;
    private int id_lavoro;
    private Blob propic;
    private boolean sesso;
    private boolean deceduto;
    private boolean bloccato;

    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    public String getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(String compleanno) {
        this.compleanno = compleanno;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getId_relazione() {
        return id_relazione;
    }

    public void setId_relazione(int id_relazione) {
        this.id_relazione = id_relazione;
    }

    public int getId_lavoro() {
        return id_lavoro;
    }

    public void setId_lavoro(int id_lavoro) {
        this.id_lavoro = id_lavoro;
    }

    public Blob getPropic() {
        return propic;
    }

    public void setPropic(Blob propic) {
        this.propic = propic;
    }

    public void setSesso(boolean sesso) {
        this.sesso = sesso;
    }

    public boolean isSesso() {
        return sesso;
    }

    public void setDeceduto(boolean deceduto) {
        this.deceduto = deceduto;
    }

    public boolean isDeceduto() {
        return deceduto;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public boolean isBloccato() {
        return bloccato;
    }

    @Override
    public String toString() {
        return "InfoUtenteBean{" +
                "id_utente=" + id_utente +
                ", compleanno=" + compleanno +
                ", punteggio=" + punteggio +
                ", id_relazione=" + id_relazione +
                ", id_lavoro=" + id_lavoro +
                ", propic=" + propic +
                ", sesso=" + sesso +
                ", deceduto=" + deceduto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformazioniUtenteBean)) return false;
        InformazioniUtenteBean that = (InformazioniUtenteBean) o;
        return getId_utente() == that.getId_utente() && getPunteggio() == that.getPunteggio() && getId_relazione() == that.getId_relazione() && getId_lavoro() == that.getId_lavoro() && isSesso() == that.isSesso() && isDeceduto() == that.isDeceduto() && getCompleanno().equals(that.getCompleanno()) && getPropic().equals(that.getPropic());
    }

    @Override
    public List<String> getKey() {
        ArrayList<String> keys = new ArrayList<String>();
        keys.add(Integer.toString(id_utente));
        return keys;
    }

    //TODO: Bho da rivedere L
    @Override
    public int compareKey(Bean otherBean) {
        if (this.getClass() != otherBean.getClass())
            return 1;
        InformazioniUtenteBean other = (InformazioniUtenteBean) otherBean;
        return Boolean.hashCode(id_utente == other.getId_utente());
    }

    @Override
    public String getBeanName() {
        return "InfoUtenteBean";
    }


}
