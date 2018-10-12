package com.ibis.ibisecp2.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.maps.model.LatLng;
import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.Error;
import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.model.VisitResponse;
import com.ibis.ibisecp2.model.Warning;
import com.ibis.ibisecp2.storage.convert.GenericFieldConverterFactory;
import com.ibis.ibisecp2.storage.convert.JsonConverter;

import nl.qbusict.cupboard.CupboardBuilder;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import static nl.qbusict.cupboard.CupboardFactory.setCupboard;

/**
 * Created by danila on 27.02.16.
 */
public class CupboardDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RxCupboard.db";
    private static final int DATABASE_VERSION = 35;

    private static SQLiteDatabase database;

    static {
        // Register our models with Cupboard as usual
        setCupboard(
                new CupboardBuilder()
                        .registerFieldConverter(Patient.class, new JsonConverter<Patient>(Patient.class))
                        .registerFieldConverter(Visit.class, new JsonConverter<Visit>(Visit.class))
                        .registerFieldConverter(Error.class, new JsonConverter<Error>(Error.class))
                        .registerFieldConverter(Clinic.class, new JsonConverter<Clinic>(Clinic.class))
                        .registerFieldConverter(LatLng.class, new JsonConverter<LatLng>(LatLng.class))
                        .registerFieldConverter(Warning.class, new JsonConverter<Warning>(Warning.class))
                        .registerFieldConverterFactory(new GenericFieldConverterFactory())
                        .useAnnotations()
                        .build()
        );
        cupboard().register(Patient.class);
        cupboard().register(VisitHistoryResponse.class);
        cupboard().register(Visit.class);
        cupboard().register(EventCalendar.class);
        cupboard().register(Doctor.class);
        cupboard().register(VisitResponse.class);
        cupboard().register(ClinicResponse.class);
        cupboard().register(FavoriteDoctor.class);
    }


    public CupboardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Returns a raw handle to the SQLite database connection. Do not close!
     *
     * @param context A context, which is used to (when needed) set up a connection to the database
     * @return The single, unique connection to the database, as is (also) used by our Cupboard instance
     */
    public synchronized static SQLiteDatabase getConnection(Context context) {
        if (database == null) {
            // Construct the single helper and open the unique(!) db connection for the app
            database = new CupboardDbHelper(context.getApplicationContext()).getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }

}
