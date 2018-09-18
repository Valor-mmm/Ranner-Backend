package de.valor.ranner.config;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ConfigRetrieverTest {

    @Test
    void createConfigRetrieverValidPath() {
        try {
            new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void createConfigRetrieverInvalidPath() {
        String expectedMessage = "Error while loading config from file: \"notAValidPath\"";
        ConfigRetrieverException actual = assertThrows(ConfigRetrieverException.class,
                () -> new ConfigRetriever("notAValidPath")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void createConfigRetrieverPathNull() {
        String expectedMessage = "Error in ConfigRetriever constructor! Config could not be initialized.";
        ConfigRetrieverException actual = assertThrows(ConfigRetrieverException.class,
                () -> new ConfigRetriever(null)
        );
        assertEquals(expectedMessage, actual.getMessage());
        assertTrue(actual.getCause() instanceof IllegalArgumentException);
    }

    @Test
    void createConfigRetrieverPathEmpty() {
        String expectedMessage = "Error in ConfigRetriever constructor! Config could not be initialized.";
        ConfigRetrieverException actual = assertThrows(ConfigRetrieverException.class,
                () -> new ConfigRetriever("")
        );
        assertEquals(expectedMessage, actual.getMessage());
        assertTrue(actual.getCause() instanceof IllegalArgumentException);
    }

    @Test
    void getPropertyValid() {
        String propertyValue = "someProperty 9394.3839 testEnd {/\\?";
        try {
            ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
            assertEquals(propertyValue, configRetriever.getProperty("testProp"));
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPropertyInvalid() {
        try {
            ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
            assertNull(configRetriever.getProperty("nonExistentProperty"));
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPropertyEmpty() {
        try {
            ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
            assertEquals("", configRetriever.getProperty("emptyProp"));
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPropertyParamNull() {
        try {
            ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
            assertThrows(IllegalArgumentException.class,
                    () -> configRetriever.getProperty(null)
            );
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPropertyParamEmpty() {
        try {
            ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
            assertThrows(IllegalArgumentException.class,
                    () -> configRetriever.getProperty("")
            );
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPropertyPath() {
        try {
            String expectedPath = "persistence/ravendb/config/tests/configRetrieverTest.properties";
            ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
            assertEquals(expectedPath, configRetriever.getPropertyPath());
        } catch (ConfigRetrieverException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPropertyList() throws ConfigRetrieverException {
        ConfigRetriever configRetriever = new ConfigRetriever("persistence/ravendb/config/tests/configRetrieverTest.properties");
        Set<String> expectedList = new HashSet<>();
        expectedList.add("testProp");
        expectedList.add("emptyProp");
        expectedList.add("anotherProp");
        assertEquals(expectedList, configRetriever.getPropertySet());
    }
}