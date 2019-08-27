package lt.bit.java2.springjdbc.services;

import lt.bit.java2.springjdbc.entities.Pazymys;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PazymysRowMapper implements RowMapper<Pazymys> {
    @Override
    public Pazymys mapRow(ResultSet rs, int rowNum) throws SQLException {

        Pazymys pazymys = new Pazymys();
                pazymys.setId(rs.getInt("id"));
                pazymys.setStudentasId(rs.getInt("studentas_id"));
                pazymys.setData(rs.getDate("data").toLocalDate());
                pazymys.setPazymys(rs.getInt("pazymys"));

        return pazymys;
    }
}
