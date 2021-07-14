package model;

import java.io.Serializable;
import java.lang.String;
import java.time.LocalDateTime;

public class CommentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Integer id_commento;
    Integer id_commentatore;
	Integer id_post;
    Integer id_utente;
    LocalDateTime timestamp;
    String testo;

    CommentoBean() {
    	id_commento = -1;
    	id_commentatore = -1;
    	id_post = -1;
    	id_utente = -1;
    	testo = "";
    }

	public Integer getId_commento() {
		return id_commento;
	}

	public void setId_commento(Integer id_commento) {
		this.id_commento = id_commento;
	}

	public Integer getId_commentatore() {
		return id_commentatore;
	}

	public void setId_commentatore(Integer id_commentatore) {
		this.id_commentatore = id_commentatore;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_commentatore == null) ? 0 : id_commentatore.hashCode());
		result = prime * result + ((id_commento == null) ? 0 : id_commento.hashCode());
		result = prime * result + ((id_post == null) ? 0 : id_post.hashCode());
		result = prime * result + ((id_utente == null) ? 0 : id_utente.hashCode());
		result = prime * result + ((testo == null) ? 0 : testo.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
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
		if (id_commentatore == null) {
			if (other.id_commentatore != null)
				return false;
		} else if (!id_commentatore.equals(other.id_commentatore))
			return false;
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
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentoBean [id_commento=" + id_commento + ", id_commentatore=" + id_commentatore + ", id_post="
				+ id_post + ", id_utente=" + id_utente + ", timestamp=" + timestamp + ", testo=" + testo + "]";
	}
    
    
}
