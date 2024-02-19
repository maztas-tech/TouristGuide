package touristguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import touristguide.service.TouristService;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getTouristAttractions(Model model){
        model.addAttribute("attractions", touristService.getTouristAttractionList());
        return "attractionList";
    }

    @GetMapping("/{name}/tags")
    public String tags(@PathVariable("name") String name, Model model){
        model.addAttribute("tags", touristService.attractionTagsList(name));
        return "tags";
    }

}
