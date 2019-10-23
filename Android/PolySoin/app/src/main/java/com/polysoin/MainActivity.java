package com.polysoin;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.polysoin.TabFragment.TabFragment1;
import com.polysoin.TabFragment.TabHistoryFragment;
import com.polysoin.dummy.DummyItem;
import com.polysoin.dummy.MedicineDummyContent;
import com.polysoin.dummy.MedicineHistoryDummyContent;

import java.util.Calendar;
import java.util.ConcurrentModificationException;

public class MainActivity extends AppCompatActivity implements SensorEventListener, TabFragment1.OnListFragmentInteractionListener, TabHistoryFragment.OnListFragmentInteractionListener {

    private boolean darkMode;
    private static SensorManager sensorManager;
    private Sensor lightSensor;
    private static Sensor accelerometerSensor;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            darkMode = savedInstanceState.getBoolean("darkMode");
        }

        if (loadPrefs("enable_dark_mode")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(myPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (loadPrefs("auto_dark_mode")) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorManager.unregisterListener(this, lightSensor);
        }
        if (loadPrefs("accelerometer_validation")) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorManager.unregisterListener(this, accelerometerSensor);
        }
    }

    public void savePrefs(String key, Boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private Boolean loadPrefs(String key) {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(key, false);
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
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onListFragmentInteraction(FloatingActionButton floatingActionButton) {
        int id = MedicineDummyContent.ITEMS.size() + MedicineHistoryDummyContent.ITEMSHISTORY.size();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 10);
        MedicineDummyContent.addItem(MedicineDummyContent.createDummyItem(id, "Medicine " + id, "Take your medicine " + id, c));
        scheduleNotification(getNotification("PolySoin", "Take your medicine " + id), 10000, id);
        myPagerAdapter.notifyDataSetChanged();
    }

    public void onListFragmentInteraction(Button button, int id) {
        myPagerAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (loadPrefs("auto_dark_mode")) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorManager.unregisterListener(this, lightSensor);
        }
        if (loadPrefs("accelerometer_validation")) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorManager.unregisterListener(this, accelerometerSensor);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //remove sensor
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("darkMode", darkMode);
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            float acceleration = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            if (acceleration >= 2.5) {
                boolean isFinish = false;
                while (!isFinish) {
                    try {
                        for (DummyItem d : MedicineDummyContent.ITEMS) {
                            if (Calendar.getInstance().after(d.date)) {
                                d.isTaken = true;
                                myPagerAdapter.removeAt(d);
                                if (NotificationPublisher.notificationManager != null) {
                                    NotificationPublisher.notificationManager.cancel(d.id);
                                }
                            }
                        }
                        isFinish = true;
                    } catch (ConcurrentModificationException e) {
                    }
                    myPagerAdapter.notifyDataSetChanged();
                }
            }
        }

        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lux = event.values[0];
            if (lux < 20 && !darkMode) {
                savePrefs("enable_dark_mode", true);
                darkMode = true;
                recreate();
            } else if (lux >= 20 && darkMode) {
                savePrefs("enable_dark_mode", false);
                darkMode = false;
                recreate();
            }
        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    private void scheduleNotification(Notification.Builder builder, int delay, int notificationId) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent activity = PendingIntent.getActivity(this, notificationId, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(activity);

        Notification notification = builder.build();

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, notificationId);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification.Builder getNotification(String title, String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setAutoCancel(true);
        if (loadPrefs("vibrate_notification")) {
            builder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        }
        if (loadPrefs("sound_notification")) {
            builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        }
        if (loadPrefs("led_notification")) {
            builder.setLights(Color.BLUE, 3000, 3000);
        }
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(),
                R.mipmap.ic_launcher));
        return builder;
    }
}
