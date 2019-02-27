package dev147.com.vn.projectpsychological.utils;

public class Define {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "psychological.db";
    public static final long CLICK_TIME_INTERVAL = 300L;

    public class ResponseStatus {
        public static final int LOADING = 1;
        public static final int SUCCESS = 2;
        public static final int ERROR = 0;
    }

    public class Customer {
        public static final String TABLE_NAME = "customer";
        public static final String ID = "id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String BIRTHDATE = "birthdate";
        public static final String GENDER = "gender";
        public static final String CREATED_AT= "created_at";
        public static final String UPDATED_AT= "updated_at";
        public static final String DEL_FLG = "del_flg";
    }

    public static class SharedPref{
        public static final String KEY_IS_FIRST = "is_first_lauch_app";
    }
}
