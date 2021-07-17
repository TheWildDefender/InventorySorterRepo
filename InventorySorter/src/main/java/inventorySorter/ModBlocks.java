package inventorySorter;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InventorySorter.MODID);

    public static final RegistryObject<Block> MAGIC_LAMP_BLOCK = registerBlockWithItem(
            "magic_lamp",
            () -> new MagicLampBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(1.0f, 2.0f)
                    .sound(SoundType.GLASS)
            ),
            ItemGroup.DECORATIONS
    );

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static <T extends Block> RegistryObject<Block> registerBlockWithItem(String name, Supplier<T> blockSupplier, ItemGroup itemGroup) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        ModItems.ITEMS.register(
                name,
                () -> new BlockItem(block.get(), new Item.Properties().group(itemGroup))
        );
        return block;
    }
}
