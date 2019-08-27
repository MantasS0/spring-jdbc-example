package lt.bit.java2.springjdbc.Controllers;


import lt.bit.java2.springjdbc.entities.SortStudentai;
import lt.bit.java2.springjdbc.entities.Studentas;
import lt.bit.java2.springjdbc.services.StudentasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/studentai")
public class StudentasController {


    private final StudentasService studentasService;

    public StudentasController(StudentasService studentasService){
        this.studentasService = studentasService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studentas> getStudentas(@PathVariable int id){
        Studentas studentas = studentasService.getStudentasById(id);
        if (studentas == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentas);
    }

    @GetMapping
    public ResponseEntity<List<Studentas>> getAllStudentai(){
        List<Studentas> studentai = studentasService.getAllStudentas();
        if (studentai == null || studentai.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        studentai.sort(new SortStudentai());

        return ResponseEntity.ok(studentai);
//        return studentai.isPresent() ? ResponseEntity.ok(studentai.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Double> getAllStudentAverageGrade(){
        List<Studentas> studentai = studentasService.getAllStudentas();
        if (studentai == null || studentai.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        ArrayList<Integer> grades = new ArrayList<>();
        studentai.forEach(studentas ->
                studentas.getPazymiai().forEach(pazymys ->
                        grades.add(pazymys.getPazymys())));

        Integer sum = 0;
        for (Integer grade : grades) {
            sum +=grade;
        }

        //bad code. need to correct.
        Double average;

        return null;
    }

}
