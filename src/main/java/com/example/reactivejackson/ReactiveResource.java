package com.example.reactivejackson;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpMethod;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RouteBase(path = "/reactive-jackson")
public class ReactiveResource {


    public ReactiveResource() {
    }

    @Route(path = "quarks", methods = HttpMethod.GET)
    public Uni<Quark> get() {
        return Uni.createFrom().item(new Quark("???", null));
    }

}
