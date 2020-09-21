package br.com.lucianobrsts.repository;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.lucianobrsts.model.PessoaModel;
import br.com.lucianobrsts.repository.entity.PessoaEntity;
import br.com.lucianobrsts.repository.entity.UsuarioEntity;
import br.com.lucianobrsts.uteis.Uteis;

public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;

	@Inject
	EntityManager entityManager;

	/***
	 * M�TODO RESPONS�VEL POR SALVAR UMA NOVA PESSOA
	 * 
	 * @param pessoaModel
	 */
	public void salvarNovoRegistro(PessoaModel pessoaModel) {
		entityManager = Uteis.JpaEntityManager();

		pessoaEntity = new PessoaEntity();
		pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setOrigemCadastro(pessoaModel.getOrigemCadastro());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class,
				pessoaModel.getUsuarioModel().getCodigo());

		pessoaEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(pessoaEntity);
	}

}