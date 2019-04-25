package my.sheshenya.samplemicronaut;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Validated
public class FooService {

    private final AtomicLong counter = new AtomicLong();

    private final FooConfiguration fooConfiguration;

    private AtomicReference<Foo> lastGreeting = new AtomicReference<>();

    public FooService(FooConfiguration fooConfiguration) {
        this.fooConfiguration = fooConfiguration;
    }

    public Foo greeting( @Pattern(regexp = "\\D+") String name) {
        final Foo greeting = new Foo(counter.incrementAndGet(),
                String.format(fooConfiguration.getTemplate(), name));
        lastGreeting.set(greeting);
        return greeting;
    }

    public Optional<Foo> getLastGreeting() {
        return Optional.ofNullable(lastGreeting.get());
    }
}