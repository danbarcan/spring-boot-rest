package technical.test.repositories;

import org.springframework.data.repository.CrudRepository;
import technical.test.enitities.Specializare;
import technical.test.enitities.Student;

import java.util.Set;

public interface SpecializareRepository extends CrudRepository<Specializare, String> {
    Set<Specializare> findAll();
}
