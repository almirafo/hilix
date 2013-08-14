package br.com.supportcomm.freecall.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;


import org.primefaces.context.RequestContext;

import br.com.supportcomm.freecall.entity.UserAccess;
import br.com.supportcomm.freecall.entity.UserType;
import br.com.supportcomm.freecall.exception.FreeCallException;

import br.com.supportcomm.freecall.service.user.UserService;
import br.com.supportcomm.freecall.util.Constantes;
import br.com.supportcomm.freecall.util.EmailUtil;
import br.com.supportcomm.freecall.util.JSFUtil;

/**
 * Classe backingbean de cadastro de usuário
 * 
 * @author andre.vilhalba
 * 
 */
@ManagedBean(name="usuarioMBean")
@SessionScoped
public class UsuarioMBean extends AbstractManagedBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserAccess usuarioSelecionado ;
	
	public UserAccess getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(UserAccess usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	private String passwordConfirmado;
	
	private final static String[] status;
	private final static Integer[] statusValue;

	static {
		status = new String[2];
		status[0] = "ativada";
		status[1] = "desativada";

		statusValue = new Integer[2];
		statusValue[0] = 1;
		statusValue[1] = 0;

	}
	private SelectItem[] statusOptions;
	
	private UserService userService = new UserService();
	
	


	/**
	 * Método de carregamento da lista da datatable através do tipo do usuário
	 * logado
	 * 
	 * @return
	 */
	public List<UserAccess> getListaUsuarios() throws FreeCallException {

		List<UserAccess> lista = new ArrayList<UserAccess>();

		if (super.getUserType() == Constantes.USUARIO_ADMINISTRADOR.getValor()) {
			lista = userService.getUserAccessAll();
		}
		else if (super.getUserType() == Constantes.USUARIO_AGENCIA.getValor()) {
			lista = userService.getUserAccessUsuario(super.getUserAccess().getIdUserAccess());
		}

		return lista;
	}

	/**
	 * método de preencimento da lista utilizada na combo de tipo de usuario do
	 * cadastro de campanha
	 * 
	 * @return List<Spot>
	 * @throws FreeCallException
	 */
	public List<SelectItem> getListaUserTypes() throws FreeCallException {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<UserType> listaUserType = userService.getUserTypeAll();
		for (UserType c : listaUserType) {
			lista.add(new SelectItem(c.getIdUserType(), c.getNameUserType()));
		}
		return lista;
	}

	public UsuarioMBean() {
		statusOptions = createFilterOptions(statusValue, status);

	}

	/**
	 * Chamada inicial da pagina de Usuarios
	 * 
	 * @throws IOException
	 */
	@PostConstruct
	public String iniciarUsuario() throws IOException {
		//usuarioSelecionado = new UserAccess();
		//usuarioSelecionado.setUserType(new UserType());

		this.passwordConfirmado = "";

		return "usuario";
	}

	/**
	 * Método para iniciar um novo usuário
	 */
	public void iniciar() {
		try {
			this.getListaUsuarios();

			usuarioSelecionado = new UserAccess();
			usuarioSelecionado.setUserType(new UserType());

			this.passwordConfirmado = "";
		}
		catch (FreeCallException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exclusão lógica, setar o campo status para inativo
	 */
	public void excluirUsuario() throws FreeCallException {
		try {

			this.getUsuarioSelecionado().setStatus(Constantes.STATUS_INATIVO.getValor());
			userService.mergeUserAccess(this.getUsuarioSelecionado());
			//userService.removeUserAccess(this.getUsuarioSelecionado());
			super.addInfo(super.getMessage("usuarioExcluido"));
			saveHistory(super.getMessage("usuarioDeletado") +" -- "  + this.getUsuarioSelecionado().getLogin(), null, null );
			
			this.iniciar();
		}
		catch (Exception e) {
			
		}
	}

	/**
	 * Método salvar/alterar o objeto Utiliza o requestContext para fechar ou
	 * não, casa haja problema, o modal de cadastro
	 */
	public void salvarUsuario() {
		RequestContext context = RequestContext.getCurrentInstance();
		super.setSucesso(true);

		try {
			if (super.isNullOrBlank(this.getUsuarioSelecionado().getIdUserAccess())) {
				if (this.getUsuarioSelecionado().getUserType().getIdUserType().intValue() == Constantes.USUARIO_AGENCIA.getValor()) {
					super.addWarn(super.getMessage("erroCadastroAgencia"));
					super.setSucesso(false);
				}
				else if (this.getUsuarioSelecionado().getUserType().getIdUserType().intValue() == Constantes.USUARIO_ANUNCIANTE.getValor()) {
					super.addWarn(super.getMessage("erroCadastroAnunciante"));
					super.setSucesso(false);
				}
			}
			if (!this.passwordConfirmado.equals(this.usuarioSelecionado.getPassword())) {
				super.addError(super.getMessage("erroConfirmarSenha"));
				super.setSucesso(false);
			}
			else {
				//if ( super.isNullOrBlank(this.getUsuarioSelecionado().getIdUserAccess())) {
				if ( this.getUsuarioSelecionado().getIdUserAccess()==0) {
					// Colocado essa condição pois não pode permitir cadastrar um novo usuario com Login Existente
					if (!userService.getUserAccessLogin(this.getUsuarioSelecionado().getLogin()).isEmpty()) {

						super.addError(super.getMessage("loginExistente"));
						super.setSucesso(false);
						return;

					}
					
					userService.persistUserAccess(this.getUsuarioSelecionado());
				}
				else {
					userService.mergeUserAccess(this.getUsuarioSelecionado());
				}
				EmailUtil.sendHTMLMail(super.getUsuarioAutenticado().getEmail(), this.getUsuarioSelecionado().getEmail(), this.getUsuarioSelecionado().getLogin(), "Usuário Chamadas Patrocinadas",
						super.getEmailCadastroUsuario(this.getUsuarioSelecionado().getLogin(), this.getUsuarioSelecionado().getPassword()));
				super.addInfo(super.getMessage("usuarioSalvo"));
				saveHistory(super.getMessage("usuarioHistorico") +" -- "  + this.getUsuarioSelecionado().getLogin(), null, null );
				this.iniciar();
				
			}
		}
		catch (Exception e) {
			super.addError(JSFUtil.getEmailMessage("erroEnviarEmail"));
			super.setSucesso(false);
		}
		context.addCallbackParam("sucesso", super.isSucesso());
	}

	public String getPasswordConfirmado() {
		return passwordConfirmado;
	}

	public void setPasswordConfirmado(String passwordConfirmado) {
		this.passwordConfirmado = passwordConfirmado;
	}



	/**
	 * Método para desabilitar a combo tipo de usuário
	 * 
	 * @return
	 */
	public boolean getDesabilitarTipoUsuario() {
		if (super.getUserType() == Constantes.USUARIO_ADMINISTRADOR.getValor()) {
			return false;
		}
		return true;
	}

	public void edit(UserAccess user){
		setUsuarioSelecionado(user);
		//this.usuarioSelecionado = user;
	}
	
	
	public void saveHistory(String action, Long idCampanha, Long idSpot) {

		try {
			
			
			
		}
		catch (Exception e) {
			
		}

	}
	
	private SelectItem[] createFilterOptions(Integer[] values, String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Select");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem( String.valueOf(values[i]), data[i]);
		}

		return options;
	}

	public SelectItem[] getStatusOptions() {
		return statusOptions;
	}
	

}
