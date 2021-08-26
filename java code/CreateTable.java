package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite\\db\\cinema_fav.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
                + "	Movie_id integer PRIMARY KEY,\n"
                + "	Movie_name text NOT NULL,\n"
                + "	Lead_Actor text NOT NULL,\n"
		+ "	Lead_Actress text NOT NULL,\n"
		+ "	Director text NOT NULL,\n"
		+ "	Year_of_Release date NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement Stmt = conn.createStatement()) {
            // create a new table
            Stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}