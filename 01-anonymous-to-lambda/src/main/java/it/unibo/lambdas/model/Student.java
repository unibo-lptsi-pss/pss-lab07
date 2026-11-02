package it.unibo.lambdas.model;

/**
 * Uno studente, con il numero di crediti (CFU) acquisiti e la media dei voti.
 * Le istanze di questa classe sono immutabili.
 */
public final class Student {

    private final String firstName;
    private final String lastName;
    private final int credits;
    private final double averageGrade;

    /**
     * @param firstName il nome
     * @param lastName il cognome
     * @param credits i crediti acquisiti
     * @param averageGrade la media dei voti
     */
    public Student(final String firstName, final String lastName, final int credits, final double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.averageGrade = averageGrade;
    }

    /**
     * @return il nome
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return il cognome
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return i crediti acquisiti
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @return la media dei voti
     */
    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " [credits=" + credits + ", average=" + averageGrade + "]";
    }
}
