package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerLoginBody {
    private String nick;
    private String password;

    /**
     * Temporary Player like class used for Client-Server communication
     * @see Player
     * @param nick Player nick
     * @param password Player password
     */
    public PlayerLoginBody(@JsonProperty("nick") String nick,
                           @JsonProperty("password") String password) {

        this.nick = nick;
        this.password = password;
    }

    /**
     * Get PlayerLoginBody nick
     * @return PlayerLoginBody nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * Get PlayerLoginBody password
     * @return PlayerLoginBody password
     */
    public String getPassword() {
        return password;
    }
}
