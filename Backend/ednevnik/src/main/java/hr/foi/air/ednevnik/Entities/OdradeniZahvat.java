package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "odradeni_zahvat", schema = "dbo", catalog = "AIR2211_DB")
@IdClass(OdradeniZahvatPK.class)
public class OdradeniZahvat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "zahvat", nullable = false)
    private int zahvat;
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

    public int getZahvat() {
        return zahvat;
    }

    public void setZahvat(int zahvat) {
        this.zahvat = zahvat;
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

        OdradeniZahvat that = (OdradeniZahvat) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (zahvat != that.zahvat) return false;
        if (stupanj != that.stupanj) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + zahvat;
        result = 31 * result + stupanj;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }
}
