package hr.foi.air.ednevnik.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class OdradeniZahvatPK implements Serializable {
    @Column(name = "specijalizacija", nullable = false)
    @Id
    private int specijalizacija;
    @Column(name = "zahvat", nullable = false)
    @Id
    private int zahvat;
    @Column(name = "stupanj", nullable = false)
    @Id
    private int stupanj;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradeniZahvatPK that = (OdradeniZahvatPK) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (zahvat != that.zahvat) return false;
        if (stupanj != that.stupanj) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + zahvat;
        result = 31 * result + stupanj;
        return result;
    }
}
