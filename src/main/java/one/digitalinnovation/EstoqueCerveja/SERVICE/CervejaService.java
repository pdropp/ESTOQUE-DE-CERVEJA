package one.digitalinnovation.EstoqueCerveja.SERVICE;

import lombok.AllArgsConstructor;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.ENTITY.Cerveja;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaAlreadyRegisteredException;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaNotFoundException;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaStockExceededException;
import one.digitalinnovation.EstoqueCerveja.MAPPER.CervejaMapper;
import one.digitalinnovation.EstoqueCerveja.REPOSITORY.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaService {

    private final CervejaRepository cervejaRepository;
    private final CervejaMapper cervejaMapper = CervejaMapper.INSTANCE;


    //Procurar por nome da cerveja
    public CervejaDTO findByName(String nome) throws CervejaNotFoundException {
        Cerveja cervejaEncontrada = cervejaRepository.findByName(nome)
                .orElseThrow(() -> new CervejaNotFoundException(nome));
        return CervejaMapper.INSTANCE.toDTO(cervejaEncontrada);
    }

    //Verifica se produto já está registrado
    private void verificarSeJaEstaRegistrado(String name) throws CervejaAlreadyRegisteredException{
        Optional<Cerveja> optCervejaSalva = cervejaRepository.findByName(name);
        if(optCervejaSalva.isPresent()){
            throw new CervejaAlreadyRegisteredException(name);
        }
    }
    //Cria uma nova cerveja
    public  CervejaDTO criarCerveja(CervejaDTO cervejaDTO) throws CervejaAlreadyRegisteredException {
        verificarSeJaEstaRegistrado(cervejaDTO.getNome());
        Cerveja cerveja = cervejaMapper.INSTANCE.toModel(cervejaDTO);
        Cerveja cervejaSalva = cervejaRepository.save(cerveja);
        return cervejaMapper.toDTO(cervejaSalva);


    }

    //Deletar uma cerveja
    public void deleteById(Long id) throws CervejaNotFoundException{
        verificarSeIdExiste(id);
        cervejaRepository.deleteById(id);
    }
    //Verificar se a cerveja já existe
    private Cerveja verificarSeIdExiste(Long id) throws CervejaNotFoundException{
        return cervejaRepository.findById(id)
                .orElseThrow(() -> new CervejaNotFoundException(id));
    }


    //Listar todas as ceverjas
    public List<CervejaDTO> listAll(){
        return cervejaRepository.findAll()
                .stream()
                .map(cervejaMapper::toDTO)
                .collect(Collectors.toList());
    }

    //Incrementar cervejas
    public CervejaDTO incremento(Long id, int quantidadeIncremento) throws CervejaNotFoundException, CervejaStockExceededException{
        Cerveja cervejaIncrementoNoEstoque = verificarSeIdExiste(id);
        int quantidadeAposIncremento = quantidadeIncremento + cervejaIncrementoNoEstoque.getQuantidade();
        if(quantidadeAposIncremento <= cervejaIncrementoNoEstoque.getNumeromax()){
            cervejaIncrementoNoEstoque.setQuantidade(cervejaIncrementoNoEstoque.getQuantidade() + quantidadeAposIncremento);
            Cerveja incrementoNoEstoqueDeCerveja = cervejaRepository.save(cervejaIncrementoNoEstoque);
            return cervejaMapper.toDTO(incrementoNoEstoqueDeCerveja);
        }
        throw  new CervejaStockExceededException(id, quantidadeIncremento);
    }
}
