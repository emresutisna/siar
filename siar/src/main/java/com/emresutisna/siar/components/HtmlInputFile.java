package com.emresutisna.siar.components;

import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlInputText;

@FacesComponent(value="HtmlInputFile")
public class HtmlInputFile extends HtmlInputText{

	@Override
	public String getRendererType(){
		return "javax.faces.File";
	}
}