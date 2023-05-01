package edu.quelis.projet.item;

import java.util.ArrayList;

public class Items extends ArrayList<Item> {
    private static Items instance = null;

    public static Items getInstance(){
        if(instance==null){
            instance = new Items();
        }
        return instance;
    }

    private Items(){
        //TODO -> récupérer tous les items, webService ?
    }


}
