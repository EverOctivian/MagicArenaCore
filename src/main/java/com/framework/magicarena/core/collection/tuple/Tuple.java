/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	Tuple.java										</br>
 * <b>PackageName</b>	:	com.magicarena.collection.tuple					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.collection.tuple;


import java.lang.reflect.Field;

/**
 * <b>ClassName</b>		:	Tuple																				</br>
 * <b>Function</b>		: 	A Tuple is a data structure that has a specific number and sequence of elements. 	</br>
 * <b>Reason</b>		:	To create the same class as C# does.												</br>
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
 * @since 1.6
 */
public abstract class Tuple {
    //*******************************************
    //*	Static Area								*
    //*******************************************
    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Gets a instance of <code>UnitTuple</code>.
     *
     * @author Guo QingJun
     * @param    t1    this first item
     * @return a instance of <code>UnitTuple</code>
     */
    public static <T1> UnitTuple<T1> create(final T1 t1) {
        return new UnitTuple<T1>(t1);
    }

    /**
     * Gets a instance of <code>PairTuple</code>.
     *
     * @author Guo QingJun
     * @param    t1    the first item
     * @param    t2    the second item
     * @return a instance of <code>PairTuple</code>
     */
    public static <T1, T2> PairTuple<T1, T2> create(final T1 t1, final T2 t2) {
        return new PairTuple<T1, T2>(t1, t2);
    }

    /**
     * Gets a instance of <code>TripleTuple</code>.
     *
     * @author Guo QingJun
     * @param    t1    the first item
     * @param    t2    the second item
     * @param    t3    the third item
     * @return a instance of <code>TripleTuple</code>.
     */
    public static <T1, T2, T3> TripleTuple<T1, T2, T3> create(final T1 t1,
                                                              final T2 t2, final T3 t3) {
        return new TripleTuple<T1, T2, T3>(t1, t2, t3);
    }

    /**
     * Gets a instance of <code>QuarTuple</code>.
     *
     * @author Guo QingJun
     * @param    t1    the first item
     * @param    t2    the second item
     * @param    t3    the third item
     * @param    t4    the fourth item
     * @return a instance of <code>QuarTuple</code>
     */
    public static <T1, T2, T3, T4> QuarTuple<T1, T2, T3, T4> create(
            final T1 t1, final T2 t2, final T3 t3, final T4 t4) {
        return new QuarTuple<T1, T2, T3, T4>(t1, t2, t3, t4);
    }

    /**
     * Gets a instance of <code>QuinTuple</code>.
     *
     * @author Guo QingJun
     * @param    t1    the first item
     * @param    t2    the second item
     * @param    t3    the third item
     * @param    t4    the fourth item
     * @param    t5    the fifth item
     * @return a instance of <code>QuinTuple<T1></code>
     */
    public static <T1, T2, T3, T4, T5> QuinTuple<T1, T2, T3, T4, T5> create(
            final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5) {
        return new QuinTuple<T1, T2, T3, T4, T5>(t1, t2, t3, t4, t5);
    }

    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Methods								*
    //***************************************
    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of Tuple.
     *
     */
    public Tuple() {

    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************

    /**
     * TODO To print all the items of this <code>Tuple</code>.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer stringResult = new StringBuffer();

        for (Field field : this.getClass().getFields()) {
            try {
                stringResult.append(field.getName() + ":" + field.get(this).toString() + "\n");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return stringResult.toString();
    }
}
