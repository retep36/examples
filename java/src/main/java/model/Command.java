package model;

/**
 * Rozhranie sa vyuíva v objektoch, kde sa môe vyskytnú sekvencia príkazov.
 */
public interface Command {
    boolean isDone();
    String print();
}
