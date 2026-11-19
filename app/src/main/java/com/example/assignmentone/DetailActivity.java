package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Detail screen of CampusLife.
 * Shows a banner with the topic icon and name, followed by a title and
 * scrollable content text for one topic.
 */
public class DetailActivity extends AppCompatActivity {

    /** Intent extra key for the index of the topic to show. */
    public static final String EXTRA_TOPIC_INDEX = "com.example.assignmentone.EXTRA_TOPIC_INDEX";

    // Unique identifier of each topic. The values are positions in the
    // string arrays, so they must follow the order Facilities, Events, Clubs, Support.
    public static final int TOPIC_FACILITIES = 0;
    public static final int TOPIC_EVENTS = 1;
    public static final int TOPIC_CLUBS = 2;
    public static final int TOPIC_SUPPORT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        // Pad the root layout so that content is not drawn under the status and navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
