package io.github.ratismal.felineutilities.init;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-16.
 */

public class Whitelist {

    public static List<String> whitelist = new ArrayList<String>();

    public static void init() {
        whitelist.add("sheep");
        whitelist.add("cow");
        whitelist.add("entityhorse");
        whitelist.add("enderman");
        whitelist.add("creeper");
        whitelist.add("zombie");
        whitelist.add("skeleton");
        whitelist.add("spider");
        whitelist.add("cavespider");
        whitelist.add("silverfish");
        whitelist.add("witch");
        whitelist.add("blaze");
        whitelist.add("chicken");
        whitelist.add("pig");
        whitelist.add("ozelot");
    }

}
