package touristguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import touristguide.model.TouristAttraction;
import touristguide.service.TouristService;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }
    /*
    Print out the tourist attractions
     */
    @GetMapping("")
    public String getTouristAttractions(Model model){
        model.addAttribute("attractions", touristService.getTouristAttractionList());
        return "attractionList";
    }

    /*
    Getting the tags for the individual attractions.
     */
    @GetMapping("/{name}/tags")
    public String tags(@PathVariable("name") String name, Model model){
        model.addAttribute("tags", touristService.attractionTagsList(name));
        return "tags";
    }


    @GetMapping("/add")
    public String addAttraction(Model model){
        model.addAttribute("attractionObject", new TouristAttraction());
        model.addAttribute("attractionCities", touristService.getAttractionCities());
        model.addAttribute("attractionTags", touristService.getAttractionTags());
        return "add";
    }

    @PostMapping("/add")
    public String addedAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.addTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/delete")
    public String deleteAttraction(@PathVariable("name") String name){
        touristService.deleteTouristAttraction(name);
        return "redirect:/attractions";
    }
    /*
        - GetMapping -> få mig herhen
        - Alle metoder i getmapping -> prop de her værdier på den side jeg gerne vil til
        - returner mig til siden som er skrevet i string værdien der også er defineret som html siden
     */
    @GetMapping("/{name}/updateAttraction")
    public String updateAttration(@PathVariable("name") String name, Model model){
        TouristAttraction abc = touristService.getTouristAttraction(name);

        model.addAttribute("updateObject", touristService.getTouristAttraction(name));
        model.addAttribute("attractionTags", touristService.getAttractionTags());
        return "updateAttraction";
    }

    @PostMapping("/updateAttraction")
    public String updatedAttraction(@ModelAttribute TouristAttraction updatedTouristAttraction){
        touristService.updateAttraction(updatedTouristAttraction.getName(), updatedTouristAttraction);
        return "redirect:/attractions";
    }
}
