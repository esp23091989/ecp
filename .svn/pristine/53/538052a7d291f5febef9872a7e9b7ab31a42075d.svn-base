package com.ibis.ibisecp2.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ibis.ibisecp2.EcpApplication;
import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.Visit;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.DatabaseCompartment;
import nl.qbusict.cupboard.QueryResultIterable;
import rx.Observable;
import rx.Subscriber;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by danila on 01.03.16.
 */
public class Storage<T> {

    private static final Object INIT_LOCK = new Object();
    private static Storage Instance;
    CupboardDbHelper mOpenHelper;
    SQLiteDatabase mDatabase;
    DatabaseCompartment mDataCompartment;

    public Storage(Context context) {
        mOpenHelper = new CupboardDbHelper(context);
        mDatabase = mOpenHelper.getWritableDatabase();
        mDataCompartment = cupboard().withDatabase(mDatabase);
    }

    public static Storage get() {
        if (Instance == null) {
            synchronized (INIT_LOCK) {
                if (Instance == null) {
                    Instance = new Storage(EcpApplication.getInstance());
                }
            }
        }
        return Instance;
    }

    public Observable<Boolean> saveArrayListInDb(final List<T> list) {
        return Observable.create(subscriber -> {
            mDatabase.beginTransaction();
            try {
                for (T data : list) {
                    mDataCompartment.put(data);
                }
                mDatabase.setTransactionSuccessful();
                subscriber.onNext(true);
                subscriber.onCompleted();
            } finally {
                mDatabase.endTransaction();
            }
        });
    }

    public Observable<Boolean> saveVisitListInDb(final List<Visit> list) {
        return Observable.create(subscriber -> {
            mDatabase.beginTransaction();
            try {
                for (Visit data : list) {
                    Visit item =
                            mDataCompartment.query(Visit.class).withSelection("caseNumber = ?",
                                    data.getCaseNumber()).get();
                    if (item != null) {
                        data.setTime(item.getTime());
                        data.set_id(item.get_id());
                    } else {
                        data.set_id(System.currentTimeMillis());
                    }
                    mDataCompartment.put(data);
                }
                subscriber.onNext(true);
                subscriber.onCompleted();
                mDatabase.setTransactionSuccessful();
            } finally {
                mDatabase.endTransaction();
            }
        });
    }

    public Observable<Boolean> saveItemInDb(final T entity) {
        return Observable.create(subscriber -> {
            mDatabase.beginTransaction();
            try {
                mDataCompartment.put(entity);
                mDatabase.setTransactionSuccessful();
                subscriber.onNext(true);
                subscriber.onCompleted();
            } finally {
                mDatabase.endTransaction();
            }
        });
    }

    public Observable<Boolean> deleteItemInDb(final T entity) {
        return Observable.create(subscriber -> {
            mDatabase.beginTransaction();
            try {
                mDataCompartment.delete(entity);
                mDatabase.setTransactionSuccessful();
                subscriber.onNext(true);
                subscriber.onCompleted();
            } finally {
                mDatabase.endTransaction();
            }
        });
    }

    public Observable<Boolean> deleteObjectById(final Class<T> entityClass, final long id) {
        return Observable.create(subscriber -> {
            mDatabase.beginTransaction();
            try {
                mDataCompartment.delete(entityClass, id);
                mDatabase.setTransactionSuccessful();
                subscriber.onNext(true);
                subscriber.onCompleted();
            } finally {
                mDatabase.endTransaction();
            }
        });
    }

    public Observable<T> getObjectById(final Class<T> entityClass, final long id) {
        return Observable.create(subscriber -> {
            mDatabase.beginTransaction();
            try {
                T item = mDataCompartment.get(entityClass, id);
                subscriber.onNext(item);
                subscriber.onCompleted();
//                    mDatabase.setTransactionSuccessful();
            } finally {
                mDatabase.endTransaction();
            }
        });
    }

