package lt.bit.java2.springjdbc;

import lt.bit.java2.springjdbc.entities.Pazymys;
import lt.bit.java2.springjdbc.entities.Studentas;
import lt.bit.java2.springjdbc.services.StudentasService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringJdbcApplication {
    private static List<Studentas> studentai;
	private static StudentasService studentasService;

    public SpringJdbcApplication(StudentasService studentasService) {
        SpringJdbcApplication.studentasService = studentasService;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);

//        List<Studentas> s1 = studentasService.getStudentasById(1);
        uzkrautiDuomenis(studentasService);
		SpringJdbcApplication.studentai.forEach(System.out::println);
    }

    public static void uzkrautiDuomenis(StudentasService studentasService) {

        SpringJdbcApplication.studentai = studentasService.uzkrautiVisusStudentus();

        SpringJdbcApplication.studentai = SpringJdbcApplication.studentai.stream()
                .collect(Collectors.groupingBy(Studentas::getId)).values().stream()
        .map(list -> {
            List<Pazymys> pazymiai = list.stream()
                    .filter(it -> it.getPazymiai() != null)
                    .flatMap(stud -> stud.getPazymiai().stream())
                    .collect(Collectors.toList());
            list.get(0).setPazymiai(pazymiai);
            return list.get(0);
        })
        .collect(Collectors.toList());

    }

    public static List<Studentas> getStudentai() {
        return studentai;
    }

    public static void setStudentai(List<Studentas> studentai) {
        SpringJdbcApplication.studentai = studentai;
    }
}
