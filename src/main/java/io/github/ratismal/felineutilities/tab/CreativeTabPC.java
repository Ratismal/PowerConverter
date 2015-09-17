package io.github.ratismal.felineutilities.tab;

import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabPC {

	public static final CreativeTabs PC_TAB = new CreativeTabs(Reference.MODID) {
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
