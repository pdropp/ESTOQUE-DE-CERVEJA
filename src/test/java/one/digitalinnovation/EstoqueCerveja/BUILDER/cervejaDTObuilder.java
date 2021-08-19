package one.digitalinnovation.EstoqueCerveja.BUILDER;

import lombok.Builder;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.ENUMS.CervejaType;

@Builder
public class cervejaDTObuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Brahma";

    @Builder.Default
    private String marca = "AMBEV";

    @Builder.Default
    private Integer Numeromax = 10;

    @Builder.Default
    private Integer quantidade = 50;

    @Builder.Default
    private CervejaType type = CervejaType.LAGER;

    public CervejaDTO tocervejaDTO(){
        return new CervejaDTO(
                id,
                name,
                marca,
                Numeromax,
                quantidade,
                type);
    }


}
