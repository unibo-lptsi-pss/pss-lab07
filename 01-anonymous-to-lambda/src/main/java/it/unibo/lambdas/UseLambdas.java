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
 * Parte 3: gli stessi {@link Comparator} della parte 2, scritti come lambda.
 */
public final class UseLambdas {

    private UseLambdas() { }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Con una lambda, creare un comparatore che ordini gli studenti per cognome e, a parità di cognome,
         * per nome.
         */
        final Comparator<Student> byFullName = (s1, s2) -> {
            final int byLastName = s1.getLastName().compareTo(s2.getLastName());
            if (byLastName != 0) {
                return byLastName;
            }
            return s1.getFirstName().compareTo(s2.getFirstName());
        };
        assertContentEqualsInOrder(
            List.of(ANNA_BIANCHI, SARA_ESPOSITO, PAOLO_NERI, GIULIA_ROSSI, MARIO_ROSSI, LUCA_VERDI),
            sortedWith(byFullName)
        );
        /*
         * 2) Con una lambda, creare un comparatore che ordini gli studenti per media dei voti decrescente.
         */
        final Comparator<Student> byAverageGradeDescending =
            (s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
        assertContentEqualsInOrder(
            List.of(GIULIA_ROSSI, ANNA_BIANCHI, SARA_ESPOSITO, MARIO_ROSSI, PAOLO_NERI, LUCA_VERDI),
            sortedWith(byAverageGradeDescending)
        );
        /*
         * 3) Con una lambda, creare un comparatore che ordini gli studenti per crediti crescenti e, a parità di
         * crediti, per cognome.
         */
        final Comparator<Student> byCreditsThenLastName = (s1, s2) -> {
            final int byCredits = Integer.compare(s1.getCredits(), s2.getCredits());
            if (byCredits != 0) {
                return byCredits;
            }
            return s1.getLastName().compareTo(s2.getLastName());
        };
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
