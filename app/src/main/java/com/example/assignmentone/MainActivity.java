package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Main screen of CampusLife.
 * Shows the welcome banner and the four topic ImageButtons
 * (Facilities, Events, Clubs and Support).
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Pad the root layout so that content is not drawn under the status and navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Click handlers below are linked to the ImageButtons through android:onClick
    // in both the portrait and the landscape activity_main.xml files.
    // Each one confirms the click with a Toast and then opens the matching topic.

    /** Called when the Facilities ImageButton is clicked: shows the Facilities details. */
    public void onClickFacilities(View view) {
        showClickedToast(R.string.topic_facilities);
        openDetail(DetailActivity.TOPIC_FACILITIES);
    }

    /** Called when the Events ImageButton is clicked: shows the Events details. */
    public void onClickEvents(View view) {
        showClickedToast(R.string.topic_events);
        openDetail(DetailActivity.TOPIC_EVENTS);
    }

    /** Called when the Clubs ImageButton is clicked: shows the Clubs details. */
    public void onClickClubs(View view) {
        showClickedToast(R.string.topic_clubs);
        openDetail(DetailActivity.TOPIC_CLUBS);
    }

    /** Called when the Support ImageButton is clicked: shows the Support details. */
    public void onClickSupport(View view) {
        showClickedToast(R.string.topic_support);
        openDetail(DetailActivity.TOPIC_SUPPORT);
    }

    /**
     * Starts DetailActivity with an explicit Intent and passes the index of the
     * selected topic, so that DetailActivity knows which content to display.
     *
     * @param topicIndex one of the DetailActivity.TOPIC_* identifiers
     */
    private void openDetail(int topicIndex) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, topicIndex);
        startActivity(intent);
    }

    /**
     * Shows a short Toast such as "Facilities clicked" to confirm that a button works.
     *
     * @param topicNameId string resource id of the topic name
     */
    private void showClickedToast(int topicNameId) {
        String message = getString(R.string.toast_topic_clicked, getString(topicNameId));
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
