package net.paulacr.rxjavastudies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.subjects.BehaviorSubject;


public class MainActivity extends AppCompatActivity implements ViewInterface {

    private BehaviorSubject<Integer> subject = BehaviorSubject.create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Basics basics = new Basics();

        Button button = findViewById(R.id.button);
        basics.debounceButton(button, 100000, TimeUnit.DAYS);

        Presenter presenter = new Presenter(this);

        subject.subscribe();


    }

    @NotNull
    @Override
    public BehaviorSubject<Integer> onRequestMorePages() {
        return subject;
    }
}
