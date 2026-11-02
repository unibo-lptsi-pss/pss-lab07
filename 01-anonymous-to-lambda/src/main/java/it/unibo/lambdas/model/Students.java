package it.unibo.lambdas.model;

import it.unibo.lambdas.api.Criterion;

import java.util.ArrayList;
import java.util.List;

/**
 * Metodi di utilità per lavorare con liste di studenti.
 */
public final class Students {

    private Students() { }

    /**
     * Seleziona gli studenti che soddisfano un criterio.
     *
     * @param students la lista di studenti, che non deve essere modificata
     * @param criterion il criterio da applicare a ogni studente
     * @return una nuova lista con i soli studenti accettati da criterion, nello stesso ordine in cui compaiono in
     *     students
     */
    public static List<Student> select(final List<Student> students, final Criterion criterion) {
        final List<Student> selected = new ArrayList<>();
        for (final Student student : students) {
            if (criterion.accepts(student)) {
                selected.add(student);
            }
        }
        return selected;
    }
}
