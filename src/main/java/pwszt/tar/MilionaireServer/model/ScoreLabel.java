package pwszt.tar.MilionaireServer.model;

/**
 * Class use for story information about Player score
 */
public class ScoreLabel {
    private String nick;
    private int score;

    /**
     * Class use for story information about Player score
     * @see Player
     * @param nick Player nick
     * @param score Player scores
     */
    public ScoreLabel(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }

    /**
     * Get Player nick from ScoreLabel
     * @return Player nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * Get Player score from ScoreLabel
     * @return Player score
     */
    public int getScore() {
        return score;
    }
}
