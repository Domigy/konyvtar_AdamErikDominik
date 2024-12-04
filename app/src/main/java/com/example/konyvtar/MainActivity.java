package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    private CustumeAdapter adapter;
    private EditText editTextTitle;
    private EditText editTextAuthor;
    private EditText editTextPage;
    private Button addButton;
    private ListView listViewBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();


        listViewBook.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("Title", bookList.get(position).getTitle());
            intent.putExtra("Author", bookList.get(position).getAuthor());
            intent.putExtra("Page", bookList.get(position).getPage());
            startActivity(intent);
        });
        listViewBook.setOnItemLongClickListener((parent, view, position, id) -> {
            bookList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
    public void init(){
        adapter = new CustumeAdapter(this, bookList);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextPage = findViewById(R.id.editTextPage);
        addButton= findViewById(R.id.addButton);
        listViewBook = findViewById(R.id.listViewBook);
        listViewBook.setAdapter(adapter);

        addButton.setOnClickListener(view ->{
            String title = editTextTitle.getText().toString();
            String author = editTextAuthor.getText().toString();
            String page = editTextPage.getText().toString();
            if(!title.isEmpty()&& !author.isEmpty() && !page.isEmpty()){
                if(Integer.parseInt(page)>49){
                 bookList.add(new Book(title, author, Integer.parseInt(page)));
                 adapter.notifyDataSetChanged();
                 editTextAuthor.setText("");
                 editTextPage.setText("");
                 editTextTitle.setText("");
                }
                else{
                    CharSequence text = "Az oldalszám legalább 50 legyen!!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(this, text, duration);
                    toast.show();
                }
            }

        });









    }
}