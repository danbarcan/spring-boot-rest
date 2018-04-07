package technical.test.enitities;

import javax.persistence.*;

@Entity
@Table(name = "Materii")
public class Materie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String denumireMaterie;

    @MapsId @ManyToOne
    @JoinColumn(name = "specializare_id")
    private Specializare specializare;

    @MapsId @ManyToOne
    @JoinColumn(name = "an_studiu_id")
    private AnStudiu anStudiu;

    @MapsId @ManyToOne
    @JoinColumn(name = "semestru_id")
    private Semestru semestru;

    private int numarCredite;

    private int oreCurs;

    private int oreSeminar;

    private int oreLP;

    private boolean optional;
}
