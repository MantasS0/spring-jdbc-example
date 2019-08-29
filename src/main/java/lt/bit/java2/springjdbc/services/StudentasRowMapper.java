package lt.bit.java2.springjdbc.services;

import lt.bit.java2.springjdbc.entities.Pazymys;
import lt.bit.java2.springjdbc.entities.Studentas;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentasRowMapper implements RowMapper<Studentas> {

//    @Autowired
//    PazymysService pazymysService;

    @Override
    public Studentas mapRow(ResultSet rs, int rowNum) throws SQLException {

        Studentas studentas = new Studentas();
        studentas.setId(rs.getInt("id"));
        studentas.setVardas(rs.getString("vardas"));
        studentas.setPavarde(rs.getString("pavarde"));
        studentas.setElPastas(rs.getString("el_pastas"));
        if (rs.getInt("p_id") == 0){
            return studentas;
        }
        Pazymys pazymys = new Pazymys();
        pazymys.setId(rs.getInt("p_id"));
        pazymys.setStudentasId(rs.getInt("studentas_id"));
        pazymys.setData(rs.getDate("data").toLocalDate());
        pazymys.setPazymys(rs.getInt("pazymys"));

        List<Pazymys> pazymiai = new ArrayList<>();
        pazymiai.add(pazymys);
        studentas.setPazymiai(pazymiai);

        return studentas;
    }
}
