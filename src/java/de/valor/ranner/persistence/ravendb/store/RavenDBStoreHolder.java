package de.valor.ranner.persistence.ravendb.store;

import de.valor.ranner.main.validation.arguments.IArgumentValidator;
import de.valor.ranner.main.validation.arguments.NotNullArgumentValidator;
import de.valor.ranner.persistence.ravendb.store.config.RavenConfigCreationException;
import de.valor.ranner.persistence.ravendb.store.config.RavenConfigFactory;
import de.valor.ranner.persistence.ravendb.store.config.RavenStoreConfig;
import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Set;
import java.util.stream.Collectors;

public class RavenDBStoreHolder {

    private static final Logger logger = LogManager.getLogger(RavenDBStoreHolder.class);
    private static final IArgumentValidator notNullArgValidator = new NotNullArgumentValidator();

    private static final IDocumentStore documentStore = RavenDBStoreHolder.createDocumentStore();
    private static final String RAVENDB_CONFIG_NAME = "ravendb.properties";

    public static IDocumentStore getStore() {
        return documentStore;
    }

    private static IDocumentStore createDocumentStore() {
        RavenStoreConfig config = retrieveRavenStoreConfig();
        Set<String> urlSet = mapURLsToString(config.getUrlSet());
        IDocumentStore documentStore = new DocumentStore(urlSet.toArray(new String[0]), config.getDbName());
        documentStore.initialize();
        return documentStore;
    }

    private static Set<String> mapURLsToString(Set<URL> source) {
        notNullArgValidator.validateExistsStrict(source, "source");
        return source.stream()
                .map(URL::toString)
                .collect(Collectors.toSet());
    }

    private static RavenStoreConfig retrieveRavenStoreConfig() {
        try {
            return RavenConfigFactory.createRavenConfig(RAVENDB_CONFIG_NAME);
        } catch (RavenConfigCreationException e) {
            logger.error("Could not create RavenDBStoreHolder because config creation was faulty!", e);
            throw new IllegalStateException("Error creating Database store: A Backend without database is in a faulty state.", e);
        }
    }
}
