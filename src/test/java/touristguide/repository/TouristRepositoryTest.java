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
        //Arrange

        //Act
        //Assert
    }

    @Test
    void addTouristAttraction() {
        //Arrange
        TouristAttraction addTouristAttraction = new TouristAttraction("Jellinge sten", "Vikinge historie", "Jelling", List.of(
                "Natur", "Gratis", "Børnevenlig"
        ));

        TouristAttraction addTouristAttraction2 = new TouristAttraction("Havfruen", "Brugt som politisk budskab", "København", List.of(
                "Kunst", "Gratis", "Politik"
        ));

        TouristAttraction addTouristAttraction3 = new TouristAttraction("Amalienborg", "De kongelige", "København", List.of(
                "Gratis", "Politik", "Historie"
        ));
        //Act
        touristRepository.addTouristAttraction(addTouristAttraction, addTouristAttraction2, addTouristAttraction3);
        //touristRepository.addTouristAttraction(addTouristAttraction2);
        //touristRepository.addTouristAttraction(addTouristAttraction3);
        //Assert
        assertEquals(7, touristRepository.getTouristAttractionList().size());
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