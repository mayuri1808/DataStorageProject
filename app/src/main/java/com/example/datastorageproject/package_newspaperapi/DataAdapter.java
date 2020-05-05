package com.example.datastorageproject.package_newspaperapi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.datastorageproject.R;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
     ArrayList<NewsPaper> articles=new ArrayList<>();
     Context context;

    public DataAdapter(ArrayList<NewsPaper> articles, Context context) {
        this.context=context;
        this.articles=articles;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, final int i) {

       /* final String title=articles.get(i).getTitle();
        final String description=articles.get(i).getDescription();
        final String author=articles.get(i).getAuthor();*/

        viewHolder.title.setText(articles.get(i).getTitle());
        viewHolder.description.setText(articles.get(i).getDescription());
        viewHolder.Author.setText(articles.get(i).getAuthor());
    }

    @Override
    public int getItemCount() {

        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView title,description,Author;


        public ViewHolder(View view) {
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            description = (TextView)view.findViewById(R.id.description);
            Author=(TextView) view.findViewById(R.id.author);
        }
    }

}
