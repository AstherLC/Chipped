package earth.terrarium.chipped.common.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.stream.Stream;

public final class ModUtils {

    public static void writeItem(FriendlyByteBuf buffer, Item item) {
        buffer.writeVarInt(Item.getId(item));
    }

    public static Item readItem(FriendlyByteBuf buffer) {
        return Item.byId(buffer.readVarInt());
    }

    public static <T> Stream<T> streamHolderSet(HolderSet<T> holderSet) {
        return holderSet.stream().filter(Holder::isBound).map(Holder::value);
    }

    public static <T> List<T> fromHolderSet(HolderSet<T> holderSet) {
        return streamHolderSet(holderSet).toList();
    }

    public static ResourceLocation expectResourcelocation(JsonElement element) {
        if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isString()) {
            final ResourceLocation rl = ResourceLocation.tryParse(element.getAsString());
            if (rl == null) {
                throw new JsonSyntaxException("Invalid resourcelocation: " + element.getAsString());
            }
            return rl;
        }
        throw new JsonSyntaxException("Expected resourcelocation, got " + element);
    }
}
