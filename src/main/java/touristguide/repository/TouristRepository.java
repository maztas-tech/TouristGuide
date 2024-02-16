package touristguide.repository;

import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;
import touristguide.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(
            new TouristAttraction("SMK", "Statens Museum for kunst"),
            new TouristAttraction("Odense Zoo", "Verdens bedste zoo"),
            new TouristAttraction("Rundetårn", "Oversigt over København"),
            new TouristAttraction("Tivoli", "Københavns øjesten")

    ));

    public List<TouristAttraction> getTouristAttractionList(){
        return touristAttractionList;
    }




}
