package kazpost.kz.mobterminal.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

import kazpost.kz.mobterminal.di.ApplicationContext;
import kazpost.kz.mobterminal.di.DatabaseInfo;

/**
 * Created by root on 10/2/17.
 */

public class DbHelper extends SQLiteOpenHelper implements DBHelper {

    @Inject
    public DbHelper(@ApplicationContext Context context,
                    @DatabaseInfo String dbName,
                    @DatabaseInfo Integer version) {
        super(context, dbName, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_NOTE);
    }

    private static final String CREATE_TABLE_NOTE = "create table note"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "title" + " text not null, "
            + "content" + " text not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null " + ")";

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("some sql statement to do something");
    }
}
