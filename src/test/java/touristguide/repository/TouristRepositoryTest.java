package touristguide.repository;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import touristguide.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {
    private TouristRepository touristRepository;
    private TouristAttraction touristAttraction;

    @BeforeEach
    void setTouristRepository(){
        touristRepository = new TouristRepository();
        touristAttraction = new TouristAttraction();
    }
    @Test
    void touristAttractionListSize() {
        //Arrange
        List<TouristAttraction> sizeOfList = touristRepository.getTouristAttractionList();
        //Act
        int actualSizeOfList = sizeOfList.size();
        //Assert
        assertEquals(4, actualSizeOfList);

    }

    @Test
    void getAttractionCities() {
        //Arrange
        List<String> getNameOfCities = touristRepository.getAttractionCities();
        String actualCityName = "København";
        boolean doesExist = false;
        //Act
        for (String touristAttraction : getNameOfCities){
            if (actualCityName.equalsIgnoreCase(touristAttraction)){
                doesExist = true;
                break;
            }
        }
        //Assert
        assertTrue(doesExist);
    }

    @Test
    void getAttractionTags() {
        //Arrange
        List<String> actualTags = touristRepository.getAttractionTags();
        //Act
        List<String> expectedTags = new ArrayList<>(List.of(
                "Børnevenlig", "Gratis",
                "Gebyr", "Kunst", "Natur"));
        //Assert

        assertEquals(expectedTags, actualTags);
    }

    @Test
    void attractionTagsList() {
    }

    @Test
    void addTouristAttraction() {
    }

    @Test
    void deleteTouristAttraction() {
    }

    @Test
    void updateAttraction() {

    }

    @Test
    void getTouristAttraction() {
    }
}