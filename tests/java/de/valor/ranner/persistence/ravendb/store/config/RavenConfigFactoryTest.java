package de.valor.ranner.persistence.ravendb.store.config;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RavenConfigFactoryTest {

    private final String validConfigPath = "validRavenConfig.properties";

    @Test
    void createRavenConfigFactory() {
        new RavenConfigFactory();
    }

    @Test
    void createRavenConfigValid() throws RavenConfigCreationException {
        assertNotNull(RavenConfigFactory.createRavenConfig(validConfigPath));
    }

    @Test
    void checkValidConfigDbName() throws RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfigPath);
        assertEquals("RannerTestDB", config.getDbName());
    }

    @Test
    void checkValidConfigUrls() throws MalformedURLException, RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfigPath);
        URL firstNodeURL = new URL("http://127.0.0.1:8085");
        URL secondNodeURL = new URL("http://127.0.0.1:8086");
        URL thirdNodeURL = new URL("https://someValidOtherUrl.com");
        Set<URL> urlSet = new HashSet<>();
        urlSet.add(firstNodeURL);
        urlSet.add(thirdNodeURL);
        urlSet.add(secondNodeURL);
        assertEquals(urlSet, config.getUrlSet());
    }

    @Test
    void checkValidConfigURL() throws MalformedURLException, RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig("validSingleURLRavenConfig.properties");
        URL singleNodeURL = new URL("http://singleNodeUrl.com");
        Set<URL> urlSet = new HashSet<>();
        urlSet.add(singleNodeURL);
        assertEquals(urlSet, config.getUrlSet());
    }

    @Test
    void checkInvalidConfigDbNameMissing() {
        String message = "Could not find a database name in the config.";
        RavenConfigCreationException actual = assertThrows(RavenConfigCreationException.class,
                () -> RavenConfigFactory.createRavenConfig("invalidRavenConfigDbNameMissing.properties")
        );
        assertEquals(message, actual.getMessage());
    }

    @Test
    void checkNotExistentConfig() {
        String expectedMessage = "Config could not be created, because properties file \"notExistent.properties\" does not exist or can not be read.";
        RavenConfigCreationException actual = assertThrows(RavenConfigCreationException.class,
                () -> RavenConfigFactory.createRavenConfig("notExistent.properties")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkNullPath() {
        assertThrows(IllegalArgumentException.class, () -> RavenConfigFactory.createRavenConfig(null));
    }

    @Test
    void checkEmptyPath() {
        assertThrows(IllegalArgumentException.class, () -> RavenConfigFactory.createRavenConfig(""));
    }

}