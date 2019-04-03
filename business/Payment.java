package business;
/**
 * 
 * @author Andreas
 *
 */
public class Payment {

	private String payment_id, first_name, last_name, title, amount, payment_date, return_date;

	public Payment(String payment_id, String first_name, String last_name, String title, String amount,
			String payment_date, String return_date) {
		setPayment_id(payment_id);
		setFirst_name(first_name);
		setLast_name(last_name);
		setTitle(title);
		setAmount(amount);
		setPayment_date(payment_date);
		setReturn_date(return_date);
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		
		if(return_date == null) {
			return_date = "";
		}
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", title=" + title + ", amount=" + amount + ", payment_date=" + payment_date + ", return_date="
				+ return_date + "]";
	}
	

}
