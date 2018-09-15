package de.valor.ranner.persistence.ravendb.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RavenDBStoreHolderTest {

    @Test
    void getInstance() {
        assertNotNull(RavenDBStoreHolder.getStore());
    }
}