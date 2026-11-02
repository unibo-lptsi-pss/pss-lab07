package it.unibo.team;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A football team, made of a set of {@link Player}s.
 */
public final class Team {

    private final String name;
    private final Set<Player> players = new HashSet<>();

    /**
     * Creates an empty team.
     *
     * @param name the name of the team
     */
    public Team(final String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * @return the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a player to the team.
     *
     * @param player the player to add
     * @return true if the player was added, false if an equal player was already in the team
     */
    public boolean addPlayer(final Player player) {
        return players.add(Objects.requireNonNull(player));
    }

    /**
     * @param player the player to look for
     * @return true if the team contains a player equal to the given one
     */
    public boolean contains(final Player player) {
        return players.contains(player);
    }

    /**
     * @param role the role to filter by
     * @return the players of the team having the given role
     */
    public Set<Player> getPlayersByRole(final Role role) {
        final Set<Player> result = new HashSet<>();
        for (final Player player : players) {
            if (player.getRole() == role) {
                result.add(player);
            }
        }
        return result;
    }

    /**
     * @return a new, empty lineup for this team
     */
    public Lineup newLineup() {
        return new Lineup();
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

        private final String name;
        private final int number;
        private final Role role;

        /**
         * Creates a new player.
         *
         * @param name the name of the player
         * @param number the shirt number of the player
         * @param role the role of the player
         */
        public Player(final String name, final int number, final Role role) {
            this.name = Objects.requireNonNull(name);
            this.number = number;
            this.role = Objects.requireNonNull(role);
        }

        /**
         * @return the name of the player
         */
        public String getName() {
            return name;
        }

        /**
         * @return the shirt number of the player
         */
        public int getNumber() {
            return number;
        }

        /**
         * @return the role of the player
         */
        public Role getRole() {
            return role;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof final Player other) {
                return number == other.number && name.equals(other.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, number);
        }

        @Override
        public String toString() {
            return name + " (" + number + ", " + role + ")";
        }
    }

    /**
     * The starting players of this team for a match.
     * A lineup is complete when it has eleven players, exactly one of which is a goalkeeper.
     */
    public final class Lineup {

        private static final int SIZE = 11;

        private final Set<Player> starters = new HashSet<>();

        /**
         * Adds a starting player to the lineup.
         *
         * @param player the player to add
         * @return false if the procedure failed; true otherwise
         */
        public boolean addStarter(final Player player) {
            if (!players.contains(player)) {
                return false;
            }
            if (starters.size() == SIZE) {
                return false;
            }
            starters.add(player);
            return true;
        }

        /**
         * @return true if the lineup has eleven players and exactly one goalkeeper
         */
        public boolean isComplete() {
            int goalkeepers = 0;
            for (final Player player : starters) {
                if (player.getRole() == Role.GOALKEEPER) {
                    goalkeepers++;
                }
            }
            return starters.size() == SIZE && goalkeepers == 1;
        }

        /**
         * @return the team this lineup belongs to
         */
        public Team getTeam() {
            return Team.this;
        }
    }
}
