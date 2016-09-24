/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	RegexMatchRng.java							</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


/**
 * <b>ClassName</b>		:	RegexMatchRng																	</br>
 * <b>Function</b>		: 	Provides enumerated values to use to set regular expression MatchRange options.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.											</br>
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
public enum RegexMatchRng {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Constructs Instances Of Enumerations*
    //***************************************
    /**
     * Attempts to find the next subsequence of the input sequence that matches the pattern.
     */
    Fragment,
    /**
     * Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
     */
    Begin,
    /**
     * Attempts to match the entire region against the pattern.
     */
    Whole;
}
