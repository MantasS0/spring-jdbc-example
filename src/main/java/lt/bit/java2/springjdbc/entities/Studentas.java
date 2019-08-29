package lt.bit.java2.springjdbc.entities;

import java.util.List;

public class Studentas {

    private Integer id;
    private String vardas;
    private String pavarde;
    private String elPastas;
    private List<Pazymys> pazymiai;


    public Studentas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public List<Pazymys> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(List<Pazymys> pazymiai) {
        this.pazymiai = pazymiai;
    }

    @Override
    public boolean equals(Object obj) {
        Studentas s1 = (Studentas) obj;
        return this.id == s1.getId();
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", elPastas='" + elPastas + '\'' +
                ", pazymiai=" + pazymiai +
                '}';
    }
}
