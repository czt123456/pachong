package com.czt.pc.wnl;

/**
 * 万年历entity
 * @author Administrator
 *
 */
public class Almanac {
	private String solar;
	private String lunar;
	private String chineseAra;
	private String should;
	private String avoid;
	public String getSolar() {
		return solar;
	}
	public void setSolar(String solar) {
		this.solar = solar;
	}
	public String getLunar() {
		return lunar;
	}
	public void setLunar(String lunar) {
		this.lunar = lunar;
	}
	public String getChineseAra() {
		return chineseAra;
	}
	public void setChineseAra(String chineseAra) {
		this.chineseAra = chineseAra;
	}
	public String getShould() {
		return should;
	}
	public void setShould(String should) {
		this.should = should;
	}
	public String getAvoid() {
		return avoid;
	}
	public void setAvoid(String avoid) {
		this.avoid = avoid;
	}
	public Almanac(String solar, String lunar, String chineseAra, String should, String avoid) {
		super();
		this.solar = solar;
		this.lunar = lunar;
		this.chineseAra = chineseAra;
		this.should = should;
		this.avoid = avoid;
	}
	

}
