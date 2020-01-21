package br.edu.ifal.lista_compras_prova;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepositorio extends CrudRepository<Item, Long>{

}