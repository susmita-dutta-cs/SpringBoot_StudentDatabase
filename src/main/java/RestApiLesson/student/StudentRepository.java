package RestApiLesson.student;
//
// responsible for data access layer
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{

    // write business logic

     @Query ("SELECT_s FROM Student s WHERE s.email=?1")
     Optional<Student> findStudentByEmail(String email);

}
