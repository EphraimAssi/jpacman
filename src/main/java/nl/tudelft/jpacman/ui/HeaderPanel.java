package nl.tudelft.jpacman.ui;

import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.level.Player;


public class HeaderPanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The map of players and the labels their information is displayed on.
     */
    private final Map<Player, JLabel> infoLabels;

    /**
     * Creates a new header panel with a column for each player.
     *
     * @param players
     *            The players to display the information for.
     */
    public HeaderPanel(List<Player> players) {
        super();
        assert players != null;

        setLayout(new GridLayout(3, players.size()));

        for (int i = 1; i <= players.size(); i++) {
            add(new JLabel("Player " + i, JLabel.CENTER));
        }
        infoLabels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel infoLabel = new JLabel("0", JLabel.CENTER);
            infoLabels.put(player, infoLabel);
            add(infoLabel);
        }
    }

    protected void refresh() {
        for (Map.Entry<Player, JLabel> entry : infoLabels.entrySet()) {
            Player player = entry.getKey();
            String scoreText = String.format("Score: %d", player.getScore());
            String livesText = String.format("Lives: %d", player.getLives());
            String infoText = scoreText + " | " + livesText;

            StringBuilder info = new StringBuilder();
            if (!player.isAlive()) {
                info.append(infoText).append(" | You died.");
            } else {
                info.append(infoText);
            }

            entry.getValue().setText(info.toString());
        }
    }
}
