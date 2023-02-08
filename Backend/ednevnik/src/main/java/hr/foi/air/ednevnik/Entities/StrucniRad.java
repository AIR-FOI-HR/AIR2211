package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
@Table(name = "strucni_rad", schema = "dbo", catalog = "AIR2211_DB")
public class StrucniRad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_rad", nullable = false)
    private int idRad;
    @Basic
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @Basic
    @Column(name = "naslov_rad", nullable = false, length = 255)
    private String naslovRad;
    @Basic
    @Column(name = "objavljen_u", nullable = true, length = 255)
    private String objavljenU;

    public int getIdRad() {
        return idRad;
    }

    public void setIdRad(int idRad) {
        this.idRad = idRad;
    }

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public String getNaslovRad() {
        return naslovRad;
    }

    public void setNaslovRad(String naslovRad) {
        this.naslovRad = naslovRad;
    }

    public String getObjavljenU() {
        return objavljenU;
    }

    public void setObjavljenU(String objavljenU) {
        this.objavljenU = objavljenU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StrucniRad that = (StrucniRad) o;

        if (idRad != that.idRad) return false;
        if (specijalizacija != that.specijalizacija) return false;
        if (naslovRad != null ? !naslovRad.equals(that.naslovRad) : that.naslovRad != null) return false;
        if (objavljenU != null ? !objavljenU.equals(that.objavljenU) : that.objavljenU != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRad;
        result = 31 * result + specijalizacija;
        result = 31 * result + (naslovRad != null ? naslovRad.hashCode() : 0);
        result = 31 * result + (objavljenU != null ? objavljenU.hashCode() : 0);
        return result;
    }
}
