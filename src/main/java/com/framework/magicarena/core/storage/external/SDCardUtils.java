package com.framework.magicarena.core.storage.external;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * <p>Supply basic information about external storage.</p>
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
 * 			<td>2016-8-15</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 */
public final class SDCardUtils {
    private Context context;

    public SDCardUtils(Context context) {
        this.context = context;
    }

    /**
     * Checks if external storage is available for read and write.
     *
     * @return return true if external is writable,false otherwise.
     */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }

        return false;
    }

    /**
     * Checks if external storage is available to at least read.
     *
     * @return return true if external is readable,false otherwise.
     */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }

        return false;
    }

    /**
     * Try to obtain the path of SD card.
     *
     * @return  <code>File</code> object representing for the SDCaredPath;
     *          null if the SD card device isn't available at the moment.
     */
    public File getSDCardAbsoluteDir() {
        if (this.isExternalStorageReadable()) {
            return Environment.getExternalStorageDirectory();
        }

        return null;
    }

    /**
     * Get the public standard directory of Android system in SD card.
     *
     * @param type the type of public standard directory
     * @return <code>File</code> object representing for the public standard directory of Android system in SD card;
     *         null if the SD card device isn't available at the moment.
     */
    public File getSDCardPublicStandardDir(StandardDirectory type) {
        if (this.isExternalStorageReadable()) {
            return Environment.getExternalStoragePublicDirectory(type.value());
        }

        return null;
    }

    /**
     * Get the private standard directory of Android system in SD card.
     *
     * @param type the type of public standard directory
     * @return <code>File</code> object representing for the private standard directory of Android system in SD card;
     *         null if the SD card device isn't available at the moment.
     */
    public File getSDCardPrivateStandardDir(StandardDirectory type) {
        if (this.isExternalStorageReadable()) {
            return this.context.getExternalFilesDir(type.value());
        }

        return null;
    }

    /**
     * Get the private media directory of Android system in SD card.
     *
     * @return <code>File</code> object representing for the private media directory of Android system in SD card;
     *         null if the SD card device isn't available at the moment.
     */
    public File getSDCardPrivateMediaDir() {
        if (this.isExternalStorageReadable()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                File[] externalMediaDirs = this.context.getExternalMediaDirs();

                if (externalMediaDirs != null && externalMediaDirs.length >= 1) {
                    return externalMediaDirs[0];
                }
            }
        }

        return null;
    }

    /**
     * Get the private cache directory of Android system in SD card.
     *
     * @return <code>File</code> object representing for the private cache directory of Android system in SD card;
     *         null if the SD card device isn't available at the moment.
     */
    public File getSDCardPrivateCacheDir() {
        if (this.isExternalStorageReadable()) {
            return this.context.getExternalCacheDir();
        }

        return null;
    }

    /**
     * Get the private customized directory of Android system in SD card.
     *
     * @param dirName the name of customized directory
     * @return <code>File</code> object representing for the private customized directory of Android system in SD card;
     *         null if the SD card device isn't available at the moment.
     */
    public File getSDCardPrivateDir(String dirName) {
        if (this.isExternalStorageReadable()) {
            return new File(this.context.getExternalFilesDir(null), dirName);
        }

        return null;
    }

    /**
     * Get the private standard directory of Android system in SD card.
     *
     * @return <code>File</code> object representing for the private standard directory of Android system in SD card;
     *         null if the SD card device isn't available at the moment.
     */
    public File getSDCardPublicDownloadCacheDir() {
        if (this.isExternalStorageReadable()) {
            return Environment.getDownloadCacheDirectory();
        }

        return null;
    }

    /**
     * Get the total size of space of SD card.
     *
     * @return the total size of space of SD card;
     *         0 if the SD card device isn't available at the moment.
     */
    public long getSDCardTotalSpace() {
        File sdCardPath = this.getSDCardAbsoluteDir();

        if (sdCardPath != null) {
            StatFs statFs = new StatFs(sdCardPath.getAbsolutePath());

            long blockCountLong = statFs.getBlockCountLong();
            long blockSizeLong = statFs.getBlockSizeLong();

            return blockCountLong * blockSizeLong;
        }

        return 0;
    }

    /**
     * Get the available size of space of SD card.
     *
     * @return the available size of space of SD card;
     *         0 if the SD card device isn't available at the moment.
     */
    public long getSDCardAvailableSpace() {
        File sdCardPath = this.getSDCardAbsoluteDir();

        if (sdCardPath != null) {
            StatFs statFs = new StatFs(sdCardPath.getAbsolutePath());

            long blockCountLong = statFs.getAvailableBlocksLong();
            long blockSizeLong = statFs.getBlockSizeLong();

            return blockCountLong * blockSizeLong;
        }

        return 0;
    }

    /**
     * Get the free size of space of SD card.
     *
     * @return the free size of space of SD card;
     *         0 if the SD card device isn't available at the moment.
     */
    public long getSDCardFreeSpace() {
        File sdCardPath = this.getSDCardAbsoluteDir();

        if (sdCardPath != null) {
            StatFs statFs = new StatFs(sdCardPath.getAbsolutePath());

            long blockCountLong = statFs.getFreeBlocksLong();
            long blockSizeLong = statFs.getBlockSizeLong();

            return blockCountLong * blockSizeLong;
        }
        return 0;
    }

    /**
     * <p>Supply enumerations for standard directories of SD card.</p>
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
     * 			<td>2016-8-15</td>
     * 			<td>Guo QingJun</td>
     * 			<td>All</td>
     *			<td>Created.</td>
     * 		</tr>
     * </table>
     */
    public enum StandardDirectory {
        //*******************************************
        //*	Instance Area							*
        //*******************************************
        //***************************************
        //*	Constructs Instances Of Enumerations*
        //***************************************

        /**
         * @see Environment#DIRECTORY_ALARMS
         */
        ALARMS(Environment.DIRECTORY_ALARMS),

        /**
         * @see Environment#DIRECTORY_DCIM
         */
        DCIM(Environment.DIRECTORY_DCIM),

        /**
         * @see Environment#DIRECTORY_DOCUMENTS
         */
        DOCUMENTS(Environment.DIRECTORY_DOCUMENTS),

        /**
         * @see Environment#DIRECTORY_DOWNLOADS
         */
        DOWNLOADS(Environment.DIRECTORY_DOWNLOADS),

        /**
         * @see Environment#DIRECTORY_MOVIES
         */
        MOVIES(Environment.DIRECTORY_MOVIES),

        /**
         * @see Environment#DIRECTORY_MUSIC
         */
        MUSIC(Environment.DIRECTORY_MUSIC),

        /**
         * @see Environment#DIRECTORY_NOTIFICATIONS
         */
        NOTIFICATIONS(Environment.DIRECTORY_NOTIFICATIONS),

        /**
         * @see Environment#DIRECTORY_PICTURES
         */
        PICTURES(Environment.DIRECTORY_PICTURES),

        /**
         * @see Environment#DIRECTORY_PODCASTS
         */
        PODCASTS(Environment.DIRECTORY_PODCASTS),

        /**
         * @see Environment#DIRECTORY_RINGTONES
         */
        RINGTONES(Environment.DIRECTORY_RINGTONES);


        //***************************************
        //*	Fields								*
        //***************************************
        private String dirName;

        //***************************************
        //*	Constructors						*
        //***************************************

        /**
         * Creates a new instance of RegexOptions.
         *
         * @param    dirName    name for system directory
         */
        private StandardDirectory(String dirName) {
            this.dirName = dirName;
        }

        //***************************************
        //*	Methods								*
        //***************************************
        //***********************************
        //*	Functional Methods				*
        //***********************************

        /**
         * Returns the name of <code>StandardDirectory</code>.
         *
         * @author Guo QingJun
         * @return the name of <code>StandardDirectory</code>
         */
        public String value() {
            return this.dirName;
        }
    }
}
