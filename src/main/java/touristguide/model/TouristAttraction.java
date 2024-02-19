package touristguide.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<String> tagsList;

    public TouristAttraction(String name, String description, List<String> tagsList){
        this.name = name;
        this.description = description;
        this.tagsList = tagsList;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
