package technical.test.repositories;

import org.springframework.data.repository.CrudRepository;
import technical.test.enitities.Student;

import java.util.Set;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByNumarMatricol(String numarMatricol);

    Set<Student> findAll();

    Set<Student> findAllBySpecializareAndAnInmatriculare();
}
