
import java.io.Serializable;
public class Members implements Serializable 
{
 private String id,name,add,phn,credit;
 public Members(String id,String name,String add,String phn,String credit)
 {
	 super();
	 this.id=id;
	 this.name=name;
	 this.add=add;
	 this.phn=phn;
	 this.credit=credit;
 }
public String getid() {
	return id;
}
public void setid(String id) {
	this.id = id;
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getadd() {
	return add;
}
public void setadd(String add) {
	this.add = add;
}
public String getphn() {
	return phn;
}
public void setphn(String phn) {
	this.phn = phn;
}
public String getcredit() {
	return credit;
}
public void setcredit(String credit) {
	this.credit = credit;
}
 
}
