package cristian_sedano.curriculum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Christian on 13/01/2018.
 */

public class Launcher extends AppCompatActivity {

    private static final int TIMER_RUNTIMER = 3000;
    private boolean launcher;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Timer timer = new Timer();
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

        final Thread timerThread = new Thread() {
            @Override
            public void run() {
                launcher = true;
                try {
                    int walted = 0;
                    while (launcher && (walted < TIMER_RUNTIMER)) {
                        sleep(200);
                        if (launcher) {
                            walted += 200;
                            updateProgress(walted);
                        }
                    }
                } catch (InterruptedException ignored) {

                } finally {
                    onContinue();
                }
            }
        };
        timerThread.start();
    }

    public void updateProgress(final int timerPassed){
        if (null != progressBar){
            final int progress = progressBar.getMax() * timerPassed / TIMER_RUNTIMER;
            progressBar.setProgress(progress);
        }
    }
    private void onContinue(){}

}
