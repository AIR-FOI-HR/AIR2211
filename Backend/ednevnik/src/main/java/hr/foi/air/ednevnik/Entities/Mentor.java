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
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "lozinka", nullable = false, length = 255)
    private String lozinka;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
        if (email != null ? !email.equals(mentor.email) : mentor.email != null) return false;
        if (lozinka != null ? !lozinka.equals(mentor.lozinka) : mentor.lozinka != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMentor;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + ustrojstvenaJedinica;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lozinka != null ? lozinka.hashCode() : 0);
        return result;
    }
}
