package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
public class Kompetencija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_kompetencija", nullable = false)
    private int idKompetencija;
    @Basic
    @Column(name = "program_specijalizacije", nullable = true)
    private Integer programSpecijalizacije;
    @Basic
    @Column(name = "naziv_kompetencija", nullable = true, length = 255)
    private String nazivKompetencija;
    @Basic
    @Column(name = "posebna", nullable = true)
    private Byte posebna;

    public int getIdKompetencija() {
        return idKompetencija;
    }

    public void setIdKompetencija(int idKompetencija) {
        this.idKompetencija = idKompetencija;
    }

    public Integer getProgramSpecijalizacije() {
        return programSpecijalizacije;
    }

    public void setProgramSpecijalizacije(Integer programSpecijalizacije) {
        this.programSpecijalizacije = programSpecijalizacije;
    }

    public String getNazivKompetencija() {
        return nazivKompetencija;
    }

    public void setNazivKompetencija(String nazivKompetencija) {
        this.nazivKompetencija = nazivKompetencija;
    }

    public Byte getPosebna() {
        return posebna;
    }

    public void setPosebna(Byte posebna) {
        this.posebna = posebna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kompetencija that = (Kompetencija) o;

        if (idKompetencija != that.idKompetencija) return false;
        if (programSpecijalizacije != null ? !programSpecijalizacije.equals(that.programSpecijalizacije) : that.programSpecijalizacije != null)
            return false;
        if (nazivKompetencija != null ? !nazivKompetencija.equals(that.nazivKompetencija) : that.nazivKompetencija != null)
            return false;
        if (posebna != null ? !posebna.equals(that.posebna) : that.posebna != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idKompetencija;
        result = 31 * result + (programSpecijalizacije != null ? programSpecijalizacije.hashCode() : 0);
        result = 31 * result + (nazivKompetencija != null ? nazivKompetencija.hashCode() : 0);
        result = 31 * result + (posebna != null ? posebna.hashCode() : 0);
        return result;
    }
}
