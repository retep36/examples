package model;

/**
 * Rozhranie je vyu��van� v pr�kazoch s podmienkou.
 */
public interface Condition {
    boolean isDone();
    String print();
    int isNeg();
}
