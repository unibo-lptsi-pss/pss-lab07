package it.unibo.lambdas;

import it.unibo.lambdas.model.Student;
import it.unibo.lambdas.test.SampleStudents;

import java.util.Comparator;
import java.util.List;

import static it.unibo.lambdas.test.Assertions.assertContentEqualsInOrder;
import static it.unibo.lambdas.test.SampleStudents.ANNA_BIANCHI;
import static it.unibo.lambdas.test.SampleStudents.GIULIA_ROSSI;
import static it.unibo.lambdas.test.SampleStudents.LUCA_VERDI;
import static it.unibo.lambdas.test.SampleStudents.MARIO_ROSSI;
import static it.unibo.lambdas.test.SampleStudents.PAOLO_NERI;
import static it.unibo.lambdas.test.SampleStudents.SARA_ESPOSITO;

/**
 * Parte 2: {@link Comparator} implementati tramite classi anonime.
 */
public final class UseAnonymousClasses {

    private UseAnonymousClasses() { }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Con una classe anonima, creare un comparatore che ordini gli studenti per cognome e, a parità di
         * cognome, per nome (lo stesso ordinamento di ByFullNameComparator).
         */
        final Comparator<Student> byFullName = null;
        assertContentEqualsInOrder(
            List.of(ANNA_BIANCHI, SARA_ESPOSITO, PAOLO_NERI, GIULIA_ROSSI, MARIO_ROSSI, LUCA_VERDI),
            sortedWith(byFullName)
        );
        /*
         * 2) Con una classe anonima, creare un comparatore che ordini gli studenti per media dei voti decrescente
         * (prima la media più alta).
         */
        final Comparator<Student> byAverageGradeDescending = null;
        assertContentEqualsInOrder(
            List.of(GIULIA_ROSSI, ANNA_BIANCHI, SARA_ESPOSITO, MARIO_ROSSI, PAOLO_NERI, LUCA_VERDI),
            sortedWith(byAverageGradeDescending)
        );
        /*
         * 3) Con una classe anonima, creare un comparatore che ordini gli studenti per crediti crescenti e, a parità
         * di crediti, per cognome.
         */
        final Comparator<Student> byCreditsThenLastName = null;
        assertContentEqualsInOrder(
            List.of(GIULIA_ROSSI, ANNA_BIANCHI, PAOLO_NERI, MARIO_ROSSI, LUCA_VERDI, SARA_ESPOSITO),
            sortedWith(byCreditsThenLastName)
        );
    }

    private static List<Student> sortedWith(final Comparator<Student> comparator) {
        final List<Student> students = SampleStudents.all();
        students.sort(comparator);
        return students;
    }
}
