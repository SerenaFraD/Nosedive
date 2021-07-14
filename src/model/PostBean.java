package model;

import java.io.Serializable;
import java.sql.Blob;

public class PostBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Integer id_post;
    Integer id_utente;
    String timestamp;
    Blob postpic;
    String testo;

    public PostBean() {
        id_post = -1;
        id_utente = -1;
        timestamp = "";
        testo = "";
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

	public Blob getPostpic() {
		return postpic;
	}

	public void setPostpic(Blob postpic) {
		this.postpic = postpic;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

    @Override
	public String toString() {
		return "PostBean [id_post=" + id_post + ", id_utente=" + id_utente + ", timestamp=" + timestamp + ", postpic="
				+ postpic + ", testo=" + testo + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostBean other = (PostBean) obj;
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
		if (postpic == null) {
			if (other.postpic != null)
				return false;
		} else if (!postpic.equals(other.postpic))
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

   
}