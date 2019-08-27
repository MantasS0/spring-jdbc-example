package lt.bit.java2.springjdbc.services;

import lt.bit.java2.springjdbc.entities.Pazymys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PazymysService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PazymysRowMapper pazymysRowMapper;

    public List<Pazymys> getGradesByStudentId(int studentId){
        List<Pazymys> pazymiai = jdbcTemplate.query("SELECT * FROM pazymiai WHERE studentas_id = ?", pazymysRowMapper, studentId);

        return pazymiai;
    }

}
