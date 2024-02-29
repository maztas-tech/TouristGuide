package touristguide.service;

import org.springframework.stereotype.Service;
import touristguide.model.TouristAttraction;
import touristguide.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
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
}
