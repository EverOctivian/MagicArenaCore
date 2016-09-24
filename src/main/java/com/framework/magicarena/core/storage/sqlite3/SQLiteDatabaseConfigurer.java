/**
 * <b>ProjectName</b>	:	MagicArenaUtils								</br>
 * <b>FileName</b>    	:	SQLiteDatabaseConfigurer.java				</br>
 * <b>PackageName</b>	:	com.magicarena.storage.sqlite3				</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br> 
 */
package com.framework.magicarena.core.storage.sqlite3;


import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.InvocationTargetException;

/**
 * <b>ClassName</b>		:	SQLiteDatabaseConfigurer									</br>
 * <b>Function</b>		: 	To initialize the pragma parameters of specified database.	</br>
 * <b>Reason</b>		:	To extend the optional state of sqlite database.         	</br>
 *
 * </br>
 * <b>Maintenance History</b>:
 * <table>
 * 		<tr>
 * 			<th>Date</th>
 * 			<th>Developer</th>
 * 			<th>Target</th>
 * 			<th>Content</th>
 * 		</tr>
 * 		<tr>
 * 			<td>2016-7-30</td>
 * 			<td>Administrator</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 *
 * @author Administrator
 * @version 1.0.1
 * @since 1.6
 */
public class SQLiteDatabaseConfigurer implements SQLiteCommonKeys {
    //*******************************************
    //*	Static Area								*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private final static String PRAGMA = "pragma";
    private final static String PRAGMA_INSTRUCTION_AUTO_VACUUM = "auto_vacuum";
    private final static String PRAGMA_INSTRUCTION_CACHE_SIZE = "cache_size";
    private final static String PRAGMA_INSTRUCTION_CASE_SENSITIVE_LIKE = "case_sensitive_like";
    private final static String PRAGMA_INSTRUCTION_COUNT_CHANGES = "count_changes";
    private final static String PRAGMA_INSTRUCTION_DEFAULT_CACHE_SIZE = "default_cache_size";
    private final static String PRAGMA_INSTRUCTION_EMPTY_RESULT_CALLBACKS = "empty_result_callbacks";
    private final static String PRAGMA_INSTRUCTION_ENCODING = "encoding";

    private final static long PRAGMA_VALIDATED = 1;
    private final static long PRAGMA_UNVALIDATED = 0;

    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private SQLiteDatabase db;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of SQLiteDatabaseConfigurer.
     *
     * @param    targetDb    the {@link SQLiteDatabase} intended to retrieve configurations from
     */
    public SQLiteDatabaseConfigurer(SQLiteDatabase targetDb) {
        this.db = targetDb;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * 	Indicate pragma instruction <code>AUTO_VACUUM</code> validated or not.
     *
     * @author Administrator
     * @return true if <code>AutoVacuum</code> is validated,otherwise false
     */
    public boolean isAutoVacuum() {
        return this.getBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_AUTO_VACUUM);
    }

