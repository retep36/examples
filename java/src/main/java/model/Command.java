package model;

/**
 * Rozhranie sa vyu��va v objektoch, kde sa m��e vyskytn�� sekvencia pr�kazov.
 */
public interface Command {
    boolean isDone();
    String print();
}
