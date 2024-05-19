package cn.ksmcbrigade.igmun;

import net.fabricmc.loader.language.LanguageAdapter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.SimpleOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class HideGui extends SimpleOptionsScreen {


    public HideGui(Screen last) {
        super(last, MinecraftClient.getInstance().options,Text.of("All mods"),Utils.getMods(last));
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

}
