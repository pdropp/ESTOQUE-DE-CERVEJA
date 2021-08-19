package one.digitalinnovation.EstoqueCerveja.CONTROLLER;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.ENTITY.Cerveja;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaAlreadyRegisteredException;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Gerenciador de estoque de cervejas")
public interface CervejaControllerDocs {


    @ApiOperation(value = "Operação de criação de cerveja")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação de cerveja"),
            @ApiResponse(code = 400, message = "Campos obrigatórios ausentes ou valor de intervalo de campo incorreto")
    })
    CervejaDTO criarCerveja(CervejaDTO cervejaDTO) throws CervejaAlreadyRegisteredException;

    @ApiOperation(value = "Retorna cerveja encontrada por um determinado nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cerveja encontrada com sucesso no sistema")
            @ApiResponse(code = 404, message = "Cerveja com o nome fornecido não encontrada.")

    })

    CervejaDTO findByName(@PathVariable String name) throws CervejaNotFoundException;

    @ApiOperation(value = "Retorna a lista de todas as cervejas registrada no sistema"),
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de todas as cervejas registrada no sistema")
    })

    List<CervejaDTO> listaCervejas();

    @ApiOperation(value = "Exclua uma cerveja encontrada por um determinado ID válido")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso em deletar uma cerveja do sistema"),
            @ApiResponse(code = 204, = "Cerveja com a identificação fornecida não encontrada.")
    })

    void deleteById(@PathVariable Long id) throws CervejaNotFoundException;

}
