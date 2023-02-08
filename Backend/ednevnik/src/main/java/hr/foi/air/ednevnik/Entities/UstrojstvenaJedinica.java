package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
@Table(name = "ustrojstvena_jedinica", schema = "dbo", catalog = "AIR2211_DB")
public class UstrojstvenaJedinica {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_jedinica", nullable = false)
    private int idJedinica;
    @Basic
    @Column(name = "naziv_ustanova", nullable = true, length = 500)
    private String nazivUstanova;
    @Basic
    @Column(name = "naziv_jedinica", nullable = true, length = 500)
    private String nazivJedinica;

    public int getIdJedinica() {
        return idJedinica;
    }

    public void setIdJedinica(int idJedinica) {
        this.idJedinica = idJedinica;
    }

    public String getNazivUstanova() {
        return nazivUstanova;
    }

    public void setNazivUstanova(String nazivUstanova) {
        this.nazivUstanova = nazivUstanova;
    }

    public String getNazivJedinica() {
        return nazivJedinica;
    }

    public void setNazivJedinica(String nazivJedinica) {
        this.nazivJedinica = nazivJedinica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UstrojstvenaJedinica that = (UstrojstvenaJedinica) o;

        if (idJedinica != that.idJedinica) return false;
        if (nazivUstanova != null ? !nazivUstanova.equals(that.nazivUstanova) : that.nazivUstanova != null)
            return false;
        if (nazivJedinica != null ? !nazivJedinica.equals(that.nazivJedinica) : that.nazivJedinica != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJedinica;
        result = 31 * result + (nazivUstanova != null ? nazivUstanova.hashCode() : 0);
        result = 31 * result + (nazivJedinica != null ? nazivJedinica.hashCode() : 0);
        return result;
    }
}
