/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	UnitTuple.java									</br>
 * <b>PackageName</b>	:	com.magicarena.collection.tuple					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.collection.tuple;


/**
 * <b>ClassName</b>		:	UnitTuple																</br>
 * <b>Function</b>		: 	A <code>UnitTuple</code> is a data structure that has a one element. 	</br>
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
 * @since 1.6
 */
public class UnitTuple<T1> extends Tuple {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    T1 item1;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of UnitTuple.
     *
     * @param    item1    the first item
     */
    UnitTuple(T1 item1) {
        super();
        this.item1 = item1;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * UnitTuple's property item1's getter
     *
     * @return the item1
     */
    public T1 getItem1() {
        return this.item1;
    }
}
