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
}
