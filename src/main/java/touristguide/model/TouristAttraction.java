package touristguide.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private String by;
    private List<String> tagsList;

    public TouristAttraction(String name, String description, String by ,List<String> tagsList){
        this.name = name;
        this.description = description;
        this.by = by;
        this.tagsList = tagsList;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
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
