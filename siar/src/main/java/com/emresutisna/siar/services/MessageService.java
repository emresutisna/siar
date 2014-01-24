package com.emresutisna.siar.services;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageService implements Serializable {
	private static final long serialVersionUID = 7023593192062593326L;

    public FacesMessage constructErrorMessage(String message, String detail){
        return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
    }

    public FacesMessage constructInfoMessage(String message, String detail) {
        return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
    }

    public FacesMessage constructFatalMessage(String message, String detail) {
        return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
    }

    public ResourceBundle getMessageBundle() {
        return ResourceBundle.getBundle("message-labels");
    }
}
