package io.github.ratismal.felineutilities.api.containers;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class EmptyContainerFactory extends ContainerFactory {

    private static EmptyContainerFactory instance = null;

    public static synchronized EmptyContainerFactory getInstance() {
        if (instance == null) {
            instance = new EmptyContainerFactory();
        }
        return instance;
    }

}
