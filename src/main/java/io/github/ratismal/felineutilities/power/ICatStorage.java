package io.github.ratismal.felineutilities.power;

/**
 * Created by Ratismal on 2015-09-09.
 */
public interface ICatStorage {

    void receiveCat(int receiveMax);

    void extractCat(int extractMax);

    int receiveRF(int receiveMax);

    int extractRF(int extractMax);

    int receiveEU(int receiveMax);

    int extractEU(int extractMax);

    int getEnergy();

    int getCapacity();

}
