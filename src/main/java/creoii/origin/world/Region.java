package creoii.origin.world;

import creoii.origin.tile.Tile;
import org.joml.Vector2f;

import java.util.function.Consumer;

public class Region {
    private Tile[][] tiles;

    public Region() {
        tiles = new Tile[32][32];

        for (int i = 0; i < tiles.length; ++i) {
            for (int j = 0; j < tiles[i].length; ++j) {
                tiles[i][j] = new Tile("rock.png");
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void forEachTile(Consumer<Tile> action) {
        for (Tile[] tile : tiles) {
            for (Tile value : tile) {
                action.accept(value);
            }
        }
    }
}
