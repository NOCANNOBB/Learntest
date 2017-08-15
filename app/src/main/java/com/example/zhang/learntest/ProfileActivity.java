package com.example.zhang.learntest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by zhang on 2017/8/15.
 */

public class ProfileActivity extends Activity {
    private TextView name;
    private TextView location;
    private TextView webSite;
    private TextView onlineStatus;
    private EditText description;

    @Override
    protected void onCreate(Bundle sasvedInstaceState){
        super.onCreate(sasvedInstaceState);
        setContentView(R.layout.relative_example);
        name = (TextView)findViewById(R.id.name);
        location = (TextView)findViewById(R.id.location);
        webSite = (TextView)findViewById(R.id.website);
        onlineStatus = (TextView)findViewById(R.id.online_status);
        description = (EditText)findViewById(R.id.description);

        View parent = (View)name.getParent();

        parent.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        name.setTextAppearance(this,android.R.style.TextAppearance_DeviceDefault_Large);

    }
}
