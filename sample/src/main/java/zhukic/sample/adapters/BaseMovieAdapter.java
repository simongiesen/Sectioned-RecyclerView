package zhukic.sample.adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhukic.sectionedrecyclerview.SectionedRecyclerAdapter;

import java.util.List;

import zhukic.sample.Movie;
import zhukic.sectionedrecyclerview.R;

/**
 * Created by RUS on 02.11.2016.
 */

public abstract class BaseMovieAdapter extends SectionedRecyclerAdapter<BaseMovieAdapter.SubheaderViewHolder, BaseMovieAdapter.MovieViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked(int adapterPosition, int positionInCollection);
    }

    protected List<Movie> movieList;

    protected OnItemClickListener onItemClickListener;

    public static class SubheaderViewHolder extends RecyclerView.ViewHolder {

        private static Typeface meduiumTypeface = null;

        public TextView subheaderText;

        public SubheaderViewHolder(View itemView) {
            super(itemView);
            this.subheaderText = (TextView) itemView.findViewById(R.id.subheaderText);

            if(meduiumTypeface == null) {
                meduiumTypeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "Roboto-Medium.ttf");
            }
            this.subheaderText.setTypeface(meduiumTypeface);
        }

    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        protected TextView textMovieName;
        protected TextView textMovieGenre;
        protected TextView textMovieYear;

        public MovieViewHolder(View itemView) {
            super(itemView);
            this.textMovieName = (TextView) itemView.findViewById(R.id.movieName);
            this.textMovieGenre = (TextView) itemView.findViewById(R.id.movieGenre);
            this.textMovieYear = (TextView) itemView.findViewById(R.id.movieYear);
        }
    }

    public BaseMovieAdapter(List<Movie> itemList) {
        super();
        this.movieList = itemList;
    }

    @Override
    public MovieViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public SubheaderViewHolder onCreateSubheaderViewHolder(ViewGroup parent, int viewType) {
        return new SubheaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false));
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
