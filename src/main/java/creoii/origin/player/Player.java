package creoii.origin.player;

import creoii.origin.core.game.GameSettings;
import creoii.origin.core.game.Transform;
import creoii.origin.core.input.KeyListener;
import creoii.origin.core.render.DynamicSpriteRenderer;
import creoii.origin.core.render.Spritesheet;
import creoii.origin.core.util.AssetPool;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int characterSlots = 2;
    private List<Character> characters = new ArrayList<>();
    private DynamicSpriteRenderer sprite;

    public Player(String name) {
        this.name = name;
    }

    public void init() {
        sprite = new DynamicSpriteRenderer(new Transform(new Vector2f(100f, 100f), new Vector2f(50f, 50f)), AssetPool.getSpritesheet(Spritesheet.X8_SHEET).getSprite(0));
    }

    public String getName() { return name; }
    public int getCharacterSlots() { return characterSlots; }
    public List<Character> getCharacters() { return characters; }
    public DynamicSpriteRenderer getSpriteRenderer() { return sprite; }

    public void addCharacterSlot() { ++characterSlots; }

    public Character getCharacter(int slot) {
        return characters.get(slot);
    }

    public void createCharacter(Class clazz) {
        if (characters.size() < characterSlots) {
            characters.add(new Character(this, clazz));
        }
    }

    public void update(float deltaTime) {
        if (KeyListener.isKeyPressed(GameSettings.MOVE_FORWARDS)) sprite.getTransform().getPosition().add(0f, deltaTime * 250f);
        if (KeyListener.isKeyPressed(GameSettings.MOVE_BACKWARDS)) sprite.getTransform().getPosition().add(0f, deltaTime * -250f);
        if (KeyListener.isKeyPressed(GameSettings.MOVE_RIGHT)) sprite.getTransform().getPosition().add(deltaTime * 250f, 0f);
        if (KeyListener.isKeyPressed(GameSettings.MOVE_LEFT)) sprite.getTransform().getPosition().add(deltaTime * -250f, 0f);

        sprite.update(deltaTime);
    }
}