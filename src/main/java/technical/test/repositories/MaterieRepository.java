package technical.test.repositories;

import org.springframework.data.repository.CrudRepository;
import technical.test.enitities.Materie;
import technical.test.enitities.Student;

import java.util.Set;

public interface MaterieRepository extends CrudRepository<Materie, String> {
    Set<Materie> findAll();

    Set<Materie> findAllBySpecializare();
}
