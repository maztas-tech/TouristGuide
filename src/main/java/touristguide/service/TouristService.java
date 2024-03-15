package touristguide.service;

import org.springframework.stereotype.Service;
import touristguide.model.TouristAttraction;
import touristguide.repository.TouristRepository;
import touristguide.repository.TouristRepository_DB;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository;
    private TouristRepository_DB touristRepository_db;

    public TouristService(TouristRepository touristRepository, TouristRepository_DB touristRepository_db){
        this.touristRepository = touristRepository;
        this.touristRepository_db = touristRepository_db;
    }

    public List<TouristAttraction> getTouristAttractionList(){
        return touristRepository.getTouristAttractionList();
    }
    public List<String> attractionTagsList(String touristAttractionName){
        return touristRepository.attractionTagsList(touristAttractionName);
    }

    public void addTouristAttraction(TouristAttraction touristAttraction){
        touristRepository.addTouristAttraction(touristAttraction);
    }

    public List<String> getAttractionCities(){
        return touristRepository.getAttractionCities();
    }

    public List<String> getAttractionTags(){
        return touristRepository.getAttractionTags();
    }

    public void deleteTouristAttraction(String name){
        touristRepository.deleteTouristAttraction(name);
    }

    public void updateAttraction(String name, TouristAttraction touristAttraction){
        touristRepository.updateAttraction(name, touristAttraction);
    }

    public TouristAttraction getTouristAttraction(String name){
        return touristRepository.getTouristAttraction(name);
    }
    //-----------------------------------------------------------------------------------------

    public List<TouristAttraction> getTouristAttractionDB(){
        return touristRepository_db.getAllTouristAttractions();
    }
    public List<String> getTouristAttractionTagsDB(String name){
        return touristRepository_db.attractionTagListDB(name);
    }
}
