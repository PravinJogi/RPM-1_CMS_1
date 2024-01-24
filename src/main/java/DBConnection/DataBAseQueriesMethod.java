package DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBAseQueriesMethod {

	Properties prop;
	String eventID;
	// DB Connection variable
	public static String Sale_Event_ID;
	public String eventUpdateQuery;
	static Connection connection = null;
	static String databaseName = "Sale_Event";
	static String url = "jdbc:mysql://wci-qa-db-cluster.cluster-cudofuostxaw.us-west-2.rds.amazonaws.com:3306/Sale_Event";
	static String userName = "wci_qa_rw";
	static String password = "wciqa#rw";

	public void fetchSaleEventID() {
		try {
			File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

			eventID = prop.getProperty("CITSS_Event_ID");
//			System.out.println(eventID);
			String query = "Select * from Sale_Event.Sale_Event Where CITSS_Event_id='" + eventID + "';";

			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				Sale_Event_ID = res.getString(1);
				System.out.println("Sale_Event_ID: " + Sale_Event_ID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCittsEventID() throws SQLException {
		Statement st = connection.createStatement();
		DataBAseQueriesMethod ref = new DataBAseQueriesMethod();
		ref.fetchSaleEventID();
//		String query = "Select * from Sale_Event.Sale_Event Where CITSS_Event_id='" + eventID + "';";
//		st.executeQuery(query);
		eventUpdateQuery = "UPDATE `Sale_Event`.`Sale_Event` SET `CITSS_Event_ID` = '2' WHERE (`Sale_Event_ID` = '"+Sale_Event_ID+"');";
		st.executeUpdate(eventUpdateQuery);
	}
	

	public static  void setConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// To set the connection
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("connection done successfully");
//			java.sql.Statement st = connection.createStatement();

	}

	public static void updateAllFeilds() throws SQLException {
		DataBAseQueriesMethod ref = new DataBAseQueriesMethod();
		ref.fetchSaleEventID();

		// Upload HL and PL
		String query1 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Holding_Limit_Current` = '11598000', `Purchase_Limit_Current` = '5000', `Holding_Limit_Future` = '0', `Purchase_Limit_Future` = '0',Bond_Bid_Guarantee_Value='0' WHERE (fsa_Account_Number ='QC4446-5674' and Sale_Event_ID ='"
				+ Sale_Event_ID + "');";
		String query2 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Holding_Limit_Current` = '11598000', `Purchase_Limit_Current` = '5000', `Holding_Limit_Future` = '0', `Purchase_Limit_Future` = '0',Bond_Bid_Guarantee_Value='0' WHERE (fsa_Account_Number ='QC4448-5678' and Sale_Event_ID ='"
				+ Sale_Event_ID + "');";
		String query3 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Holding_Limit_Current` = '11598000', `Purchase_Limit_Current` = '5000', `Holding_Limit_Future` = '0', `Purchase_Limit_Future` = '0',Bond_Bid_Guarantee_Value='0' WHERE (fsa_Account_Number ='CA4376-5560' and Sale_Event_ID ='"
				+ Sale_Event_ID + "');";
		String query4 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Holding_Limit_Current` = '11598000', `Purchase_Limit_Current` = '5000', `Holding_Limit_Future` = '0', `Purchase_Limit_Future` = '0',Bond_Bid_Guarantee_Value='0' WHERE (fsa_Account_Number ='CA4377-5562' and Sale_Event_ID ='"
				+ Sale_Event_ID + "');";
		String query5 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Holding_Limit_Current` = '11598000', `Purchase_Limit_Current` = '5000', `Holding_Limit_Future` = '0', `Purchase_Limit_Future` = '0',Bond_Bid_Guarantee_Value='0' WHERE (fsa_Account_Number ='CA4378-5564' and Sale_Event_ID ='"
				+ Sale_Event_ID + "');";

//		Upload Bid Guarantee
		String query6 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Cash_Bid_Guarantee` = '1000000' , Letter_Of_Credit_Bid_Guarantee_Value='0' Where fsa_Account_Number ='QC4446-5674' and Sale_Event_Id='"
				+ Sale_Event_ID + "';";
		String query7 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Cash_Bid_Guarantee` = '90000' , Letter_Of_Credit_Bid_Guarantee_Value='0' Where fsa_Account_Number ='QC4448-5678' and Sale_Event_Id='"
				+ Sale_Event_ID + "';";
		String query8 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Cash_Bid_Guarantee` = '65000' , Letter_Of_Credit_Bid_Guarantee_Value='0' Where fsa_Account_Number ='CA4376-5560' and Sale_Event_Id='"
				+ Sale_Event_ID + "';";
		String query9 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Cash_Bid_Guarantee` = '90000' , Letter_Of_Credit_Bid_Guarantee_Value='0' Where fsa_Account_Number ='CA4377-5562' and Sale_Event_Id='"
				+ Sale_Event_ID + "';";
		String query10 = "UPDATE `Sale_Event`.`Sale_Event_Account` SET `Cash_Bid_Guarantee` = '200000' , Letter_Of_Credit_Bid_Guarantee_Value='0' Where fsa_Account_Number ='CA4378-5564' and Sale_Event_Id='"
				+ Sale_Event_ID + "';";

		System.out.println(query1);
		Statement st = connection.createStatement();
		st.executeUpdate(query1);
		st.executeUpdate(query2);
		st.executeUpdate(query3);
		st.executeUpdate(query4);
		st.executeUpdate(query5);
		st.executeUpdate(query6);
		st.executeUpdate(query7);
		st.executeUpdate(query8);
		st.executeUpdate(query9);
		st.executeUpdate(query10);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		// To set the connection
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("connection done successfully");
//		java.sql.Statement st = connection.createStatement();

		DataBAseQueriesMethod ref = new DataBAseQueriesMethod();
//		ref.updateCittsEventID();
		ref.updateAllFeilds();
	}

}
