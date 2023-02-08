package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
public class Zahvat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_zahvat", nullable = false)
    private int idZahvat;
    @Basic
    @Column(name = "program_specijalizacije", nullable = false)
    private int programSpecijalizacije;
    @Basic
    @Column(name = "naziv_zahvat", nullable = false, length = 255)
    private String nazivZahvat;

    public int getIdZahvat() {
        return idZahvat;
    }

    public void setIdZahvat(int idZahvat) {
        this.idZahvat = idZahvat;
    }

    public int getProgramSpecijalizacije() {
        return programSpecijalizacije;
    }

    public void setProgramSpecijalizacije(int programSpecijalizacije) {
        this.programSpecijalizacije = programSpecijalizacije;
    }

    public String getNazivZahvat() {
        return nazivZahvat;
    }

    public void setNazivZahvat(String nazivZahvat) {
        this.nazivZahvat = nazivZahvat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zahvat zahvat = (Zahvat) o;

        if (idZahvat != zahvat.idZahvat) return false;
        if (programSpecijalizacije != zahvat.programSpecijalizacije) return false;
        if (nazivZahvat != null ? !nazivZahvat.equals(zahvat.nazivZahvat) : zahvat.nazivZahvat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZahvat;
        result = 31 * result + programSpecijalizacije;
        result = 31 * result + (nazivZahvat != null ? nazivZahvat.hashCode() : 0);
        return result;
    }
}
