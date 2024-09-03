package com.onurbalci.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<AdapterItems> listnewData = new ArrayList<AdapterItems>();
    MyCustomAdapter myAdapter;
    ListView tvlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvlist = findViewById(R.id.tvlist);

        if(((CheckBox)findViewById(R.id.human1)).isChecked()){
            listnewData.add(new AdapterItems(1,"Jack", "White body, Black Hair"));
        }
        if(((CheckBox)findViewById(R.id.human2)).isChecked()){
            listnewData.add(new AdapterItems(2,"Maria", "White body, Gray Hair"));
        }
        if(((CheckBox)findViewById(R.id.dog)).isChecked()){
            listnewData.add(new AdapterItems(3,"Dog Henry", "White Body, Black Ears"));
        }
        if(((CheckBox)findViewById(R.id.cat)).isChecked()){
            listnewData.add(new AdapterItems(4,"Cat Sully", "Orange Body, Pink Nose"));
        }

        myAdapter = new MyCustomAdapter(listnewData);
        tvlist.setAdapter(myAdapter);
    }

    private class MyCustomAdapter extends BaseAdapter{
        public ArrayList<AdapterItems> listnewsDataAdapter;
        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdapter){
            this.listnewsDataAdapter = listnewsDataAdapter;
        }

        @Override
        public int getCount() {
            return listnewsDataAdapter.size();
        }
        @Override
        public String getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.ticket_layout, null);

            final AdapterItems s = listnewsDataAdapter.get(position);

            TextView tvID = (TextView)myView.findViewById(R.id.tvID);
            tvID.setText("ID: "+s.ID);


            TextView tvName = (TextView)myView.findViewById(R.id.tvName);
            tvName.setText(s.Name);
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),s.Name, Toast.LENGTH_LONG).show();
                }
            });

            TextView tvDesc = (TextView)myView.findViewById(R.id.tvDesc);
            tvDesc.setText(s.Description);
            tvDesc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),s.Description, Toast.LENGTH_LONG).show();
                }
            });

            return myView;
        }
    }

    public void description (View view) {
        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(dialogView);

        builder.setPositiveButton("Kapat", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
