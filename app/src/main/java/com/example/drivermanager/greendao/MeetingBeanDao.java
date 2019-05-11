package com.example.drivermanager.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.drivermanager.bean.MeetingBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEETING_BEAN".
*/
public class MeetingBeanDao extends AbstractDao<MeetingBean, Long> {

    public static final String TABLENAME = "MEETING_BEAN";

    /**
     * Properties of entity MeetingBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserId = new Property(1, Long.class, "userId", false, "USER_ID");
        public final static Property MettingRoomId = new Property(2, Long.class, "mettingRoomId", false, "METTING_ROOM_ID");
        public final static Property MettingName = new Property(3, String.class, "mettingName", false, "METTING_NAME");
        public final static Property JoinerName = new Property(4, String.class, "joinerName", false, "JOINER_NAME");
        public final static Property IsOk = new Property(5, boolean.class, "isOk", false, "IS_OK");
    }


    public MeetingBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MeetingBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEETING_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_ID\" INTEGER," + // 1: userId
                "\"METTING_ROOM_ID\" INTEGER," + // 2: mettingRoomId
                "\"METTING_NAME\" TEXT," + // 3: mettingName
                "\"JOINER_NAME\" TEXT," + // 4: joinerName
                "\"IS_OK\" INTEGER NOT NULL );"); // 5: isOk
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEETING_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MeetingBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(2, userId);
        }
 
        Long mettingRoomId = entity.getMettingRoomId();
        if (mettingRoomId != null) {
            stmt.bindLong(3, mettingRoomId);
        }
 
        String mettingName = entity.getMettingName();
        if (mettingName != null) {
            stmt.bindString(4, mettingName);
        }
 
        String joinerName = entity.getJoinerName();
        if (joinerName != null) {
            stmt.bindString(5, joinerName);
        }
        stmt.bindLong(6, entity.getIsOk() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MeetingBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(2, userId);
        }
 
        Long mettingRoomId = entity.getMettingRoomId();
        if (mettingRoomId != null) {
            stmt.bindLong(3, mettingRoomId);
        }
 
        String mettingName = entity.getMettingName();
        if (mettingName != null) {
            stmt.bindString(4, mettingName);
        }
 
        String joinerName = entity.getJoinerName();
        if (joinerName != null) {
            stmt.bindString(5, joinerName);
        }
        stmt.bindLong(6, entity.getIsOk() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MeetingBean readEntity(Cursor cursor, int offset) {
        MeetingBean entity = new MeetingBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // mettingRoomId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // mettingName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // joinerName
            cursor.getShort(offset + 5) != 0 // isOk
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MeetingBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setMettingRoomId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setMettingName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setJoinerName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsOk(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MeetingBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MeetingBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MeetingBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}