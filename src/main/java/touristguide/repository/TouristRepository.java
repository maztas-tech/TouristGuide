package touristguide.repository;

import org.springframework.stereotype.Repository;
import touristguide.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    final private List<String> attractionCities = new ArrayList<>(List.of(
            "København", "Odense", "Aarhus", "Roskilde",
            "Aarhus", "Aalborg", "Sønderborg", "Jelling", "Randers", "Billund"
    ));

    final private List<String> attractionTags = new ArrayList<>(List.of(
            "Børnevenlig", "Gratis", "Gebyr", "Kunst", "Natur"
    ));

    final private List<String> emptyAttractionTags = new ArrayList<>();

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

    public List<String> getAttractionTags(){
        return attractionTags;
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

    public List<TouristAttraction> deleteTouristAttraction(String name){
        for (TouristAttraction attraction: touristAttractionList){
            if (attraction.getName().contains(name)){
                touristAttractionList.remove(attraction);
                return touristAttractionList;
            }
        }
        return null;
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction){
        for (TouristAttraction attraction: touristAttractionList){
            if (attraction.getName().contains(name)){
                attraction.setDescription(updatedAttraction.getDescription());
                attraction.setCity(updatedAttraction.getCity());
                attraction.setTagsList(updatedAttraction.getTagsList());

                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction getTouristAttraction(String name){
        for (TouristAttraction touristAttraction : touristAttractionList){
            if (touristAttraction.getName().contains(name)){
                return touristAttraction;
            }
        }
        return null;
    }



}
