package cn.ksmcbrigade.igmun.mixin;

import cn.ksmcbrigade.igmun.HideGui;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(TitleScreen.class)
public abstract class AddButtonMixin extends Screen {
    protected AddButtonMixin(Text title) {
        super(title);
    }

    @Inject(method = "init",at = @At("TAIL"),locals = LocalCapture.CAPTURE_FAILSOFT)
    public void init(CallbackInfo ci, int i, int j, int k, int l){
        int c = 4;
        try {
            Class.forName("com.terraformersmc.modmenu.ModMenu");
            c = 4;
        }
        catch (Exception e){
            System.out.println("no mod menu.");
        }
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("ModHider"), (button) -> {
            this.client.setScreen(new HideGui(MinecraftClient.getInstance().currentScreen));
        }).dimensions(this.width / 2 - 100, l+24*c-26, 200, 16).build());
    }
}
