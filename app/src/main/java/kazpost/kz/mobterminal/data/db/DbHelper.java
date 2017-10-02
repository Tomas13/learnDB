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
        sqLiteDatabase.execSQL("CREATE TABLE customer(_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "name TEXT NOT NULL, email TEXT,  image_path TEXT, phone TEXT, \n" +
                "street1 TEXT, street2 TEXT, city TEXT, state TEXT, zip TEXT, note TEXT, \n" +
                "create_date BIGINT, last_update_date BIGINT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("some sql statement to do something");
    }
}
