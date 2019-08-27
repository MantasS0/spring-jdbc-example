package lt.bit.java2.springjdbc.services;

import lt.bit.java2.springjdbc.entities.Studentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class StudentasRowMapper implements RowMapper<Studentas> {

    @Autowired
    PazymysService pazymysService;

    @Override
    public Studentas mapRow(ResultSet rs, int rowNum) throws SQLException {

        Studentas studentas = new Studentas();
        studentas.setId(rs.getInt("id"));
        studentas.setVardas(rs.getString("vardas"));
        studentas.setPavarde(rs.getString("pavarde"));
        studentas.setElPastas(rs.getString("el_pastas"));
        studentas.setPazymiai(pazymysService.getGradesByStudentId(rs.getInt("id")));

        return studentas;
    }
}
