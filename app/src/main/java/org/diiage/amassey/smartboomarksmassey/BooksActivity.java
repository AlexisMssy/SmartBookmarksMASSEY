package org.diiage.amassey.smartboomarksmassey;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.diiage.amassey.smartboomarksmassey.Adapters.BookAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.DatabaseAdapter;
import org.diiage.amassey.smartboomarksmassey.Adapters.ListViewBooksAdapter;
import org.diiage.amassey.smartboomarksmassey.Models.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    ArrayList<Book> books;
    ListViewBooksAdapter customAdapter;
    ListView lvBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        lvBooks = (ListView) findViewById(R.id.listViewBooks);
        books = new ArrayList<Book>();

        DatabaseAdapter maCollecDb = new DatabaseAdapter(this);
        //Demande au Helper une connexion en lecture seule
        //SQLiteDatabase db = maCollecDb.getReadableDatabase();
        SQLiteDatabase db = maCollecDb.getWritableDatabase();

        BookAdapter booksAdapter = new BookAdapter(db);
        books = booksAdapter.getAll();

        customAdapter = new ListViewBooksAdapter(books, this);

        lvBooks.setAdapter(customAdapter);
    }
}
