package no.nilsen.fengsel;

import java.util.UUID;

public class Person {


    private final UUID id;
    public final String fornavn;
    public final String etternavn;
    public final String fnr;

    public Person(final String fornavn, final String etternavn, final String fnr) {
        super();
        id = UUID.randomUUID();
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fnr = fnr;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", fnr=" + fnr + "]";
    }

}
