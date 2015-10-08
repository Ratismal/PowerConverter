package io.github.ratismal.felineutilities.api.guide;

import io.github.ratismal.felineutilities.common.core.util.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class Guide {

    private static List<GuideCategory> categories = new ArrayList<GuideCategory>();
    private static List<GuideEntry> entries = new ArrayList<GuideEntry>();

    public static GuideCategory categoryBasic;
    public static GuideCategory categoryIncomplete;

    public static void addCategory(GuideCategory category) {
        categories.add(category);
    }

    public static List<GuideCategory> getCategories() {
        return categories;
    }

    public static void addEntry(GuideEntry entry, GuideCategory category) {
        Logger.Debug.info("Adding entry " + entry.getUnlocalizedName() + " to " + category.getUnlocalizedName());
        entries.add(entry);
        category.entries.add(entry);
    }

    public static List<GuideEntry> getEntries() {
        return entries;
    }

}
