package io.github.ratismal.felineutilities.common.tab;

import io.github.ratismal.felineutilities.common.init.ModItems;
import io.github.ratismal.felineutilities.common.lib.RefInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabPC {

	public static final CreativeTabs PC_TAB = new CreativeTabs(RefInfo.MODID) {
		@Override
		public Item getTabIconItem() {
			return ModItems.eyePlunder;
		}

		@Override
		public String getTranslatedTabLabel() {
			return "Feline Utilities";
		}
	};

}
