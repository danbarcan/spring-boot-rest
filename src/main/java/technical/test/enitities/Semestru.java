package technical.test.enitities;

import javax.persistence.*;

@Entity
@Table(name = "Semestre")
public class Semestru {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int semestru;
}
