package net.killerkrow.asesno.init.mass;

import net.killerkrow.asesno.init.*;

public class AsesinoInit {
    public static void MassInit() {
        AsesinoItems.registerModItems();
        AsesinoItemGroups.registerItemGroups();
        FoodWeatherManager.register();
    }
}
