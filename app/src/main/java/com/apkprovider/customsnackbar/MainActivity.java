package com.apkprovider.customsnackbar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button snackTxtColor;
    private Button snackBgColor;
    private Button snackActionClick;
    private Button snackTitleFont;
    private Button snackActionFont;
    private Button snackTitleIcon;
    private Button snackActionIcon;

    private void findViews() {
        snackTxtColor = (Button)findViewById( R.id.snack_txt_color );
        snackBgColor = (Button)findViewById( R.id.snack_bg_color );
        snackActionClick = (Button)findViewById( R.id.snack_action_click );
        snackTitleFont = (Button)findViewById( R.id.snack_title_font );
        snackActionFont = (Button)findViewById( R.id.snack_action_font );
        snackTitleIcon = (Button)findViewById( R.id.snack_title_icon );
        snackActionIcon = (Button)findViewById( R.id.snack_action_icon );

        snackTxtColor.setOnClickListener( this );
        snackBgColor.setOnClickListener( this );
        snackActionClick.setOnClickListener( this );
        snackTitleFont.setOnClickListener( this );
        snackActionFont.setOnClickListener( this );
        snackTitleIcon.setOnClickListener( this );
        snackActionIcon.setOnClickListener( this );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.snack_txt_color:
                // Handle clicks for snackTxtColor

                CustomSnackBar customSnackBarTxtColor = new CustomSnackBar();
                customSnackBarTxtColor.view(snackTxtColor)
                        .text("Snackbar with custom text and action color","Done")
                        .textColors(Color.RED,Color.GREEN)
                        .duration(CustomSnackBar.SnackBarDuration.SHORT)
                        .show();
                break;

            case R.id.snack_bg_color:
                // Handle clicks for snackBgColor

                CustomSnackBar customSnackBarBgColor = new CustomSnackBar();
                customSnackBarBgColor.view(snackBgColor)
                        .text("Snackbar with custom background color", "Done")
                        .backgroundColor(Color.BLUE)
                        .duration(CustomSnackBar.SnackBarDuration.LONG)
                        .show();
                break;

            case R.id.snack_action_click:
                // Handle clicks for snackActionClick

                CustomSnackBar customSnackBarActionClick = new CustomSnackBar();
                customSnackBarActionClick.view(snackActionClick)
                        .text("Snackbar with ActionClick", "Click me")
                        .duration(CustomSnackBar.SnackBarDuration.INDEFINITE)
                        .setOnClickListener(true, new OnActionClickListener() {
                            @Override
                            public void onClick(View view) {

                              Toast.makeText(MainActivity.this,"Simple Toast Message",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

                break;

            case R.id.snack_title_font:

                CustomSnackBar customSnackBarTitleFont = new CustomSnackBar();
                customSnackBarTitleFont.view(snackTitleFont)
                        .text("Custom font for Title", "Done")
                        .customTitleFont(Typeface.MONOSPACE)
                        .show();

                break;

            case R.id.snack_action_font:

                CustomSnackBar customSnackBarActionFont = new CustomSnackBar();
                customSnackBarActionFont.view(snackActionFont)
                        .text("Custom font for Action", "Done")
                        .customActionFont(Typeface.MONOSPACE)
                        .show();

                break;

            case R.id.snack_title_icon:

                CustomSnackBar customSnackBarIconTitle = new CustomSnackBar();
                customSnackBarIconTitle.view(snackTitleIcon)
                        .text("Icons for title", "Done")
                        .setIconForTitle(generateDrawableBasedOnVersions(), CustomSnackBar.IconPosition.LEFT,6)
                        .show();
                break;

            case R.id.snack_action_icon:

                CustomSnackBar customSnackBarIconAction = new CustomSnackBar();
                customSnackBarIconAction.view(snackActionIcon)
                        .text("Icons for action", "Done")
                        .setIconForAction(generateDrawableBasedOnVersions(), CustomSnackBar.IconPosition.RIGHT,6)
                        .show();
                break;
        }
    }


    public Drawable generateDrawableBasedOnVersions(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getResources().getDrawable(android.R.drawable.ic_lock_lock, null);
        } else {
            return getResources().getDrawable(android.R.drawable.ic_lock_lock);
        }
    }
}
