package com.andififian.resto2;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class AdapterListMaPembuka extends RecyclerView.Adapter<AdapterListMaPembuka.HolderItem> {
    List<ListModelMaPembuka> mListItem;
    Context context;
    private final MakananUtamaInterface makananutamainterface;

    public AdapterListMaPembuka(List<ListModelMaPembuka> mListItem, Context context, MakananUtamaInterface makananutamainterface) {
        this.mListItem = mListItem;
        this.context = context;
        this.makananutamainterface = makananutamainterface;
    }

    @NonNull
    @Override
    public HolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_big,parent,false);
        HolderItem holder = new HolderItem(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListMaPembuka.HolderItem holder, int position) {
        ListModelMaPembuka mlist = mListItem.get(position);

        holder.judulmenumakanan.setText(mlist.getMenu_makanan());
        holder.harga.setText(mlist.getHarga());
        holder.deskripsi.setText(mlist.getDesc_makanan());

        /*ambil gambar*/
        Glide.with(context)
                .load(mlist.getGambar_makanan())
                .thumbnail(0.5f)
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView judulmenumakanan, harga, deskripsi;

        public HolderItem(View v){
            super(v);

            thumbnail = (ImageView) v.findViewById(R.id.imagess);
            judulmenumakanan = v.findViewById(R.id.judulmenumakanan);
            deskripsi = v.findViewById(R.id.deskripsi);
            harga = v.findViewById(R.id.hargamakanan);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(makananutamainterface != null){
                        int pos = getBindingAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            makananutamainterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

    }

}
