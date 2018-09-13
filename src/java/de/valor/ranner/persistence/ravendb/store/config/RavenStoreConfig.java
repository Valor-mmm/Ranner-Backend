package de.valor.ranner.persistence.ravendb.store.config;

import de.valor.ranner.main.validation.arguments.IArgumentValidator;
import de.valor.ranner.main.validation.arguments.NotNullArgumentValidator;
import de.valor.ranner.main.validation.arguments.StringArgumentValidator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class RavenStoreConfig {


    private static final IArgumentValidator notNullArgValidator = new NotNullArgumentValidator();
    private static final IArgumentValidator stringArgValidator = new StringArgumentValidator();

    private Set<URL> nodeURLSet = new HashSet<>();
    private String dbName = null;

    RavenStoreConfig() {

    }

    public boolean addUrl(String urlString) throws MalformedURLException {
        stringArgValidator.validateExistsStrict(urlString, "urlString");
        URL createdURL = new URL(urlString);
        return nodeURLSet.add(createdURL);
    }

    public boolean addUrl(URL url) {
        notNullArgValidator.validateExistsStrict(url, "url");
        return nodeURLSet.add(url);
    }

    public Set<URL> getUrlSet() {
        return nodeURLSet;
    }

    public void setDbName(String dbName) {
        stringArgValidator.validateExistsStrict(dbName, "dbName");
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }
}
