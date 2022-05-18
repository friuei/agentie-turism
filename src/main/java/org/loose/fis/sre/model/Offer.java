package org.loose.fis.sre.model;

public class Offer {

    public String tara;
    public String oras;
    public String pret;
    public String descriere;
    public String usr;


    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }



    public String getTara() {
        return tara;
    }

    public String getOras() {
        return oras;
    }

    public String getPret() {
        return pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public Offer( String usr,String tara, String oras, String pret, String descriere) {
        this.usr=usr;
        this.tara = tara;
        this.oras = oras;
        this.pret = pret;
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "Tara='" + tara + '\'' +
                ", Oras='" + oras + '\'' +
                ", Pret='" + pret + '\'' +
                ", Descriere='" + descriere + '\'' +
                ", Agent='" + usr + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return false;
    }
}
