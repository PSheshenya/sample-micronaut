package my.sheshenya.samplemicronaut;

import io.micronaut.core.convert.ArgumentConversionContext;
import io.micronaut.core.convert.value.MutableConvertibleValues;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.*;

@Controller("/foo")
@Validated
public class FooController {

    @Inject
    private FooService fooService;

//    public FooController(FooService fooService) {
//        this.fooService = fooService;
//    }

    @Get("/greeting")
    @Version("1")
    @CircuitBreaker(reset = "3s")
    public Foo greeting(@RequestParam(value="name", defaultValue="World") @Pattern(regexp = "\\D+") String name) throws InterruptedException {

        Thread.sleep(5000);
        return fooService.greeting(name);
    }

    @Get("/greeting")
    @Version("2")
    @CircuitBreaker(reset = "3s")
    public Foo greeting_v2(@RequestParam(value="name", defaultValue="World v2") @Pattern(regexp = "\\D+") String name)  {

        return fooService.greeting(name);
    }

    @Post("/greeting")
    public Foo greetingByPost(@Body @Valid Foo greeting) {
        return fooService.greeting(greeting.getName());
    }

    @Delete("/greeting")
    @Hidden
    public HttpResponse deleteGreeting() {

        //MutableHttpResponse
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Foo", Arrays.asList("Bar"));

        return new HttpResponse() {
            @Override
            public io.micronaut.http.HttpStatus getStatus() {
                return HttpStatus.NO_CONTENT;
            }

            @Nonnull
            @Override
            public HttpHeaders getHeaders() {

                return new HttpHeaders() {
                    @Override
                    public List<String> getAll(CharSequence name) {
                        return headers.get(name);
                    }

                    @Nullable
                    @Override
                    public String get(CharSequence name) {
                        return headers.get(name) != null ? headers.get(name).get(0) : null;
                    }

                    @Override
                    public Set<String> names() {
                        return headers.keySet();
                    }

                    @Override
                    public Collection<List<String>> values() {
                        return headers.values();
                    }

                    @Override
                    public <T> Optional<T> get(CharSequence name, ArgumentConversionContext<T> conversionContext) {
                        return Optional.empty();
                    }
                };
            }

            @Nonnull
            @Override
            public MutableConvertibleValues<Object> getAttributes() {
                return null;
            }

            @Nonnull
            @Override
            public Optional getBody() {
                return Optional.empty();
            }
        };
    }

//    @Delete("/greeting")
//    @Hidden
//    public ResponseEntity<?> deleteGreeting() {
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("Foo", "Bar");
//        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
//    }

}