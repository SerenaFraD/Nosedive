package model;

import java.util.ArrayList;

public class Cart {
    ArrayList<ProductBean> items;

    public Cart() {
        items = new ArrayList<ProductBean>();
    }

    public void addItem(ProductBean item) {
        items.add(item);
    }

    public boolean alReadyIn(ProductBean item) {
        for(ProductBean it: items) {
            if(it.getCodiceProd().equals(item.codiceProd)) {
                return true;
            }
        }
        return false;
    }

    //incrementa la quantità dei prodotti nel carrello di 1
    public void incrementItem(ProductBean bean){
        for(ProductBean prod : items){
            if(bean.getCodiceProd().equals(prod.getCodiceProd()))
                prod.setQuantita(prod.getQuantita()+1);
        }
    }

    public void deleteItem(ProductBean item) {
        //items.remove(item);

        for(ProductBean it: items) {
            if(it.getCodiceProd().equals(item.getCodiceProd())) {
                items.remove(it);
                break;
            }
        }
    }

    public ArrayList<ProductBean> getItems() {
        return items;
    }

    public void deleteItems() {
        items.clear();
    }

    public boolean contains(ProductBean item){
        for(ProductBean it: items) {
            if(it.equals(item)) {
                return true;
            }
        }
        return false;
    }
}

