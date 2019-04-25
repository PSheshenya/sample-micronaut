package my.sheshenya.samplemicronaut;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
//import io.micronaut.security.annotation.Secured;
//import io.micronaut.security.rules.SecurityRule;
//import io.micronaut.views.View;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    //@Secured(SecurityRule.IS_ANONYMOUS)
    //@View("home")
    @Get
    public Map<String, Object> index() {
        return new HashMap<>();
    }


    @Get(uri = "/", produces = "text/html")
    public String home(final Model model) {
        model.addAttribute(
                "message",
                "Welcome to Micronaut for Spring");

        return "home";
    }



//    @Get
//    HttpResponse index() {
//        HttpResponse.status(HttpStatus.UNAUTHORIZED).body([
//                status: 401,
//                error: 'Unauthorized',
//                message: 'No message available',
//                path: '/api/announcements'])
//    }
}