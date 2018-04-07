package technical.test.enitities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Specializare")
public class Specializare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String denumireSpecializare;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Materie> materii;
}
