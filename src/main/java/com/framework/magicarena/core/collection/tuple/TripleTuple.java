/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	TripleTuple.java								</br>
 * <b>PackageName</b>	:	com.magicarena.collection.tuple					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.collection.tuple;


/**
 * <b>ClassName</b>		:	TripleTuple																</br>
 * <b>Function</b>		: 	A <code>TripleTuple</code> is a data structure that has three element. 	</br>
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
 * @since 1.6
 */
public class TripleTuple<T1, T2, T3> extends PairTuple<T1, T2> {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    T3 item3;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of TripleTuple.
     *
     * @param    item1    the first item
     * @param    item2    the second item
     * @param    item3    the third item
     */
    public TripleTuple(T1 item1, T2 item2, T3 item3) {
        super(item1, item2);
        this.item3 = item3;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * TripleTuple's property item3's getter
     *
     * @return the item3
     */
    public T3 getItem3() {
        return this.item3;
    }
}
