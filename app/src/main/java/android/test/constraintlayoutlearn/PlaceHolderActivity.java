package android.test.constraintlayoutlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PlaceHolderActivity extends AppCompatActivity {

    Placeholder placeholder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeholder);
        placeholder = findViewById(R.id.placeholder);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeholder.setContentId(R.id.textview);
            }
        });
    }
}
