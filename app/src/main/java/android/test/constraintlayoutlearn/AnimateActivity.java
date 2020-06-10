package android.test.constraintlayoutlearn;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AnimateActivity extends AppCompatActivity {
    private ConstraintSet firstconstraintSet;
    private ConstraintSet secondconstraintSet;
    private ConstraintLayout constraintLayout;
    private Button start;
    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyframe1);
        firstconstraintSet = new ConstraintSet();
        secondconstraintSet = new ConstraintSet();

        constraintLayout = findViewById(R.id.activity_main_constraintlayout);
        start = findViewById(R.id.start);


        firstconstraintSet.clone(constraintLayout);
        secondconstraintSet.clone(this, R.layout.keyframe2);
        start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if (flag) {
                    flag = false;
                    TransitionManager.beginDelayedTransition(constraintLayout);// 动画效果
                    secondconstraintSet.applyTo(constraintLayout);
                } else {
                    flag = true;
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    firstconstraintSet.applyTo(constraintLayout);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
