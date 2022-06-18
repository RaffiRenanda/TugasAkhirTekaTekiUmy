package com.example.tugasakhir.TemanAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.History;
import com.example.tugasakhir.R;
import com.example.tugasakhir.RemidiAll;
import com.example.tugasakhir.database.DBController;
import com.example.tugasakhir.model.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listData;
    private Context control;

    public TemanAdapter(ArrayList<Teman> listD){

        this.listData = listD;
    }

    @Override
    public TemanAdapter.TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());

        View v = layoutInf.inflate(R.layout.barisdata_teman, parent, false);
        control = parent.getContext();
        return new TemanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TemanViewHolder holder, int position) {

        String id, scr;
        id = listData.get(position).getId();
        scr = listData.get(position).getSkor();
        DBController db = new DBController(control);
        holder.namaTxt.setText(scr);

        holder.kartu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupmenu = new PopupMenu(control, holder.kartu);
                popupmenu.inflate(R.menu.popup_menu);
                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.mnHapus:
                                HashMap<String,String> values = new HashMap<>();
                                values.put("id", id);
                                db.DeleteData(values);
                                Intent j = new Intent (control, History.class);
                                control.startActivity(j);
                                break;
                            case R.id.mnRemid:
                                Intent i = new Intent(control, RemidiAll.class);
                                i.putExtra("id",id);


                                control.startActivity(i);
                                break;

                        }
                        return true;
                    }
                });
                popupmenu.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {

        return (listData != null)? listData.size() : 0;
    }

    public class TemanViewHolder extends  RecyclerView.ViewHolder{
        private CardView kartu;
        private TextView namaTxt;
        public TemanViewHolder(View v){
            super(v);
            kartu = (CardView) v.findViewById(R.id.cardv);
            namaTxt = (TextView) v.findViewById(R.id.textNama);


        }
    }
}
