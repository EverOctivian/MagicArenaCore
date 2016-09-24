/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	CaptureCollection.java						</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>ClassName</b>		:	CaptureCollection													</br>
 * <b>Function</b>		: 	Represents the set of captures made by a single capturing group.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.								</br>
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
 * 			<td>2016-6-10</td>
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
abstract class CaptureCollection implements Iterable<Capture> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private ArrayList<Capture> captureList;    //container for captures

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of CaptureCollection.
     *
     */
    CaptureCollection() {
        super();

        this.captureList = new ArrayList<Capture>();
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Enables access to a member of the collection by integer index.
     *
     * @author Guo QingJun
     * @param    index    index of an individual <code>Capture</code> of <code>CaptureCollection</code>
     * @return an individual <code>Capture</code> of <code>CaptureCollection</code>
     */
    public Capture getCaptureByIndex(int index) {
        return this.captureList.get(index);
    }

    /**
     * Gets the number of substrings captured by the group.
     *
     * @author Guo QingJun
     * @return the number of substrings captured by the <code>Group</code>
     */
    public int getCapturesCount() {
        return this.captureList.size();
    }

    /**
     * Copies all the elements of the collection to the given array beginning at the given index.
     *
     * @author Guo QingJun
     * @param    desArr        a new array for containing specified elements
     * @param    startIndex    the beginning index when copying elements
     */
    public void copyTo(Capture[] desArr, int startIndex) {
        int desArrCursor = 0;

        if (startIndex > (this.captureList.size() - 1)) {
            desArr = null;
        } else {
            desArr = new Capture[this.captureList.size() - startIndex];

            for (int i = startIndex; i < this.captureList.size(); i++) {
                desArr[desArrCursor++] = this.captureList.get(i);
            }
        }
    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************

    /**
     * TODO Travels the captured <code>CaptureCollection</code>.
     * @see Iterator
     */
    @Override
    public Iterator<Capture> iterator() {
        return this.captureList.iterator();
    }
}
