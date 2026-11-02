package it.unibo.lambdas;

import it.unibo.lambdas.api.Criterion;
import it.unibo.lambdas.model.Student;
import it.unibo.lambdas.model.Students;
import it.unibo.lambdas.test.SampleStudents;

import java.util.List;

import static it.unibo.lambdas.test.Assertions.assertContentEqualsInOrder;
import static it.unibo.lambdas.test.SampleStudents.ANNA_BIANCHI;
import static it.unibo.lambdas.test.SampleStudents.GIULIA_ROSSI;
import static it.unibo.lambdas.test.SampleStudents.LUCA_VERDI;
import static it.unibo.lambdas.test.SampleStudents.MARIO_ROSSI;
import static it.unibo.lambdas.test.SampleStudents.PAOLO_NERI;
import static it.unibo.lambdas.test.SampleStudents.SARA_ESPOSITO;

/**
 * Parte 4: classi anonime e lambda per un'interfaccia definita da noi, {@link Criterion}.
 */
public final class UseCriteria {

    private UseCriteria() { }

    /**
     * Program entry point.
     */
    public static void main() {
        final List<Student> students = SampleStudents.all();
        /*
         * 1) Con una classe anonima, creare un criterio che accetti gli studenti con media almeno 28.
         */
        final Criterion excellent = null;
        assertContentEqualsInOrder(
            List.of(ANNA_BIANCHI, GIULIA_ROSSI, SARA_ESPOSITO),
            Students.select(students, excellent)
        );
        /*
         * 2) Con una lambda, creare un criterio che accetti gli studenti con cognome "Rossi".
         */
        final Criterion namedRossi = null;
        assertContentEqualsInOrder(List.of(MARIO_ROSSI, GIULIA_ROSSI), Students.select(students, namedRossi));
        /*
         * 3) Con una lambda, creare un criterio che accetti gli studenti con almeno minCredits crediti.
         * La lambda deve usare la variabile locale minCredits.
         */
        final int minCredits = 100;
        final Criterion enoughCredits = null;
        assertContentEqualsInOrder(
            List.of(MARIO_ROSSI, LUCA_VERDI, SARA_ESPOSITO),
            Students.select(students, enoughCredits)
        );
        /*
         * 4) Con una lambda, creare un criterio che accetti gli studenti con almeno 90 crediti e media
         * inferiore a 27.
         */
        final Criterion manyCreditsLowAverage = null;
        assertContentEqualsInOrder(
            List.of(LUCA_VERDI, PAOLO_NERI),
            Students.select(students, manyCreditsLowAverage)
        );
        /*
         * Students.select non deve aver modificato la lista originale.
         */
        assertContentEqualsInOrder(SampleStudents.all(), students);
    }
}
