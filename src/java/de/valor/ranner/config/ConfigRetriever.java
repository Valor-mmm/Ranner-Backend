package de.valor.ranner.config;

import de.valor.ranner.main.validation.arguments.IArgumentValidator;
import de.valor.ranner.main.validation.arguments.NotNullArgumentValidator;
import de.valor.ranner.main.validation.arguments.StringArgumentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ConfigRetriever {

    private static final IArgumentValidator stringArgumentValidator = new StringArgumentValidator();
    private static final IArgumentValidator notNullArgumentValidator = new NotNullArgumentValidator();

    private static final Logger logger = LogManager.getLogger(ConfigRetriever.class);

    private String propertyPath;
    private Properties properties = new Properties();

    public ConfigRetriever(String propertyPath) throws ConfigRetrieverException {
        String errorMessage = "Error in ConfigRetriever constructor! Config could not be initialized.";
        try {
            stringArgumentValidator.validateExistsStrict(propertyPath, "propertyPath");
            this.propertyPath = propertyPath;
            this.init();
        } catch (ConfigRetrieverException configRetEx) {
            logger.error(errorMessage, configRetEx.getMessage());
            throw configRetEx;
        } catch (Exception e) {
            logger.error(errorMessage);
            throw new ConfigRetrieverException(errorMessage, e);
        }
    }

    private void init() throws ConfigRetrieverException {
        ClassLoader configClassLoader = ConfigRetriever.class.getClassLoader();
        if (!notNullArgumentValidator.validateExists(configClassLoader, "configClassLoader")) {
            String errorMessage = "Could not retrieve config. Class loader is null!";
            logger.error(errorMessage);
            throw new ConfigRetrieverException(errorMessage, new NullPointerException());
        }

        InputStream input = configClassLoader.getResourceAsStream(this.propertyPath);
        if (!notNullArgumentValidator.validateExists(input, "input")) {
            throwFileHanldingError(null);
        }

        try {
            properties.load(input);
            logger.info("Configuration loaded successfully form: " + this.getPropertyPath());
        } catch (IOException e) {
            this.throwFileHanldingError(e);
        }
    }

    private void throwFileHanldingError(Exception cause) throws ConfigRetrieverException {
        String errorMessage = "Error while loading config from file: \"" + this.getPropertyPath() + "\"";
        logger.error(errorMessage);
        throw new ConfigRetrieverException(errorMessage, cause);
    }

    public String getProperty(String propertyName) {
        stringArgumentValidator.validateExistsStrict(propertyName, "propertyName");
        String result = properties.getProperty(propertyName);
        if (!notNullArgumentValidator.validateExists(result, null)) {
            logger.warn("Property with following key could not be found: [" + propertyName + "]");
        }
        return result;
    }


    public String getPropertyPath() {
        return propertyPath;
    }

    public Set<String> getPropertySet() {
        return properties.stringPropertyNames();
    }
}
