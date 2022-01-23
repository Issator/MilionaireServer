package pwszt.tar.MilionaireServer.model;

import java.util.UUID;

public class Player {
    private UUID id;
    private String nick;
    private String password;

    public Player(UUID id, String nick, String password) {
        this.id = id;
        this.nick = nick;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
