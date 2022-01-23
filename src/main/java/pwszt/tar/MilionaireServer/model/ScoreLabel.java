package pwszt.tar.MilionaireServer.model;

public class ScoreLabel {
    private String nick;
    private int score;

    public ScoreLabel(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }

    public String getNick() {
        return nick;
    }

    public int getScore() {
        return score;
    }
}
