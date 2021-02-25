package RestApiLesson.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        return args -> {
            Student billy = new Student(
                    1L,
                "Billy", "GMAIL.COM", LocalDate.of(1991,06,27),29
//
            );

            Student marium = new Student(
                    1L,
                    "marium", "GMAIL.COM", LocalDate.of(1991,06,27),29
//
            );
            repository.saveAll(
                    List.of(billy,marium));

        };
    }
}
