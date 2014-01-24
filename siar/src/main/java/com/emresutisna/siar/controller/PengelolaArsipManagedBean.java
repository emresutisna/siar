package com.emresutisna.siar.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.emresutisna.siar.model.PengelolaArsip;
import com.emresutisna.siar.services.MessageService;
import com.emresutisna.siar.services.PengelolaArsipService;

@Controller("pengelolaArsipMB")
@Scope("session")
public class PengelolaArsipManagedBean implements Serializable {
	private static final long serialVersionUID = 1492205253491467313L;

    @Autowired
    private PengelolaArsipService pengelolaArsipService;
    
    @Autowired
    UserManagedBean userMB;
    
    @Autowired
    MessageService messageService;
    
    private List<PengelolaArsip> pengelolaArsips;
    private List<PengelolaArsip> filteredPengelolaArsip;
    private PengelolaArsip pengelolaArsip;
    private List<SelectItem> selectOneItemsPengelolaArsip;
    
    public PengelolaArsipManagedBean(){
    	this.setPengelolaArsip(new PengelolaArsip());
    }
    
    public void prepareInsert(ActionEvent event){
    	this.pengelolaArsip = new PengelolaArsip();
    }
    
    public void updatePengelolaArsip(ActionEvent event){
    	try{
    		pengelolaArsipService.updatePengelolaArsip(pengelolaArsip);
    		FacesMessage message = messageService.constructInfoMessage(messageService.getMessageBundle().getString("updateSuccessMsg"), null);
    		FacesContext.getCurrentInstance().addMessage(null,message);
    	}catch(Exception ex){
    		FacesMessage message = messageService.constructErrorMessage(ex.getMessage(), null);
    		FacesContext.getCurrentInstance().addMessage(null,message);    		
    	}
    }
    
    public PengelolaArsipService getPengelolaArsipService() {
		return pengelolaArsipService;
	}

    public void setPengelolaArsipService(PengelolaArsipService pengelolaArsipService) {
		this.pengelolaArsipService = pengelolaArsipService;
	}
	public UserManagedBean getUserMB() {
		return userMB;
	}
	public void setUserMB(UserManagedBean userMB) {
		this.userMB = userMB;
	}
	
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public List<PengelolaArsip> getPengelolaArsips() {
		this.pengelolaArsips = new ArrayList<PengelolaArsip>();
		this.pengelolaArsips.addAll(getPengelolaArsipService().getAllForTable(getUserMB().getLoggedinUser().getSubUnitKerja().getId()));
		return pengelolaArsips;
	}
	
	public void setPengelolaArsips(List<PengelolaArsip> pengelolaArsips) {
		this.pengelolaArsips = pengelolaArsips;
	}

	public List<PengelolaArsip> getFilteredPengelolaArsip() {
		return filteredPengelolaArsip;
	}
	public void setFilteredPengelolaArsip(List<PengelolaArsip> filteredPengelolaArsip) {
		this.filteredPengelolaArsip = filteredPengelolaArsip;
	}

	public PengelolaArsip getPengelolaArsip() {
		return pengelolaArsip;
	}

	public void setPengelolaArsip(PengelolaArsip pengelolaArsip) {
		this.pengelolaArsip = pengelolaArsip;
	}

	public List<SelectItem> getSelectOneItemsPengelolaArsip() {
		this.selectOneItemsPengelolaArsip = new ArrayList<SelectItem>();
		List<PengelolaArsip> pengList = this.pengelolaArsipService.getAllForTable(userMB.getLoggedinUser().getSubUnitKerja().getId());
		for(PengelolaArsip pengelolaArsip : pengList){
			SelectItem selectItem = new SelectItem(pengelolaArsip.getId(), pengelolaArsip.getNamaPengelola());
			this.selectOneItemsPengelolaArsip.add(selectItem);
		}
		return selectOneItemsPengelolaArsip;
	}
}