package sg.edu.np.mad.s10222425_practical_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";

    public static final String TABLE_USER = "user";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FOLLOWED = "followed";

    public UserDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Tables
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_USER
                + "("
                + COLUMN_NAME + " VARCHAR(50),"
                + COLUMN_DESCRIPTION + " VARCHAR(50),"
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FOLLOWED + " BOOLEAN "
                + ")";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void initilizeData(int num){
        SQLiteDatabase db = this.getWritableDatabase();

        //function to autogenerate random numbers
        for(int i = 0; i < num; i++){
            String randInt = Integer.toString(new Random().nextInt(10000000) + 10000000);
            String randInt2 = Integer.toString(new Random().nextInt());
            Boolean randBool3 = new Random().nextBoolean();
            User u = new User("Name" + randInt, "Description "+ randInt2, Integer.parseInt(randInt), randBool3);
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, u.name);
            values.put(COLUMN_DESCRIPTION, u.description);
            values.put(COLUMN_FOLLOWED, u.followed);
            db.insert(TABLE_USER, null, values);
        }

    }

    public List<User> getUsers(){
        String query = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<User> userList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                userList.add(new User(cursor.getString(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Boolean.parseBoolean(cursor.getString(3))));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userList;
    }

    public void updateUser(User u){
        String id = Integer.toString(u.id);
        String followed = Boolean.toString(u.followed);
        String query = "UPDATE " + TABLE_USER
                    + " SET " + COLUMN_FOLLOWED + " = " + followed
                    + " WHERE " + COLUMN_ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
    }
}
