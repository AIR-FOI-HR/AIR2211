package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
@Table(name = "stupanj_napredovanja", schema = "dbo", catalog = "AIR2211_DB")
public class StupanjNapredovanja {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_stupanj", nullable = false)
    private int idStupanj;
    @Basic
    @Column(name = "naziv_stupanj", nullable = false, length = 255)
    private String nazivStupanj;

    public int getIdStupanj() {
        return idStupanj;
    }

    public void setIdStupanj(int idStupanj) {
        this.idStupanj = idStupanj;
    }

    public String getNazivStupanj() {
        return nazivStupanj;
    }

    public void setNazivStupanj(String nazivStupanj) {
        this.nazivStupanj = nazivStupanj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StupanjNapredovanja that = (StupanjNapredovanja) o;

        if (idStupanj != that.idStupanj) return false;
        if (nazivStupanj != null ? !nazivStupanj.equals(that.nazivStupanj) : that.nazivStupanj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStupanj;
        result = 31 * result + (nazivStupanj != null ? nazivStupanj.hashCode() : 0);
        return result;
    }
}
