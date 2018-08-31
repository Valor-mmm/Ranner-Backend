package de.valor.ranner.persistance.definition;

public interface IPersistanceElement<T> {

    T save();

    T load();

    T remove();

}
