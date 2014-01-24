package com.emresutisna.siar.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import javax.faces.event.FacesEvent;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.emresutisna.siar.model.KlasifikasiArsip;
import com.emresutisna.siar.model.PengelolaArsip;
import com.emresutisna.siar.model.SuratMasuk;
import com.emresutisna.siar.services.KlasifikasiArsipService;
import com.emresutisna.siar.services.MessageService;
import com.emresutisna.siar.services.PengelolaArsipService;
import com.emresutisna.siar.services.SuratMasukService;

@Controller("suratMasukMB")
@Scope("session")
public class SuratMasukManagedBean implements Serializable {
	private static final long serialVersionUID = 1492205253491467313L;
	
    @Autowired
    private SuratMasukService suratMasukService;
    
    @Autowired
    UserManagedBean userMB;
    
    @Autowired
    MessageService messageService;
    
    @Autowired
    PengelolaArsipService pengelolaArsipService;

    @Autowired
    KlasifikasiArsipService klasifikasiArsipService;
    
    private List<SuratMasuk> suratMasuks;
    private List<SuratMasuk> filteredSuratMasuk;

    private List<SelectItem> selectOneItemsPengelolaArsip;
    private List<SelectItem> selectOneItemsKlasifikasiArsip;
    
    private String tahun;
    private Long idPengelolaArsip, idKlasifikasiArsip;
    private SuratMasuk suratMasuk;
    private String statusEdit;
    private boolean status;
    private PengelolaArsip pengelolaArsip;
    
//    private InputStream inputStream;
    private UploadedFile uploadedFile;
    private String filename;
    private Part part;

    public SuratMasukManagedBean(){
    	Integer thn = Calendar.getInstance().get(Calendar.YEAR);
    	this.setTahun(thn.toString());
    	pengelolaArsip = new PengelolaArsip();
    	reset();
    }
    
    public void prepareInsert(ActionEvent event){
    	reset();    	
    }
    
    public void prepareUpdate(ActionEvent event){
    	this.setStatusEdit("Ubah");	
    	if(this.suratMasuk.getPengelolaArsip() == null){
    		PengelolaArsip pa = new PengelolaArsip();
    		pa.setNamaPengelola("-- Pilih unit pengolah --");
    		this.suratMasuk.setPengelolaArsip(pa);
    	}
    }
    
    private void reset(){
    	this.statusEdit="Tambah";
    	KlasifikasiArsip klasifikasiArsip = new KlasifikasiArsip();
    	klasifikasiArsip.setId(null);
    	klasifikasiArsip.setRincian("Pilih Klasifikasi Arsip");    	
    	this.setSuratMasuk(new SuratMasuk());
    	this.suratMasuk.setKlasifikasiArsip(klasifikasiArsip);
    }
    
    public void updateSuratMasuk(ActionEvent event){
    	try{
    		if(part != null){
    			uploadFile();
    		}
    		if(this.statusEdit.equals("Tambah")){
    			suratMasuk.setSubUnitKerja(userMB.getLoggedinUser().getSubUnitKerja());
    			suratMasuk.setTahun(tahun);
    			suratMasukService.addSuratMasuk(suratMasuk);    			
    		}else{
    			if(this.suratMasuk.getPengelolaArsip().getId() == 0){
    				this.suratMasuk.setPengelolaArsip(null);
    			}
    			suratMasukService.updateSuratMasuk(suratMasuk);
    		}
    		FacesMessage message = messageService.constructInfoMessage(messageService.getMessageBundle().getString(this.statusEdit + "SuccessMsg"), null);
    		FacesContext.getCurrentInstance().addMessage(null,message);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		FacesMessage message = messageService.constructErrorMessage(ex.getMessage(), null);
    		FacesContext.getCurrentInstance().addMessage(null,message);    		
    	}
    }
        
    public void deleteSuratMasuk(ActionEvent event){
    	try{
   			suratMasukService.deleteSuratMasuk(suratMasuk);
    		FacesMessage message = messageService.constructInfoMessage(messageService.getMessageBundle().getString("deleteSuccessMsg"), null);
    		FacesContext.getCurrentInstance().addMessage(null,message);
    	}catch(Exception ex){
    		FacesMessage message = messageService.constructErrorMessage(ex.getMessage(), null);
    		FacesContext.getCurrentInstance().addMessage(null,message);    		
    	}
    }
    
