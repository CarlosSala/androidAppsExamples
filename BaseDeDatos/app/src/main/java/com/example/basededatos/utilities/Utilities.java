package com.example.basededatos.utilities;

public class Utilities {

    public static final String USERS_TABLE = "users";
    public static final String ID_FIELD = "id";
    public static final String NAME_FIELD = "name";
    public static final String CELL_FIELD = "cell";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USERS_TABLE + "("
            + ID_FIELD + " INTEGER, " + NAME_FIELD + " TEXT, " + CELL_FIELD + " TEXT)";

}
