package model;

import java.io.Serializable;
import java.lang.String;

public class CommentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Integer id_commento;
	Integer id_post;
    Integer id_utente;
    String timestamp;
    String testo;

    public CommentoBean() {
    	id_commento = -1;
    	id_post = -1;
    	id_utente = -1;
    	testo = "";
    }

	public Integer getId_commento() {
		return this.id_commento;
	}

	public void setId_commento(Integer id_commento) {
		this.id_commento = id_commento;
	}

	public Integer getId_post() {
		return id_post;
	}

	public void setId_post(Integer id_post) {
		this.id_post = id_post;
	}

	public Integer getId_utente() {
		return id_utente;
	}

	public void setId_utente(Integer id_utente) {
		this.id_utente = id_utente;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentoBean other = (CommentoBean) obj;
		if (id_commento == null) {
			if (other.id_commento != null)
				return false;
		} else if (!id_commento.equals(other.id_commento))
			return false;
		if (id_post == null) {
			if (other.id_post != null)
				return false;
		} else if (!id_post.equals(other.id_post))
			return false;
		if (id_utente == null) {
			if (other.id_utente != null)
				return false;
		} else if (!id_utente.equals(other.id_utente))
			return false;
		if (testo == null) {
			if (other.testo != null)
				return false;
		} else if (!testo.equals(other.testo))
			return false;
		if (timestamp == null) {
            return other.timestamp == null;
		} else return timestamp.equals(other.timestamp);
    }

	@Override
	public String toString() {
		return "CommentoBean [id_commento=" + id_commento + ", id_post="
				+ id_post + ", id_utente=" + id_utente + ", timestamp=" + timestamp + ", testo=" + testo + "]";
	}
    
    
}
