package org.acme;

import java.time.Instant;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public TestEntity hello() {

        TestEntity entity = new TestEntity();
        entity.value = Instant.now().toString();
        entity.persist();

        return entity;
    }
}