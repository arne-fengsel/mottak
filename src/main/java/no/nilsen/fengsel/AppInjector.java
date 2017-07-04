package no.nilsen.fengsel;

import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(RegistrereingsFeed.class).asEagerSingleton();
    }
}
