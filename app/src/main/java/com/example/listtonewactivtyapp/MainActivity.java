package com.example.listtonewactivtyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] foodName = {"Pilau Chicken", "Chicken Shawarma", "Desserts", "French Fries", "Chicken Roasted"};
    int[] foodImages = {R.drawable.pilau_chicken, R.drawable.chicken_shawarma, R.drawable.desserts, R.drawable.french_fries, R.drawable.chicken_roasted};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                intent.putExtra("name",foodName[i]);
                intent.putExtra("image",foodImages[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foodImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           View view1 = getLayoutInflater().inflate(R.layout.row_data, null);
            TextView name = view1.findViewById(R.id.foods);
            ImageView image = view1.findViewById(R.id.image);

            name.setText(foodName[i]);
            image.setImageResource(foodImages[i]);

            return view1;
        }
    }
}