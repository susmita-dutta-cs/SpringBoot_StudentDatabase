package RestApiLesson.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Component
public class StudentService {
    private final StudentRepository studentRepository;


    @Autowired
    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//    @GetMapping
    public List<Student> getStudents() {

        return studentRepository.findAll();
//        return List.of(new Student (1L,
//                "Billy", "GMAIL.COM", LocalDate.of(1991,06,27),29
//        ));
        // static list
    }
}
