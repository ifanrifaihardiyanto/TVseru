package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page1Fragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.model.Result;

/**
 * Created by Ifan on 14/05/2017.
 */

public class NewMoveiAdapter extends RecyclerView.Adapter<NewMoveiAdapter.ViewHolder> {

    ArrayList<Result> list;
    Page1Fragment page1Fragment;
    Context context;
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;

    public NewMoveiAdapter(Page1Fragment page1Fragment, ArrayList<Result> list, Context context)
    {
        this.list = list;
        this.page1Fragment = page1Fragment;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Result result = list.get(position);
        holder.tvName.setText(result.title);
        holder.tvDesc.setText(result.overview);
        image = url+result.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDesc;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
        }
    }
}
