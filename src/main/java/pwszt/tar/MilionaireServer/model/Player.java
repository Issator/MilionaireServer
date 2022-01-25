package pwszt.tar.MilionaireServer.model;

import java.util.UUID;

public class Player {
    private UUID id;
    private String nick;
    private String password;

    /**
     * Construct a new player with given UUID, nick and password
     *
     * @param id Player UUID
     * @param nick Player Nick
     * @param password Player Password
     */
    public Player(UUID id, String nick, String password) {
        this.id = id;
        this.nick = nick;
        this.password = password;
    }

    /**
     * Get player UUID
     * @return Player id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Get Player Nick
     * @return Player nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * Get Player Password
     * @return Player password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Change Player nick into another
     * @param nick Player new nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * Change Player Password into another
     * @param password Player new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
