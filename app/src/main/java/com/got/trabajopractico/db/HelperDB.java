package com.got.trabajopractico.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.got.trabajopractico.helpers.HelperConstants;
import com.got.trabajopractico.entity.Usuario;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class HelperDB extends OrmLiteSqliteOpenHelper {

    public HelperDB(Context context) {
        super(context, HelperConstants.NOMBRE_BASE_DATOS,null, HelperConstants.VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Usuario.class);
        }catch (SQLException | java.sql.SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }
}
