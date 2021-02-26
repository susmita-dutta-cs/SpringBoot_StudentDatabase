package RestApiLesson.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public void addnewStudent (Student student) {
        // search in the database by email
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        System.out.println(student);
        if (studentOptional.isPresent()){
            throw new IllegalStateException("eMAIL TAKEN");
        }
        studentRepository.save(student);


    }

    public void deleteStudent(long studentId){;
        boolean exists= studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "STUDENT WITH ID" + studentId + "does not exists");

        }
        studentRepository.deleteById(studentId);
        }
//    @Transactional
//    public void updateStudent( long studentId,
//                               String name,String email) {
//        Student student= studentRepository.findById(studentId)
//                .orElseThrow(() ->new IllegalStateException(
//                        "student with id " + studentId +"does not exist"
//                ));
//        if (name!= null && name.length() > 0 && !Object.equals(Student.getName(), name)) {
//            student.setName(name);
 //       }


    }

 // log in to see whether we can request to server - post mapping