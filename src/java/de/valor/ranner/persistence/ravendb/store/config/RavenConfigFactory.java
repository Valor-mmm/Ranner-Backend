package de.valor.ranner.persistence.ravendb.store.config;

import de.valor.ranner.config.ConfigRetriever;
import de.valor.ranner.config.ConfigRetrieverException;
import de.valor.ranner.main.validation.arguments.IArgumentValidator;
import de.valor.ranner.main.validation.arguments.NotNullArgumentValidator;
import de.valor.ranner.main.validation.arguments.StringArgumentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RavenConfigFactory {

    private static final Logger logger = LogManager.getLogger(RavenConfigFactory.class);

    private static final IArgumentValidator stringArgValidator = new StringArgumentValidator();
    private static final IArgumentValidator notNullArgValidator = new NotNullArgumentValidator();

    private static final Pattern NODE_URL_PROPERTY_TEMPLATE = Pattern.compile("nodeUrl_\\w+");
    private static final String DB_NAME_PROPERTY_NAME = "dbName";

    public static RavenStoreConfig createRavenConfig(String fileName) throws RavenConfigCreationException {
        stringArgValidator.validateExistsStrict(fileName, "fileName");
        try {
            RavenStoreConfig config = new RavenStoreConfig();
            ConfigRetriever configRetriever = createConfigRetriever(fileName);
            String dbName = configRetriever.getProperty(DB_NAME_PROPERTY_NAME);
            setDatabaseName(config, dbName);
            setNodeUrls(config, configRetriever);
            return config;
        } catch (RavenConfigCreationException rcce) {
            throw rcce;
        } catch (Exception e) {
            String errorMessage = String.format("A raven config with the filename of \"%s\" could not be created", fileName);
            logger.error(errorMessage, e);
            throw new RavenConfigCreationException(errorMessage, e);
        }
    }

    private static ConfigRetriever createConfigRetriever(String fileName) throws RavenConfigCreationException {
        stringArgValidator.validateExistsStrict(fileName, "fileName");
        ConfigRetriever result;
        try {
            result = new ConfigRetriever(fileName);
        } catch (ConfigRetrieverException e) {
            String errorMessage = String.format("Config could not be created, because properties file \"%s\" does not exist or can not be read.", fileName);
            logger.error(errorMessage);
            throw new RavenConfigCreationException(errorMessage, e);
        }
        return result;
    }

    private static void setDatabaseName(RavenStoreConfig config, String dbName) throws RavenConfigCreationException {
        notNullArgValidator.validateExistsStrict(config, "config");
        if (!stringArgValidator.validateExists(dbName, "dbName")) {
            String errorMessage = "Could not find a database name in the config.";
            logger.error(errorMessage);
            throw new RavenConfigCreationException(errorMessage, null);
        }
        config.setDbName(dbName);
    }

    private static void setNodeUrlProperty(RavenStoreConfig config, String nodeUrl) throws RavenConfigCreationException {
        notNullArgValidator.validateExistsStrict(config, "config");
        if (!stringArgValidator.validateExists(nodeUrl, "nodeUrl")) {
            String errorMessage = String.format("Given nodeUrl \"%s\" is not valid and will not be set to the config.", nodeUrl);
            logger.error(errorMessage);
            throw new RavenConfigCreationException(errorMessage, null);
        }
        try {
            boolean success = config.addUrl(nodeUrl);
            if (!success) {
                logger.warn("Url: \"" + nodeUrl + "\" is assigned to two different Nodes!");
            }
        } catch (MalformedURLException e) {
            String errorMessage = String.format("Given nodeUrl \"%s\" is not a valid URL", nodeUrl);
            logger.error(errorMessage);
            throw new RavenConfigCreationException(errorMessage, e);
        }
    }

    private static void setNodeUrls(RavenStoreConfig config, ConfigRetriever configRetriever) throws RavenConfigCreationException {
        notNullArgValidator.validateExistsStrict(config, "config");
        notNullArgValidator.validateExistsStrict(configRetriever, "configRetriever");

        Set<String> nodeProperties = getNodeProperties(configRetriever);
        for (String nodeProperty : nodeProperties) {
            String value = configRetriever.getProperty(nodeProperty);
            setNodeUrlProperty(config, value);
        }
    }

    private static Set<String> getNodeProperties(ConfigRetriever configRetriever) {
        notNullArgValidator.validateExistsStrict(configRetriever, "configRetriever");
        Set<String> allProperties = configRetriever.getPropertySet();
        return allProperties.stream().filter(propertyName -> {
            Matcher matcher = NODE_URL_PROPERTY_TEMPLATE.matcher(propertyName);
            return matcher.matches();
        }).collect(Collectors.toSet());
    }


}
