package co.ak.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.net.ProtocolFamily;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Note> mNotes;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        return new ViewHolder(view);
    }

    public Note getNoteAt(int position){
        return mNotes.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = mNotes.get(position);
        holder.txtPriority.setText(String.valueOf(note.getPriority()));
        holder.txtTitle.setText(note.getTitle());
        holder.txtDescription.setText(note.getDescription());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Touched", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public void setList(List<Note> mNotes){
        this.mNotes = mNotes;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle, txtDescription, txtPriority;
        CardView container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtPriority = itemView.findViewById(R.id.txtPriority);
            container = itemView.findViewById(R.id.container);

        }
    }
}
