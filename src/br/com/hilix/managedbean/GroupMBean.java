package br.com.hilix.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.hilix.entity.Grupo;
import br.com.hilix.exception.HilixException;
import br.com.hilix.service.group.GroupService;

/**
 * Cadastro de Grupos
 * @author almir.oliveira
 *
 */
@ManagedBean(name="groupMBean")
@SessionScoped
public class GroupMBean extends AbstractManagedBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grupo groupSelecionado ;
	private long idGroup;
	private String nameGroup;
	


	
	private GroupService groupService = new GroupService();
	
    @PostConstruct
    public void init() {
		List<Grupo> lista = new ArrayList<Grupo>();
    }


	/**
	 * M�todo de carregamento da lista da datatable atrav�s do tipo do usu�rio
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
	
	public void iniciarGrupo() throws IOException {
		groupSelecionado = new Grupo();
		groupSelecionado.setIdGroup(0l);
		groupSelecionado.setNameGroup("");
		setIdGroup(0l);
		setNameGroup("");
		
	}

	/**
	 * M�todo para iniciar um novo usu�rio
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
		catch (Exception e) {
			super.addInfo(e.getMessage());
		}
	}

	/**
	 * Exclus�o l�gica, setar o campo status para inativo
	 */
	public void excluirGrupo() throws HilixException {
		try {
			groupService.remove(this.getGroupSelecionado());
			super.addInfo(super.getMessage("groupExcluido"));
			
		}
		catch (Exception e) {
			super.addInfo(e.getMessage());
		}
	}

	/**
	 * M�todo salvar/alterar o objeto Utiliza o requestContext para fechar ou
	 * n�o, casa haja problema, o modal de cadastro
	 */
	public void salvarGrupo() throws HilixException {
		RequestContext context = RequestContext.getCurrentInstance();
		this.groupSelecionado = new Grupo();
		this.groupSelecionado.setNameGroup(this.nameGroup.toString());
		if (this.idGroup!=0)
			this.groupSelecionado.setIdGroup(this.idGroup);
		super.setSucesso(true);
		try {
			if (super.isNullOrBlank(this.getGroupSelecionado().getIdGroup())) {
				groupService.save(this.getGroupSelecionado());
			}
			else {
				if ( this.getGroupSelecionado().getIdGroup()==0 ||this.getGroupSelecionado().getIdGroup() ==null) {
					// Colocado essa condi��o pois n�o pode permitir cadastrar um novo group com Login Existente
					if (!groupService.getByName(this.getGroupSelecionado().getNameGroup()).isEmpty()) {
						super.addError(super.getMessage("grupoExistente"));
						super.setSucesso(false);
						return;
					}
					
					groupService.save(this.getGroupSelecionado());
				}
				else {
					groupService.update(this.getGroupSelecionado());
				}
				super.addInfo(super.getMessage("groupSalvo"));
				
				
			}
		}
		catch (Exception e) {
			super.setSucesso(false);
			super.addInfo(e.getMessage());
		}
		context.addCallbackParam("sucesso", super.isSucesso());
	}


	public Grupo getGroupSelecionado() {
		return groupSelecionado;
	}

     public void reset(){
    	 this.iniciar();
    	 RequestContext.getCurrentInstance().reset("formSalvarGrupo");
     }
	 public void onRowSelect(SelectEvent event) {
		 	if (event.getObject() instanceof Grupo){
		 		Grupo grupo = (Grupo)event.getObject();
		 		this.idGroup = grupo.getIdGroup();
		 		this.nameGroup =  grupo.getNameGroup();
		 		this.groupSelecionado = new Grupo();
		 		this.groupSelecionado.setIdGroup(this.idGroup);
		 		this.groupSelecionado.setNameGroup(this.nameGroup);
		 	}
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
