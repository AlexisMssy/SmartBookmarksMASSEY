package org.diiage.amassey.smartboomarksmassey.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.diiage.amassey.smartboomarksmassey.Models.Comment;
import org.diiage.amassey.smartboomarksmassey.R;

import java.util.ArrayList;

public class ListViewCommentsAdapter extends BaseAdapter {
    ArrayList<Comment> data;
    Context context;
    LayoutInflater layoutInflater;

    public ListViewCommentsAdapter(ArrayList<Comment> data, Context context) {
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
    public Comment getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolderComments holder = null;

        if(convertView == null)
        {
            vi = layoutInflater.inflate(R.layout.listview_rowcomment, null);
            holder = new ViewHolderComments((TextView) vi.findViewById(R.id.tvComment),
                    (TextView) vi.findViewById(R.id.tvDate),
                    (TextView) vi.findViewById(R.id.tvBookTitle));
            vi.setTag(holder);
        }
        else
        {
            holder = (ViewHolderComments) vi.getTag();
        }

        Comment comment = getItem(position);

        holder.tvComment.setText(comment.getComment());
        holder.tvDate.setText(comment.getDate());
        holder.tvBookTitle.setText(comment.getBook().getAuthor());

        return vi;
    }
}

class ViewHolderComments{
    public TextView tvComment;
    public TextView tvDate;
    public TextView tvBookTitle;

    public ViewHolderComments(TextView tvComment, TextView tvDate, TextView tvBookTitle){
        this.tvComment = tvComment;
        this.tvDate = tvDate;
        this.tvBookTitle = tvBookTitle;
    }
}