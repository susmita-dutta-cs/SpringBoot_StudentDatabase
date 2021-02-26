package RestApiLesson.student;

// all of the resources of api

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();

    }
    // add new resources to your system that time postmapping is used
    //putmapping - update
    // a loop postmapping will create new objects
    // aloop putmapping with update that existing objectlic void

    @PostMapping
    public void registerNewStudent (@RequestBody Student student){
        studentService.addnewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId) {
        studentService.deleteStudent(studentId);
    }

//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") long studentId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email) {
//        studentService.updateStudent(studentId, name, email);

//    }
    //)


}

