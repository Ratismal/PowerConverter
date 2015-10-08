package io.github.ratismal.felineutilities.common.guide;

import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.client.lib.RefResource;
import io.github.ratismal.felineutilities.common.lib.RefGuide;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class CategoryA extends GuideCategory {

    public CategoryA(String unlocalizedName, int priority) {
        super(RefGuide.CATEGORY.PREFIX + unlocalizedName);
        setIcon(new ResourceLocation(RefResource.GUIDE.CATEGORY_BASIC));
        setPriority(priority);
    }

}