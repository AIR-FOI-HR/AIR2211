package hr.foi.air.ednevnik.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class OdradenaKompetencijaPK implements Serializable {
    @Column(name = "specijalizacija", nullable = false)
    @Id
    private int specijalizacija;
    @Column(name = "kompetencija", nullable = false)
    @Id
    private int kompetencija;
    @Column(name = "stupanj", nullable = false)
    @Id
    private int stupanj;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradenaKompetencijaPK that = (OdradenaKompetencijaPK) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (kompetencija != that.kompetencija) return false;
        if (stupanj != that.stupanj) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + kompetencija;
        result = 31 * result + stupanj;
        return result;
    }
}
