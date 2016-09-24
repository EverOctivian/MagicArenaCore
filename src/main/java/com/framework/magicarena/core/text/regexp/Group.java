/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	Group.java									</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


/**
 * <b>ClassName</b>		:	Group													</br>
 * <b>Function</b>		: 	Represents the results from a single capturing group.	</br>
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
public class Group extends Capture {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    //	private CaptureCollection	captures;
    private boolean matchSuccess;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of Group.
     *
     * @param    groupIndex    The position in the original string where the first character of the captured substring is found.
     * @param    groupLength    Gets the length of the captured substring.
     * @param    groupValue    Gets the captured substring from the input string
     */
    private Group(int groupIndex, int groupLength, String groupValue) {
        // TODO Auto-generated constructor stub
        super(groupIndex, groupLength, groupValue);
    }

    /**
     * Creates a new instance of Group.
     *
     * @param    groupIndex        The position in the original string where the first character of the captured substring is found
     * @param    groupLength        The length of the captured substring
     * @param    groupValue        The captured substring from the input string
     * @param    matchSuccess    A value indicating whether the match is successful
     */
    Group(int groupIndex, int groupLength, String groupValue,
          boolean matchSuccess) {
        this(groupIndex, groupLength, groupValue);
        this.matchSuccess = matchSuccess;
    }

    //	/**
    //	 * Creates a new instance of Group.
    //	 *
    //	 * @param groupIndex	The position in the original string where the first character of the captured substring is found
    //	 * @param groupLength	The length of the captured substring
    //	 * @param groupValue	The captured substring from the input string
    //	 * @param captures		A collection of all the captures matched by the capturing group, in innermost-leftmost-first order (or innermost-rightmost-first order if the regular expression is modified with the RegexOptions.RightToLeft option).The collection may have zero or more items.
    //	 * @param matchSuccess	A value indicating whether the match is successful
    //	 */
    //	Group(int groupIndex, int groupLength, String groupValue,
    //			CaptureCollection captures, boolean matchSuccess) {
    //		this(groupIndex, groupLength, groupValue);
    //		this.captures = captures;
    //		this.matchSuccess = matchSuccess;
    //	}

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************
    //	/**
    //	 * Group's property captures's getter
    //	 *
    //	 * @return the captures
    //	 */
    //	public CaptureCollection getCaptures() {
    //		return this.captures;
    //	}

    /**
     * Group's property matchSuccess's getter
     *
     * @return the matchSuccess
     */
    public boolean isMatchSuccess() {
        return this.matchSuccess;
    }
}
