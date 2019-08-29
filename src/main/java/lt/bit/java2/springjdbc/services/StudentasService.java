package lt.bit.java2.springjdbc.services;


import lt.bit.java2.springjdbc.entities.Studentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentasService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentasRowMapper studentasRowMapper;

    public List<Studentas> getStudentasById(int id) {

        return jdbcTemplate.query("select studentai.id id," +
                " vardas," +
                " pavarde," +
                " el_pastas," +
                " p.id p_id," +
                " studentas_id," +
                " p.data data," +
                " pazymys" +
                " from studentai" +
                " left outer join pazymiai p on studentai.id = p.studentas_id" +
                " where studentai.id = ?" +
                " order by studentai.id",
                studentasRowMapper,
                id);
    }

    public List<Studentas> getAllStudentas() {
        return jdbcTemplate.query("SELECT * FROM studentai", studentasRowMapper);
    }

    public List<Studentas> uzkrautiVisusStudentus() {
        return jdbcTemplate.query("select studentai.id id," +
                " vardas," +
                " pavarde," +
                " el_pastas," +
                " p.id p_id," +
                " studentas_id," +
                " p.data data," +
                " pazymys" +
                " from studentai" +
                " left outer join pazymiai p on studentai.id = p.studentas_id" +
                " order by studentai.id",
                studentasRowMapper);
    }

}
