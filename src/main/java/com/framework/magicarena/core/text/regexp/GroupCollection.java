/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	GroupCollection.java						</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * <b>ClassName</b>		:	GroupCollection											</br>
 * <b>Function</b>		: 	Returns the set of captured groups in a single match.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.					</br>
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
public class GroupCollection implements Iterable<Group> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private ArrayList<Group> groupList;            //list container for groups
    private HashMap<String, Group> groupMap;            //map container for groups

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of GroupCollection.
     *
     */
    GroupCollection() {
        super();

        this.groupList = new ArrayList<Group>();
        this.groupMap = new HashMap<String, Group>();
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
     * @param    index    index of an individual <code>Group</code> of the <code>GroupCollection</code>
     * @return an individual <code>Group</code> of <code>GroupCollection</code>
     */
    public Group getGroupByIndex(int index) {
        return this.groupList.get(index);
    }

    /**
     * Enables access to a member of the collection by string index.
     *
     * @author Guo QingJun
     * @param    name    name of an individual <code>Group</code> of the <code>GroupCollection</code>
     * @return an individual <code>Capture</code> of <code>CaptureCollection</code>
     */
    public Group getGroupByName(String name) {
        return this.groupMap.get(name);
    }

    /**
     * Returns the number of groups in the collection.
     *
     * @author Guo QingJun
     * @return the number of substrings captured by the <code>Group</code>
     */
    public int getGroupsCount() {
        return this.groupList.size();
    }

    /**
     * Copies all the elements of the collection to the given array beginning at the given index.
     *
     * @author Guo QingJun
     * @param    desArr        a new array for containing specified elements
     * @param    startIndex    the beginning index when copying elements
     */
    public void copyTo(Group[] desArr, int startIndex) {
        int desArrCursor = 0;

        if (startIndex > (this.groupList.size() - 1)) {
            desArr = null;
        } else {
            desArr = new Group[this.groupList.size() - startIndex];

            for (int i = startIndex; i < this.groupList.size(); i++) {
                desArr[desArrCursor++] = this.groupList.get(i);
            }
        }
    }

    /**
     * Add a <code>Group</code> to <code>GroupCollection</code>.
     *
     * @author Guo QingJun
     * @param    groupItem    a instance added to <code>GroupCollection</code>
     */
    void addGroup(Group groupItem) {
        if (groupItem != null) {
            this.groupList.add(groupItem);
        }
    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************

    /**
     * TODO travels the captured <code>GroupCollection</code>.
     * @see Iterator
     */
    @Override
    public Iterator<Group> iterator() {
        // TODO Auto-generated method stub
        return this.groupList.iterator();
    }
}
