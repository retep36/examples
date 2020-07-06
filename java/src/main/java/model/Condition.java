package model;

/**
 * Rozhranie je využívané v príkazoch s podmienkou.
 */
public interface Condition {
    boolean isDone();
    String print();
    int isNeg();
}
