package com.example.assignmentone;

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

    /** Called when the Facilities ImageButton is clicked. */
    public void onClickFacilities(View view) {
        showClickedToast(R.string.topic_facilities);
    }

    /** Called when the Events ImageButton is clicked. */
    public void onClickEvents(View view) {
        showClickedToast(R.string.topic_events);
    }

    /** Called when the Clubs ImageButton is clicked. */
    public void onClickClubs(View view) {
        showClickedToast(R.string.topic_clubs);
    }

    /** Called when the Support ImageButton is clicked. */
    public void onClickSupport(View view) {
        showClickedToast(R.string.topic_support);
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
