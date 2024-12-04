package com.example.konyvtar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustumeAdapter extends BaseAdapter {
    private final Context context;
    private final List<Book> books;

    public CustumeAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.itemlistview, viewGroup, false);

        }
        Book book = books.get(i);

        TextView textViewTitle = view.findViewById(R.id.tvBookTitle);
        TextView textViewAuthor = view.findViewById(R.id.tvAuthor);
        TextView textViewPage = view.findViewById(R.id.tvPage);

        textViewTitle.setText(book.getTitle());
        textViewAuthor.setText(book.getAuthor());
        textViewPage.setText("Oldal: "+ book.getPage());



        return view;
    }
}
