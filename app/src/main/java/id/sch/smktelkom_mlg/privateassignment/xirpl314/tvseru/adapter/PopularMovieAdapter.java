package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.NewScrollingActivity;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page2Fragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.Page3Fragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru.model.Result;

/**
 * Created by Ifan on 14/05/2017.
 */

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.ViewHolder> {

    ArrayList<Result> list;
    Page3Fragment page3Fragment;
    Context context;
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;

    public PopularMovieAdapter(Page3Fragment page3Fragment, ArrayList<Result> list, Context context)
    {
        this.list = list;
        this.page3Fragment = page3Fragment;
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = result.id;
                Intent intent = new Intent(context, NewScrollingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movie_title",result.title);
                intent.putExtra("poster_path",result.backdrop_path);
                intent.putExtra("description",result.overview);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDesc;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
            cardView = (CardView) itemView.findViewById(R.id.CardView);
        }
    }
}
