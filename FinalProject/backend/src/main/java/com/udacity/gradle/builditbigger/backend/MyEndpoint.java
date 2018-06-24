package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.zflabs.jokeprovider.Joke;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** A simple endpoint method that tells a Joke*/
    @ApiMethod(name = "tellJoke")
    public JokeContainer tellJoke() {
        JokeContainer response = new JokeContainer();
        response.setData(Joke.giveMeJoke());
        return response;
    }

}
