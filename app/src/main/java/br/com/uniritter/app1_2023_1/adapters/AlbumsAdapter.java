package br.com.uniritter.app1_2023_1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.uniritter.app1_2023_1.R;
import br.com.uniritter.app1_2023_1.models.Albums;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder>{
    private List<Albums> albumsList;

    public AlbumsAdapter(List<Albums> albumsList) {this.albumsList = albumsList;
    }

    @NonNull
    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.convite_para_batalhar, parent, false);
        view.findViewById(R.id.button4).setOnClickListener((v)->{
            Toast.makeText(view.getContext(), ((Albums)view.getTag()).getTitle(), Toast.LENGTH_SHORT).show();
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsAdapter.ViewHolder holder, int position) {
        Albums albums = albumsList.get(position);
        holder.view.setTag(albums);
        ((TextView) holder.view.findViewById(R.id.vhUserName)).setText(albums.getTitle());
    }

    @Override
    public int getItemCount() {
        return albumsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
