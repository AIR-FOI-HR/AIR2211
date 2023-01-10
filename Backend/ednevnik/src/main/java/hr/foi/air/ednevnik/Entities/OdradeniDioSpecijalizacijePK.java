package hr.foi.air.ednevnik.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class OdradeniDioSpecijalizacijePK implements Serializable {
    @Column(name = "specijalizacija", nullable = false)
    @Id
    private int specijalizacija;
    @Column(name = "dio_specijalizacije", nullable = false)
    @Id
    private int dioSpecijalizacije;

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getDioSpecijalizacije() {
        return dioSpecijalizacije;
    }

    public void setDioSpecijalizacije(int dioSpecijalizacije) {
        this.dioSpecijalizacije = dioSpecijalizacije;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradeniDioSpecijalizacijePK that = (OdradeniDioSpecijalizacijePK) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (dioSpecijalizacije != that.dioSpecijalizacije) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + dioSpecijalizacije;
        return result;
    }
}
