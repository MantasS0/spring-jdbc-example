package lt.bit.java2.springjdbc.entities;

import java.time.LocalDate;

public class Pazymys {

    private Integer id;
    private Integer studentasId;
    private LocalDate data;
    private Integer pazymys;

    public Pazymys() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentasId() {
        return studentasId;
    }

    public void setStudentasId(Integer studentasId) {
        this.studentasId = studentasId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getPazymys() {
        return pazymys;
    }

    public void setPazymys(Integer pazymys) {
        this.pazymys = pazymys;
    }

    @Override
    public String toString() {
        return "Pazymys{" +
                "id=" + id +
                ", studentasId=" + studentasId +
                ", data=" + data +
                ", pazymys=" + pazymys +
                '}';
    }
}
