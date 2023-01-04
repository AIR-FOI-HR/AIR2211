package hr.foi.air.ednevnik.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class OdradeniZahvatPK implements Serializable {
    @Column(name = "specijalizacija", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specijalizacija;
    @Column(name = "zahvat", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zahvat;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradeniZahvatPK that = (OdradeniZahvatPK) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (zahvat != that.zahvat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + zahvat;
        return result;
    }
}