package creoii.origin.core.render.sprite;

import creoii.origin.core.game.Transform;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class DynamicSpriteRenderer extends SpriteRenderer {
    private Transform lastTransform = new Transform(new Vector2f(), new Vector2f());
    private boolean dirty = true;

    public DynamicSpriteRenderer(Vector4f color) {
        super(color);
    }

    public DynamicSpriteRenderer(Sprite sprite) {
        super(sprite);
    }

    public boolean isDirty() { return dirty; }
    public void setDirty(boolean dirty) { this.dirty = dirty; }
    @Override public boolean isDynamic() { return true; }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
        setTexture(sprite.getTexture());
        setDirty(true);
    }

    public void setColor(Vector4f color) {
        if (!this.color.equals(color)) {
            this.color.set(color);
            setDirty(true);
        }
    }

    public void update(double deltaTime) {
        if (!lastTransform.equals(getTransform())) {
            setDirty(true);
        }
        getTransform().copyTo(lastTransform);
    }
}
