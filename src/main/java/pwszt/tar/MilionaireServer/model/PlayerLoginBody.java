package pwszt.tar.MilionaireServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerLoginBody {
    private String nick;
    private String password;

    public PlayerLoginBody(@JsonProperty("nick") String nick,
                           @JsonProperty("password") String password) {

        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }
}
