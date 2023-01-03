package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "odradena_kompetencija", schema = "dbo", catalog = "AIR2211_DB")
@IdClass(OdradenaKompetencijaPK.class)
public class OdradenaKompetencija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "kompetencija", nullable = false)
    private int kompetencija;
    @Basic
    @Column(name = "stupanj", nullable = false)
    private int stupanj;
    @Basic
    @Column(name = "datum", nullable = false)
    private Date datum;

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getKompetencija() {
        return kompetencija;
    }

    public void setKompetencija(int kompetencija) {
        this.kompetencija = kompetencija;
    }

    public int getStupanj() {
        return stupanj;
    }

    public void setStupanj(int stupanj) {
        this.stupanj = stupanj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradenaKompetencija that = (OdradenaKompetencija) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (kompetencija != that.kompetencija) return false;
        if (stupanj != that.stupanj) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + kompetencija;
        result = 31 * result + stupanj;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }
}
