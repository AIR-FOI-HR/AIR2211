package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Ispit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ispit", nullable = false)
    private int idIspit;
    @Basic
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @Basic
    @Column(name = "datum", nullable = true)
    private Date datum;
    @Basic
    @Column(name = "vrijeme_odrzavanja", nullable = false)
    private Time vrijemeOdrzavanja;
    @Basic
    @Column(name = "naziv_ustanove", nullable = false, length = 255)
    private String nazivUstanove;
    @Basic
    @Column(name = "prosao", nullable = true)
    private Byte prosao;

    public int getIdIspit() {
        return idIspit;
    }

    public void setIdIspit(int idIspit) {
        this.idIspit = idIspit;
    }

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Object getVrijemeOdrzavanja() {
        return vrijemeOdrzavanja;
    }

    public void setVrijemeOdrzavanja(Time vrijemeOdrzavanja) {
        this.vrijemeOdrzavanja = vrijemeOdrzavanja;
    }

    public String getNazivUstanove() {
        return nazivUstanove;
    }

    public void setNazivUstanove(String nazivUstanove) {
        this.nazivUstanove = nazivUstanove;
    }

    public Byte getProsao() {
        return prosao;
    }

    public void setProsao(Byte prosao) {
        this.prosao = prosao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ispit ispit = (Ispit) o;

        if (idIspit != ispit.idIspit) return false;
        if (specijalizacija != ispit.specijalizacija) return false;
        if (datum != null ? !datum.equals(ispit.datum) : ispit.datum != null) return false;
        if (vrijemeOdrzavanja != null ? !vrijemeOdrzavanja.equals(ispit.vrijemeOdrzavanja) : ispit.vrijemeOdrzavanja != null)
            return false;
        if (nazivUstanove != null ? !nazivUstanove.equals(ispit.nazivUstanove) : ispit.nazivUstanove != null)
            return false;
        if (prosao != null ? !prosao.equals(ispit.prosao) : ispit.prosao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idIspit;
        result = 31 * result + specijalizacija;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (vrijemeOdrzavanja != null ? vrijemeOdrzavanja.hashCode() : 0);
        result = 31 * result + (nazivUstanove != null ? nazivUstanove.hashCode() : 0);
        result = 31 * result + (prosao != null ? prosao.hashCode() : 0);
        return result;
    }
}
