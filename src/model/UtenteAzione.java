package model;

import java.io.Serializable;
import java.util.List;

public class UtenteAzione extends Bean implements Serializable {
	Integer id_utente;
	Integer id_azione;
	
	UtenteAzione() {
		id_utente = -1;
		id_azione = -1;
	}

	public Integer getId_utente() {
		return id_utente;
	}

	public void setId_utente(Integer id_utente) {
		this.id_utente = id_utente;
	}

	public Integer getId_azione() {
		return id_azione;
	}

	public void setId_azione(Integer id_azione) {
		this.id_azione = id_azione;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteAzione other = (UtenteAzione) obj;
		if (id_azione == null) {
			if (other.id_azione != null)	
				return false;
		} else if (!id_azione.equals(other.id_azione))
			return false;
		if (id_utente == null) {
            return other.id_utente == null;
		} else return id_utente.equals(other.id_utente);
    }

	@Override
	public String toString() {
		return "UtenteAzione [id_utente=" + id_utente + ", id_azione=" + id_azione + "]";
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
