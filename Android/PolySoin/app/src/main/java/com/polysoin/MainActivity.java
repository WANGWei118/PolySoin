package com.polysoin;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.polysoin.dummy.DrugDummyContent;
import com.polysoin.dummy.DrugHistoryDummyContent;
import com.polysoin.dummy.DummyItem;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements SensorEventListener, TabFragment1.OnListFragmentInteractionListener, TabHistoryFragment.OnListFragmentInteractionListener {

    private boolean darkMode;
    private SensorManager sensorManager;
    private Sensor lightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            darkMode = savedInstanceState.getBoolean("darkMode");
        }

        if (loadPrefs("enable_night_mode")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(myPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        myPagerAdapter.addUpdate();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (loadPrefs("auto_night_mode")) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorManager.unregisterListener(this);
        }
    }

    public void savePrefs(String key, Boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private Boolean loadPrefs(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean data = sharedPreferences.getBoolean(key, false);
        return data;
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

    public void onListFragmentInteraction(DummyItem item) {

    }

    public void onListFragmentInteraction(FloatingActionButton floatingActionButton) {
        int id = DrugDummyContent.ITEMS.size() + DrugHistoryDummyContent.ITEMSHISTORY.size();
        DrugDummyContent.addItem(DrugDummyContent.createDummyItem(id, "Drug " + id, "take ur drug " + id, new Date()));
        scheduleNotification(getNotification("PolySoin", "take ur drug " + id), 10000, id);
    }

    public void onListFragmentInteraction(Button button, int id) {
        NotificationPublisher.notificationManager.cancel(id);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (loadPrefs("auto_night_mode")) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
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
        float lux = event.values[0];
        if (lux < 50 && !darkMode) {
            savePrefs("enable_night_mode", true);
            darkMode = true;
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else if (lux >= 50 && darkMode) {
            savePrefs("enable_night_mode", false);
            darkMode = false;
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
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
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        return builder;
    }
}
