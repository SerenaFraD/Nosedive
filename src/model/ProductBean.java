package model;

import java.io.Serializable;

public class ProductBean implements Serializable {

    private static final long serialVersionUID = 1L;

    String codiceProd;
    String nome;
    String descrizione;
    String img;
    String boh;
    double prezzo;
    String marca;
    String disponibilità;
    String offerta;
    int quantita;
    String misure;
    String stagione;
    String materiale;
    String impiego;



    public ProductBean() {
        codiceProd= "-1";
        nome="";
        descrizione= "";
        img= "";
        prezzo=0;
        marca="";
        disponibilità="";
        offerta= "";
        quantita=0;
        misure="";
        stagione= "";
        materiale= "";
        impiego= "";
    }

    public String getCodiceProd() {
        return codiceProd;
    }

    public void setCodiceProd(String codiceProd) {
        this.codiceProd = codiceProd;
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
        this.img=img;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDisponibilita() {
        return disponibilità;
    }

    public void setDisponibilita(String disponibilità) {
        this.disponibilità = disponibilità;
    }

    public boolean isEmpty() {
        return codiceProd.equals("-1");
    }

    public void setOfferta(String offerta){ this.offerta = offerta;}

    public String getOfferta(){return offerta;}

    public int getQuantita(){return quantita;}

    public void setQuantita(int quantita){
        this.quantita= quantita;
    }

    public String getMisure(){return misure;}

    public void setMisure(String misure){
        this.misure= misure;
    }

    public String getStagione(){return stagione;}

    public void setStagione(String stagione){
        this.stagione= stagione;
    }

    public String getMateriale(){return materiale;}

    public void setMateriale(String materiale){
        this.materiale= materiale;
    }

    public String getImpiego(){return impiego;}

    public void setImpiego(String impiego){
        this.impiego= impiego;
    }

    @Override
    public String toString() {
        return "ProductBean [Nome Prodotto=" + nome + ", Codice Prodotto=" + codiceProd + ", Descrizione=" + descrizione + ", Prezzo=" + prezzo
                + ", Marca=" + marca + ", Disponibilità=" + disponibilità +
                 "Quantitá=" + quantita + ",Misure="+ misure+ ",Stagione="
                + stagione + ",Materiale="+ materiale + "Impiego=" + "]";
    }

    @Override
    public boolean equals(Object other) {
        return (this.getCodiceProd() == ((ProductBean)other).getCodiceProd());
    }






}
