package it.unibo.lambdas.api;

import it.unibo.lambdas.model.Student;

/**
 * Un criterio per selezionare gli studenti.
 */
public interface Criterion {

    /**
     * @param student lo studente da valutare
     * @return true se lo studente soddisfa il criterio, false altrimenti
     */
    boolean accepts(Student student);
}
