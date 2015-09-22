package io.github.ratismal.felineutilities.common.guide;

import io.github.ratismal.felineutilities.api.guide.Guide;
import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.api.guide.GuideEntry;
import io.github.ratismal.felineutilities.common.guide.page.PageText;
import io.github.ratismal.felineutilities.common.lib.RefGuide;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuideData {

    public static GuideEntry test;

    public static void init() {

        Guide.addCategory(Guide.categoryBasic = new CategoryA(RefGuide.CATEGORY.BASIC, 9));

        GuideCategory categoryBasic = Guide.categoryBasic;

        test = new EntryA(RefGuide.ENTRY.TEST, categoryBasic);

    }

}
