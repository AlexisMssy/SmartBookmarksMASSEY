package org.diiage.amassey.smartboomarksmassey;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.diiage.amassey.smartboomarksmassey.Adapters.BookAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.CommentsAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.DatabaseAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.SpinnerBooksAdapter;
import org.diiage.amassey.smartboomarksmassey.Models.Book;

import java.util.ArrayList;

public class CreateCommentActivity extends AppCompatActivity {
    ArrayList<Book> books;
    SpinnerBooksAdapter customAdapter;
    Spinner spBooks;
    Book book;
    Button btnSubmit;
    EditText editComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comment);
        book = new Book();
        spBooks = (Spinner) findViewById(R.id.spBooks);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        editComment = (EditText)findViewById(R.id.editComment);

        DatabaseAdapter maCollecDb = new DatabaseAdapter(this);
        SQLiteDatabase db = maCollecDb.getWritableDatabase();
        final BookAdapter ba = new BookAdapter(db);
        final CommentsAdapter ca = new CommentsAdapter(db);
        books = ba.getAll();

        customAdapter = new SpinnerBooksAdapter(books, this);
        spBooks.setAdapter(customAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book = (Book)spBooks.getSelectedItem();
                ca.insert(book.getId(), editComment.getText().toString());
                Intent intent = new Intent(CreateCommentActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });

        //spLoisirs.setVisibility(View.GONE);
        //Book book = (Book)spBooks.getSelectedItem();

    }
}
