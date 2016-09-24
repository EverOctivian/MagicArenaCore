/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	QuarTuple.java									</br>
 * <b>PackageName</b>	:	com.magicarena.collection.tuple					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.collection.tuple;


/**
 * <b>ClassName</b>		:	QuarTuple																</br>
 * <b>Function</b>		: 	A <code>QuarTuple</code> is a data structure that has four elements. 	</br>
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
 * @param    <T4>	type of the fourth item
 * @since 1.6
 */
public class QuarTuple<T1, T2, T3, T4> extends TripleTuple<T1, T2, T3> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    T4 item4;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of QuarTuple.
     *
     * @param    item1    the first item
     * @param    item2    the second item
     * @param    item3    the third item
     * @param    item4    the fourth item
     */
    public QuarTuple(T1 item1, T2 item2, T3 item3, T4 item4) {
        super(item1, item2, item3);
        this.item4 = item4;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * QuarTuple's property item4's getter
     *
     * @return the item4
     */
    public T4 getItem4() {
        return this.item4;
    }
}
