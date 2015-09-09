package io.github.ratismal.powerconverter.tab;

import io.github.ratismal.powerconverter.init.ModItems;
import io.github.ratismal.powerconverter.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabPC {

	public static final CreativeTabs PC_TAB = new CreativeTabs(Reference.MODID) {
		@Override
		public Item getTabIconItem() {
			return ModItems.blankModule;
		}

		@Override
		public String getTranslatedTabLabel() {
			return "PowerConverter";
		}
	};

}
