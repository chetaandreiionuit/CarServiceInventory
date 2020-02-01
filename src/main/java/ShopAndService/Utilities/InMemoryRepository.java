package ShopAndService.Utilities;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository {
    private List<Piesa> storage;

    //Creaza o lista cand accesam constructorul
    public InMemoryRepository() {
        this.storage = new ArrayList<Piesa>();
    }

    public void addToList(Piesa newPiesaToAdd) {
        storage.add(newPiesaToAdd);
    }

    public void removeFromList(String numePiesa) {
        storage.remove(getIndexOf(numePiesa));
    }

    public int getIndexOf(String numePiesa) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getNumePiesa() == numePiesa) {
                return i;
            }
        }
        return 0;
    }
}
