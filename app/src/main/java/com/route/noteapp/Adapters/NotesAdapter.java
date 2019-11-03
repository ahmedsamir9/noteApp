package com.route.noteapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.route.noteapp.DataBase.Model.Note;
import com.route.noteapp.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view_note,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int pos) {

        Note note=notes.get(pos);

        viewHolder.title.setText(note.getTitle());
        viewHolder.date.setText(note.getDate());
viewHolder.dec.setText(note.getDesc());

viewHolder.title.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        toggleclick.onclicktoggle(pos);
        viewHolder.expandableLayout.toggle();
    }
});
        switch (note.getPriority()){
            case 1:{
                viewHolder.priority.setText(R.string.high);
                viewHolder.priority.setBackgroundResource(R.drawable.high_padge);
                break;
            }
            case 2:{
                viewHolder.priority.setText(R.string.normal);
                viewHolder.priority.setBackgroundResource(R.drawable.normal_padge);
                break;
            }
            case 3:{
                viewHolder.priority.setText(R.string.low);
                viewHolder.priority.setBackgroundResource(R.drawable.low_padge);
                break;
            }
        }

    }

    public void changeData(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (notes==null)return 0;
        return notes.size();
    }
    onclick toggleclick;

    public void setToggleclick(onclick toggleclick) {
        this.toggleclick = toggleclick;
    }

    public  interface  onclick{
        public void onclicktoggle(int i);
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,dec;
        TextView date;
        TextView priority;
ExpandableLayout expandableLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
            priority=itemView.findViewById(R.id.priority);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
             dec = itemView.findViewById(R.id.dec);
        }
    }
}
