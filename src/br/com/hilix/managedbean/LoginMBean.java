package br.com.hilix.managedbean;


import java.io.Serializable;
import java.util.Date;





import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





import org.apache.log4j.Level;
import org.primefaces.event.CloseEvent;







import br.com.hilix.entity.UserAccess;
import br.com.hilix.service.user.UserService;
import br.com.hilix.util.Constantes;

/**
 * Classe backingbean de login
 * 
 * 
 * 
 */
@ManagedBean(name="loginMBean")
@ViewScoped
public class LoginMBean extends AbstractManagedBean  implements Serializable
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4148899142613204979L;


	private String message;
   

	private HttpSession session;
    private String login; 
    private String senha;
    private String confirmSenha;
    private String  oldPassword;
    private String  newPassword;
    private String  rePassword;
				    
   
    
    
    private UserService userService =  new UserService();

    public LoginMBean()
    {
    	
    	
        super();
    }
    
    public boolean getIsAdmin(){
    
    	FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    	UserAccess user = (UserAccess) request.getSession().getAttribute("usuarioAutenticado");
    	
    	if(user.getUserType().getCodeUserType().equals("1")) return true;
    	
    	return false;
    }
    
    public boolean getIsAnunciante(){
    	
    	FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		UserAccess user = (UserAccess) request.getSession().getAttribute("usuarioAutenticado");
		
		if(user.getUserType().getCodeUserType().equals("2")) return true;
		
    	return false;
    }
    
    public boolean getIsAgencia(){
    	
    	FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		UserAccess user = (UserAccess) request.getSession().getAttribute("usuarioAutenticado");
		
		if(user.getUserType().getCodeUserType().equals("3")) return true;
		
    	return false;
    }
    
    public String autenticarUsuario()
    {
        try
        {
            UserAccess usuarioAutenticado = userService.getUserAccessLoginPass(this.getLogin(), this.getSenha()).get(0);
            if (super.isNullOrBlank(usuarioAutenticado))
            {
                super.addError(super.getMessage("usuarioNaoEncontrado"));
            }
            else if (usuarioAutenticado.getStatus() == Constantes.STATUS_INATIVO.getValor())
            {
                super.addError(super.getMessage("usuarioInativo"));
            }
            else
            {
                session = super.getSessionAtiva(false);
                session.setAttribute("usuarioAutenticado", usuarioAutenticado);
                session.setAttribute("nomeLogin", usuarioAutenticado.getLogin());
                if (usuarioAutenticado.getUserType()
                                      .getCodeUserType()
                                      .equals(Constantes.USUARIO_ADMINISTRADOR))
                {
                    return "menuInitial";
                }
                else
                {
                    return "menuInitial";
                }
            }
        }
        catch (Exception e)
        {
            super.addError(super.getMessage("problemaConexao"));

        }
		return "";
    }

    
    
    
    public String changeLogin(){
    	
    	UserAccess usuarioAutenticado = (UserAccess) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");    		
    	UserAccess userAccess = userService.getUserAccessLoginPass(usuarioAutenticado.getLogin(), usuarioAutenticado.getPassword()).get(0);
    	
    	if (userAccess!=null){
    		if(this.getNewPassword().equals(this.getRePassword())){
    	    	userAccess.setPassword(this.getNewPassword());
    	    	userAccess= userService.mergeUserAccess(userAccess);
    	    } else{
    			message = "New Password and regidig is diferent!";
    			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(message));  
	    		return "/paginas/changeLogintela.xhtml";
    		}
    	}
    	else{
    		message = "Worng Login or Password!";
    		FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(message));  
    		return "/paginas/changeLogintela.xhtml";
    	}
    	return  "/index.xhtml";
    }
    
    
    
    
    
    
    public String logout(){
   	  try {
   	       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioAutenticado");
   	       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("nomeLogin");
   	  } catch (Exception ex) {
   	          
   	  }
   	  return "/index.xhtml";

   }
    
    /**
     * M�todo respons�vel por remover o usu�rio da sess�o quando o mesmo realiza
     * logout. O bot�o sair chama este m�todo.
     */
    public String encerraSessao()
    {
        try
        {
        	FacesContext context = FacesContext.getCurrentInstance();
    		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    		request.getSession().invalidate();
    		
            return "inicio";
        }
        catch (Exception e)
        {

        }
        
        return "inicio";
    }

    public String teste() throws Exception
    {
    	return "seguranca";
    }

    /**
     * M�todo que executa o encerrar sess�o
     * 
     * @param closeEvent
     */
    public void sessaoExpirada(CloseEvent closeEvent)
    {
        this.encerraSessao();
    }

    /**
     * Mostra a data do dia
     * 
     * @return
     */
    public String getDataAtual()
    {
        return super.getDataExtenso(new Date());
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    
    public String getConfirmSenha() {
		return confirmSenha;
	}

	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
    
}
