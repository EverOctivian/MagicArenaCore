/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	Environment.java							</br>
 * <b>PackageName</b>	:	com.magicarena.sys.utils					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.utils;


/**
 * <b>ClassName</b>		:	Environment									</br>
 * <b>Function</b>		: 	To preserve system environment variables.	</br>
 * <b>Reason</b>		:	To preserve system environment variables.	</br>
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
 * 			<td>2016-6-25</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 *
 * @author Guo QingJun
 * @version 1.0.1
 * @since 1.6
 */
public final class Environment {
    //*******************************************
    //*	Static Area								*
    //*******************************************
    //***************************************
    //*	Blocks								*
    //***************************************
    static {
        //***********************************
        //*	Property Name					*
        //***********************************
        final String PROPERTY_NAME_JAVA_VERSIONE = "java.version";
        final String PROPERTY_NAME_OS_NAME = "os.name";
        final String PROPERTY_NAME_USER_DOCUMENT = "user.home";

        //***********************************
        //*	Property Default Value			*
        //***********************************
        final String PROPERTY_DV_JAVA_VERSIONE = "0.0.0_00";

        //***********************************
        //*	Property Value					*
        //***********************************
        PROPERTY_JAVA_VERSION = System.getProperty(PROPERTY_NAME_JAVA_VERSIONE, PROPERTY_DV_JAVA_VERSIONE);
        PROPERTY_OS_NAME = System.getProperty(PROPERTY_NAME_OS_NAME, "");
        PROPERTY_USER_DOCUMENT = System.getProperty(PROPERTY_NAME_USER_DOCUMENT, "");
    }

    //***************************************
    //*	Fields								*
    //***************************************
    /**
     * Indicates the current version of JDK.
     */
    public final static String PROPERTY_JAVA_VERSION;
    /**
     * Indicates the name of current operation system that runs JVM.
     */
    public final static String PROPERTY_OS_NAME;
    /**
     * Indicates the workdocument's path of current user.
     */
    public final static String PROPERTY_USER_DOCUMENT;
}
