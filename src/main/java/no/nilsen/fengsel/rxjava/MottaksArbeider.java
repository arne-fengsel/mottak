package no.nilsen.fengsel.rxjava;

import no.nilsen.fengsel.Person;
import no.nilsen.fengsel.RegistrereingsFeed;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static no.nilsen.fengsel.KontrollerNavn.sjekkNavn;

public class MottaksArbeider implements Subscriber<Person> {

    private static final Logger logger = LoggerFactory.getLogger(MottaksArbeider.class);

    @Inject
    RegistrereingsFeed feed;

    @Override
    public void onError(final Throwable error) {
        logger.error("Registrering feilet. {}", error);
    }

    @Override
    public void onComplete() {
        logger.info("Ferdig.");
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        logger.info("Abonnerer på {}", subscription);
    }

    @Override
    public void onNext(Person person) {
        try {

            if(person.fnr.length() != 11)      {
                Thread.sleep(5000L);
            }else{
                Thread.sleep(10000L);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sjekkNavn(person);

        feed.add(person);
        logger.info("Registrerer {}", person);
    }
}
