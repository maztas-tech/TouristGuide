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
    /*
    public void addAttractionDB(TouristAttraction touristAttraction){


        String sql = "INSERT INTO tourist_attraction(name,description,cityid) VALUES (?,?,?);";
        try (Connection conn = DriverManager.getConnection(db_url,uid,pwd)){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, touristAttraction.getName());
            ps.setString(2, touristAttraction.getDescription());
            ps.setString(3, touristAttraction.getCity());
            ps.executeUpdate();

            String sql2="UPDATE tourist_attraction-tag SET tagid=? WHERE tourist_attraction.name=?;";
            conn.prepareStatement(sql2);
            ps.setString(1,touristAttraction.getTagsList().toString());
            ps.setString(2,touristAttraction.getName());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

     */
    public void addAttractionDB(TouristAttraction touristAttraction) {
        int cityid=0;
        int touristID=0;
        String SQL1="SELECT cityID from city where cityName = ? ;";

        String sql2 = "INSERT INTO tourist_attraction (name, description, cityID) VALUES (?, ?, ?);";

        String sql3 = "SELECT touristID FROM tourist_attraction WHERE name=?; ";

        String sql4 = "UPDATE tourist_attraction_tag SET tagID = ? WHERE touristID = ?;";

        try (Connection conn = DriverManager.getConnection(db_url, uid, pwd)) {
            PreparedStatement ps = conn.prepareStatement(SQL1);
            ps.setString(1, touristAttraction.getCity());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cityid=rs.getInt(1);
            }
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, touristAttraction.getName());
            ps2.setString(2, touristAttraction.getDescription());
            ps2.setInt(3,cityid);
            ps2.executeUpdate();

            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setString(1,touristAttraction.getName());
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()){
                touristID=rs3.getInt(1);
            }

            PreparedStatement ps4 = conn.prepareStatement(sql4);
            ps4.setString(1, touristAttraction.getTagsList().toString());
            ps4.setInt(2, touristID);
            ps4.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> getAttractionTagsDB(){
        List<String> tags = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(db_url,uid,pwd)) {
            String SQL = "SELECT tagName FROM tag";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                tags.add(rs.getString("tagName"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return tags;
    }

    public List<String> getAttractionCitiesDB(){
        List<String> cities = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(db_url,uid,pwd)) {
            String SQL = "SELECT cityName FROM city";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                cities.add(rs.getString("cityName"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return cities;
    }
}
