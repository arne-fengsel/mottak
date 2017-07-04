package no.nilsen.fengsel;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @org.junit.Test
    public void skalSjekkeUgyldigPresisjonNegativt(){
        Optional<BigInteger> v = Optional.of(new BigInteger("-77"));

        assertFalse(sjekkPresisjon(v, 1));
    }

    @org.junit.Test
    public void skalSjekkeGyldigPresisjonNegativt(){
        Optional<BigInteger> v = Optional.of(new BigInteger("-7"));

        assertTrue(sjekkPresisjon(v, 1));
    }

    @org.junit.Test
    public void skalSjekkeUgyldigPresisjonPositiv(){
        Optional<BigInteger> v = Optional.of(new BigInteger("+77"));

        assertFalse(sjekkPresisjon(v, 1));
    }

    @org.junit.Test
    public void skalSjekkeGyldigPresisjonPositiv(){
        Optional<BigInteger> v = Optional.of(new BigInteger("+7"));

        assertTrue(sjekkPresisjon(v, 1));
    }

    @org.junit.Test
    public void skalSjekkePresisjonPaaNull(){
        Optional<BigInteger> v = Optional.ofNullable(null);

        assertTrue(sjekkPresisjon(v, 1));
    }


    @Test
    public void skalGruppereLike(){
        List<Dust> kilde = new ArrayList<>();
        kilde.add(new Dust(1, "a"));
        kilde.add(new Dust(1, "b"));
        kilde.add(new Dust(1, "c"));
        kilde.add(new Dust(3, "d"));
        kilde.add(new Dust(3, "e"));
        kilde.add(new Dust(2, "f"));
        kilde.add(new Dust(1, "g"));

        Map<Integer, List<Dust>> collected = kilde.stream().collect(Collectors.groupingBy(d -> d.id));

        for(List<Dust> c: collected.values()){
            c.stream().forEach(d -> System.out.print(d.id + " " + d.verdi+ " ") );
            System.out.println("");
        }

    }

    static class Dust{
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        Integer id;
        String verdi;

        public Dust(Integer id, String verdi) {
            this.id = id;
            this.verdi = verdi;
        }
    }

    public static boolean sjekkPresisjon(Optional<BigInteger> tall, int presisjon){

        return (tall.orElse(BigInteger.ZERO).abs().toString().length() <= presisjon);
    }



}
