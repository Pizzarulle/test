package business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnector;

/**
 * 
 * @author Andreas
 *
 */
public class Business {
	private static ResultSet rs = null;
	private static PreparedStatement stmt = null;
	private static String storeId;
	
	public Business(String storeId) {
		Business.storeId = storeId;
	}

	/**
	 * @return List of all active customer names associated with the storeId.
	 */
	public  List<String> getActiveCustomer() throws SQLException {
		List<String> customers = new ArrayList<String>();

		stmt = JDBCConnector.getInstance()
				.createStatement("select distinct  " + "		concat(first_name, ' ', last_name) as name "
						+ "from customer " + "where store_id = ? and active = '1'");

		stmt.setString(1, storeId);
		rs = stmt.executeQuery();

		while (rs.next()) {
			customers.add(rs.getString(1));
		}
		return customers;
	}

	/**
	 * @return List of all stores.
	 */
	public List<Store> getAllStores() throws SQLException {
		List<Store> stores = new ArrayList<Store>();

		rs = JDBCConnector.getInstance().createStatement(

				"select distinct " + "	store.store_id, " + // 1
						"	address.address, " + // 2
						"    concat(city.city, ', ' , country.country) as country, " + // 3
						"    sum(payment.amount) as total_sales " + // 4
						"from store " + "	inner join address on store.address_id = address.address_id "
						+ "	inner join city on address.city_id = city.city_id "
						+ "	inner join country on city.country_id = country.country_id "
						+ "	inner join inventory on store.store_id = inventory.store_id "
						+ "    inner join rental on inventory.inventory_id = rental.inventory_id "
						+ "    inner join payment on rental.rental_id = payment.rental_id "
						+ " group by store.store_id")
				.executeQuery();

		while (rs.next()) {
			stores.add(new Store(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}

		return stores;
	}
	/**
	 * @return List containing one store-object thats associated with the storeId.
	 */
	public  List<Store> getStoreInfo() throws SQLException {
		List<Store> stores = new ArrayList<Store>();

		stmt = JDBCConnector.getInstance().createStatement(

				"select distinct " + "	store.store_id, " + // 1
						"	address.address, " + // 2
						"    concat(city.city, ', ' , country.country) as country, " + // 3
						"    sum(payment.amount) as total_sales " + // 4
						"from store " + "	inner join address on store.address_id = address.address_id "
						+ "	inner join city on address.city_id = city.city_id "
						+ "	inner join country on city.country_id = country.country_id "
						+ "	inner join inventory on store.store_id = inventory.store_id "
						+ "    inner join rental on inventory.inventory_id = rental.inventory_id "
						+ "    inner join payment on rental.rental_id = payment.rental_id "
						+ "where store.store_id = ?");

		stmt.setString(1, storeId);
		rs = stmt.executeQuery();

		while (rs.next()) {
			stores.add(new Store(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}

		return stores;
	}
	/**
	 * @return List of all staff members associated with the storeId.
	 */
	public  List<Staff> getStaff() throws SQLException {
		List<Staff> staffs = new ArrayList<Staff>();

		stmt = JDBCConnector.getInstance().createStatement(

				"select  " + "	store.store_id, " + // 1
						"    sl.name, " + // 2
						"    sl.address, " + // 3
						"    sl.phone,  " + // 4
						"    staff.email     " + // 5
						"from staff_list as sl " + "	inner join store on sl.ID = store.manager_staff_id "
						+ "    inner join staff on store.manager_staff_id = staff.staff_id "
						+ "where store.store_id = ?");

		stmt.setString(1, storeId);
		rs = stmt.executeQuery();

		while (rs.next()) {
			staffs.add(new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}

		return staffs;
	}

	/**
	 * @return List of all payments associated with the storeId.
	 */
	public  List<Payment> getStorePayments() throws SQLException {
		List<Payment> payments = new ArrayList<>();

		stmt = JDBCConnector.getInstance().createStatement(

				"select" + "	payment_id, " + // 1
						"	first_name, " + // 2
						"	last_name, " + // 3
						"	title, " + // 4
						"	amount, " + // 5
						"	payment_date, " + // 6
						"	return_date " + // 7
						"from payment " + "	inner join customer on payment.customer_id = customer.customer_id "
						+ "	inner join rental on payment.rental_id = rental.rental_id "
						+ "	inner join inventory on rental.inventory_id = inventory.inventory_id "
						+ "	inner join film_text on inventory.film_id = film_text.film_id "
						+ "where store.store_id = ?");

		stmt.setString(1, storeId);
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			payments.add(new Payment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7)));

		}

		return payments;

	}
}
