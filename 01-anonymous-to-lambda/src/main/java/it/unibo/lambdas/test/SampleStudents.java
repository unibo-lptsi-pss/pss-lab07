package it.unibo.lambdas.test;

import it.unibo.lambdas.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Studenti di esempio usati dai programmi di prova.
 */
public final class SampleStudents {

    /** Mario Rossi, 120 CFU, media 27.5. */
    public static final Student MARIO_ROSSI = new Student("Mario", "Rossi", 120, 27.5);
    /** Anna Bianchi, 90 CFU, media 29.1. */
    public static final Student ANNA_BIANCHI = new Student("Anna", "Bianchi", 90, 29.1);
    /** Luca Verdi, 150 CFU, media 24.0. */
    public static final Student LUCA_VERDI = new Student("Luca", "Verdi", 150, 24.0);
    /** Giulia Rossi, 60 CFU, media 30.0. */
    public static final Student GIULIA_ROSSI = new Student("Giulia", "Rossi", 60, 30.0);
    /** Paolo Neri, 90 CFU, media 26.3. */
    public static final Student PAOLO_NERI = new Student("Paolo", "Neri", 90, 26.3);
    /** Sara Esposito, 180 CFU, media 28.0. */
    public static final Student SARA_ESPOSITO = new Student("Sara", "Esposito", 180, 28.0);

    private SampleStudents() { }

    /**
     * @return una nuova lista modificabile con tutti gli studenti di esempio, sempre nello stesso ordine
     */
    public static List<Student> all() {
        return new ArrayList<>(List.of(MARIO_ROSSI, ANNA_BIANCHI, LUCA_VERDI, GIULIA_ROSSI, PAOLO_NERI, SARA_ESPOSITO));
    }
}
