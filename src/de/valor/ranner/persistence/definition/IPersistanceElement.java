package de.valor.ranner.persistence.definition;

public interface IPersistanceElement<T> {

    T save();

    T load();

    T remove();

}
