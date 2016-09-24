/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	QuinTuple.java									</br>
 * <b>PackageName</b>	:	com.magicarena.collection.tuple					</br>
 * <b>DateTime</b>		:	2016-6-16	15:54:41							</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.collection.tuple;


/**
 * <b>ClassName</b>		:	QuinTuple																</br>
 * <b>Function</b>		: 	A <code>QuarTuple</code> is a data structure that has five elements.	</br>
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
 * 			<td>2016-6-16</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 *
 * @author Guo QingJun
 * @version 1.0.1
 * @param    <T1>	type of the first item
 * @param    <T2>	type of the second item
 * @param    <T3>	type of the third item
 * @param    <T4> 	type of the fourth item
 * @param    <T5>	type of the fifth item
 * @since 1.6
 */
public class QuinTuple<T1, T2, T3, T4, T5> extends QuarTuple<T1, T2, T3, T4> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    T5 item5;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of QuinTuple.
     *
     * @param    item1    the first item
     * @param    item2    the second item
     * @param    item3    the third item
     * @param    item4    the fourth item
     * @param    item5    the fifth item
     */
    public QuinTuple(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5) {
        super(item1, item2, item3, item4);
        this.item5 = item5;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * QuinTuple's property item5's getter
     *
     * @return the item5
     */
    public T5 getItem5() {
        return this.item5;

    }
}
