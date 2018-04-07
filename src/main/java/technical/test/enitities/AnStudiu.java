package technical.test.enitities;

import javax.persistence.*;

@Entity
@Table(name = "ani_studiu")
public class AnStudiu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int an;
}
