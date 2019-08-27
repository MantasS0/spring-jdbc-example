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

    public Studentas getStudentasById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM studentai WHERE id = ?", studentasRowMapper, id);
    }

    public List<Studentas> getAllStudentas(){
        return jdbcTemplate.query("SELECT * FROM studentai", studentasRowMapper);
    }
}
