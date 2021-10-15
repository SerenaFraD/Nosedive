package model;

public class Ordine {

    int codice;
    String dataOrd;
    int nPezzi;
    int userID;

    public Ordine(){
        codice= 0;
        dataOrd= "";
        nPezzi= 0;
        userID = 0;
    }

    public int getCodice(){ return codice;}

    public void setCodice(int codice){ this.codice= codice;}

    public String getDataOrd(){ return dataOrd;}

    public void setDataOrd(String dataOrd){ this.dataOrd= dataOrd;}

    public int getnPezzi(){ return nPezzi;}

    public void setnPezzi(int nPezzi){ this.nPezzi= nPezzi;}

    public int getUserID(){ return userID;}

    public void setUserID(int userID){ this.userID= userID;}


    public String toString(){
        return "Ordine [Codice=" + codice +", Data Ordine=" + dataOrd + ", N. Pezzi=" + nPezzi + "User ID=" + userID + "]";
    }

    public boolean equals(Object other){ return (this.getCodice() == ((Ordine)other).getCodice());}
}
