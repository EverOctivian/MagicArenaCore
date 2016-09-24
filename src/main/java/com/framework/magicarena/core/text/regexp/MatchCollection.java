/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	MatchCollection.java						</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>ClassName</b>		:	MatchCollection										</br>
 * <b>Function</b>		: 	Represents the set of successful matches found by iteratively applying a regular expression pattern to the input string.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.				</br>
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
 * 			<td>2016-6-24</td>
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
public class MatchCollection implements Iterable<Match> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private ArrayList<Match> matchList;    //list container for groups

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of MatchCollection.
     *
     */
    public MatchCollection() {
        // TODO Auto-generated constructor stub
        super();

        this.matchList = new ArrayList<Match>();
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
     * @param    index    index of an individual <code>Match</code> of the <code>MatchCollection</code>
     * @return an individual <code>Match</code> of <code>MatchCollection</code>
     */
    public Match getMatchByIndex(int index) {
        return this.matchList.get(index);
    }

    /**
     * Gets the number of matches.
     *
     * @author Guo QingJun
     * @return the number of matches
     */
    public int getMatchesCount() {
        return this.matchList.size();
    }

    /**
     * Copies all the elements of the collection to the given array beginning at the given index.
     *
     * @author Guo QingJun
     * @param    desArr        a new array for containing specified elements
     * @param    startIndex    the beginning index when copying elements
     */
    public void copyTo(Match[] desArr, int startIndex) {
        int desArrCursor = 0;

        if (startIndex > (this.matchList.size() - 1)) {
            desArr = null;
        } else {
            desArr = new Match[this.matchList.size() - startIndex];

            for (int i = startIndex; i < this.matchList.size(); i++) {
                desArr[desArrCursor++] = this.matchList.get(i);
            }
        }
    }

    /**
     * Adds a <code>Match</code> to <code>MatchCollection</code>.
     *
     * @author Guo QingJun
     * @param    matchItem    a instance added to <code>MatchCollection</code>
     */
    void addMatch(Match matchItem) {
        if (matchItem != null) {
            this.matchList.add(matchItem);
        }
    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************

    /**
     * TODO Travels the matched <code>MatchCollection</code>.
     * @see Iterator
     */
    @Override
    public Iterator<Match> iterator() {
        // TODO Auto-generated method stub
        return this.matchList.iterator();
    }
}
