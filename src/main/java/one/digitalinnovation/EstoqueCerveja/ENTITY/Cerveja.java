package one.digitalinnovation.EstoqueCerveja.ENTITY;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.EstoqueCerveja.ENUMS.CervejaType;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String marca;

    @Column (nullable = false)
    private int Numeromax;

    @Column(nullable = false)
    private int quantidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CervejaType type;



}
