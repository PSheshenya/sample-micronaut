package my.sheshenya.samplemicronaut;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FooJob {

    private final FooService fooService;

    public FooJob(FooService fooService) {
        this.fooService = fooService;
    }

    @Scheduled(fixedDelayString = "30s")
    void printLastGreeting() {
        final Optional<Foo> lastGreeting = fooService.getLastGreeting();
        lastGreeting.ifPresent(greeting -> System.out.println("Last Greeting was = " + greeting.getName()));
    }


}