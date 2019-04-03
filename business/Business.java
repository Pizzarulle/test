package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andreas
 *
 */
public class Business {
	static ResultSet rs = null;
	
	public static List<Store> getAllStores() throws SQLException {
		List<Store> stores = new ArrayList<Store>();

		rs = JDBC.getStmt().executeQuery(

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
						+ " group by store.store_id");

		while (rs.next()) {
			stores.add(new Store(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}

		return stores;
	}
	public static List<Store> getStore(String storeId) throws SQLException {
		List<Store> stores = new ArrayList<Store>();

		rs = JDBC.getStmt().executeQuery(

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
						+ "where store.store_id = '"
						+ storeId + "'");

		while (rs.next()) {
			stores.add(new Store(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}

		return stores;
	}

	public static List<Staff> getStaff(String storeId) throws SQLException {
		List<Staff> staffs = new ArrayList<Staff>();


		rs = JDBC.getStmt().executeQuery("select  " + "	store.store_id, " + // 1
				"    sl.name, " + // 2
				"    sl.address, " + // 3
				"    sl.phone,  " + // 4
				"    staff.email     " + // 5
				"from staff_list as sl " + "	inner join store on sl.ID = store.manager_staff_id "
				+ "    inner join staff on store.manager_staff_id = staff.staff_id "
				+ "where store.store_id = '"
				+ storeId + "'");

		while (rs.next()) {
			staffs.add(new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}

		return staffs;
	}

	public static List<Payment> getStorePayments(String storeId) throws SQLException {

		List<Payment> payments = new ArrayList<>();

			rs = JDBC.getStmt().executeQuery(

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
							+ "where inventory.store_id = '" + storeId + "'");

			while (rs.next()) {
				payments.add(new Payment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));

			}

		return payments;

	}
}
