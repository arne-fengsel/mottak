package no.nilsen.fengsel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KontrollerNavnTest {

    @Test
    public void skalRegistrerePerson() {
        assertTrue(KontrollerNavn.sjekkNavn(new Person("arne", "nilsen", "123")));
    }

}
