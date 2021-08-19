package one.digitalinnovation.EstoqueCerveja.EXCEPTION;

public class CervejaNotFoundException extends Exception {


    public CervejaNotFoundException(String cervejaName){
        super(String.format("Cerveja com o nome% s não encontrada no sistema.", cervejaName));
    }

    public CervejaNotFoundException(Long id){
        super(String.format("Cerveja com id% s não encontrada no sistema. ", id));
    }


}
