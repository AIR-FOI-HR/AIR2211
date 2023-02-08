package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Specijalizacija {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_specijalizacija", nullable = false)
    private int idSpecijalizacija;
    @Basic
    @Column(name = "specijalizant", nullable = false)
    private int specijalizant;
    @Basic
    @Column(name = "program_specijalizacije", nullable = false)
    private int programSpecijalizacije;
    @Basic
    @Column(name = "glavni_mentor", nullable = false)
    private int glavniMentor;
    @Basic
    @Column(name = "odobrena_za", nullable = false, length = 255)
    private String odobrenaZa;
    @Basic
    @Column(name = "datum_pocetka", nullable = false)
    private Date datumPocetka;
    @Basic
    @Column(name = "datum_zavrsetka", nullable = true)
    private Date datumZavrsetka;
    @Basic
    @Column(name = "potpis_mentora", nullable = true)
    private Byte potpisMentora;
    @Basic
    @Column(name = "zavrsno_misljenje", nullable = true, length = 8000)
    private String zavrsnoMisljenje;

    public int getIdSpecijalizacija() {
        return idSpecijalizacija;
    }

    public void setIdSpecijalizacija(int idSpecijalizacija) {
        this.idSpecijalizacija = idSpecijalizacija;
    }

    public int getSpecijalizant() {
        return specijalizant;
    }

    public void setSpecijalizant(int specijalizant) {
        this.specijalizant = specijalizant;
    }

    public int getProgramSpecijalizacije() {
        return programSpecijalizacije;
    }

    public void setProgramSpecijalizacije(int programSpecijalizacije) {
        this.programSpecijalizacije = programSpecijalizacije;
    }

    public int getGlavniMentor() {
        return glavniMentor;
    }

    public void setGlavniMentor(int glavniMentor) {
        this.glavniMentor = glavniMentor;
    }

    public String getOdobrenaZa() {
        return odobrenaZa;
    }

    public void setOdobrenaZa(String odobrenaZa) {
        this.odobrenaZa = odobrenaZa;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Byte getPotpisMentora() {
        return potpisMentora;
    }

    public void setPotpisMentora(Byte potpisMentora) {
        this.potpisMentora = potpisMentora;
    }

    public String getZavrsnoMisljenje() {
        return zavrsnoMisljenje;
    }

    public void setZavrsnoMisljenje(String zavrsnoMisljenje) {
        this.zavrsnoMisljenje = zavrsnoMisljenje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specijalizacija that = (Specijalizacija) o;

        if (idSpecijalizacija != that.idSpecijalizacija) return false;
        if (specijalizant != that.specijalizant) return false;
        if (programSpecijalizacije != that.programSpecijalizacije) return false;
        if (glavniMentor != that.glavniMentor) return false;
        if (odobrenaZa != null ? !odobrenaZa.equals(that.odobrenaZa) : that.odobrenaZa != null) return false;
        if (datumPocetka != null ? !datumPocetka.equals(that.datumPocetka) : that.datumPocetka != null) return false;
        if (datumZavrsetka != null ? !datumZavrsetka.equals(that.datumZavrsetka) : that.datumZavrsetka != null)
            return false;
        if (potpisMentora != null ? !potpisMentora.equals(that.potpisMentora) : that.potpisMentora != null)
            return false;
        if (zavrsnoMisljenje != null ? !zavrsnoMisljenje.equals(that.zavrsnoMisljenje) : that.zavrsnoMisljenje != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpecijalizacija;
        result = 31 * result + specijalizant;
        result = 31 * result + programSpecijalizacije;
        result = 31 * result + glavniMentor;
        result = 31 * result + (odobrenaZa != null ? odobrenaZa.hashCode() : 0);
        result = 31 * result + (datumPocetka != null ? datumPocetka.hashCode() : 0);
        result = 31 * result + (datumZavrsetka != null ? datumZavrsetka.hashCode() : 0);
        result = 31 * result + (potpisMentora != null ? potpisMentora.hashCode() : 0);
        result = 31 * result + (zavrsnoMisljenje != null ? zavrsnoMisljenje.hashCode() : 0);
        return result;
    }
}
