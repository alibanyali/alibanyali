package project;

public class Vehicle {
private int vehId;
private String vehBrand;
private String vehMoudle;
private int vehYear;
private String vehVennum;
public int getVehId() {
	return vehId;
}
public void setVehId(int vehId) {
	this.vehId = vehId;
}
public String getVehBrand() {
	return vehBrand;
}
public void setVehBrand(String vehBrand) {
	this.vehBrand = vehBrand;
}
public String getVehMoudle() {
	return vehMoudle;
}
public void setVehMoudle(String vehMoudle) {
	this.vehMoudle = vehMoudle;
}
public int getVehYear() {
	return vehYear;
}
public void setVehYear(int vehYear) {
	this.vehYear = vehYear;
}
public String getVehVennum() {
	return vehVennum;
}
public void setVehVennum(String vehVennum) {
	this.vehVennum = vehVennum;
}
@Override
public String toString() {
	return  "Id  :" + getVehId() + " || Brand :" + getVehBrand()
	+ " || Moudle :" + getVehMoudle()+" || Year :"+
getVehYear()+ " || VenNumber :" + getVehVennum();
}

}
