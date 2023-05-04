package br.com.api.doacoes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.api.doacoes.model.ProdutoModel;


public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long> {
    // Listar todos os produtos
    List<ProdutoModel> findAll();

    // Pesquisar por ID
    ProdutoModel findByCodigo(long id);

     // Listar todos os produtos por nome
     List<ProdutoModel> findByOrderByNome(); //Por Defaul é findByOrderByNomeAsc()

    // Listar todos os produtos por nome
    List<ProdutoModel> findByOrderByNomeDesc();

    // Listar todos os produtos por nome
    List<ProdutoModel> findByTipoOrderByCodigo(String tipo);

    //Listar produtos por letras ou parte do nome
    List<ProdutoModel> findByNomeContaining(String nome);

    //Pesquisar produtos pela Inicial
    List<ProdutoModel> findByNomeStartsWith(String nome);

    //Pesquisar produtos pelo Final
    List<ProdutoModel> findByNomeEndsWith(String nome);

    // Remover produto
    void delete(ProdutoModel produto);

    // Cadastrar/ Alterar Produtos
    <ProdMod extends ProdutoModel> ProdMod save(ProdMod produto);

    //Soma das quantidades
    @Query(value = "SELECT SUM(quantidade) from produtos", nativeQuery = true)
    int somaQuantidades();

    //Estoque de segurança
    @Query(value = "SELECT * FROM produtos WHERE quantidade <= :quantidade", nativeQuery = true)
    List<ProdutoModel> estoqueDeSeguranca(int quantidade);

    //Verificar se registro existe, pelo código
    int countByCodigo(long codigo);
}

