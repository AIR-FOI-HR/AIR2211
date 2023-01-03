package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "odradeni_dio_specijalizacije", schema = "dbo", catalog = "AIR2211_DB")
@IdClass(OdradeniDioSpecijalizacijePK.class)
public class OdradeniDioSpecijalizacije {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "specijalizacija", nullable = false)
    private int specijalizacija;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dio_specijalizacije", nullable = false)
    private int dioSpecijalizacije;
    @Basic
    @Column(name = "mentor", nullable = false)
    private int mentor;
    @Basic
    @Column(name = "mentor_potpis", nullable = true)
    private Byte mentorPotpis;
    @Basic
    @Column(name = "glavni_mentor_potpis", nullable = true)
    private Byte glavniMentorPotpis;
    @Basic
    @Column(name = "traje_od", nullable = false)
    private Date trajeOd;
    @Basic
    @Column(name = "traje_do", nullable = true)
    private Date trajeDo;

    public int getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(int specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getDioSpecijalizacije() {
        return dioSpecijalizacije;
    }

    public void setDioSpecijalizacije(int dioSpecijalizacije) {
        this.dioSpecijalizacije = dioSpecijalizacije;
    }

    public int getMentor() {
        return mentor;
    }

    public void setMentor(int mentor) {
        this.mentor = mentor;
    }

    public Byte getMentorPotpis() {
        return mentorPotpis;
    }

    public void setMentorPotpis(Byte mentorPotpis) {
        this.mentorPotpis = mentorPotpis;
    }

    public Byte getGlavniMentorPotpis() {
        return glavniMentorPotpis;
    }

    public void setGlavniMentorPotpis(Byte glavniMentorPotpis) {
        this.glavniMentorPotpis = glavniMentorPotpis;
    }

    public Date getTrajeOd() {
        return trajeOd;
    }

    public void setTrajeOd(Date trajeOd) {
        this.trajeOd = trajeOd;
    }

    public Date getTrajeDo() {
        return trajeDo;
    }

    public void setTrajeDo(Date trajeDo) {
        this.trajeDo = trajeDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdradeniDioSpecijalizacije that = (OdradeniDioSpecijalizacije) o;

        if (specijalizacija != that.specijalizacija) return false;
        if (dioSpecijalizacije != that.dioSpecijalizacije) return false;
        if (mentor != that.mentor) return false;
        if (mentorPotpis != null ? !mentorPotpis.equals(that.mentorPotpis) : that.mentorPotpis != null) return false;
        if (glavniMentorPotpis != null ? !glavniMentorPotpis.equals(that.glavniMentorPotpis) : that.glavniMentorPotpis != null)
            return false;
        if (trajeOd != null ? !trajeOd.equals(that.trajeOd) : that.trajeOd != null) return false;
        if (trajeDo != null ? !trajeDo.equals(that.trajeDo) : that.trajeDo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specijalizacija;
        result = 31 * result + dioSpecijalizacije;
        result = 31 * result + mentor;
        result = 31 * result + (mentorPotpis != null ? mentorPotpis.hashCode() : 0);
        result = 31 * result + (glavniMentorPotpis != null ? glavniMentorPotpis.hashCode() : 0);
        result = 31 * result + (trajeOd != null ? trajeOd.hashCode() : 0);
        result = 31 * result + (trajeDo != null ? trajeDo.hashCode() : 0);
        return result;
    }
}
