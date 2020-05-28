package com.JavaLabs.mobileimagesorter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ImageSorter.Image;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>  {
    ArrayList<Image> items = new ArrayList<>();

    public void setItems(ArrayList<Image> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);

        return new ImageAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ImageViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView pic;

        public ImageViewHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.imageIcon);

        }

        public void bind(Image item) {
            pic.setImageBitmap(item.getSource());
        }
    }
}