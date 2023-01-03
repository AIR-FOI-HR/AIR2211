package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "provjera_znanja", schema = "dbo", catalog = "AIR2211_DB")
public class ProvjeraZnanja {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_provjera", nullable = false)
    private int idProvjera;
    @Basic
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @Basic
    @Column(name = "datum_provjera", nullable = false)
    private Date datumProvjera;
    @Basic
    @Column(name = "ocjena_provjera", nullable = true)
    private Integer ocjenaProvjera;
    @Basic
    @Column(name = "potpis_mentora", nullable = true)
    private Byte potpisMentora;

    public int getIdProvjera() {
        return idProvjera;
    }

    public void setIdProvjera(int idProvjera) {
        this.idProvjera = idProvjera;
    }

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public Date getDatumProvjera() {
        return datumProvjera;
    }

    public void setDatumProvjera(Date datumProvjera) {
        this.datumProvjera = datumProvjera;
    }

    public Integer getOcjenaProvjera() {
        return ocjenaProvjera;
    }

    public void setOcjenaProvjera(Integer ocjenaProvjera) {
        this.ocjenaProvjera = ocjenaProvjera;
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

        ProvjeraZnanja that = (ProvjeraZnanja) o;

        if (idProvjera != that.idProvjera) return false;
        if (specijalizacija != that.specijalizacija) return false;
        if (datumProvjera != null ? !datumProvjera.equals(that.datumProvjera) : that.datumProvjera != null)
            return false;
        if (ocjenaProvjera != null ? !ocjenaProvjera.equals(that.ocjenaProvjera) : that.ocjenaProvjera != null)
            return false;
        if (potpisMentora != null ? !potpisMentora.equals(that.potpisMentora) : that.potpisMentora != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProvjera;
        result = 31 * result + specijalizacija;
        result = 31 * result + (datumProvjera != null ? datumProvjera.hashCode() : 0);
        result = 31 * result + (ocjenaProvjera != null ? ocjenaProvjera.hashCode() : 0);
        result = 31 * result + (potpisMentora != null ? potpisMentora.hashCode() : 0);
        return result;
    }
}
