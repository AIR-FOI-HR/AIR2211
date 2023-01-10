package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
@Table(name = "dio_specijalizacije", schema = "dbo", catalog = "AIR2211_DB")
public class DioSpecijalizacije {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dio_specjalizacije", nullable = false)
    private int idDioSpecjalizacije;
    @Basic
    @Column(name = "program_specijalizacije", nullable = false)
    private int programSpecijalizacije;
    @Basic
    @Column(name = "ustrojstvena_jedinica", nullable = false)
    private int ustrojstvenaJedinica;

    public int getIdDioSpecjalizacije() {
        return idDioSpecjalizacije;
    }

    public void setIdDioSpecjalizacije(int idDioSpecjalizacije) {
        this.idDioSpecjalizacije = idDioSpecjalizacije;
    }

    public int getProgramSpecijalizacije() {
        return programSpecijalizacije;
    }

    public void setProgramSpecijalizacije(int programSpecijalizacije) {
        this.programSpecijalizacije = programSpecijalizacije;
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

        DioSpecijalizacije that = (DioSpecijalizacije) o;

        if (idDioSpecjalizacije != that.idDioSpecjalizacije) return false;
        if (programSpecijalizacije != that.programSpecijalizacije) return false;
        if (ustrojstvenaJedinica != that.ustrojstvenaJedinica) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDioSpecjalizacije;
        result = 31 * result + programSpecijalizacije;
        result = 31 * result + ustrojstvenaJedinica;
        return result;
    }
}
