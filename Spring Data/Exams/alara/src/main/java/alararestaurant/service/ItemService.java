package alararestaurant.service;

import java.io.IOException;

public interface ItemService {

    Boolean itemsAreImported();

    String readItemsJsonFile() throws IOException;

    String importItems(String items);
}
