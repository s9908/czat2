package czat2;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="state")
@ApplicationScoped
public class State 
{
	String txt_tresc;

	public State()
	{
		txt_tresc = "SYSTEM: Uruchomienie czatu.<br/>";
	}

	public String getTxt_tresc() 
	{
		return txt_tresc;
	}

	public void setTxt_tresc(String txt_tresc) 
	{
		this.txt_tresc = txt_tresc;
	}
	
	
    
}