    public Observable getEventCalendar(final String caseNumber) {
        return Observable.create((Observable.OnSubscribe<EventCalendar>) subscriber -> {
            Cursor cursor = mDataCompartment.query(EventCalendar.class)
                    .withSelection("caseNumber = ?", caseNumber).getCursor();

            try {
                QueryResultIterable<EventCalendar> itr = cupboard().withCursor(cursor)
                        .iterate(EventCalendar.class);
                EventCalendar eventCalendar = itr.get();
                subscriber.onNext(eventCalendar);
                subscriber.onCompleted();
            } finally {
                // close the cursor
                cursor.close();
            }
        });
    }

    public Observable<Boolean> deleteArrayListFromDb(final Class<T> entityClass) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                mDatabase.beginTransaction();
                try {
                    // delete all entries in a given table
                    mDataCompartment.delete(entityClass, null);
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                    mDatabase.setTransactionSuccessful();
                } finally {
                    mDatabase.endTransaction();
                }
            }
        });
    }

    public Observable<List<Doctor>> getDocByDepartment(final String deptCode) {
        return Observable.create(new Observable.OnSubscribe<List<Doctor>>() {
            @Override
            public void call(Subscriber<? super List<Doctor>> subscriber) {
                List<Doctor> doctorList = new ArrayList<Doctor>();
                Cursor cursor = mDataCompartment.query(Doctor.class)
                        .withSelection("deptCode = ?", deptCode).getCursor();
                try {
                    QueryResultIterable<Doctor> itr = cupboard().withCursor(cursor)
                            .iterate(Doctor.class);
                    for (Doctor doctor : itr) {
                        doctorList.add(doctor);
                    }
                } finally {
                    // close the cursor
                    cursor.close();
                }
                subscriber.onNext(doctorList);
                subscriber.onCompleted();
            }
        });
    }

    private ArrayList<T> getArrayList(Class<T> entityClass) {
        ArrayList<T> mMediaData = new ArrayList<>();
        mDatabase.beginTransaction();
        Cursor mMediaDataCursor = mDataCompartment.query(entityClass).getCursor();
        try {
            QueryResultIterable<T> iterator = cupboard().withCursor(mMediaDataCursor)
                    .iterate(entityClass);
            for (T mediaData : iterator) {
                mMediaData.add(mediaData);
            }
//            mDatabase.setTransactionSuccessful();
        } finally {
            mDatabase.endTransaction();
            mMediaDataCursor.close();
        }
        return mMediaData;
    }

    public Observable<List<T>> getArrayListFromDb(final Class<T> entityClass) {
        return Observable.create(new Observable.OnSubscribe<List<T>>() {
            @Override
            public void call(Subscriber<? super List<T>> subscriber) {
                subscriber.onNext(getArrayList(entityClass));
                subscriber.onCompleted();
            }
        });
    }

//    public Observable<Boolean> saveFavoriteDoctor(final FavoriteDoctor entity) {
//        return Observable.create(new Observable.OnSubscribe<Boolean>() {
//            @Override
//            public void call(Subscriber<? super Boolean> subscriber) {
//                mDatabase.beginTransaction();
//                Cursor cursor = mDataCompartment.query(FavoriteDoctor.class).getCursor();
//                try {
//                    QueryResultIterable<FavoriteDoctor> itr = cupboard().withCursor(cursor)
//                            .iterate(FavoriteDoctor.class);
//                    List<FavoriteDoctor> favoriteDoctors = itr.list();
//                    int maxSize = 4;
//                    if(favoriteDoctors.size() >= maxSize){
//                        FavoriteDoctor favoriteDoctor = favoriteDoctors.get(0);
//                        mDataCompartment.delete(favoriteDoctor);
//                    }
//                    mDataCompartment.put(entity);
//                    mDatabase.setTransactionSuccessful();
//                    subscriber.onNext(true);
//                    subscriber.onCompleted();
//                } finally {
//                    mDatabase.endTransaction();
//                    cursor.close();
//                }
//            }
//        });
//    }

    public DatabaseCompartment getDataCompartment() {
        return mDataCompartment;
    }
}
