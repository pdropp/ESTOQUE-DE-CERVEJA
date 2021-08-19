package one.digitalinnovation.EstoqueCerveja.EXCEPTION;

public class CervejaStockExceededException extends Exception{
    public CervejaStockExceededException(Long id, int quantidadeIncremento){
        super(String.format("Cervejas com% s ID para incremento informado excede a capacidade máxima de estoque: %s", id, quantidadeIncremento));
    }
}
