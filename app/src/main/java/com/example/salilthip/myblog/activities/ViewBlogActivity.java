package com.example.salilthip.myblog.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.utils.Storage;

import java.util.ArrayList;

public class ViewBlogActivity extends AppCompatActivity {

    private TextView titleBlog;
    private TextView descriptDetail;
    private ImageView editlabel;

    private Blog blog;
    private int locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_blog);
        Intent intent = getIntent();
        locationList = (int) intent.getSerializableExtra("pos_blog");
        Log.i("hello", locationList + "");
        blog = Storage.getInstance().getBlogList().get(locationList);
        initComponenets();

    }

    private void initComponenets() {
        titleBlog = (TextView)findViewById(R.id.title_viewpage);
        descriptDetail = (TextView)findViewById(R.id.descript_viewpage);
        editlabel = (ImageView)findViewById(R.id.icon_edit_viewpage);
        titleBlog.setText(blog.getTitle());
        descriptDetail.setText(blog.getDescription());
        editlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewBlogActivity.this,EditBlogActivity.class);
                intent.putExtra("pos_blog",locationList);
                startActivity(intent);
            }
        });
    }

}
