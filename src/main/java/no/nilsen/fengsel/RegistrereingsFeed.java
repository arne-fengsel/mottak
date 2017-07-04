package no.nilsen.fengsel;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class RegistrereingsFeed<T>{
        private static final Logger logger = LoggerFactory.getLogger(RegistrereingsFeed.class);

    SyndFeedImpl feed = new SyndFeedImpl();

    public RegistrereingsFeed() {
        super();
        feed.setFeedType("rss_1.0");

        feed.setTitle("Sample Feed (created with ROME)");
        feed.setLink("http://rome.dev.java.net");
        feed.setDescription("This feed has been created using ROME (Java syndication utilities");
        final List<SyndEntry> entries = new ArrayList<>();
        feed.setEntries(entries);
    }



    public void add(final T nyInnsatt) {
        final SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("ROME v1.0");
        entry.setLink("http://wiki.java.net/bin/view/Javawsxml/Rome01");
        entry.setPublishedDate(new Date());
        final SyndContent description = new SyndContentImpl();
        description.setType("text/html");

        final XStream xstream = new XStream();
        description.setValue(xstream.toXML(nyInnsatt).toString());
        entry.setDescription(description);

        feed.getEntries().add(entry);
    }

    public String skrivFeed(final Request req, final Response resp){
        try (Writer writer = new StringWriter()){
            final SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed,writer);
            return writer.toString();
        } catch (IOException | FeedException e) {
            logger.error("Feil ved skriving av feed {}", e);
        }

        return "";
    }
    
    static class NyInnsatt {
        String fornavn;
        String ettternavn;
        String fnr;

        public NyInnsatt(final Person person) {
            fornavn = person.fornavn;
            ettternavn = person.etternavn;
            fnr = person.fnr;
        }
        
    }
}
