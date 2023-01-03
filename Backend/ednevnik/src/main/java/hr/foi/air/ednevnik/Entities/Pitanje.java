package hr.foi.air.ednevnik.Entities;

import javax.persistence.*;

@Entity
public class Pitanje {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pitanje", nullable = false)
    private int idPitanje;
    @Basic
    @Column(name = "provjera", nullable = false)
    private int provjera;
    @Basic
    @Column(name = "sadrzaj_pitanja", nullable = false, length = 1000)
    private String sadrzajPitanja;

    public int getIdPitanje() {
        return idPitanje;
    }

    public void setIdPitanje(int idPitanje) {
        this.idPitanje = idPitanje;
    }

    public int getProvjera() {
        return provjera;
    }

    public void setProvjera(int provjera) {
        this.provjera = provjera;
    }

    public String getSadrzajPitanja() {
        return sadrzajPitanja;
    }

    public void setSadrzajPitanja(String sadrzajPitanja) {
        this.sadrzajPitanja = sadrzajPitanja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pitanje pitanje = (Pitanje) o;

        if (idPitanje != pitanje.idPitanje) return false;
        if (provjera != pitanje.provjera) return false;
        if (sadrzajPitanja != null ? !sadrzajPitanja.equals(pitanje.sadrzajPitanja) : pitanje.sadrzajPitanja != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPitanje;
        result = 31 * result + provjera;
        result = 31 * result + (sadrzajPitanja != null ? sadrzajPitanja.hashCode() : 0);
        return result;
    }
}
