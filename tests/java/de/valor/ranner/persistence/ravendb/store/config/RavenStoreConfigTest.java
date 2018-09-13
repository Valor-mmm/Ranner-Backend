package de.valor.ranner.persistence.ravendb.store.config;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RavenStoreConfigTest {

    private final String validConfig = "validRavenConfig.properties";
    
    @Test
    void addUrlStringSingle() throws MalformedURLException, RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertTrue(config.addUrl("http://validURl.com"));
    }

    @Test
    void addUrlStringDouble() throws MalformedURLException, RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        String urlString = "http:thisIsaURL";
        config.addUrl(urlString);
        assertFalse(config.addUrl(urlString));
    }

    @Test
    void addUrlStringValid() throws MalformedURLException, RavenConfigCreationException {
        String validString = "http://somehost.test.a";
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        config.addUrl(validString);

        assertTrue(config.getUrlSet()
                .stream()
                .anyMatch(url -> url.toString().equals(validString)));
    }

    @Test
    void addURLStringInvalid() throws RavenConfigCreationException {
        String invalidString = "notValidURL";
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertThrows(MalformedURLException.class, () -> config.addUrl(invalidString));
    }

    @Test
    void addURLStringNull() throws RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertThrows(IllegalArgumentException.class, () -> config.addUrl((String) null));
    }

    @Test
    void addURLSingle() throws MalformedURLException, RavenConfigCreationException {
        URL url = new URL("https://aVeryValidURL.com");
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertTrue(config.addUrl(url));
    }

    @Test
    void addURLDouble() throws MalformedURLException, RavenConfigCreationException {
        URL url = new URL("http:183.23857.483:483");
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        config.addUrl(url);
        assertFalse(config.addUrl(url));
    }

    @Test
    void addURLValid() throws MalformedURLException, RavenConfigCreationException {
        URL validURL = new URL("https://127.0.0.1:20000");
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        config.addUrl(validURL);
        assertTrue(config.getUrlSet().stream().anyMatch(url -> url.equals(validURL)));
    }

    @Test
    void addURLNull() throws RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertThrows(IllegalArgumentException.class, () -> config.addUrl((URL) null));
    }

    @Test
    void getURLSetFilled() throws MalformedURLException, RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig("validSingleURLRavenConfig.properties");
        String urlString = "http://aValidURLtoAdd.yes";
        URL validURL = new URL(urlString);
        String urlString2 = "http://singleNodeUrl.com";
        URL validURL2 = new URL(urlString2);
        Set<URL> expectedSet = new HashSet<>();
        expectedSet.add(validURL);
        expectedSet.add(validURL2);
        config.addUrl(urlString);
        assertEquals(expectedSet, config.getUrlSet());
    }

    @Test
    void setDbNameValid() throws RavenConfigCreationException {
        String dbName = "This is a valid Name";
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        config.setDbName(dbName);
        assertEquals(dbName, config.getDbName());
    }

    @Test
    void setDbNameEmpty() throws RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertThrows(IllegalArgumentException.class, () -> config.setDbName(""));
    }

    @Test
    void setDbNameNull() throws RavenConfigCreationException {
        RavenStoreConfig config = RavenConfigFactory.createRavenConfig(validConfig);
        assertThrows(IllegalArgumentException.class, () -> config.setDbName(null));
    }

}