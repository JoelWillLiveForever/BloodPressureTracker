package jo.joelly.bpt.blood_pressure;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import jo.joelly.bpt.blood_pressure.database.DBHelper;

public class BloodPressureManager
{
    private static BloodPressureManager _instance;
    private final List<BloodPressure> pressureList;
    private final DBHelper dbHelper;

    private BloodPressureManager( Context context )
    {
        pressureList = new ArrayList<>();
        dbHelper = new DBHelper( context );
    }

    public static BloodPressureManager getInstance( Context context )
    {
        if (_instance == null)
            _instance = new BloodPressureManager(context);
        return _instance;
    }

    public void addPressureRecord(BloodPressure pressure)
    {
        // добавление в список
        pressureList.add(pressure);

        // получение времени записи в миллисекундах
        Instant instant = pressure.getDateTime().atZone( ZoneId.systemDefault()).toInstant();
        long milliseconds = instant.toEpochMilli();

        // добавление в бд
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("systolic", pressure.getSystolic());
        values.put("diastolic", pressure.getDiastolic());
        values.put("pulse", pressure.getPulse());
        values.put("date_time", milliseconds);

        db.insert("pressure_records", null, values);
        db.close();
    }

    public List< BloodPressure > getPressureList()
    {
        return pressureList;
    }
}
