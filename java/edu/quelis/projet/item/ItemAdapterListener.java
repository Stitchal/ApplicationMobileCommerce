package edu.quelis.projet.item;

import android.content.Context;
import android.widget.TextView;

public interface ItemAdapterListener {
    void onClickNom(Item item, TextView display);
    Context getContext();
}