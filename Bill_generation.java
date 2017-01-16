import java.io.Serializable;

 
public class Bill_generation implements Serializable {
	
	private String name,id,price,quantity,disc,disc_price;
	 public Bill_generation(String id,String name,String price,String quantity,String disc, String disc_price)
	 {
		 super();
		 this.id=id;
		 this.name=name;
		 this.price=price;
		 this.quantity=quantity;
		 this.disc=disc;
		 this.disc_price=disc_price;
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
		public String getprice() {
			return price;
		}
		public void setprice(String price) {
			this.price = price;
		}
		public String getquantity() {
			return quantity;
		}
		public void setquantity(String quantity) {
			this.quantity = quantity;
		}
		public String getdisc() {
			return disc;
		}
		public void setdisc(String disc) {
			this.disc = disc;
		}
		 
		public String getdisc_price() {
			return disc_price;
		}
		public void setdisc_price(String disc_price) {
			this.disc_price = disc_price;
		}

}
