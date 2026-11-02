package it.unibo.lambdas;

import it.unibo.lambdas.comparators.ByFullNameComparator;
import it.unibo.lambdas.model.Student;
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
 * Parte 1: un {@link java.util.Comparator} implementato come classe separata.
 */
public final class UseNamedComparator {

    private UseNamedComparator() { }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * Implementare ByFullNameComparator, che ordina gli studenti per cognome e, a parità di cognome, per nome.
         */
        final List<Student> students = SampleStudents.all();
        students.sort(new ByFullNameComparator());
        assertContentEqualsInOrder(
            List.of(ANNA_BIANCHI, SARA_ESPOSITO, PAOLO_NERI, GIULIA_ROSSI, MARIO_ROSSI, LUCA_VERDI),
            students
        );
    }
}
