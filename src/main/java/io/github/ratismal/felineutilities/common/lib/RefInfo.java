package io.github.ratismal.felineutilities.common.lib;

public class RefInfo {

	public static final String MODID = "FelineUtilities";
    public static final String MODID_LOWER = MODID.toLowerCase();
	public static final String VERSION = "1.7.10-1.0";
	public static final String NAME = "Feline Utilities";
	public static final String CLIENT_PROXY_CLASS = "io.github.ratismal.felineutilities.client.core.proxy.ClientProxy";
	//public static final String CLIENT_PROXY_CLASS = "io.github.ratismal.felineutilities.proxy.ServerProxy";
    public static final String COMMON_PROXY_CLASS = "io.github.ratismal.felineutilities.common.core.proxy.CommonProxy";
	public static final String GUI_FACTORY_CLASS = "io.github.ratismal.felineutilities.api.gui.GuiFactory";

    public static final String RESOURCE_PREFIX = MODID_LOWER + ":";

    public static final int[] CONTROL_CODE_COLORS = new int[] {
            0x000000, 0x0000AA, 0x00AA00, 0x00AAAA,
            0xAA0000, 0xAA00AA, 0xFFAA00, 0xAAAAAA,
            0x555555, 0x5555FF, 0x55FF55, 0x55FFFF,
            0xFF5555, 0xFF55FF, 0xFFFF55, 0xFFFFFF
    };


}
