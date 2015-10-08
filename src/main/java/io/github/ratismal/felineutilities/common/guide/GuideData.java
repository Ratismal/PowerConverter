package io.github.ratismal.felineutilities.common.guide;

import io.github.ratismal.felineutilities.api.guide.Guide;
import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.api.guide.GuideEntry;
import io.github.ratismal.felineutilities.client.lib.RefResource;
import io.github.ratismal.felineutilities.common.guide.page.PageText;
import io.github.ratismal.felineutilities.common.init.ModItems;
import io.github.ratismal.felineutilities.common.item.ItemEyePlunder;
import io.github.ratismal.felineutilities.common.item.ItemGuide;
import io.github.ratismal.felineutilities.common.lib.RefGuide;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuideData {

    public static GuideEntry test;
    public static GuideEntry test1;
    public static GuideEntry test2;

    public static GuideEntry plunderEye;

    public static void init() {

        Guide.addCategory(Guide.categoryBasic = new CategoryA(RefGuide.CATEGORY.BASIC, 9));
        Guide.addCategory(Guide.categoryIncomplete = new CategoryA(RefGuide.CATEGORY.INCOMPLETE, 8));

        GuideCategory categoryBasic = Guide.categoryBasic;
        GuideCategory categoryIncomplete = Guide.categoryIncomplete;

        categoryIncomplete.setIcon(new ResourceLocation(RefResource.GUIDE.CATEGORY_INCOMPLETE));

        test = new EntryA(RefGuide.ENTRY.TEST, categoryBasic);
        test.setPages(new PageText("0"), new PageText("1"));
        test.setIcon(new ItemStack(ModItems.guide));

        test1 = new EntryA(RefGuide.ENTRY.TEST, categoryBasic);
        test2 = new EntryA(RefGuide.ENTRY.TEST, categoryBasic);

        plunderEye = new EntryA(RefGuide.ENTRY.EYE_PLUNDER, categoryIncomplete);
        plunderEye.setPages(new PageText("0"), new PageText("1"));
        plunderEye.setIcon(new ItemStack(ModItems.eyePlunder));


        //categoryBasic.entries.add(test);

    }

}
