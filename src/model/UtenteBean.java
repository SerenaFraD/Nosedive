package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;

public class UserBean extends Bean implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private int id_utente;
    private String email;
    private String nome;
    private String password;
    private Boolean sup; //se un utente è anche supervisore

    public UserBean(int id_utente, String email, String nome, Boolean sup) {
        this.id_utente = id_utente;
        this.email = email;
        this.nome = nome;
        this.sup = sup; //false = utente normale
    }

    public UserBean() {
        id_utente = -1;
        nome = email = password = "";
        sup = false;
    }

    public int getId() {
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

    //ritorna true se l'utente è un admin, false altrimenti
    public Boolean isSupervisor() {
        return auth;
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

    public void setSupervisor(Boolean sup) {
        this.sup = sup;
    }

    @Override
    public UserBean clone() {
        UserBean bean = null;
        try {
            bean = (UserBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id_utente=" + id_utente +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", supervisor=" + sup +
                '}';
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null || otherObj.getClass() != getClass())
            return false;
        UserBean other = (UserBean) otherObj;
        return other.id_utente == id_utente;
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
        UserBean other = (UserBean) otherBean;
        return email.compareTo(other.email);
    }

    @Override
    public String getBeanName() {
        return nome;
    }
}
