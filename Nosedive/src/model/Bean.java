package model;

import java.util.List;

public abstract class Bean {
    /**
     * Ritorna una collezione di valori, indicati con la notazione di tuple (key1, key2, ...)
     * ogni valore e' stato convertito in una String
     */
    public abstract List<String> getKey();

    /**
     * Ritorna 0 se i due Bean sono uguali,
     * > 0 se this e' maggiore di otherBean o le classi sono diverse
     * < 0 se this e' minore di otherBean
     */
    public abstract int compareKey(Bean otherBean);

    /**
     * Metodo aggiunto per semplicità
     *
     * @return Nome del Bean o null se non possiede il concetto di nome
     */
    public abstract String getBeanName();
}
