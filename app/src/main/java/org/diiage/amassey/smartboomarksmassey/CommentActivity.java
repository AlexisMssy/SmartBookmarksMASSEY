package org.diiage.amassey.smartboomarksmassey;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.diiage.amassey.smartboomarksmassey.Adapters.CommentsAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.DatabaseAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.ListViewCommentsAdapter;
import org.diiage.amassey.smartboomarksmassey.Models.Comment;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {

    ArrayList<Comment> comments;
    ListViewCommentsAdapter customAdapter;
    ListView lvComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        lvComments = (ListView) findViewById(R.id.lvComments);
        comments = new ArrayList<Comment>();

        DatabaseAdapter maCollecDb = new DatabaseAdapter(this);
        //Demande au Helper une connexion en lecture seule
        //SQLiteDatabase db = maCollecDb.getReadableDatabase();
        SQLiteDatabase db = maCollecDb.getWritableDatabase();

        CommentsAdapter commentsAdapter = new CommentsAdapter(db);
        comments = commentsAdapter.getAll();

        customAdapter = new ListViewCommentsAdapter(comments, this);

        lvComments.setAdapter(customAdapter);
    }
}
