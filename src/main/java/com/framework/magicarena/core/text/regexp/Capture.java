/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	Capture.java								</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


/**
 * <b>ClassName</b>		:	Capture																	</br>
 * <b>Function</b>		: 	Represents the results from a single successful subexpression capture.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.									</br>
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
abstract class Capture {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private int index;
    private int length;
    private String value;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of Capture.
     *
     * @param    captureIndex    the position in the original string where the first character of the captured substring is found
     * @param    captrueLength    gets the length of the captured substring
     * @param    captureValue    gets the captured substring from the input string
     */
    Capture(int captureIndex, int captrueLength, String captureValue) {
        super();
        this.index = captureIndex;
        this.length = captrueLength;
        this.value = captureValue;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * Capture's property index's getter
     *
     * @return the index
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Capture's property length's getter
     *
     * @return the length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Capture's property value's getter
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************

    /**
     * TODO Retrieves the captured substring from the input string by calling the getCaptureValue.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return this.getValue();
    }
}
