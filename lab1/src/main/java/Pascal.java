/**
 * Erik Pettersson, erpette@kth.se
 * interface to require implementing classes to have a method binom() and a method printPascal()
 */

public interface Pascal {
    int binom(int n, int k);
    void printPascal(int n);
}
