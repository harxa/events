package fi.jamk.student.events.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fi.jamk.student.events.domain.Event;
import fi.jamk.student.events.domain.EventRepository;


@Controller
public class EventController {
	@Autowired
	private EventRepository repository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
	} 
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String greetings(Model model) {
        return "index";
    }
    
    @RequestMapping(value="/eventlist", method=RequestMethod.GET)
    public String EventList(Model model) {
    	model.addAttribute("events", repository.findAll());
        return "eventlist";
    }
    
/*    @RequestMapping(value="/eventmap", method=RequestMethod.GET)
    public ModelAndView getPages(HttpServletRequest request) {
        Geolocation geoloc = geolocDAO.get();
        ModelAndView model = new ModelAndView("map");
        List<Geolocation> listGeo = geolocDAO.list();
        model.addObject("listGeo", listGeo);
        return model;
    }*/
    @RequestMapping(value="/eventmap", method=RequestMethod.GET)
    public String EventMap(Model model) {
    	model.addAttribute("events", repository.findAll());
        return "eventmap";
    }
	
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Event event){
        repository.save(event);
        return "redirect:eventlist";
    }  
}
