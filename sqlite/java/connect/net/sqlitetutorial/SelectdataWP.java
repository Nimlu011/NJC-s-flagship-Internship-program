package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectdataWP{

    /**
     * Connect to the cinema_fav.db database
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
     * select all rows from the MOVIES table with parameter
     */
    public void selectAll(){
        String sql = "SELECT Movie_id, Movie_name, Lead_Actor, Lead_Actress,  Director, Year_of_Release FROM movies WHERE Lead_Actor like 'Ajay Devgan' ORDER BY Movie_id ";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("\n" + rs.getInt("Movie_id") +  "\t" + 
                                   rs.getString("Movie_name") + "\t" +
				   rs.getString("Lead_Actor") + "\t" +
				   rs.getString("Lead_Actress") + "\t" +
				   rs.getString("Director") + "\t" +
                                   rs.getString("Year_of_Release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @args the command line arguments
     */
    public static void main(String[] args) {
        SelectdataWP app = new SelectdataWP();
        app.selectAll();
    }

}