package technical.test.enitities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Studenti")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nume;

    private String numeDupaCasatorie;

    private String initialaTatalui;

    private String prenume;

    private Date dataNasterii;

    private String localitateaNasterii;

    private String judetulNasterii;

    private String numarMatricol;

    private String CNP;

    private int anInmatriculare;

    private String statutProfesional;

    @MapsId @ManyToOne
    @JoinColumn(name = "specializare_id")
    private Specializare specializare;
}
