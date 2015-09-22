package io.github.ratismal.felineutilities.common.guide;

import io.github.ratismal.felineutilities.api.guide.Guide;
import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.api.guide.GuideEntry;
import io.github.ratismal.felineutilities.api.guide.GuidePage;
import io.github.ratismal.felineutilities.common.lib.RefGuide;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class EntryA extends GuideEntry {

    public EntryA(String unlocalizedName, GuideCategory category) {
        super(unlocalizedName, category);
        Guide.addEntry(this, category);
    }

    @Override
    public GuideEntry setPages(GuidePage... pages) {
        for(GuidePage page : pages) {
            page.unlocalizedName = getUnlocalizedNamePage() + page.unlocalizedName;
        }

        return super.setPages(pages);
    }

    public String getUnlocalizedNameEntry() {
        return RefGuide.ENTRY.PREFIX + super.unlocalizedName;
    }

    public String getUnlocalizedNamePage() {
        return RefGuide.PAGE.PREFIX + super.unlocalizedName;
    }


}
