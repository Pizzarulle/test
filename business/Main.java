package business;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) throws SQLException {

		for(Store s: Business.getAllStores()) {
			System.out.println(s);
		}
		
		System.out.println("-----");
		
		for(Store s: Business.getStore("1")) {
			System.out.println(s);
			for(Staff staff: Business.getStaff(s.getStore_id())) {
				System.out.println("     " + staff);
			}
			for(Payment p: Business.getStorePayments(s.getStore_id())) {
				System.out.println(p);
			}
		}
	}
}
