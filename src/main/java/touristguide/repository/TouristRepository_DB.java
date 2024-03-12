package touristguide.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import touristguide.model.TouristAttraction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository_DB {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;



    //Read all objects in the database
    public List<TouristAttraction> getAllTouristAttractions(){
        List<TouristAttraction> attractions = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)){
            String SQL = "SELECT * FROM tourist_attraction;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                attractions.add(new TouristAttraction(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("city"),
                        List.of(rs.getString(4))));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return attractions;

    }
}
