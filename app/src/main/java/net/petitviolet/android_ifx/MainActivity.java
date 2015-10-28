package net.petitviolet.android_ifx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.petitviolet.ifx.IFx;
import net.petitviolet.ifx.func.Action;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private boolean mFabPressedOddTimes = false;
    private int mPressedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Start: Odd? " + mFabPressedOddTimes + ", count: " + mPressedCount);
                final int result;
                if (mFabPressedOddTimes) {
                    result = 100 + mPressedCount;
                } else if (mPressedCount % 3 == 0) {
                    result = 200 + mPressedCount;
                } else {
                    result = 300 + mPressedCount;
                }
                Log.d(TAG, "Condition => " + result);

                final int result2 = IFx.<Integer>of(mFabPressedOddTimes).apply(100 + mPressedCount)
                        .ElseIf(mPressedCount % 3 == 0).apply(new Action<Integer>() {
                            @Override
                            public Integer run() {
                                return 200 + mPressedCount;
                            }
                        })
                        .Else(() -> mPressedCount + 300);
                Log.d(TAG, "Condition => " + result2);
                Log.d(TAG, "End");
                mPressedCount += 1;
                mFabPressedOddTimes = !mFabPressedOddTimes;
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
