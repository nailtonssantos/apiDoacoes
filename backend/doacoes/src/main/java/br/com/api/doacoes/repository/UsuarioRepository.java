package br.com.api.doacoes.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.api.doacoes.model.UsuarioModel;


public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    //Listar todos os usuários
    List<UsuarioModel> findAll();

    //Pesquisar Usuário por ID
    UsuarioModel findByCodigo(long id);

    //Pesquisar Usuário por CPF
    UsuarioModel findByCpf(long cpf);

    //Pesquisar pelo tipo de usuário
    UsuarioModel findByOrderByTipo(String tipo);

    //Listar usuários por letras ou parte do nome
    List<UsuarioModel> findByNomeContaining(String nome);


    
}
