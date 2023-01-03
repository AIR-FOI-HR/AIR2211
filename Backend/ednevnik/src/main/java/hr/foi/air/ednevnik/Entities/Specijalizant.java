package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
public class Specijalizant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_specijalizant", nullable = false)
    private int idSpecijalizant;
    @Basic
    @Column(name = "ime", nullable = false, length = 255)
    private String ime;
    @Basic
    @Column(name = "prezime", nullable = false, length = 255)
    private String prezime;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "lozinka", nullable = false, length = 255)
    private String lozinka;
    @Basic
    @Column(name = "slika", nullable = true, length = 255)
    private String slika;

    public int getIdSpecijalizant() {
        return idSpecijalizant;
    }

    public void setIdSpecijalizant(int idSpecijalizant) {
        this.idSpecijalizant = idSpecijalizant;
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

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specijalizant that = (Specijalizant) o;

        if (idSpecijalizant != that.idSpecijalizant) return false;
        if (ime != null ? !ime.equals(that.ime) : that.ime != null) return false;
        if (prezime != null ? !prezime.equals(that.prezime) : that.prezime != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (lozinka != null ? !lozinka.equals(that.lozinka) : that.lozinka != null) return false;
        if (slika != null ? !slika.equals(that.slika) : that.slika != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpecijalizant;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lozinka != null ? lozinka.hashCode() : 0);
        result = 31 * result + (slika != null ? slika.hashCode() : 0);
        return result;
    }
}
