package br.com.hilix.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.hilix.entity.Grupo;
import br.com.hilix.exception.HilixException;
import br.com.hilix.service.group.GroupService;

/**
 * Cadastro de Grupos
 * @author almir.oliveira
 *
 */
@ManagedBean(name="groupMBean")
@ViewScoped
public class GroupMBean extends AbstractManagedBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grupo groupSelecionado ;
	
	public Grupo getGrupoSelecionado() {
		return groupSelecionado;
	}

	public void setUsuarioSelecionado(Grupo groupSelecionado) {
		this.groupSelecionado = groupSelecionado;
	}
	private long idGroup;
	private String nameGroup;
	
	private GroupService groupService = new GroupService();
	
	


	/**
	 * Método de carregamento da lista da datatable através do tipo do usuário
	 * logado
	 * 
	 * @return
	 */
	public List<Grupo> getListaGrupos() throws HilixException {
		List<Grupo> lista = new ArrayList<Grupo>();
		lista = groupService.findAll();
		return lista;
	}

	/**
	 * Chamada inicial da pagina de Grupo
	 * 
	 * @throws IOException
	 */
	@PostConstruct
	public String iniciarGrupo() throws IOException {
		groupSelecionado = new Grupo();
		groupSelecionado.setIdGroup(0l);
		groupSelecionado.setNameGroup("");
		setIdGroup(0l);
		setNameGroup("");
		return "group";
	}

	/**
	 * Método para iniciar um novo usuário
	 */
	public void iniciar() {
		try {
			this.getListaGrupos();
			this.groupSelecionado = new Grupo();
			this.groupSelecionado.setIdGroup(0l);
			this.groupSelecionado.setNameGroup("");
			this.setIdGroup(0l);
			this.setNameGroup("");
		}
		catch (HilixException e) {
			super.addInfo(e.getMessage());
		}
	}

	/**
	 * Exclusão lógica, setar o campo status para inativo
	 */
	public void excluirGrupo() throws HilixException {
		try {
			groupService.remove(this.getGroupSelecionado());
			super.addInfo(super.getMessage("groupExcluido"));
			this.iniciar();
		}
		catch (Exception e) {
			super.addInfo(e.getMessage());
		}
	}

	/**
	 * Método salvar/alterar o objeto Utiliza o requestContext para fechar ou
	 * não, casa haja problema, o modal de cadastro
	 */
	public void salvarGrupo() throws HilixException {
		RequestContext context = RequestContext.getCurrentInstance();
		this.groupSelecionado = new Grupo();
		this.groupSelecionado.setNameGroup(this.nameGroup.toString());
		if (this.idGroup!=0)
			this.groupSelecionado.setIdGroup(this.idGroup);
		super.setSucesso(true);
		try {
			if (super.isNullOrBlank(this.getGrupoSelecionado().getIdGroup())) {
				groupService.save(this.getGrupoSelecionado());
			}
			else {
				if ( this.getGrupoSelecionado().getIdGroup()==0 ||this.getGrupoSelecionado().getIdGroup() ==null) {
					// Colocado essa condição pois não pode permitir cadastrar um novo group com Login Existente
					if (!groupService.getByName(this.getGrupoSelecionado().getNameGroup()).isEmpty()) {
						super.addError(super.getMessage("grupoExistente"));
						super.setSucesso(false);
						return;
					}
					
					groupService.save(this.getGrupoSelecionado());
				}
				else {
					groupService.update(this.getGrupoSelecionado());
				}
				super.addInfo(super.getMessage("groupSalvo"));
				this.iniciar();
				
			}
		}
		catch (Exception e) {
			super.setSucesso(false);
			super.addInfo(e.getMessage());
		}
		context.addCallbackParam("sucesso", super.isSucesso());
	}


	public void edit(Grupo group){
		setUsuarioSelecionado(group);
		this.groupSelecionado = group;
	}



	public Grupo getGroupSelecionado() {
		return groupSelecionado;
	}

	public void setGroupSelecionado(Grupo groupSelecionado) {
		this.groupSelecionado = groupSelecionado;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	public long getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(long idGroup) {
		this.idGroup = idGroup;
	}

}
