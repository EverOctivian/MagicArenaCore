/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	MatchEvaluatable.java						</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


/**
 * <b>ClassName</b>		:	MatchEvaluatable												</br>
 * <b>Function</b>		: 	Represents the method that is called each time a regular
 * 							expression match is found during a Replace method operation.	</br>
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
public interface MatchEvaluatable {
    /**
     * Represents the method that is called each time a regular expression match is found during a Replace method operation.
     *
     * @author Guo QingJun
     * @param    match    the Match object that represents a single regular expression match during a Replace method operation
     * @return a string returned by the method that is represented by the MatchEvaluator delegate
     */
    public String evaluate(Match match);
}
