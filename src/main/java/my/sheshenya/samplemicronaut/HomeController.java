package my.sheshenya.samplemicronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import org.springframework.ui.Model;

//import io.micronaut.security.annotation.Secured;
//import io.micronaut.security.rules.SecurityRule;

@Controller("/")
public class HomeController {

    //@Secured(SecurityRule.IS_ANONYMOUS)
    @View("home")
    @Get(uri = "/", produces = "text/html")
    public String home(final Model model) {
//  public Map<String, Object> index() {
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