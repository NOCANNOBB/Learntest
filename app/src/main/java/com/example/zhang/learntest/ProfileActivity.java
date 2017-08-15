package com.example.zhang.learntest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by zhang on 2017/8/15.
 */

public class ProfileActivity extends Activity {

    public static final String IMAGE = "IMAGE";
    public static final String NAME = "NAME";
    public static final String LOCATION = "LOCATION";
    public static final String WEBSITE = "WEBSITE";
    public static final String DESCRIPTION = "DESCRIPTION";

    private TextView name;
    private TextView location;
    private TextView webSite;
    private TextView onlineStatus;
    private EditText description;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle sasvedInstaceState){
        super.onCreate(sasvedInstaceState);
        setContentView(R.layout.relative_example);
        name = (TextView)findViewById(R.id.name);
        location = (TextView)findViewById(R.id.location);
        webSite = (TextView)findViewById(R.id.website);
        onlineStatus = (TextView)findViewById(R.id.online_status);
        description = (EditText)findViewById(R.id.description);

        int profileImageId = getIntent().getIntExtra(IMAGE,-1);
        profileImage.setImageDrawable(getResources().getDrawable(profileImageId));
        name.setText(getIntent().getStringExtra(NAME));
        location.setText(getIntent().getStringExtra(LOCATION));
        webSite.setText(getIntent().getStringExtra(WEBSITE));
        description.setText(getIntent().getStringExtra(DESCRIPTION));

        View parent = (View)name.getParent();

        parent.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        name.setTextAppearance(this,android.R.style.TextAppearance_DeviceDefault_Large);
        location.setTextAppearance(this,android.R.style.TextAppearance_DeviceDefault_Inverse);
        webSite.setTextAppearance(this,android.R.style.TextAppearance_DeviceDefault_Inverse);
        onlineStatus.setTextAppearance(this,android.R.style.TextAppearance_DeviceDefault_Inverse);
        description.setEnabled(false);
        description.setBackgroundColor(getResources().getColor(android.R.color.black));

    }
}
