package no.nilsen.fengsel.rxjava;

import javax.inject.Inject;

import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import no.nilsen.fengsel.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class MottaksRessurs {

  private static final Logger logger = LoggerFactory.getLogger(MottaksRessurs.class);

  @Inject
  MottaksArbeider arbeider;

  public String motta(final Request req, final Response resp) {
    try {
      String requestBody = req.body();

      Flowable.just(requestBody)
        .subscribeOn(Schedulers.computation())
        .map(r -> new Gson().fromJson(r, Person.class))
        .subscribe(arbeider);

    } catch (final Exception e) {
      logger.error("Feil {}", e);
      resp.status(500);
    }

    return "";
  }
}
