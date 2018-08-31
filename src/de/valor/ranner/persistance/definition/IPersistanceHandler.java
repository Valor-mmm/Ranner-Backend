package de.valor.ranner.persistance.definition;

public interface IPersistanceHandler<T> {

    T save(T toSave);

    T load(T toFetch);

    T remove(T toRemove);

}
