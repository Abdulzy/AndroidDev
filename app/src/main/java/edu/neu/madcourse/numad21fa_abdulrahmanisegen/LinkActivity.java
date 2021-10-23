package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class LinkActivity extends AppCompatActivity  {

    private ArrayList<URLCard> itemList = new ArrayList<>();

    private RecyclerView recyclerView;
    private UViewAdapter uviewAdapter;
    private RecyclerView.LayoutManager rLayoutManger;
    private FloatingActionButton addButton;

    private ConstraintLayout snackBar;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText dialogName;
    private EditText dialogUrl;
    private Button dialogCancel;
    private Button dialogSave;


    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        snackBar = findViewById(R.id.constraint_link);
        init(savedInstanceState);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewDialog();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {


        int size = itemList == null ? 0 : itemList.size();
        outState.putInt(NUMBER_OF_ITEMS, size);

        for (int i = 0; i < size; i++) {
            outState.putString(KEY_OF_INSTANCE + i + "0", itemList.get(i).getName());
            outState.putString(KEY_OF_INSTANCE + i + "1", itemList.get(i).getUrl());
        }
        super.onSaveInstanceState(outState);
    }


    private void init(Bundle savedInstanceState) {

        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void initialItemData(Bundle savedInstanceState) {

        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if (itemList == null || itemList.size() == 0) {

                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

                // Retrieve keys we stored in the instance
                for (int i = 0; i < size; i++) {
                    String itemName = savedInstanceState.getString(KEY_OF_INSTANCE + i + "0");
                    String itemUrl = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");

                    URLCard urlCard = new URLCard(itemName, itemUrl);

                    itemList.add(urlCard);
                }
            }
        }

    }

    private void createRecyclerView() {


        rLayoutManger = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        uviewAdapter = new UViewAdapter(itemList);
        UrlListener urlListener = new UrlListener() {
            @Override
            public void onURLClick(int position) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemList.get(position).getUrl()));
                startActivity(intent);

                uviewAdapter.notifyItemChanged(position);
            }
        };
        uviewAdapter.setOnUrlListener(urlListener);

        recyclerView.setAdapter(uviewAdapter);
        recyclerView.setLayoutManager(rLayoutManger);
    }

    private void addItem(int position,String name, String url) {

        itemList.add(position, new URLCard(name, url));
        uviewAdapter.notifyItemInserted(position);
    }

    public void createNewDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View dialogPopup = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        dialogName = (EditText) dialogPopup.findViewById(R.id.dialog_name);
        dialogUrl = (EditText) dialogPopup.findViewById(R.id.dialog_url);

        dialogSave = (Button) dialogPopup.findViewById(R.id.dialog_save);
        dialogCancel = (Button) dialogPopup.findViewById(R.id.dialog_cancel);


        dialogBuilder.setView(dialogPopup);
        dialog = dialogBuilder.create();
        dialog.show();
        dialogSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = 0;
                if(!dialogName.getText().toString().trim().isEmpty()
                        && !dialogUrl.getText().toString().trim().isEmpty()){
                    String url = "" +dialogUrl.getText().toString().trim();
                    if(url.length() > 12){
                        String domain = url.substring((url.length() - 4));
                        if(dialogUrl.getText().toString().trim().substring(0,8).equals("https://" )
                                && (domain.equals(".com")
                                || domain.equals(".edu")
                                || domain.equals(".org"))){
                            addItem(pos, dialogName.getText().toString(),dialogUrl.getText().toString());
                            Snackbar.make(snackBar,"Link successfully added",Snackbar.LENGTH_LONG).show();
                        }
                        else{
                            Snackbar.make(snackBar, "Link unsuccessfully added", Snackbar.LENGTH_LONG)
                                    .setAction("Try Again", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            createNewDialog();
                                        }
                                    }).show();
                        }
                    }
                    else{
                        Snackbar.make(snackBar, "Link unsuccessfully added", Snackbar.LENGTH_LONG)
                                .setAction("Try Again", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        createNewDialog();
                                    }
                                }).show();
                    }
                }
                else{
                    Snackbar.make(snackBar, "Link unsuccessfully added", Snackbar.LENGTH_LONG)
                            .setAction("Try Again", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    createNewDialog();
                                }
                            }).show();
                }
                dialog.dismiss();
            }
        });

        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });




    }

}