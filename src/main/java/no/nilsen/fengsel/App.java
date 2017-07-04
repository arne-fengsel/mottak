package no.nilsen.fengsel;

import com.google.inject.Guice;

/**
 * Hello world!
 *
 */
public class App {

    private App() {
        final MottakRestServer ruter = Guice.createInjector(new AppInjector()).getInstance(MottakRestServer.class);
        ruter.start();
    }

    public static void main(final String[] args) {
        new App();
    }
}
