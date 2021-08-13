package br.com.keyworks.view.backing;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.keyworks.framework.faces.backing.AbstractBacking;
import br.com.keyworks.services.UsuarioService;

@Named("templateBack")
@ViewScoped
public class TemplateBacking extends AbstractBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private IdentidadeSessao sessao;

	private String nome;

	@PostConstruct
	public void Init() {
		this.nome = sessao.getNome();
	}

	public String nomeParcial() {
		return usuarioService.gerenciarNomeParaView("parcial", nome);
	}

	public String nomeCompleto() {
		return usuarioService.gerenciarNomeParaView("completo", nome);
	}

}
