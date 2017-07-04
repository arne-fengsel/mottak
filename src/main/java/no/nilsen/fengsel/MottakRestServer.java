package no.nilsen.fengsel;

import no.nilsen.fengsel.rxjava.MottaksRessurs;

import static spark.Spark.get;
import static spark.Spark.post;

import javax.inject.Inject;

public class MottakRestServer {

    @Inject
    MottaksRessurs mottak;

    @Inject
    RegistrereingsFeed registreringsFeed;

    public void start() {
        post("/mottak", mottak::motta);
        get("/registrerte", registreringsFeed::skrivFeed);
    }
}
