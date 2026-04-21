package CyberWinPHP.Cyber_IO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class Cyber_KVStorage {
    private static final String DATABASE_NAME = "KVStorage";
    private static final String TABLE_CATALYST = "catalystLocalStorage";
    private static final String KEY_COLUMN = "key";
    private static final String VALUE_COLUMN = "value";
    private static final int DATABASE_VERSION = 1;
    private static final int SLEEP_TIME_MS = 30;
    private static final int MAX_SQL_KEYS = 999;





}