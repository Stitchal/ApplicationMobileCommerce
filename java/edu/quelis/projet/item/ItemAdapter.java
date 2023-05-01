package edu.quelis.projet.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import edu.quelis.projet.R;

public class ItemAdapter extends BaseAdapter {
    private final ItemAdapterListener activity;
    private final LayoutInflater inflater;
    private final Context context;

    public ItemAdapter(ItemAdapterListener activityCallBack){
        activity = activityCallBack;
        this.context = activityCallBack.getContext();
        System.out.println(context);
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return Items.getInstance().size();
    }

    @Override
    public Object getItem(int i) {
        return Items.getInstance().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View layoutItem = view == null ? inflater.inflate(R.layout.items_layout, viewGroup, false) : view;

        //(2) : Récupération des TextView de notre layout
        TextView displayName = (TextView)layoutItem.findViewById(R.id.item_name);
        TextView displayPrice = (TextView)layoutItem.findViewById(R.id.item_price);
        ImageView imagePizza = layoutItem.findViewById(R.id.item);

        //(3) : Renseignement des valeurs
        displayName.setText(Items.getInstance().get(i).getNom());
        System.out.println(i);
        String prix = String.valueOf(Items.getInstance().get(i).getPrix());
        displayPrice.setText(prix);
        imagePizza.setImageResource(Items.getInstance().get(i).image);

        layoutItem.setOnClickListener( layout -> {
            sendListener(Items.getInstance().get(i), displayName);
        });
        return layoutItem;
    }

    private void sendListener(Item item, TextView display) {
        activity.onClickNom(item, display);
    }


}