package my.sheshenya.samplemicronaut;


import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;

import javax.annotation.Nullable;

@Client("/foo")
public interface FooClient {

    @Version("1")
    @Get("/greeting{?name}")
    Foo greet(@Nullable String name);

    @Version("2")
    @Get("/greeting{?name}")
    Foo greet_v2(@Nullable String name);

    @Post("/greeting")
    Foo greetByPost(@Body Foo greeting);

    @Delete("/greeting")
    @Header(name = "Foo", value = "Bar")
    HttpResponse deletePost();
//
//    @Get("/nested/greeting{?name}")
//    Foo nestedGreet(@Nullable String name);
//
//    @Get("/greeting-status{?name}")
//    ResponseEntity<Foo> greetWithStatus(@Nullable String name);
}