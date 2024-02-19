package touristguide.repository;

import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;
import touristguide.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(
            new TouristAttraction("SMK", "Statens Museum for kunst", List.of(
                    "Historie", "Kunst", "Litteratur"
            )),
            new TouristAttraction("Odense Zoo", "Verdens bedste zoo", List.of(
                    "Pingviner", "Isbjørn", "Ulve"
            )),
            new TouristAttraction("Rundetårn", "Oversigt over København", List.of(
                    "Udsigt", "København", "Historie"
            )),
            new TouristAttraction("Tivoli", "Københavns øjesten", List.of(
                    "Restaurant", "Forlystelser", "Fyreværkeri"
            ))

    ));

    public List<TouristAttraction> getTouristAttractionList(){
        return touristAttractionList;
    }

    public List<String> attractionTagsList(String touristAttractionName){
        for (TouristAttraction touristAttraction : touristAttractionList){
            if (touristAttraction.getName().contains(touristAttractionName)){
                return touristAttraction.getTagsList();
            }
        }
        return null;
    }

    public List<TouristAttraction> addTouristAttraction(TouristAttraction touristAttraction){
        touristAttractionList.add(touristAttraction);
        return touristAttractionList;
    }



}
