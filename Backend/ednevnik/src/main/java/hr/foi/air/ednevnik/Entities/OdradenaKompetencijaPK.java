package hr.foi.air.ednevnik.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class OdradenaKompetencijaPK implements Serializable {
    @Column(name = "specijalizacija", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specijalizacija;
    @Column(name = "kompetencija", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kompetencija;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradenaKompetencijaPK that = (OdradenaKompetencijaPK) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (kompetencija != that.kompetencija) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + kompetencija;
        return result;
    }
}
