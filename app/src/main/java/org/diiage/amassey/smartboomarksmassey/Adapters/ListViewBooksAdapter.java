package org.diiage.amassey.smartboomarksmassey.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.diiage.amassey.smartboomarksmassey.Models.Book;
import org.diiage.amassey.smartboomarksmassey.R;

import java.util.ArrayList;

public class ListViewBooksAdapter extends BaseAdapter {
    ArrayList<Book> data;
    Context context;
    LayoutInflater layoutInflater;

    public ListViewBooksAdapter(ArrayList<Book> data, Context context) {
        super();
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Book getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder = null;

        if(convertView == null)
        {
            vi = layoutInflater.inflate(R.layout.listview_rowbook, null);
            holder = new ViewHolder((TextView) vi.findViewById(R.id.textViewTitle),
                    (TextView) vi.findViewById(R.id.textViewAuthor),
                    (TextView) vi.findViewById(R.id.textViewGenre),
                    (TextView) vi.findViewById(R.id.textViewNbComments));
            vi.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) vi.getTag();
        }

        Book book = getItem(position);

        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvGenre.setText(book.getGenre());
        holder.tvCommentsCount.setText(String.valueOf(book.getCommentsCount()));

        return vi;
    }
}

class ViewHolder{
    public TextView tvTitle;
    public TextView tvAuthor;
    public TextView tvGenre;
    public TextView tvCommentsCount;

    public ViewHolder(TextView tvTitle, TextView tvAuthor, TextView tvGenre, TextView tvCommentsCount){
        this.tvTitle = tvTitle;
        this.tvAuthor = tvAuthor;
        this.tvGenre = tvGenre;
        this.tvCommentsCount = tvCommentsCount;
    }
}
