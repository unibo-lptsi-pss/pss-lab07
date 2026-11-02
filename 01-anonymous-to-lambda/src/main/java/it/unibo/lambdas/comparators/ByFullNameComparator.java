package it.unibo.lambdas.comparators;

import it.unibo.lambdas.model.Student;

import java.util.Comparator;

/**
 * Ordina gli studenti per cognome e, a parità di cognome, per nome.
 */
public final class ByFullNameComparator implements Comparator<Student> {

    @Override
    public int compare(final Student s1, final Student s2) {
        return 0;
    }
}
