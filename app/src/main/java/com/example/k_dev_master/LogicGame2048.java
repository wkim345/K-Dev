package com.example.k_dev_master;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class LogicGame2048 extends AppCompatActivity {
    // 2048 Game
    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";
    private static final String SCORE = "score";
    private static final String HIGH_SCORE = "high score temp";
    private static final String UNDO_SCORE = "undo score";
    private static final String CAN_UNDO = "can undo";
    private static final String UNDO_GRID = "undo";
    private static final String GAME_STATE = "game state";
    private static final String UNDO_GAME_STATE = "undo game state";
    private MainView2048 view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MainView2048(this);
        setContentView(R.layout.activity_main_2048game);
        ImageButton openMenu = findViewById(R.id.ListViewBtn2048);
        view.invalidate();
        openMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(LogicGame2048.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_2048, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()) {
                            case R.id.pop_2048:
                                startActivity(new Intent());

                            case R.id.pop_2048_inst:
                                LayoutInflater inflater = (LayoutInflater)
                                        getSystemService(LAYOUT_INFLATER_SERVICE);
                                View popupView = inflater.inflate(R.layout.popup_instruction_2048, null);

                                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                                boolean focusable = true; // lets taps outside the popup also dismiss it
                                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                                // show the popup window
                                // which view you pass in doesn't matter, it is only used for the window tolken
                                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                                // dismiss the popup window when touched
                                popupView.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        popupWindow.dismiss();
                                        return true;
                                    }
                                });




                            case R.id.pop_2048_exit:
                                //view.getContext().startActivity();

                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
//        findViewById(R.layout.activity_main_2048game).setOnTouchListener(this);
    }



//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_MENU) {
//            //Do nothing
//            return true;
//        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
//            view.game.move(2);
//            return true;
//        } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
//            view.game.move(0);
//            return true;
//        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
//            view.game.move(3);
//            return true;
//        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
//            view.game.move(1);
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    //    @Override
    //    public void onBackPressed() {
    //        Toast.makeText(this, "Back button pressed.", Toast.LENGTH_SHORT).show();
    //        super.onBackPressed();
    //    }
}
