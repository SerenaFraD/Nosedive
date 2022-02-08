package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrdineBean extends Bean {

    int id_ordine;
    int id_carrello;
    String data;

    public OrdineBean() {
        id_ordine = 0;
        LocalDateTime data;
        id_carrello = 0;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public int getId_carrello() {
        return id_carrello;
    }

    public void setId_carrello(int id_carrello) {
        this.id_carrello = id_carrello;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OrdineBean{" +
                "id_ordine=" + id_ordine +
                ", id_carrello=" + id_carrello +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdineBean)) return false;
        OrdineBean that = (OrdineBean) o;
        return getId_ordine() == that.getId_ordine() && getId_carrello() == that.getId_carrello() && Objects.equals(getData(), that.getData());
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
