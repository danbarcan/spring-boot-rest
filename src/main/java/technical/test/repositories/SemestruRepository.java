package technical.test.repositories;

import org.springframework.data.repository.CrudRepository;
import technical.test.enitities.Semestru;
import technical.test.enitities.Student;

import java.util.Set;

public interface SemestruRepository extends CrudRepository<Semestru, String> {
    Set<Semestru> findAll();
}
