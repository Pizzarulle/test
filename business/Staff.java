package business;
/**
 * 
 * @author Andreas
 *
 */
public class Staff {

	private String store_id, name, address, phone, email;

	public Staff() {
	}

	public Staff(String store_id, String name, String address, String phone, String email) {
		setStore_id(store_id);
		setName(name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Staff [store_id=" + store_id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}

}
