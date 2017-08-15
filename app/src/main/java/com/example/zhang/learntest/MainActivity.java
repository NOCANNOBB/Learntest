package com.example.zhang.learntest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        Person[] listItems = new Person[]{
                new Person(R.drawable.mary,"Mary","New York","www.allmybuddies.com/mary","Avid cook,writes poetry"),
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


}
