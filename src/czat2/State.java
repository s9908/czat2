package czat2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="state")
@ApplicationScoped
public class State 
{
	private String txt_tresc;
	private String editor;
	
	private void wiadomosc(String nick, String tresc)
	{
		//emotikony
		tresc = tresc.replaceAll(":\\)", "<img src='./img/usmiech.png' width='16'>");
		tresc = tresc.replaceAll(":\\*", "<img src='./img/kiss.png' width='16'>");		
		//obecna data i czas
		DateFormat formatdaty = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
		Date teraz = new Date();		
		//budowanie finalnej wiadomosci (z nickiem, data, trescia itp)
		String ret = "<font color='brown'>";
		ret += formatdaty.format(teraz) + " " + nick + ":";
		ret += "</font>" + tresc;
		//dodawanie tresci wiadomosci do reszty
		txt_tresc += ret + "<br/>";
	}
	
	public void wyslij()
	{
		//pobieranie nicku z bean login
		FacesContext facesContext = FacesContext.getCurrentInstance();
		@SuppressWarnings("deprecation")
		Login login = (Login) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "login");
		String nick = login.getUzytkownik_pole();
		
		//wysylanie wiadomosci
		if(editor.trim().length() > 0)
		{
		 	wiadomosc(nick, editor);
			editor = "";
		}
	}

	public State()
	{
		txt_tresc = "";
		wiadomosc("SYSTEM", "Uruchomiono aplikację czatu.");
	}
	
	
	public String getTxt_tresc() 
	{
		return txt_tresc;
	}
	public void setTxt_tresc(String txt_tresc) 
	{
		this.txt_tresc = txt_tresc;
	}

	public String getEditor() 
	{
		return editor;
	}

	public void setEditor(String editor) 
	{
		this.editor = editor;
	}
}
