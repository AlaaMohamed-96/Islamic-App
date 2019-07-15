package com.route.islamiappgfri.API.Model;

import java.util.List;

public class RadioChannelsResponse{
	private List<RadiosItem> radios;

	public void setRadios(List<RadiosItem> radios){
		this.radios = radios;
	}

	public List<RadiosItem> getRadios(){
		return radios;
	}

	@Override
 	public String toString(){
		return 
			"RadioChannelsResponse{" + 
			"radios = '" + radios + '\'' + 
			"}";
		}
}