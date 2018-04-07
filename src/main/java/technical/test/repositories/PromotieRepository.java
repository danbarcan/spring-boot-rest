package technical.test.repositories;

import org.springframework.data.repository.CrudRepository;
import technical.test.enitities.Promotie;
import technical.test.enitities.Student;

import java.util.Set;

public interface PromotieRepository extends CrudRepository<Promotie, String> {
    Set<Promotie> findAll();
}
