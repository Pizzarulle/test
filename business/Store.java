package business;

/**
 * 
 * @author Andreas
 *
 */
public class Store {
	private String store_id, address, country, total_sales;

	public Store() {
	}

	public Store(String store_id, String address, String country, String total_sales) {
		setStore_id(store_id);
		setAddress(address);
		setCountry(country);
		setTotal_sales(total_sales);
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(String total_sales) {
		this.total_sales = total_sales;
	}

	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", address=" + address + ", country=" + country + ", total_sales="
				+ total_sales + "]";
	}

}
