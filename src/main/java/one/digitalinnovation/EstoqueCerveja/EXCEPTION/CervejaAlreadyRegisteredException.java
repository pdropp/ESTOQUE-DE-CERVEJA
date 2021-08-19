package one.digitalinnovation.EstoqueCerveja.EXCEPTION;

public class CervejaAlreadyRegisteredException extends Exception{
    public CervejaAlreadyRegisteredException(String cervejaName){
        super(String.format("Cerveja com nome% s já cadastrada no sistema.", cervejaName));
    }
}
