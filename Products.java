
import java.io.Serializable;
public class Products implements Serializable 
{
 private String id,descp,price,invent,disc;
 public Products(String id,String descp,String price,String invent,String disc)
 {
	 super();
	 this.id=id;
	 this.descp=descp;
	 this.price=price;
	 this.invent=invent;
	 this.disc=disc;
 }
public String getid() {
	return id;
}
public void setid(String id) {
	this.id = id;
}
public String getdescp() {
	return descp;
}
public void setdescp(String descp) {
	this.descp = descp;
}
public String getprice() {
	return price;
}
public void setprice(String price) {
	this.price = price;
}
public String getinvent() {
	return invent;
}
public void setinvent(String invent) {
	this.invent = invent;
}
public String getdisc() {
	return disc;
}
public void setdisc(String disc) {
	this.disc = disc;
}
 
}
