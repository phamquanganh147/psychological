package dev147.com.vn.projectpsychological.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import dev147.com.vn.projectpsychological.data.converter.DateConverter;
import dev147.com.vn.projectpsychological.data.dao.CustomerDao;
import dev147.com.vn.projectpsychological.data.model.Customer;
import dev147.com.vn.projectpsychological.utils.Define;

@Database(entities = {
        Customer.class
}, version = Define.DATABASE_VERSION, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AbstractAppDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();

    private static AbstractAppDatabase INSTANCE;

    public static AbstractAppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AbstractAppDatabase.class, Define.DATABASE_NAME).build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
