package it.sprik.javascriptinterface;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class JavascriptInterfacePressure implements SensorEventListener {
    private Context context;
    private SensorManager sensorManager;
    private float mPressure;

    public JavascriptInterfacePressure(Context context) {
        this.context = context;
        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        this.mPressure = 0.0F;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
            this.mPressure = event.values[0];
        }
    }

    public String getPressure() {
        return String.valueOf(this.mPressure);
    }

    public void registerSensor() {
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregisterSensor() {
        sensorManager.unregisterListener(this);
    }

}
