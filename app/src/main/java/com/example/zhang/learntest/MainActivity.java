package com.example.zhang.learntest;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        Person[] listItems = new Person[]{
                new Person("Nary","www.allmybuddies.com/mary"),
                new Person("Joseph","www.allmybuddies.com/Joseph"),
                new Person("Leah","www.allmybuddies.com/Leah"),
                new Person("Mark","www.allmybuddies.com/Mark")

        };
        setListAdapter(new PersonAdapter(this,android.R.layout.activity_list_item,listItems));
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
