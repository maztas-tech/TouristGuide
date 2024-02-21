package touristguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import touristguide.model.TouristAttraction;
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
    public String deleteAttraction(@PathVariable("name") TouristAttraction name, Model model){
        model.addAttribute("delete", touristService.deleteTouristAttraction(name));
        return "redirect:/attractions";
    }

}
