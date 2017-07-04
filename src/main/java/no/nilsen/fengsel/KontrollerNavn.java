package no.nilsen.fengsel;

import javax.inject.Inject;

public class KontrollerNavn {

    private static final String EMPTY = "";


    public static boolean sjekkNavn(final Person person) {
        if (person == null) {
            return false;
        }

        if (EMPTY.equals(person.fornavn) || EMPTY.equals(person.etternavn) || EMPTY.equals(person.fnr)) {
            throw new IllegalArgumentException("Mangler person " + person);
        }

        return true;
    }
}
