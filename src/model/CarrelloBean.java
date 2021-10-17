package model;

import java.util.ArrayList;

public class CarrelloBean {
    ArrayList<ProdottoBean> items;

    public CarrelloBean() {
        items = new ArrayList<ProdottoBean>();
    }

    public void addItem(ProdottoBean item) {
        items.add(item);
    }

    /*public boolean alReadyIn(ProdottoBean item) {
        for(ProdottoBean it: items) {
            if(it.getId_prodotto().equals(item.getId_prodotto())) {
                return true;
            }
        }
        return false;
    }
*/

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
}
