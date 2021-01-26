import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class JDBCLecture {
    public static void main(String[] args) throws SQLException {

        // url connection /localhost/ databaseName

        try {
            DriverManager.registerDriver(new Driver());

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            //============= create a statement object

            Statement stm = connection.createStatement();
            String query = "SELECT * FROM albums";
            ResultSet rs = stm.executeQuery(query);

            // ===== IF USED WITH A WHILE LOOP THE RS.NEXT() IN THE LOOP ESSENTIALLY SKIPS RECORD ONE SOOOOOOO.... CAN USE RS.beforeFirst()  ||  rs.previous() before your while loop
            rs.next(); // to start reading the first column ==== BEGINS THE ITERATION AND DOES ONE ITERATION

            //================== THIS HARD CODED WAY BASICALLY GRABS JUST THE FIRST RECORD UNLESS YOU ADD 'X' AMOUNT OF rs.next() prior to skip rows
            System.out.println(rs.getString(1)); // to get the first column ( id )
            System.out.println(rs.getString(2)); // to get the second column ( artist )
            //================

            while(rs.next()){
                System.out.println("==========");
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("artist"));
                System.out.println(rs.getString("name"));
            }


            //============== GETTING META DATA ( KEYS, COLUMN NAMES, INFO ABOUT THE STRUCTURE OF THE TABLE

            // IN DOCUMENTATION

            ResultSetMetaData rsmd = rs.getMetaData();
            // COUNT NUMBER OF COL
            int colCount = rsmd.getColumnCount();

            for(int i = 0; i <= colCount; i++){
                System.out.println(rsmd.getColumnName(i));
                // id, artist, name, release date, sales, and genres
            }


            // WORKING WITH THE ALBUM MODEL (BEAN)

            // move cursor back to beginning of result set
            rs.beforeFirst();

            // grab the first result
            rs.next();


            // create an album object based on the result set of the query
            Album album = new Album(
                    rs.getLong("id"),
                    rs.getString("artist"),
                    rs.getString("name"),
                    rs.getString("genre"),
                    rs.getDouble("sales"),
                    rs.getInt("release_date")
            );

            System.out.println(album);
            System.out.println(album.getArtist());
            System.out.println(album.getRelease_date());



        } catch (SQLException e){
            e.printStackTrace();
        }






    }
}
