package one.digitalinnovation.EstoqueCerveja.ENUMS;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CervejaType {

    LAGER("Lager"),
    MALZBIER("Malzbier"),
    WEISS("Weiss"),
    ALE("Ale"),
    IPA("IPA"),
    STOUT("stout");

    private final String descricao;




}
