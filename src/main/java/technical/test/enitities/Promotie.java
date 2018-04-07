package technical.test.enitities;

import javax.persistence.*;

@Entity
@Table(name = "Promotii")
public class Promotie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int anTerminare;
}
