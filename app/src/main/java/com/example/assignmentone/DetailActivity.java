package com.example.assignmentone;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Detail screen of CampusLife.
 * Shows a banner with the topic icon and name, followed by a title and
 * scrollable content text for one topic.
 * The topic is chosen by the index that MainActivity passes in the Intent.
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

        // Read the unique identifier of the clicked topic (Facilities if it is missing)
        int topicIndex = getIntent().getIntExtra(EXTRA_TOPIC_INDEX, TOPIC_FACILITIES);
        showTopic(topicIndex);
    }

    /**
     * Fills the screen with the data of one topic.
     * All arrays use the same order, so the topic index selects the matching
     * name, title, content and image name without any if or switch statements.
     * getIdentifier() is used (and its lint warning suppressed) because
     * arrays.xml stores the image names as plain text, not as resource ids.
     *
     * @param topicIndex one of the TOPIC_* identifiers
     */
    @SuppressLint("DiscouragedApi")
    private void showTopic(int topicIndex) {
        Resources resources = getResources();

        // Retrieve the data that belongs to the selected topic
        String name = resources.getStringArray(R.array.topic_names)[topicIndex];
        String title = resources.getStringArray(R.array.string_array_titles)[topicIndex];
        String content = resources.getStringArray(R.array.string_array_content)[topicIndex];
        // The image names in arrays.xml have spaces around them, so trim them first
        String imageName = resources.getStringArray(R.array.string_array_images)[topicIndex].trim();
        int imageId = resources.getIdentifier(imageName, "drawable", getPackageName());

        // Replace the placeholder text and image in the layout
        ImageView ivIcon = findViewById(R.id.imageviewDetailIcon);
        TextView tvName = findViewById(R.id.textviewDetailName);
        TextView tvTitle = findViewById(R.id.textviewDetailTitle);
        TextView tvContent = findViewById(R.id.textviewDetailContent);

        ivIcon.setImageResource(imageId);
        tvName.setText(name);
        tvTitle.setText(title.trim());
        tvContent.setText(content);
    }
}
