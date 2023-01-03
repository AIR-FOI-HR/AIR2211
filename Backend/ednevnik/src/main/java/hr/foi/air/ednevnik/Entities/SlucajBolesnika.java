package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "slucaj_bolesnika", schema = "dbo", catalog = "AIR2211_DB")
public class SlucajBolesnika {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_slucaj", nullable = false)
    private int idSlucaj;
    @Basic
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @Basic
    @Column(name = "datum_slucaj", nullable = false)
    private Date datumSlucaj;
    @Basic
    @Column(name = "dijagnoza_slucaj", nullable = true, length = 1000)
    private String dijagnozaSlucaj;
    @Basic
    @Column(name = "opis_slucaj", nullable = true, length = 8000)
    private String opisSlucaj;
    @Basic
    @Column(name = "potpis_mentora", nullable = true)
    private Byte potpisMentora;

    public int getIdSlucaj() {
        return idSlucaj;
    }

    public void setIdSlucaj(int idSlucaj) {
        this.idSlucaj = idSlucaj;
    }

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public Date getDatumSlucaj() {
        return datumSlucaj;
    }

    public void setDatumSlucaj(Date datumSlucaj) {
        this.datumSlucaj = datumSlucaj;
    }

    public String getDijagnozaSlucaj() {
        return dijagnozaSlucaj;
    }

    public void setDijagnozaSlucaj(String dijagnozaSlucaj) {
        this.dijagnozaSlucaj = dijagnozaSlucaj;
    }

    public String getOpisSlucaj() {
        return opisSlucaj;
    }

    public void setOpisSlucaj(String opisSlucaj) {
        this.opisSlucaj = opisSlucaj;
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

        SlucajBolesnika that = (SlucajBolesnika) o;

        if (idSlucaj != that.idSlucaj) return false;
        if (specijalizacija != that.specijalizacija) return false;
        if (datumSlucaj != null ? !datumSlucaj.equals(that.datumSlucaj) : that.datumSlucaj != null) return false;
        if (dijagnozaSlucaj != null ? !dijagnozaSlucaj.equals(that.dijagnozaSlucaj) : that.dijagnozaSlucaj != null)
            return false;
        if (opisSlucaj != null ? !opisSlucaj.equals(that.opisSlucaj) : that.opisSlucaj != null) return false;
        if (potpisMentora != null ? !potpisMentora.equals(that.potpisMentora) : that.potpisMentora != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSlucaj;
        result = 31 * result + specijalizacija;
        result = 31 * result + (datumSlucaj != null ? datumSlucaj.hashCode() : 0);
        result = 31 * result + (dijagnozaSlucaj != null ? dijagnozaSlucaj.hashCode() : 0);
        result = 31 * result + (opisSlucaj != null ? opisSlucaj.hashCode() : 0);
        result = 31 * result + (potpisMentora != null ? potpisMentora.hashCode() : 0);
        return result;
    }
}
