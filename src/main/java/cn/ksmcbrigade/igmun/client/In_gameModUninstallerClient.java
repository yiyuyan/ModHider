package cn.ksmcbrigade.igmun.client;

import cn.ksmcbrigade.igmun.Utils;
import net.fabricmc.api.ClientModInitializer;

public class In_gameModUninstallerClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        //hide self
        try {
            Utils.uninstall("igmun");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Can't hide self.");
        }
    }
}
