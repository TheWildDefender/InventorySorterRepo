package inventorySorter;

import net.minecraft.client.gui.screen.inventory.ChestScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModChestScreen extends ChestScreen {
    public ModChestScreen(ChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void init() {
        super.init();
        addButton(new Button(guiLeft, guiTop, 10, 10, new TranslationTextComponent("gui.inventory-sorter.sort-button"), this::onButton));
    }

    private void onButton(Button button) {
    }
}
