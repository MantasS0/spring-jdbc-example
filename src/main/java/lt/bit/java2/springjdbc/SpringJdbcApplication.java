package lt.bit.java2.springjdbc;

import lt.bit.java2.springjdbc.entities.Studentas;
import lt.bit.java2.springjdbc.services.StudentasService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {
	private static List<Studentas> studentai;
	private final StudentasService studentasService;

	public SpringJdbcApplication(StudentasService studentasService) {
		this.studentasService = studentasService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	public static void uzkrautiDuomenis(StudentasService studentasService){
		setStudentai(studentasService.getAllStudentas());
	}

	public static List<Studentas> getStudentai() {
		return studentai;
	}

	public static void setStudentai(List<Studentas> studentai) {
		SpringJdbcApplication.studentai = studentai;
	}
}
