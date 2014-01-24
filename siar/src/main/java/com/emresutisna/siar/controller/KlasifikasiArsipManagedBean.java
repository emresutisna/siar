package com.emresutisna.siar.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.emresutisna.siar.model.KlasifikasiArsip;
import com.emresutisna.siar.services.KlasifikasiArsipService;

@Controller("klasifikasiArsipMB")
@Scope("request")
public class KlasifikasiArsipManagedBean implements Serializable{
	private static final long serialVersionUID = -4380868689766209803L;
	private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @Autowired
    private KlasifikasiArsipService klasifikasiArsipService;

    private List<KlasifikasiArsip> klasifikasiArsips;
    private List<KlasifikasiArsip> filteredKlasifikasi;
    private List<SelectItem> selectOneItemsKlasifikasiArsip;
    
    public List<KlasifikasiArsip> getFilteredKlasifikasi() {
		return filteredKlasifikasi;
	}

	public void setFilteredKlasifikasi(List<KlasifikasiArsip> filteredKlasifikasi) {
		this.filteredKlasifikasi = filteredKlasifikasi;
	}

	private String kodeKlasifikasi;
    private String rincian;

    public String addKlasifikasiArsip() {
        try {
            KlasifikasiArsip klasifikasiArsip = new KlasifikasiArsip();
            klasifikasiArsip.setKodeKlasifikasi(getKodeKlasifikasi());
            klasifikasiArsip.setRincian(getRincian());
            getKlasifikasiArsipService().addKlasifikasiArsip(klasifikasiArsip);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public KlasifikasiArsipService getKlasifikasiArsipService() {
		return klasifikasiArsipService;
	}

	public void setKlasifikasiArsipService(
			KlasifikasiArsipService klasifikasiArsipService) {
		this.klasifikasiArsipService = klasifikasiArsipService;
	}

    public void reset() {
        this.setKodeKlasifikasi("");
        this.setRincian("");
    }

    public List<KlasifikasiArsip> getKlasifikasiArsips() {
        klasifikasiArsips = new ArrayList<KlasifikasiArsip>();
        klasifikasiArsips.addAll(getKlasifikasiArsipService().getAll());
        return klasifikasiArsips;
    }

	public void setKlasifikasiArsips(List<KlasifikasiArsip> klasifikasiArsips) {
		this.klasifikasiArsips = klasifikasiArsips;
	}

	public String getKodeKlasifikasi() {
		return kodeKlasifikasi;
	}

	public void setKodeKlasifikasi(String kodeKlasifikasi) {
		this.kodeKlasifikasi = kodeKlasifikasi;
	}

	public String getRincian() {
		return rincian;
	}

	public void setRincian(String rincian) {
		this.rincian = rincian;
	}
	
	public List<SelectItem> getSelectOneItemsKlasifikasiArsip() {
		this.selectOneItemsKlasifikasiArsip = new ArrayList<SelectItem>();
		List<KlasifikasiArsip> klasList = this.klasifikasiArsipService.getAll();
		for(KlasifikasiArsip klasifikasiArsip : klasList){
			SelectItem selectItem = new SelectItem(klasifikasiArsip.getId(), klasifikasiArsip.getKodeKlasifikasi() + "-" + klasifikasiArsip.getRincian());
			this.selectOneItemsKlasifikasiArsip.add(selectItem);
		}
		return selectOneItemsKlasifikasiArsip;
	}	
}
