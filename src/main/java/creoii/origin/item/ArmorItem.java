package creoii.origin.item;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import creoii.origin.core.util.JsonUtil;
import creoii.origin.data.objects.JsonObjects;

public class ArmorItem extends Item implements EquippableItem {
    private final JsonObjects.StatData statBonus;

    public ArmorItem(String id, ItemType type, ItemRarity rarity, JsonObjects.StatData statBonus) {
        super(id, type, rarity);
        this.statBonus = statBonus;
    }

    @Override
    public JsonObjects.StatData getStatBonus() {
        return statBonus;
    }

    public static ArmorItem deserialize(JsonObject object) {
        String id = JsonUtil.getString(object, "id");
        ItemType type = ItemType.valueOf(JsonUtil.getString(object, "type").toUpperCase());
        ItemRarity rarity = ItemRarity.valueOf(JsonUtil.getString(object, "rarity", "COMMON").toUpperCase());
        JsonObjects.StatData statBonus = JsonObjects.StatData.deserialize(object, "stat_bonus");
        return new ArmorItem(id, type, rarity, statBonus);
    }

    public static JsonElement serialize(Item item, JsonSerializationContext context) {
        if (item instanceof ArmorItem weapon) {
            JsonObject object = new JsonObject();
            object.addProperty("id", item.getId());
            object.addProperty("type", item.getType().name().toLowerCase());
            object.addProperty("rarity", item.getRarity().name().toLowerCase());
            object.add("stat_bonus", context.serialize(weapon.getStatBonus()));
            return object;
        } throw new JsonSyntaxException("Unable to serialize non-weapon item.");
    }
}