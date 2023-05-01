package edu.quelis.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;

import java.io.File;
import java.util.List;

import edu.quelis.projet.item.Item;

public class MainActivity extends AppCompatActivity implements PostExecuteActivity<Item>{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CreationJSON creationJSON = new CreationJSON("data");
        Button login = findViewById(R.id.login);
        login.setOnClickListener(view -> {
            /*Intent intent = new Intent(this, ItemsActivity.class);
            startActivity(intent);*/
            String url = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.17/items.json";
            new HttpAsyncGet<>(url, Item.class, this, new ProgressDialog(view.getContext()));
        });
    }

    @Override
    public void onPostExecutePokemons(List<Item> itemList) {

    }
}

