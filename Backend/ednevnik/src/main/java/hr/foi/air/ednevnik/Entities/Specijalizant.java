package hr.foi.air.ednevnik.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "specijalizant")
public class Specijalizant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_specijalizant")
    private Integer id_specijalizant;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "email")
    private String email;

    @Column(name = "lozinka")
    private String lozinka;

    @Column(name = "slika")
    private String slika;

    public Specijalizant(String ime, String prezime, String email, String lozinka, String slika){
        this.ime=ime;
        this.prezime=prezime;
        this.email=email;
        this.lozinka=lozinka;
        this.slika=slika;
    }
}
