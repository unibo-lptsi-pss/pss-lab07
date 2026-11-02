package it.unibo.team;

import java.util.Set;

/**
 * A football team, made of a set of {@link Player}s.
 */
public final class Team {

    /**
     * Creates an empty team.
     *
     * @param name the name of the team
     */
    public Team(final String name) {
    }

    /**
     * @return the name of the team
     */
    public String getName() {
        return null;
    }

    /**
     * Adds a player to the team.
     *
     * @param player the player to add
     * @return true if the player was added, false if an equal player was already in the team
     */
    public boolean addPlayer(final Player player) {
        return false;
    }

    /**
     * @param player the player to look for
     * @return true if the team contains a player equal to the given one
     */
    public boolean contains(final Player player) {
        return false;
    }

    /**
     * @param role the role to filter by
     * @return the players of the team having the given role
     */
    public Set<Player> getPlayersByRole(final Role role) {
        return null;
    }

    /**
     * @return a new, empty lineup for this team
     */
    public Lineup newLineup() {
        return null;
    }

    /**
     * The roles a player can have on the field.
     */
    public enum Role {
        /**
         * Goalkeeper.
         */
        GOALKEEPER,
        /**
         * Defender.
         */
        DEFENDER,
        /**
         * Midfielder.
         */
        MIDFIELDER,
        /**
         * Forward.
         */
        FORWARD
    }

    /**
     * A player of a team.
     * Two players are equal if they have the same name and the same shirt number, regardless of their role.
     */
    public static final class Player {

        /**
         * Creates a new player.
         *
         * @param name the name of the player
         * @param number the shirt number of the player
         * @param role the role of the player
         */
        public Player(final String name, final int number, final Role role) {
        }

        /**
         * @return the name of the player
         */
        public String getName() {
            return null;
        }

        /**
         * @return the shirt number of the player
         */
        public int getNumber() {
            return 0;
        }

        /**
         * @return the role of the player
         */
        public Role getRole() {
            return null;
        }
    }

    /**
     * The starting players of this team for a match.
     * A lineup is complete when it has eleven players, exactly one of which is a goalkeeper.
     */
    public final class Lineup {

        /**
         * Adds a starting player to the lineup.
         *
         * @param player the player to add
         * @return false if the procedure failed; true otherwise
         */
        public boolean addStarter(final Player player) {
            return false;
        }

        /**
         * @return true if the lineup has eleven players and exactly one goalkeeper
         */
        public boolean isComplete() {
            return false;
        }

        /**
         * @return the team this lineup belongs to
         */
        public Team getTeam() {
            return null;
        }
    }
}
