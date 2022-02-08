//todo rifare tuttaa aiuto
package model;

import java.util.ArrayList;
import java.util.List;

public class CarrelloBean extends Bean {
    final ArrayList<ProdottoBean> items;

    public CarrelloBean() {
        items = new ArrayList<>();
    }

    public void addItem(ProdottoBean item) {
        items.add(item);
    }

    public boolean alReadyIn(ProdottoBean item) {
        for(ProdottoBean it: items) {
            if(it.getId_prodotto().equals(item.getId_prodotto())) {
                return true;
            }
        }
        return false;
    }

    public void deleteItem(ProdottoBean item) {
        //items.remove(item);

        for(ProdottoBean it: items) {
            if(it.equals(item)) {
                items.remove(it);
                break;
            }
        }
    }

    public ArrayList<ProdottoBean> getItems() {
        return items;
    }

    public void deleteAllItems() {
        items.clear();
    }

    public boolean contains(ProdottoBean item){
        for(ProdottoBean it: items) {
            if(it.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getKey() {
        return null;
    }

    @Override
    public int compareKey(Bean otherBean) {
        return 0;
    }

    @Override
    public String getBeanName() {
        return null;
    }
}
