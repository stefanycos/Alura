package br.com.casado.codigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casado.codigo.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext // com esta anotação estamos delegando o gerenciamento do manager ao Spring
	private EntityManager manager;
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}
}
