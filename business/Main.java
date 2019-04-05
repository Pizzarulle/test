package business;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) throws SQLException {
		
//		Business Business = new Business();
//
//		for(Store s: Business.getAllStores()) {
//			System.out.println(s);
//		}
//		
//		System.out.println("-----");
//		
//		for(Store s: Business.getStore("1")) {
//			System.out.println(s);
//			for(Staff staff: Business.getStaff(s.getStore_id())) {
//				System.out.println("     " + staff);
//			}
////			for(Payment p: Business.getStorePayments(s.getStore_id())) {
////				System.out.println(p);
////			}
//			
////			for(String customer: Business.getActiveCustomer("1")) {
////				System.out.println(customer);
////			}
//		}
		
		
		Business store_One = new Business("1");
		
		for(Store s: store_One.getAllStores()) {
			System.out.println(s);
		}
		
		System.out.println("-----");
		System.out.println("STORE 1");
		for(Store store : store_One.getStoreInfo()) {
			System.out.println(store);
		}
		for(Staff staff : store_One.getStaff()) {
			System.out.println("    " + staff);
		}
		
		
		
	Business store_two = new Business("2");
		
	
		System.out.println("-----");
		System.out.println("STORE 2");
		for(Store store : store_two.getStoreInfo()) {
			System.out.println(store);
		}
		for(Staff staff : store_two.getStaff()) {
			System.out.println("    " + staff);
		}
	}
}
