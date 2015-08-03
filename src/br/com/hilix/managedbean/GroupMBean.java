package br.com.hilix.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.hilix.entity.Group;
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
	
	private Group groupSelecionado ;
	
	public Group getGrupoSelecionado() {
		return groupSelecionado;
	}

	public void setUsuarioSelecionado(Group groupSelecionado) {
		this.groupSelecionado = groupSelecionado;
	}

	private String name;
	
	private GroupService groupService = new GroupService();
	
	


	/**
	 * Método de carregamento da lista da datatable através do tipo do usuário
	 * logado
	 * 
	 * @return
	 */
	public List<Group> getListaGrupos() throws HilixException {
		List<Group> lista = new ArrayList<Group>();
		return lista;
	}


	public GroupMBean() {

	}

	/**
	 * Chamada inicial da pagina de Usuarios
	 * 
	 * @throws IOException
	 */
	@PostConstruct
	public String iniciarUsuario() throws IOException {
		groupSelecionado = new Group();
		return "group";
	}

	/**
	 * Método para iniciar um novo usuário
	 */
	public void iniciar() {
		try {
			this.getListaGrupos();
			groupSelecionado = new Group();
		}
		catch (HilixException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exclusão lógica, setar o campo status para inativo
	 */
	public void excluirGrupo() throws HilixException {
		try {
			groupService.remove(this.getGroupSelecionado());
			super.addInfo(super.getMessage("groupExcluido"));
			saveHistory(super.getMessage("groupDeletado") +" -- "  + this.getGroupSelecionado().getNameGroup(), null, null );
			this.iniciar();
		}
		catch (Exception e) {
			
		}
	}

	/**
	 * Método salvar/alterar o objeto Utiliza o requestContext para fechar ou
	 * não, casa haja problema, o modal de cadastro
	 */
	public void salvarGrupo() {
		RequestContext context = RequestContext.getCurrentInstance();
		super.setSucesso(true);

		try {
			if (super.isNullOrBlank(this.getGrupoSelecionado().getIdgroup())) {

			}
			else {
				if ( this.getGrupoSelecionado().getIdgroup()==0) {
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
				saveHistory(super.getMessage("groupHistorico") +" -- "  + this.getGrupoSelecionado().getNameGroup(), null, null );
				this.iniciar();
				
			}
		}
		catch (Exception e) {
			super.setSucesso(false);
		}
		context.addCallbackParam("sucesso", super.isSucesso());
	}


	public void edit(Group group){
		setUsuarioSelecionado(group);
		this.groupSelecionado = group;
	}
	
	
	public void saveHistory(String action, Long idCampanha, Long idSpot) {

		try {
			
		}
		catch (Exception e) {
			
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroupSelecionado() {
		return groupSelecionado;
	}

	public void setGroupSelecionado(Group groupSelecionado) {
		this.groupSelecionado = groupSelecionado;
	}


	

}
