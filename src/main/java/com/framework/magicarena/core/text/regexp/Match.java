/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	Match.java									</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


/**
 * <b>ClassName</b>		:	Match															</br>
 * <b>Function</b>		: 	Represents the results from a single regular expression match.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.							</br>
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
public class Match extends Group {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private GroupCollection groups;
    private Regex.MatchOperation matchOperation;

    //***************************************
    //*	Constructors						*
    //***************************************
    //	/**
    //	 * Creates a new instance of Match.
    //	 *
    //	 * @param matchIndex	The position in the original string where the first character of the captured substring is found
    //	 * @param matchLength	The length of the captured substring
    //	 * @param matchValue	The captured substring from the input string
    //	 * @param captures		A collection of all the captures matched by the capturing group, in innermost-leftmost-first order (or innermost-rightmost-first order if the regular expression is modified with the RegexOptions.RightToLeft option).The collection may have zero or more items.
    //	 * @param matchSuccess	A value indicating whether the match is successful
    //	 */
    //	private Match(int matchIndex, int matchLength, String matchValue,
    //			CaptureCollection captures, boolean matchSuccess) {
    //		super(matchIndex, matchLength, matchValue, captures, matchSuccess);
    //
    //	}

    /**
     * Creates a new instance of Match.
     *
     * @param    matchIndex        The position in the original string where the first character of the captured substring is found
     * @param    matchLength        The length of the captured substring
     * @param    matchValue        The captured substring from the input string
     * @param    captures        A collection of all the captures matched by the capturing group, in innermost-leftmost-first order (or innermost-rightmost-first order if the regular expression is modified with the RegexOptions.RightToLeft option).The collection may have zero or more items.
     * @param    matchSuccess    A value indicating whether the match is successful
     */
    private Match(int matchIndex, int matchLength, String matchValue,
                  boolean matchSuccess) {
        super(matchIndex, matchLength, matchValue, matchSuccess);
    }

    /**
     * Creates a new instance of Match.
     *
     * @param    matchIndex        The position in the original string where the first character of the captured substring is found
     * @param    matchLength        The length of the captured substring
     * @param    matchValue        The captured substring from the input string
     * @param    matchSuccess    A value indicating whether the match is successful
     * @param    groups            a collection of groups matched by the regular expression
     * @param    matchOperation    a reference to the <code>MatchOperation</code> corresponded to this match
     */
    Match(int matchIndex, int matchLength, String matchValue,
          boolean matchSuccess, GroupCollection groups,
          Regex.MatchOperation matchOperation) {
        this(matchIndex, matchLength, matchValue, matchSuccess);
        this.groups = groups;
        this.matchOperation = matchOperation;
    }

    //	/**
    //	 * Creates a new instance of Match.
    //	 *
    //	 * @param matchIndex	The position in the original string where the first character of the captured substring is found
    //	 * @param matchLength	The length of the captured substring
    //	 * @param matchValue	The captured substring from the input string
    //	 * @param captures		A collection of all the captures matched by the capturing group, in innermost-leftmost-first order (or innermost-rightmost-first order if the regular expression is modified with the RegexOptions.RightToLeft option).The collection may have zero or more items.
    //	 * @param matchSuccess	A value indicating whether the match is successful
    //	 * @param groups		a collection of groups matched by the regular expression
    //	 */
    //	Match(int matchIndex, int matchLength, String matchValue,
    //			CaptureCollection captures, boolean matchSuccess,
    //			GroupCollection groups) {
    //		this(matchIndex, matchLength, matchValue, captures, matchSuccess);
    //		this.groups = groups;
    //	}

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Returns a new Match object with the results for the next match, starting at the
     * position at which the last match ended (at the character after the last matched character).
     *
     * @author Guo QingJun
     * @return a new Match object with the results for the next match
     */
    public Match nextMatch() {
        return this.matchOperation.nextMatch();
    }

    //	/**
    //	 * result	:	Returns the expansion of the specified replacement pattern.
    //	 *
    //	 * @author	Guo QingJun
    //	 * @param	pattern	specified replacement pattern
    //	 * @return	the expansion of the specified replacement pattern
    //	 */
    //	public String result(String pattern) {
    //		return matchOperation;
    //	}

    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * Match's property groups's getter
     *
     * @return the groups
     */
    public GroupCollection getGroups() {
        return this.groups;
    }
}
