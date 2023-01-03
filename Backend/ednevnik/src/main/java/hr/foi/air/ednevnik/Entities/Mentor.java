package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
public class Mentor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mentor", nullable = false)
    private int idMentor;
    @Basic
    @Column(name = "ime", nullable = false, length = 255)
    private String ime;
    @Basic
    @Column(name = "prezime", nullable = false, length = 255)
    private String prezime;
    @Basic
    @Column(name = "ustrojstvena_jedinica", nullable = false)
    private int ustrojstvenaJedinica;

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getUstrojstvenaJedinica() {
        return ustrojstvenaJedinica;
    }

    public void setUstrojstvenaJedinica(int ustrojstvenaJedinica) {
        this.ustrojstvenaJedinica = ustrojstvenaJedinica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mentor mentor = (Mentor) o;

        if (idMentor != mentor.idMentor) return false;
        if (ustrojstvenaJedinica != mentor.ustrojstvenaJedinica) return false;
        if (ime != null ? !ime.equals(mentor.ime) : mentor.ime != null) return false;
        if (prezime != null ? !prezime.equals(mentor.prezime) : mentor.prezime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMentor;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + ustrojstvenaJedinica;
        return result;
    }
}
