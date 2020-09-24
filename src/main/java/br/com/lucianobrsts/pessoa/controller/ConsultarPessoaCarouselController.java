package br.com.lucianobrsts.pessoa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucianobrsts.model.PessoaModel;
import br.com.lucianobrsts.repository.PessoaRepository;

@Named(value = "consultarPessoaCarouselController")
@ViewScoped
public class ConsultarPessoaCarouselController implements Serializable {

	private static final long serialVersionUID = 6206933676337240265L;

	@Inject
	transient private PessoaRepository pessoaRepository;

	@Produces
	private List<PessoaModel> pessoas;

	public List<PessoaModel> getPessoas() {
		return pessoas;
	}

	@PostConstruct
	private void init() {
		this.pessoas = pessoaRepository.getPessoas();
	}

}
