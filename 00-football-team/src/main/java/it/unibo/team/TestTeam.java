package it.unibo.team;

import it.unibo.team.Team.Player;
import it.unibo.team.Team.Role;

import java.util.List;
import java.util.Set;

import static it.unibo.team.test.Assertions.assertEquals;
import static it.unibo.team.test.Assertions.assertFalse;
import static it.unibo.team.test.Assertions.assertNotEquals;
import static it.unibo.team.test.Assertions.assertSame;
import static it.unibo.team.test.Assertions.assertTrue;

/**
 * Tests the {@link Team} class and its nested {@link Player} and {@link Team.Lineup} classes.
 */
public final class TestTeam {

    private static final String ROSSI = "Rossi";
    private static final int ROSSI_NUMBER = 10;
    private static final int VERDI_NUMBER = 9;
    private static final int LINEUP_SIZE = 11;

    private static final Player PLAYER_ROSSI = new Player(ROSSI, ROSSI_NUMBER, Role.FORWARD);
    private static final Player PLAYER_BIANCHI = new Player("Bianchi", 1, Role.GOALKEEPER);
    private static final Player PLAYER_VERDI = new Player("Verdi", VERDI_NUMBER, Role.FORWARD);

    private TestTeam() { }

    /**
     * Program entry point.
     */
    public static void main() {
        testRoles();
        testEquals();
        testHashCode();
        testAddPlayers();
        testPlayersByRole();
        testLineupBelongsToTeam();
        testCompleteLineup();
        testLineupWithTwoGoalkeepers();
    }

    private static void testRoles() {
        assertEquals(
            List.of(Role.GOALKEEPER, Role.DEFENDER, Role.MIDFIELDER, Role.FORWARD),
            List.of(Role.values())
        );
    }

    private static void testEquals() {
        assertEquals(PLAYER_ROSSI, PLAYER_ROSSI);
        assertEquals(PLAYER_ROSSI, new Player(ROSSI, ROSSI_NUMBER, Role.FORWARD));
        // The role is not part of the identity of a player
        assertEquals(PLAYER_ROSSI, new Player(ROSSI, ROSSI_NUMBER, Role.MIDFIELDER));
        assertNotEquals(PLAYER_ROSSI, new Player(ROSSI, ROSSI_NUMBER + 1, Role.FORWARD));
        assertNotEquals(PLAYER_ROSSI, new Player("Neri", ROSSI_NUMBER, Role.FORWARD));
        assertNotEquals(PLAYER_ROSSI, PLAYER_BIANCHI);
        assertNotEquals(null, PLAYER_ROSSI);
        assertNotEquals(ROSSI, PLAYER_ROSSI);
    }

    private static void testHashCode() {
        assertEquals(PLAYER_ROSSI.hashCode(), new Player(ROSSI, ROSSI_NUMBER, Role.FORWARD).hashCode());
        assertEquals(PLAYER_ROSSI.hashCode(), new Player(ROSSI, ROSSI_NUMBER, Role.DEFENDER).hashCode());
    }

    private static void testAddPlayers() {
        final Team team = new Team("Cesena");
        assertTrue(team.addPlayer(PLAYER_ROSSI));
        assertTrue(team.addPlayer(PLAYER_BIANCHI));
        assertFalse(team.addPlayer(new Player(ROSSI, ROSSI_NUMBER, Role.MIDFIELDER)));
        assertTrue(team.contains(new Player(ROSSI, ROSSI_NUMBER, Role.FORWARD)));
        assertFalse(team.contains(PLAYER_VERDI));
    }

    private static void testPlayersByRole() {
        final Team team = new Team("Cesena");
        team.addPlayer(PLAYER_ROSSI);
        team.addPlayer(PLAYER_BIANCHI);
        team.addPlayer(PLAYER_VERDI);
        assertEquals(Set.of(PLAYER_ROSSI, PLAYER_VERDI), team.getPlayersByRole(Role.FORWARD));
        assertEquals(Set.of(PLAYER_BIANCHI), team.getPlayersByRole(Role.GOALKEEPER));
        assertEquals(Set.of(), team.getPlayersByRole(Role.DEFENDER));
    }

    private static void testLineupBelongsToTeam() {
        final Team team = new Team("Cesena");
        // Inner classes are instantiated starting from an instance of the outer class
        final Team.Lineup lineup = team.new Lineup();
        assertSame(team, lineup.getTeam());
        team.addPlayer(PLAYER_ROSSI);
        lineup.addStarter(new Player(ROSSI, ROSSI_NUMBER, Role.FORWARD));
        assertFalse(lineup.addStarter(PLAYER_VERDI));
        assertFalse(new Team("Rimini").newLineup().addStarter(PLAYER_ROSSI));
    }

    private static void testCompleteLineup() {
        final Team team = new Team("Cesena");
        final Team.Lineup lineup = team.newLineup();
        team.addPlayer(PLAYER_BIANCHI);
        lineup.addStarter(PLAYER_BIANCHI);
        for (int number = 2; number <= LINEUP_SIZE; number++) {
            assertFalse(lineup.isComplete());
            final Player defender = new Player("Defender" + number, number, Role.DEFENDER);
            team.addPlayer(defender);
            lineup.addStarter(defender);
        }
        assertTrue(lineup.isComplete());
        team.addPlayer(PLAYER_ROSSI);
        assertFalse(lineup.addStarter(PLAYER_ROSSI));
    }

    private static void testLineupWithTwoGoalkeepers() {
        final Team team = new Team("Cesena");
        final Team.Lineup lineup = team.newLineup();
        for (int number = 1; number <= LINEUP_SIZE; number++) {
            final Player goalkeeper = new Player("Goalkeeper" + number, number, Role.GOALKEEPER);
            team.addPlayer(goalkeeper);
            lineup.addStarter(goalkeeper);
        }
        assertFalse(lineup.isComplete());
    }
}