    public void uploadFile(){
        try{
        	filename = getFileName(part);
        	System.out.println(filename);
        	copyFile(filename);
        	FacesMessage msg = new FacesMessage("Berhasil! ", "File" + filename + " berhasil diupload.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);            
        }catch(Exception ex){
        	FacesMessage message=messageService.constructErrorMessage(ex.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, message);        	
        }
    }

    public void handleUpload(FileUploadEvent event){    	
    	System.out.println(event.getFile().getFileName());
    }
    
    public void copyFile(String fileName) {
        try {
        	ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        	String destination = servletContext.getRealPath("/WEB-INF/Files/");
             // write the inputStream to a FileOutputStream
        	
             OutputStream out = new FileOutputStream(new File(destination + fileName));          
             int read = 0;
             byte[] bytes = new byte[1024];
             InputStream in = part.getInputStream();
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }          
             in.close();
             out.flush();
             out.close();
             this.suratMasuk.setNamaFile(destination + fileName);
        } catch (IOException e) {
         	 FacesMessage message = messageService.constructErrorMessage(e.getMessage(), null);
         	 FacesContext.getCurrentInstance().addMessage(null,message);
        }
    }
    
    public SuratMasukService getSuratMasukService() {
		return suratMasukService;
	}

    public void setSuratMasukService(SuratMasukService suratMasukService) {
		this.suratMasukService = suratMasukService;
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

	public List<SuratMasuk> getSuratMasuks() {
		this.suratMasuks = new ArrayList<SuratMasuk>();
		this.suratMasuks.addAll(getSuratMasukService().getAllForTable(getUserMB().getLoggedinUser().getSubUnitKerja().getId(), getTahun()));
		return suratMasuks;
	}
	
	public void setSuratMasuks(List<SuratMasuk> suratMasuks) {
		this.suratMasuks = suratMasuks;
	}

	public List<SuratMasuk> getFilteredSuratMasuk() {
		return filteredSuratMasuk;
	}
	public void setFilteredSuratMasuk(List<SuratMasuk> filteredSuratMasuk) {
		this.filteredSuratMasuk = filteredSuratMasuk;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public SuratMasuk getSuratMasuk() {
		return suratMasuk;
	}

	public void setSuratMasuk(SuratMasuk suratMasuk) {
		this.suratMasuk = suratMasuk;
	}

	public Long getIdPengelolaArsip() {
		return idPengelolaArsip;
	}

	public void setIdPengelolaArsip(Long idPengelolaArsip) {
		this.idPengelolaArsip = idPengelolaArsip;
	}

	public Long getIdKlasifikasiArsip() {
		return idKlasifikasiArsip;
	}

	public void setIdKlasifikasiArsip(Long idKlasifikasiArsip) {
		this.idKlasifikasiArsip = idKlasifikasiArsip;
	}
	
    public String getStatusEdit() {
		return statusEdit;
	}

	public void setStatusEdit(String statusEdit) {
		this.statusEdit = statusEdit;
	}

	public boolean isStatus() {
		status = statusEdit.equals("Ubah");
		return status;
	}

	public PengelolaArsip getPengelolaArsip() {
		return pengelolaArsip;
	}

	public void setPengelolaArsip(PengelolaArsip pengelolaArsip) {
		this.pengelolaArsip = pengelolaArsip;
	}

	public List<SelectItem> getSelectOneItemsPengelolaArsip() {
		if(this.selectOneItemsPengelolaArsip == null){
			this.selectOneItemsPengelolaArsip = new ArrayList<SelectItem>();
			List<PengelolaArsip> pengList = this.pengelolaArsipService.getAllForTable(userMB.getLoggedinUser().getSubUnitKerja().getId());
			for(PengelolaArsip pengelolaArsip : pengList){
				SelectItem selectItem = new SelectItem(pengelolaArsip.getId(), pengelolaArsip.getNamaPengelola());
				this.selectOneItemsPengelolaArsip.add(selectItem);
			}
		}
		return selectOneItemsPengelolaArsip;
	}

	public List<SelectItem> getSelectOneItemsKlasifikasiArsip() {
		if(this.selectOneItemsKlasifikasiArsip == null){
			this.selectOneItemsKlasifikasiArsip = new ArrayList<SelectItem>();
			List<KlasifikasiArsip> klasList = this.klasifikasiArsipService.getAll();
			for(KlasifikasiArsip klasifikasiArsip : klasList){
				SelectItem selectItem = new SelectItem(klasifikasiArsip.getId(), klasifikasiArsip.getKodeKlasifikasi() + "-" + klasifikasiArsip.getRincian());
				this.selectOneItemsKlasifikasiArsip.add(selectItem);
			}			
		}
		return selectOneItemsKlasifikasiArsip;
	}	

	public PengelolaArsipService getPengelolaArsipService() {
		return pengelolaArsipService;
	}

	public void setPengelolaArsipService(PengelolaArsipService pengelolaArsipService) {
		this.pengelolaArsipService = pengelolaArsipService;
	}

	public KlasifikasiArsipService getKlasifikasiArsipService() {
		return klasifikasiArsipService;
	}

	public void setKlasifikasiArsipService(
			KlasifikasiArsipService klasifikasiArsipService) {
		this.klasifikasiArsipService = klasifikasiArsipService;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public Part getPart() {
        return part;
    }
 
    public void setPart(Part part) {
        this.part = part;
    }
    
    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("***** partHeader: " + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }    
}