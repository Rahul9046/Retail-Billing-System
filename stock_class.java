import java.io.Serializable;

 
public class stock_class implements Serializable {
	
	private String bill_no,day,mon,year,time,items_sold;
	 public stock_class(String bill_no,String day,String mon,String year,String time, String items_sold)
	 {
		 super();
		 this.bill_no=bill_no;
		 this.day=day;
		 this.mon=mon;
		 this.year=year;
		 this.time=time;
		 this.items_sold=items_sold;
	 }
	 
	

	public String getbill_no() {
			return bill_no;
		}
		public void setid(String bill_no) {
			this.bill_no = bill_no;
		}
		public String getday() {
			return day;
		}
		public void setday(String day) {
			this.day = day;
		}
		public String getmon() {
			return mon;
		}
		public void setmon(String mon) {
			this.mon = mon;
		}
		public String getyear() {
			return year;
		}
		public void setyear(String year) {
			this.year = year;
		}
		public String gettime() {
			return time;
		}
		public void settime(String time) {
			this.time = time;
		}
		 
		public String getitems_sold() {
			return items_sold;
		}
		public void setitems_sold(String items_sold) {
			this.items_sold = items_sold;
		}

}
