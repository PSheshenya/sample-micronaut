package my.sheshenya.samplemicronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class FooServiceTest {

    @Inject
    FooClient fooClient;

    @Test
    void GET_Greeting_test() {
            assertEquals(
                    "Hola, John!",
                    fooClient.greet("John").getName()
            );
    }

    @Ignore("dublicate /greeting: GET")  @Test
    void GET_Greeting_v2_test() {
            assertEquals(
                    "Hola, John!",
                    fooClient.greet_v2("John").getName()
            );
    }



    @Test
    void POST_Greeting_test() {
        assertEquals(
                "Hola, John!",
                fooClient.greetByPost(new Foo(1, "John")).getName()
        );
    }

    @Ignore("not ready yet") @Test
    void DELETE_Greeting_test() {

        HttpResponse fooHttpResponse = fooClient.deletePost();
        assertEquals(
                Optional.empty(),
                fooHttpResponse.body()
        );

        assertEquals(
                HttpStatus.NO_CONTENT,
                fooHttpResponse.status()
        );

        assertEquals(
                "Bar",
                fooHttpResponse.header("Foo")
        );
    }



}