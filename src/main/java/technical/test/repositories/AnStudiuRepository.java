package technical.test.repositories;

import org.springframework.data.repository.CrudRepository;
import technical.test.enitities.AnStudiu;

import java.util.Set;

public interface AnStudiuRepository extends CrudRepository<AnStudiu, String> {
    Set<AnStudiu> findAll();
}