    /**
     * 	Retrieve the maximum cache size of database.
     *
     * @author Administrator
     * @return the maximum cache size of database(default value is 2000)
     */
    public long getCacheSize() {
        return this.getLongConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_CACHE_SIZE);
    }

    /**
     * 	Indicate pragma instruction <code>CASE_SENSITIVE_LIKE</code> validated or not.
     *
     * @author Administrator
     * @return true if <code>CASE_SENSITIVE_LIKE</code> is validated,otherwise false
     */
    public boolean isCaseSensitiveLike() {
        return this.getBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_CASE_SENSITIVE_LIKE);
    }

    /**
     * 	Indicate pragma instruction <code>COUNT_CHANGES</code> validated or not.
     *
     * @author Administrator
     * @return true if <code>COUNT_CHANGES</code> is validated,otherwise false
     */
    public boolean isCountChanges() {
        return this.getBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_COUNT_CHANGES);
    }

    /**
     * 	Retrieve the default maximum cache size of database.
     *
     * @author Administrator
     * @return the default maximum cache size of database(default value is 2000)
     */
    public long getDefaultCacheSize() {
        return this.getLongConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_DEFAULT_CACHE_SIZE);
    }

    /**
     * 	Indicate pragma instruction <code>EMPTY_RESULT_CALLBACKS</code> validated or not.
     *
     * @author Administrator
     * @return true if <code>EMPTY_RESULT_CALLBACKS</code> is validated,otherwise false
     */
    public boolean isEmptyResultCallbacks() {
        return this.getBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_EMPTY_RESULT_CALLBACKS);
    }

    /**
     * 	Retrieve the default encoding type of database.
     *
     * @author Administrator
     * @return the default maximum cache size of database(default value is 2000)
     */
    public long getEncoding() {
        String encodingType = DatabaseUtils.stringForQuery(this.db, SQLiteDatabaseConfigurer.PRAGMA + " " + SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_ENCODING, null);
        if (encodingType == null) {
        }
        ;
        return this.getLongConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_DEFAULT_CACHE_SIZE);
    }

    /**
     * 	Indicate the configuration's validated or not.
     *
     * @author Administrator
     * @param    pragmaInstruction    the pragma instruction intended to make
     * @return the value for specfied configuration of database
     */
    private boolean getBooleanConfig(String pragmaInstruction) {
        return DatabaseUtils.longForQuery(this.db, SQLiteDatabaseConfigurer.PRAGMA + " " + pragmaInstruction, null) == SQLiteDatabaseConfigurer.PRAGMA_VALIDATED;
    }

    /**
     * 	Retrieve the configuration's value currently.
     *
     * @author Administrator
     * @param    pragmaInstruction    the pragma instruction intended to make
     * @return the value for specified configuration of database
     */
    private long getLongConfig(String pragmaInstruction) {
        return DatabaseUtils.longForQuery(this.db, SQLiteDatabaseConfigurer.PRAGMA + " " + pragmaInstruction, null);
    }

    //***********************************
    //*	Nested Class					*
    //***********************************

    /**
     * <b>ClassName</b>		:	Setter												</br>
     * <b>Function</b>		: 	To set the configuration of {@link SQLiteDatabase}.	</br>
     * <b>Reason</b>		:	To set the configuration of {@link SQLiteDatabase}.	</br>
     *
     * </br>
     * <b>Maintenance History</b>:
     * <table>
     * 		<tr>
     * 			<th>Date</th>
     * 			<th>Developer</th>
     * 			<th>Target</th>
     * 			<th>Content</th>
     * 		</tr>
     * 		<tr>
     * 			<td>2016-7-30</td>
     * 			<td>Administrator</td>
     * 			<td>All</td>
     *			<td>Created.</td>
     * 		</tr>
     * </table>
     *
     * @author Administrator
     * @version 1.0.1
     * @since 1.6
     */
    public static class Setter {
        //*******************************************
        //*	Instance Area							*
        //*******************************************
        //***************************************
        //*	Fields								*
        //***************************************
        private SQLiteDatabase db;

        //***************************************
        //*	Constructors						*
        //***************************************

        /**
         * Creates a new instance of Setter.
         *
         * @param    db    the {@link SQLiteDatabase} intended to set configurations for
         */
        public Setter(SQLiteDatabase db) {
            this.db = db;
        }

        //***************************************
        //*	Methods								*
        //***************************************
        //***********************************
        //*	Functional Methods				*
        //***********************************

        /**
         * 	Create the the instance of {@link SQLiteDatabaseConfigurer}.
         *
         * @author Administrator
         * @return the instance of {@link SQLiteDatabaseConfigurer}
         */
        public SQLiteDatabase validate() {
            return this.db;
        }

        /**
         * 	Render pragma instruction <code>AUTO_VACUUM</code> validated or not.
         *
         * @author Administrator
         * @param    flag    the flag to indicate whether to validate pragma instruction <code>AUTO_VACUUM</code> or not
         * @return the {@link Setter} itself
         */
        public Setter setAutoVacuum(boolean flag) {
            this.setBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_AUTO_VACUUM, flag);
            return this;
        }

        /**
         * 	Render the maximum cache size of database.
         *
         * @author Administrator
         * @param    numberOfPages    the maximum cache size of database(default value is 2000)
         * @return the {@link Setter} itself
         */
        public Setter setCacheSize(long numberOfPages) {
            this.setConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_CACHE_SIZE, String.valueOf(numberOfPages));
            return this;
        }

        /**
         * 	Render pragma instruction <code>CASE_SENSITIVE_LIKE</code> validated or not.
         *
         * @author Administrator
         * @param    flag    the flag to indicate whether to validate pragma instruction <code>CASE_SENSITIVE_LIKE</code> or not
         * @return the {@link Setter} itself
         */
        public Setter setCaseSensitiveLike(boolean flag) {
            this.setBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_CASE_SENSITIVE_LIKE, flag);
            return this;
        }

        /**
         * 	Render pragma instruction <code>COUNT_CHANGES</code> validated or not.
         *
         * @author Administrator
         * @param    flag    the flag to indicate whether to validate pragma instruction <code>COUNT_CHANGES</code> or not
         * @return the {@link Setter} itself
         */
        public Setter setCountChanges(boolean flag) {
            this.setBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_COUNT_CHANGES, flag);
            return this;
        }

        /**
         * 	Render the default maximum cache size of database.
         *
         * @author Administrator
         * @param    numberOfPages    the default maximum cache size of database(default value is 2000)
         * @return the {@link Setter} itself
         */
        public Setter setDefaultCacheSize(
                long numberOfPages) {
            this.setConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_DEFAULT_CACHE_SIZE, String.valueOf(numberOfPages));
            return this;
        }

        /**
         * 	Render pragma instruction <code>EMPTY_RESULT_CALLBACKS</code> validated or not.
         *
         * @author Administrator
         * @param    flag    the flag to indicate whether to validate pragma instruction <code>COUNT_CHANGES</code> or not
         * @return the {@link Setter} itself
         */
        public Setter setEmptyResultCallbacks(
                boolean flag) {
            this.setBooleanConfig(SQLiteDatabaseConfigurer.PRAGMA_INSTRUCTION_EMPTY_RESULT_CALLBACKS, flag);
            return this;
        }

        /**
         * 	Render the configuration validated or not.
         *
         * @author Administrator
         * @param    pragmaInstruction    the pragma instruction intended to make
         * @param    flag                true if the state of configuration turns out to be validated,otherwise false.
         */
        private void setBooleanConfig(String pragmaInstruction, boolean flag) {
            this.setConfig(pragmaInstruction, String.valueOf(flag ? SQLiteDatabaseConfigurer.PRAGMA_VALIDATED : SQLiteDatabaseConfigurer.PRAGMA_UNVALIDATED));
        }

        /**
         * 	Set the configuration's value currently.
         *
         * @author Administrator
         * @param    pragmaInstruction    the pragma instruction intended to make
         */
        private void setConfig(String pragmaInstruction, String value) {
            String completeInstruction = SQLiteDatabaseConfigurer.PRAGMA + " " + pragmaInstruction + " " + value;

            try {
                SQLiteDatabase.class.getDeclaredMethod("execSQL", String.class).invoke(this.db, completeInstruction);
            } catch (IllegalAccessException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            } catch (IllegalArgumentException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            } catch (InvocationTargetException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            } catch (NoSuchMethodException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }
        }
    }
}
