package fooglesinc.foogles;

/**
 * Created by joeyjennings on 4/6/18.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FoogleDB.db";
    private static final String TABLE_FOOGLES = "foogles";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FOOGLENAME = "fooglename";
    public static final String COLUMN_ENERGY = "energy";



    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_FOOGLES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_FOOGLENAME
                + " TEXT," + COLUMN_ENERGY + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOGLES);
        onCreate(db);
    }

    public void addFoogle(Foogle foogle) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_FOOGLENAME, foogle.getFoogleName());
        values.put(COLUMN_ENERGY, foogle.getEnergy());


        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_FOOGLES, null, values);
        db.close();
    }
    public Foogle findFoogle(String fooglename) {
        String query = "Select * FROM " + TABLE_FOOGLES + " WHERE " + COLUMN_FOOGLENAME + " =  \"" + fooglename + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Foogle foogle = new Foogle();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            foogle.set_id(Integer.parseInt(cursor.getString(0)));
            foogle.setFoogleName(cursor.getString(1));
            foogle.setEnergy(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            foogle = null;
        }
        db.close();
        return foogle;
    }

    public boolean deleteFoogle(String fooglename) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_FOOGLES + " WHERE " + COLUMN_FOOGLENAME + " =  \"" + fooglename + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Foogle foogle = new Foogle();

        if (cursor.moveToFirst()) {
            foogle.set_id(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_FOOGLES, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(foogle.get_id()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
