package inventorySorter;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> MAGIC_LAMP_BLOCK = register(
            "magic_lamp",
            () -> new MagicLampBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(1.0f, 2.0f)
                    .sound(SoundType.GLASS)
            ),
            ItemGroup.DECORATIONS
    );

    // Load class to run static initializers
    public static void load() {}

    private static <T extends Block> RegistryObject<Block> register(String name, Supplier<T> blockSupplier, ItemGroup itemGroup) {
        RegistryObject<Block> block = Registration.BLOCKS.register(name, blockSupplier);
        Registration.ITEMS.register(
                name,
                () -> new BlockItem(block.get(), new Item.Properties().group(itemGroup))
        );
        return block;
    }
}
