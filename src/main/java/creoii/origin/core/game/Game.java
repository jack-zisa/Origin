package creoii.origin.core.game;

import creoii.origin.core.util.AssetPool;
import creoii.origin.data.DataLoader;
import creoii.origin.player.Character;
import creoii.origin.player.Player;
import creoii.origin.world.World;

public class Game {
    private static Player player;
    private static Character activeCharacter;
    private static World world;

    public Game() {
        player = new Player("test");
        player.createCharacter(DataLoader.CLASSES.getObject("wizard"));
        player.createCharacter(DataLoader.CLASSES.getObject("warrior"));
        activeCharacter = player.getCharacter(0);
        world = new World(World.WorldSize.MEDIUM);
    }

    public static Player getPlayer() { return player; }
    public static Character getActiveCharacter() { return activeCharacter; }
    public static void setActiveCharacter(int charSlot) {
        activeCharacter = player.getCharacter(charSlot);
        player.getSpriteRenderer().setSprite(AssetPool.getClassSprite(activeCharacter.getCharacterClass().getId()));
    }
    public static World getWorld() { return world; }

    public void update(float deltaTime) {
        player.update(deltaTime);
        activeCharacter.update(deltaTime);
        world.update(deltaTime);
    }
}
