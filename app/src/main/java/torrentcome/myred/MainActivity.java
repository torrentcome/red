package torrentcome.myred;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import torrentcome.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);

        /*
        *  EXERCISE UNDERSTANDING OF THE RX STUFF
        *  exo -- 1
        * */
        // observable
        Flowable<String> observable1 = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("hello");
                e.onNext("world");
                e.onNext("!");
                e.onComplete();
            }
        }, BackpressureStrategy.MISSING);

        // subscriber
        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.i("ex", "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i("ex", s);
            }

            @Override
            public void onError(Throwable t) {
                Log.e("ex", "onError");
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.i("ex", "onComplete");
            }
        };
        // observable subscribe to
        observable1.subscribe(subscriber1);

        /*
        *  FUNCTIONALITY
        * */
        set();
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    set();
                }
            });
        }
    }

    public void set() {
        String networkClass = Connectivity.getNetworkClass(MainActivity.this);
        Flowable.just(networkClass).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                String[] tab = s.split("=");
                textView1.setText(tab[0]);
                textView2.setText(tab[1]);
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
