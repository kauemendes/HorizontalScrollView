package com.kauemendes.horizontalscroll;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    // GUI controls
    TextView txtMsg;
    ViewGroup scrollViewGroup;
    // each frame in the horizontalScrollView has [icon, caption]
    ImageView icon;
    TextView caption;

    //frame-captions;
    String[] itens = { "Data-1", "Data-2", "Data-3", "Data-4", "Data-5",
            "Data-6", "Data-7", "Data-8", "Data-9", "Data-10" };

    Integer[] thumbnails = { R.drawable.image_thumb1 ,
            R.drawable.image_thumb2 ,
            R.drawable.image_thumb3 ,
            R.drawable.image_thumb4 ,
            R.drawable.image_thumb5 ,
            R.drawable.image_thumb6 ,
            R.drawable.image_thumb7 ,
            R.drawable.image_thumb8 ,
            R.drawable.image_thumb9 ,
            R.drawable.image_thumb10
    };

    Integer[] largeImages = { R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
    };

    ImageView imageSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind GUI controls to java classes
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        imageSelected = (ImageView) findViewById(R.id.imageSelected);

        // this layout goes inside  the horizontalViewGroup
        scrollViewGroup = (ViewGroup) findViewById(R.id.viewgroup);

        for(int i = 0; i < itens.length; i++)
        {
            final View singleFrame = getLayoutInflater().inflate(R.layout.frame_icon_caption,null);

            singleFrame.setId(i);

            TextView caption = (TextView) singleFrame.findViewById(R.id.caption);
            ImageView icon = (ImageView) singleFrame.findViewById(R.id.icon);

            // put data[ icon, caption] in each frame;
            icon.setImageResource(thumbnails[i]);
            caption.setText(itens[i]);

            scrollViewGroup.addView( singleFrame );

            singleFrame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = "Selected position " +  singleFrame.getId();
                    txtMsg.setText(text);
                    ShowLargeImage(singleFrame.getId());
                }
            });

        } // For de populating

    }

    protected void ShowLargeImage(int frameId){
        Drawable selectedLargeImage = getResources()
                .getDrawable(largeImages[frameId]);
        imageSelected.setBackground(selectedLargeImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
