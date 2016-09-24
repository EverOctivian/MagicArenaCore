/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	PairTuple.java									</br>
 * <b>PackageName</b>	:	com.magicarena.collection.tuple					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.collection.tuple;


/**
 * <b>ClassName</b>		:	PairTuple																</br>
 * <b>Function</b>		: 	A <code>PairTuple</code> is a data structure that has two elements. 	</br>
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
 * @since 1.6
 */
public class PairTuple<T1, T2> extends UnitTuple<T1> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    T2 item2;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of PairTuple.
     *
     * @param    item1    the first item
     * @param    item2    the second item
     */
    public PairTuple(T1 item1, T2 item2) {
        super(item1);
        this.item2 = item2;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * PairTuple's property item2's getter
     *
     * @return the    item2
     */
    public T2 getItem2() {
        return this.item2;
    }
}
