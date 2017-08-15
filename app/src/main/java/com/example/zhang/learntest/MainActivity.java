package com.example.zhang.learntest;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        Person[] listItems = new Person[]{
                new Person(R.drawable.mary,"Nary","New York","www.allmybuddies.com/mary","Avid cook,writes poetry"),
                new Person(R.drawable.joseph,"Joseph","Virginia","www.allmybuddies.com/Joseph","Author of servral novels"),
                new Person(R.drawable.leah,"Leah","North Carolina","www.allmybuddies.com/Leah","Baseketball superstar. Rock climber."),
                new Person(R.drawable.mark,"Mark","Denver","www.allmybuddies.com/Mark","Established chemical scientist with several patents.")

        };
        setListAdapter(new PersonAdapter(this,android.R.layout.simple_list_item_2,listItems));



    }

    @Override
    protected  void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        Person person = (Person)l.getItemAtPosition(position);


        Intent intent = new Intent(this,ProfileActivity.class);
        intent.putExtra(ProfileActivity.IMAGE,person.image);
        intent.putExtra(ProfileActivity.NAME,person.name);
        intent.putExtra(ProfileActivity.LOCATION,person.location);
        intent.putExtra(ProfileActivity.WEBSITE,person.website);
        intent.putExtra(ProfileActivity.DESCRIPTION,person.descr);

        startActivity(intent);
    }



    public class PersonAdapter extends BaseAdapter {

        private final Context context;
        private final int layout;
        private Person[] listItems;

        public PersonAdapter(Context contex, int layout, Person[] listItems) {
            this.context = contex;
            this.layout = layout;
            this.listItems = listItems;
        }

        @Override
        public int getCount(){
            return listItems.length;
        }

        @Override
        public Object getItem(int i){
            return listItems[i];
        }

        @Override
        public long getItemId(int i)
        {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View view = convertView;
            if(view == null)
            {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(layout,parent,false);
            }
            TextView text1 =(TextView)view.findViewById(android.R.id.text1);
            TextView text2 = (TextView)view.findViewById(android.R.id.text2);
            text1.setText(listItems[position].name);
            text2.setText(listItems[position].website);
            return  view;
        }


    }
}
