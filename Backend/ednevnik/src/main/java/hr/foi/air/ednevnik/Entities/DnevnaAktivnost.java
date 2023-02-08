package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dnevna_aktivnost", schema = "dbo", catalog = "AIR2211_DB")
public class DnevnaAktivnost {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_aktivnost", nullable = false)
    private int idAktivnost;
    @Basic
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @Basic
    @Column(name = "datum_aktivnost", nullable = false)
    private Date datumAktivnost;
    @Basic
    @Column(name = "naziv_aktivnost", nullable = false, length = 255)
    private String nazivAktivnost;
    @Basic
    @Column(name = "opis_aktivnost", nullable = true, length = 8000)
    private String opisAktivnost;
    @Basic
    @Column(name = "br_zahvata_nadzor", nullable = true)
    private Integer brZahvataNadzor;
    @Basic
    @Column(name = "br_zahvata_samostalno", nullable = true)
    private Integer brZahvataSamostalno;
    @Basic
    @Column(name = "potpis_mentora", nullable = true)
    private Byte potpisMentora;

    public int getIdAktivnost() {
        return idAktivnost;
    }

    public void setIdAktivnost(int idAktivnost) {
        this.idAktivnost = idAktivnost;
    }

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public Date getDatumAktivnost() {
        return datumAktivnost;
    }

    public void setDatumAktivnost(Date datumAktivnost) {
        this.datumAktivnost = datumAktivnost;
    }

    public String getNazivAktivnost() {
        return nazivAktivnost;
    }

    public void setNazivAktivnost(String nazivAktivnost) {
        this.nazivAktivnost = nazivAktivnost;
    }

    public String getOpisAktivnost() {
        return opisAktivnost;
    }

    public void setOpisAktivnost(String opisAktivnost) {
        this.opisAktivnost = opisAktivnost;
    }

    public Integer getBrZahvataNadzor() {
        return brZahvataNadzor;
    }

    public void setBrZahvataNadzor(Integer brZahvataNadzor) {
        this.brZahvataNadzor = brZahvataNadzor;
    }

    public Integer getBrZahvataSamostalno() {
        return brZahvataSamostalno;
    }

    public void setBrZahvataSamostalno(Integer brZahvataSamostalno) {
        this.brZahvataSamostalno = brZahvataSamostalno;
    }

    public Byte getPotpisMentora() {
        return potpisMentora;
    }

    public void setPotpisMentora(Byte potpisMentora) {
        this.potpisMentora = potpisMentora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DnevnaAktivnost that = (DnevnaAktivnost) o;

        if (idAktivnost != that.idAktivnost) return false;
        if (specijalizacija != that.specijalizacija) return false;
        if (datumAktivnost != null ? !datumAktivnost.equals(that.datumAktivnost) : that.datumAktivnost != null)
            return false;
        if (nazivAktivnost != null ? !nazivAktivnost.equals(that.nazivAktivnost) : that.nazivAktivnost != null)
            return false;
        if (opisAktivnost != null ? !opisAktivnost.equals(that.opisAktivnost) : that.opisAktivnost != null)
            return false;
        if (brZahvataNadzor != null ? !brZahvataNadzor.equals(that.brZahvataNadzor) : that.brZahvataNadzor != null)
            return false;
        if (brZahvataSamostalno != null ? !brZahvataSamostalno.equals(that.brZahvataSamostalno) : that.brZahvataSamostalno != null)
            return false;
        if (potpisMentora != null ? !potpisMentora.equals(that.potpisMentora) : that.potpisMentora != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAktivnost;
        result = 31 * result + specijalizacija;
        result = 31 * result + (datumAktivnost != null ? datumAktivnost.hashCode() : 0);
        result = 31 * result + (nazivAktivnost != null ? nazivAktivnost.hashCode() : 0);
        result = 31 * result + (opisAktivnost != null ? opisAktivnost.hashCode() : 0);
        result = 31 * result + (brZahvataNadzor != null ? brZahvataNadzor.hashCode() : 0);
        result = 31 * result + (brZahvataSamostalno != null ? brZahvataSamostalno.hashCode() : 0);
        result = 31 * result + (potpisMentora != null ? potpisMentora.hashCode() : 0);
        return result;
    }
}
