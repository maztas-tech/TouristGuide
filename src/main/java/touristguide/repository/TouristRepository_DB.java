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
        String SQL = "SELECT * FROM tourist_attraction;";
        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)){
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

    public List<String> attractionTagListDB(String name){
        List<String> tags = new ArrayList<>();
        String SQL = "SELECT tag.tagName FROM tourist_attraction " +
                "JOIN tag " +
                "JOIN tourist_attraction_tag " +
                "ON tag.tagID = tourist_attraction_tag.tagID AND tourist_attraction.touristID = tourist_attraction_tag.touristID AND tourist_attraction.name = ?";

        try(Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tags.add(rs.getString(1));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return tags;
    }
}
