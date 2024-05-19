package cn.ksmcbrigade.igmun;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class In_gameModUninstaller implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("hideMod").then(argument("id", StringArgumentType.string()).executes(context -> {
            try {
                int r = 0;
                boolean ret = Utils.uninstall(StringArgumentType.getString(context,"id").toLowerCase());
                if(!ret){
                    r = 1;
                    context.getSource().sendMessage(Text.of("Can't hide the mod."));
                }
                else{
                    context.getSource().sendMessage(Text.of("Done."));
                }
                return r;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                context.getSource().sendMessage(Text.of("ERROR:" + e.getMessage()));
                e.printStackTrace();
                return 1;
            }
        }))));
    }
}
