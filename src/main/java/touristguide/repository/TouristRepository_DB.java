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
        String SQL = "SELECT name, description, cityName, GROUP_CONCAT(tagName) AS tags FROM tourist_attraction JOIN city ON tourist_attraction.cityID = city.cityID JOIN tourist_attraction_tag ON tourist_attraction.touristID = tourist_attraction_tag.touristID JOIN tag ON tourist_attraction_tag.tagID = tag.tagID GROUP BY tourist_attraction.name, tourist_attraction.description, city.cityName;";
        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                attractions.add(new TouristAttraction(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("cityName"),
                        List.of(rs.getString(4))));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return attractions;
    }

    public List<String> attractionTagListDB(String name){
        List<String> tags = new ArrayList<>();
        String SQL = "SELECT tag.tagName FROM tourist_attraction JOIN tourist_attraction_tag ON tourist_attraction.touristID = tourist_attraction_tag.touristID JOIN tag ON tourist_attraction_tag.tagID = tag.tagID WHERE tourist_attraction.name = ?;";

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

    public void deleteAttraction(String name){
        try(Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT touristID FROM tourist_attraction WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            int atID = 0;

            while(rs.next()) {
                atID = rs.getInt(1);
            }

            String SQLChild = "DELETE FROM tourist_attraction_tag WHERE touristID = ?";
            ps = conn.prepareStatement(SQLChild);
            ps.setInt(1, atID);
            ps.executeUpdate();

            String SQLParent = "DELETE FROM tourist_attraction WHERE touristID = ?";
            conn.prepareStatement(SQLParent);
            ps.setInt(1, atID);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
