package com.emresutisna.siar.utils;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.stereotype.Service;

@Service("uiUtils")
@SessionScoped
public class UIUtils implements Serializable {
    private static final long serialVersionUID = 7872083365595569634L;

    private int viewLoadCount = 0;
    public void greetOnViewLoad(ComponentSystemEvent event) {
            FacesContext context = FacesContext.getCurrentInstance(); 
            if (viewLoadCount < 1 && !context.isPostback()) {
                    String firstName = (String) event.getComponent().getAttributes().get("firstName");
                    String lastName = (String) event.getComponent().getAttributes().get("lastName");
                    if(!firstName.isEmpty()){
	                    FacesMessage message = new FacesMessage(String.format("Selamat datang %s %s", firstName, lastName));
	                    context.addMessage("growlMessages", message);                   
	                    viewLoadCount++;
                    }    
            }
    }
    
    public void logout(){
    	viewLoadCount = 0;
        FacesContext context = FacesContext.getCurrentInstance();               	
    	FacesMessage message = new FacesMessage(String.format("Terima kasih telah menggunakan aplikasi SIAr"));
        context.addMessage("growlMessages", message);
    }
}
