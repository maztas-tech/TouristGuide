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

    public List<TouristAttraction> addTouristAttraction(TouristAttraction touristAttraction){
        return touristRepository.addTouristAttraction(touristAttraction);
    }

    public List<String> getAttractionCities(){
        return touristRepository.getAttractionCities();
    }

    public List<String> getAttractionTags(){
        return touristRepository.getAttractionTags();
    }

    public List<TouristAttraction> deleteTouristAttraction(TouristAttraction touristAttraction){
        return touristRepository.deleteTouristAttraction(touristAttraction);
    }
}
