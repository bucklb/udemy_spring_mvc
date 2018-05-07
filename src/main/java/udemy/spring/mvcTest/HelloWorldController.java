package udemy.spring.mvcTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

// BB : Flag that this is something that can act as a controller (and therefore have requests directed at it)
//      and allow specification of the root URL (so could distinguish between PSM and CM URLs that go to different controllers)
@RequestMapping("")     // parent mapping (so could be /claims or /schedules etc to divvy up the mappings (which will be RELATIVE to this)
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/showForm")
    public String showTheForm(){
        return "hwForm";
    }

    @RequestMapping(value = "/processForm")
    public String processTheForm(HttpServletRequest request,   ModelMap model){

        // Note - can get the parameter passed in directly (so the "extract" code is in the call).  Why?
        // This binds the "parameter" and the variable ?? Two way traffic - update to variable updates param's value ??
        // public String processTheForm(@RequestParam("theName") String theName, ModelMap model){}

        String theName=request.getParameter("theName");
        model.addAttribute("name", "Senor "+theName.toUpperCase() );
        return "hw";
    }



    // BB : Initially we'll repond to EVERYTHING that's a GET with the the same "I heard you" style response.
    //      ?? Scope to allow summat else to handle a POST/PUT/DELETE etc ??
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {

        // BB : set an attribute (key/value) to be used in displaying the page/view that we tell the system to use
        //      so in this case use key=message, value=I heard ..., view= ...randomCrap...jsp
        model.addAttribute("message", "I heard you, already!");

        // BB : there could be MANY key pairs we set.  Definitely need not be just one!

        // BB : Looks like what we return is used to specify the page to be displayed next.
        //      ?? Returned value gets merged with prefix/suffix as defined in our context servlet (currently WEB-INF/mvcTest.xml)
        //      so likely to become /WEB-INF/view/<return value>.jsp
        return "index";
    }
}