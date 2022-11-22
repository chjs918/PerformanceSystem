package model;

import java.util.ArrayList;
import java.util.List;

public class MyPreference {
	 private String standingOrseat;
	 private String sideOrcenter;
	 private String frontOrbehind;
	 
	 
	public MyPreference() {
		super();
	}
	
	
	public MyPreference(String standingOrseat, String sideOrcenter, String frontOrbehind) {
		super();
		this.standingOrseat = standingOrseat;
		this.sideOrcenter = sideOrcenter;
		this.frontOrbehind = frontOrbehind;
	}


	public String getStandingOrseat() {
		return standingOrseat;
	}

	public void setStandingOrseat(String standingOrseat) {
		this.standingOrseat = standingOrseat;
	}

	public String getSideOrcenter() {
		return sideOrcenter;
	}

	public void setSideOrcenter(String sideOrcenter) {
		this.sideOrcenter = sideOrcenter;
	}

	public String getFrontOrbehind() {
		return frontOrbehind;
	}

	public void setFrontOrbehind(String frontOrbehind) {
		this.frontOrbehind = frontOrbehind;
	}
}