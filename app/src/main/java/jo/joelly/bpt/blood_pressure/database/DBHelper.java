package jo.joelly.bpt.blood_pressure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "blood_pressure.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "blood_pressure_records";
    private static final String COLUMN_ID = "Record_ID";
    private static final String COLUMN_SYSTOLIC = "Systolic";
    private static final String COLUMN_DIASTOLIC = "Diastolic";
    private static final String COLUMN_PULSE = "Pulse";
    private static final String COLUMN_DATE_TIME = "Record_DateTime";

    // Конструктор
    public DBHelper( @Nullable Context context )
    {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    // Метод для создания таблицы
    @Override
    public void onCreate( SQLiteDatabase db )
    {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                COLUMN_SYSTOLIC + " INTEGER NOT NULL," +
                COLUMN_DIASTOLIC + " INTEGER NOT NULL," +
                COLUMN_PULSE + " INTEGER NOT NULL," +
                COLUMN_DATE_TIME + " INTEGER NOT NULL)";
        db.execSQL(createTableQuery);
    }

    // Метод для обновления таблицы
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
    {
        // Обработка обновления базы данных (если необходимо)

    }
}
