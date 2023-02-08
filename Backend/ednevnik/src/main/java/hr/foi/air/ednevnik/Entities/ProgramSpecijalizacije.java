package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
@Table(name = "program_specijalizacije", schema = "dbo", catalog = "AIR2211_DB")
public class ProgramSpecijalizacije {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_program_specijalizacije", nullable = false)
    private int idProgramSpecijalizacije;
    @Basic
    @Column(name = "naziv_program_specijalizacije", nullable = false, length = 255)
    private String nazivProgramSpecijalizacije;

    public int getIdProgramSpecijalizacije() {
        return idProgramSpecijalizacije;
    }

    public void setIdProgramSpecijalizacije(int idProgramSpecijalizacije) {
        this.idProgramSpecijalizacije = idProgramSpecijalizacije;
    }

    public String getNazivProgramSpecijalizacije() {
        return nazivProgramSpecijalizacije;
    }

    public void setNazivProgramSpecijalizacije(String nazivProgramSpecijalizacije) {
        this.nazivProgramSpecijalizacije = nazivProgramSpecijalizacije;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramSpecijalizacije that = (ProgramSpecijalizacije) o;

        if (idProgramSpecijalizacije != that.idProgramSpecijalizacije) return false;
        if (nazivProgramSpecijalizacije != null ? !nazivProgramSpecijalizacije.equals(that.nazivProgramSpecijalizacije) : that.nazivProgramSpecijalizacije != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgramSpecijalizacije;
        result = 31 * result + (nazivProgramSpecijalizacije != null ? nazivProgramSpecijalizacije.hashCode() : 0);
        return result;
    }
}
