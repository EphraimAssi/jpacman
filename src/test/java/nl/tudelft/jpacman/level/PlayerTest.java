package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void testIsPlayerAlive() {
        PacManSprites pacManSprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player player = playerFactory.createPacMan();

        // Vérifier si le joueur est vivant: La réponse devrait être true
        assertThat(player.isAlive()).isTrue();

        // Pour tester si le joueur est vivant, une collision avec un fantôme doit arriver 3 fois
        GhostFactory ghostFactory = new GhostFactory(pacManSprites);
        Ghost ghost = ghostFactory.createBlinky();

        for (int i = 0; i < 3; i++) {
            player.handleGhostCollision(ghost);
        }

        // Vérifier si le joueur est vivant: La réponse devrait être false
        assertThat(player.isAlive()).isFalse();
    }
}
