package touristguide.repository;

import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;
import touristguide.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    final private List<String> attractionCities = new ArrayList<>(List.of(
            "København", "Odense", "Aarhus", "Roskilde",
            "Aarhus", "Aalborg", "Sønderborg"
    ));

    private List<TouristAttraction> touristAttractionList = new ArrayList<>(List.of(
            new TouristAttraction("SMK", "Statens Museum for kunst","København",List.of(
                    "Historie", "Kunst", "Litteratur"
            )),
            new TouristAttraction("Odense Zoo", "Verdens bedste zoo","Odense" ,List.of(
                    "Pingviner", "Isbjørn", "Ulve"
            )),
            new TouristAttraction("Rundetårn", "Oversigt over København", "København",List.of(
                    "Udsigt", "København", "Historie"
            )),
            new TouristAttraction("Tivoli", "Københavns øjesten", "København",List.of(
                    "Restaurant", "Forlystelser", "Fyreværkeri"
            ))

    ));

    public List<TouristAttraction> getTouristAttractionList(){
        return touristAttractionList;
    }

    public List<String> getAttractionCities(){
        return attractionCities;
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
