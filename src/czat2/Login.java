package czat2;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="login")
@SessionScoped
public class Login 
{
	private boolean zalogowany;		// czy uzytkownik sie zalogowal
	private String uzytkownik_txt;	// nazwa uzytkownika w oknie czatu
	private String uzytkownik_pole; // pole do logowania
	
	public Login()
	{
		wyloguj();
	}
	
	public void zaloguj()
	{
		if(uzytkownik_pole.length() < 3)
		{
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd!", "Nazwa użytkownika musi mieć minimum 3 znaki."));
		}
		else
		{
			//logowanie
			uzytkownik_txt = uzytkownik_pole;
			zalogowany = true;
		}
	}
	
	public void wyloguj()
	{
		//wylogowywanie
		zalogowany = false;	
		uzytkownik_pole = "";
		uzytkownik_txt = "";
	}

	public boolean isZalogowany() 
	{
		return zalogowany;
	}

	public void setZalogowany(boolean zalogowany) 
	{
		this.zalogowany = zalogowany;
	}


	public String getUzytkownik_txt() 
	{
		return uzytkownik_txt;
	}

	public void setUzytkownik_txt(String uzytkownik_txt) 
	{
		this.uzytkownik_txt = uzytkownik_txt;
	}

	public String getUzytkownik_pole() 
	{
		return uzytkownik_pole;
	}

	public void setUzytkownik_pole(String uzytkownik_pole) 
	{
		this.uzytkownik_pole = uzytkownik_pole;
	}
	
	
}
