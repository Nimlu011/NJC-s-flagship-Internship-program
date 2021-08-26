package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class InsertData{

    /**
     * Connect to the cinema_fav.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite\\db\\cinema_fav.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the MOVIES table
     *
     */
    public void insert(String Movie_name, String Lead_Actor, String Lead_Actress, String Director, String Year_of_Release) {
        String sql = "INSERT INTO movies(Movie_name,Lead_Actor,Lead_Actress,Director,Year_of_Release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Movie_name);
            pstmt.setString(2, Lead_Actor);
            pstmt.setString(3, Lead_Actress);
            pstmt.setString(4, Director);
            pstmt.setString(5, Year_of_Release);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * args the command line arguments
     */
    public static void main(String[] args) {

        InsertData app = new InsertData();
        // inserting 15 new rows
        app.insert("K.G.F: Chapter 1","Yash","Srinidhi Shetty","Prashanth Neel","21-December-2018");

	app.insert("Tum Bin","Priyanshu Chatterjee","Sandali Sinha","Anubhav Sinha","13-July-2001");

	app.insert("Baahubali: The Beginning", "Prabhas", "Anushka Shetty", "S. S. Rajamouli","10-July-2015");

	app.insert("Baahubali 2: The Conclusion","Prabhas","Anushka Shetty","S. S. Rajamouli","28-April-2017");

	app.insert("Junglee","Vidyut Jammwal","Pooja Sawant","Chuck Russell","29-March-2019");

	app.insert("Dangal","Aamir Khan","Fatima Sana Shaikh","Nitesh Tiwari","23-December-2016");

	app.insert("3 Idiots","Aamir Khan","Kareena Kapoo","Rajkumar Hirani","25-December-2009");

	app.insert("Thugs of Hindostan","Aamir Khan","Fatima Sana Shaikh","Vijay Krishna Acharya","8-November-2018");

	app.insert("Lagaan","Aamir Khan","Gracy Singh","Ashutosh Gowariker","15-June-2001");

	app.insert("Mangal Pandey: The Rising","Aamir Khan","Rani Mukerji","Ketan Mehta","12-August-2005");

	app.insert("Drishyam","Ajay Devgan","Tabu","Nishikant Kamat","31-July-2015");

	app.insert("Shivaay","Ajay Devgan","Erika Kaar","Ajay Devgn","28-October-2016");

	app.insert("Raid","Ajay Devgan","Ileana D Cruz","Raj Kumar Gupta","16-March-2018");

	app.insert("Tanhaji","Ajay Devgan","Kajol","Om Raut","10-January-2020");

	app.insert("Kesari","Akshay Kumar","Parineeti Chopra","Anurag Singh","21-March-2019");
 
}

}