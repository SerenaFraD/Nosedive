package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.List;
import java.util.ArrayList;

public class UtenteBean extends Bean implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private int id_utente;
    private String email;
    private String nome;
    private String password;
    private Boolean sup; //se un utente � anche supervisore
    private String compleanno;
    private int punteggio;
    private int id_relazione;
    private int id_lavoro;
    private String propic;
    private boolean sesso;
    private boolean deceduto;
    private boolean bloccato;

    public UtenteBean(int id_utente, String email, String nome, String password, Boolean sup, String compleanno, int punteggio, int id_relazione, int id_lavoro, String propic, boolean sesso, boolean deceduto, boolean bloccato) {
        this.id_utente = id_utente;
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.sup = sup;
        this.compleanno = compleanno;
        this.punteggio = punteggio;
        this.id_relazione = id_relazione;
        this.id_lavoro = id_lavoro;
        this.propic = propic;
        this.sesso = sesso;
        this.deceduto = deceduto;
        this.bloccato = bloccato;
    }

    public UtenteBean() {
        id_utente = -1;
        id_relazione = 3;
        id_lavoro = 2;
        nome = email = password = compleanno =  "";
        punteggio = 1000;
        propic = null;
        sesso = deceduto = bloccato = sup = false;
    }

    public int getId_utente() {
    	return id_utente;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }
    
    public String getPassword() {
        return this.password;
    }

    //ritorna true se l'utente � un admin, false altrimenti
    public Boolean isSupervisor() {
        return sup;
    }
    
    public void setPasswordhash(String passwordNew) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(passwordNew.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPassword(String password){this.password= password;}

    public void setSupervisor(boolean sup) {
        this.sup = sup;
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
        this.punteggio += punteggio;
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

    public String getPropic() {
        return propic;
    }

    public void setPropic(String propic) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtenteBean)) return false;
        UtenteBean that = (UtenteBean) o;
        return getId_utente() == that.getId_utente() && getPunteggio() == that.getPunteggio() && getId_relazione() == that.getId_relazione() && getId_lavoro() == that.getId_lavoro() && isSesso() == that.isSesso() && isDeceduto() == that.isDeceduto() && isBloccato() == that.isBloccato() && getEmail().equals(that.getEmail()) && getNome().equals(that.getNome()) && getPassword().equals(that.getPassword()) && sup.equals(that.sup) && getCompleanno().equals(that.getCompleanno()) && getPropic().equals(that.getPropic());
    }

    @Override
    public UtenteBean clone() {
        UtenteBean bean = null;
        try {
            bean = (UtenteBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public String toString() {
        return "UtenteBean{" +
                "id_utente=" + id_utente +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", sup=" + sup +
                ", compleanno='" + compleanno + '\'' +
                ", punteggio=" + punteggio +
                ", id_relazione=" + id_relazione +
                ", id_lavoro=" + id_lavoro +
                ", propic=" + propic +
                ", sesso=" + sesso +
                ", deceduto=" + deceduto +
                ", bloccato=" + bloccato +
                '}';
    }

    @Override
    public List<String> getKey() {
        ArrayList<String> keys = new ArrayList<String>();
        keys.add(email);
        return keys;
    }

    @Override
    public int compareKey(Bean otherBean) {
        if (this.getClass() != otherBean.getClass())
            return 1;
        UtenteBean other = (UtenteBean) otherBean;
        return email.compareTo(other.email);
    }

    @Override
    public String getBeanName() {
        return "UtenteBean";
    }
}
