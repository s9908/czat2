package czat2;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="state")
@ApplicationScoped
public class State 
{
	String txt_tresc;
	String editor;
	
	public void wyslij()
	{
		if(editor.trim().length() > 0)
		{
			editor = editor.replaceAll(":\\)", "<img src='./img/usmiech.png' width='16'>");
			editor = editor.replaceAll(":\\*", "<img src='./img/kiss.png' width='16'>");
			String txt = "<font color='brown'>";
			txt += "XXXX";
			txt += "</font>" + editor;
			txt_tresc += txt + "<br/>";
			editor = "";
		}
	}

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

	public String getEditor() 
	{
		return editor;
	}

	public void setEditor(String editor) 
	{
		this.editor = editor;
	}
	
	
	
    
}
