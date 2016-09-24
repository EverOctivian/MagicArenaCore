/**
 * <b>ProjectName</b>	:	ArenaSource										</br>
 * <b>FileName</b>    	:	SortTemplate.java								</br>
 * <b>PackageName</b>	:	com.magicarena.sys.utils						</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved. 	</br>
 */
package com.framework.magicarena.core.utils;


/**
 * <b>ClassName</b>		:	SortTemplate									</br>
 * <b>Function</b>		: 	To supply templates of function for sorting.	</br>
 * <b>Reason</b>		:	To supply templates of function for sorting.	</br>
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
 * 			<td>2016-6-13</td>
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
public class SortTemplate {
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
     * The first algorithm for SelectionSort.
     *
     * @author Guo QingJun
     * @param    sortArray    an array of integers for sorting
     */
    public static void SelectionSort1(int[] sortArray) {
        int temp;

        for (int i = 0; i < (sortArray.length - 1); i++) {
            for (int j = i + 1; j < sortArray.length; j++) {
                if (sortArray[i] > sortArray[j]) {
                    temp = sortArray[i];
                    sortArray[i] = sortArray[j];
                    sortArray[j] = temp;
                }
            }
        }
    }

    /**
     * The second algorithm for SelectionSort.
     *
     * @author Guo QingJun
     * @param    sortArray    an array of integers for sorting
     */
    public static void SelectionSort2(int[] sortArray) {
        int indexSwap;
        int upperBound;
        int temp;

        for (int i = 0; i < (sortArray.length); i++) {
            indexSwap = 0;

            for (int j = 0; j < (sortArray.length - i); j++) {
                if (sortArray[indexSwap] < sortArray[j]) {
                    indexSwap = j;
                }
            }

            upperBound = sortArray.length - 1 - i;
            if (indexSwap != upperBound) {
                temp = sortArray[upperBound];
                sortArray[upperBound] = sortArray[indexSwap];
                sortArray[indexSwap] = temp;
            }
        }
    }

    /**
     * The first algorithm for BubbleSort.
     *
     * @author Guo QingJun
     * @param    sortArray    an array of integers for sorting
     */
    public static void BubbleSort1(int[] sortArray) {
        int temp;

        for (int i = 0; i < (sortArray.length - 1); i++) {
            for (int j = 0; j < (sortArray.length - i - 1); j++) {
                if (sortArray[j] > sortArray[j + 1]) {
                    temp = sortArray[j];
                    sortArray[j] = sortArray[j + 1];
                    sortArray[j + 1] = temp;
                }
            }
        }
    }

    /**
     * The second algorithm for BubbleSort.
     *
     * @author Guo QingJun
     * @param    sortArray    an array of integers for sorting
     */
    public static void BubbleSort2(int[] sortArray) {
        int temp;
        boolean flag;

        for (int i = 0; i < (sortArray.length); i++) {
            flag = false;

            for (int j = 1; j < (sortArray.length - i); j++) {
                if (sortArray[j] > sortArray[j + 1]) {
                    temp = sortArray[j];
                    sortArray[j] = sortArray[j + 1];
                    sortArray[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }

    /**
     * The algorithm for InsertSort
     *
     * @author Guo QingJun
     * @param    sortArray    an array of integers for sorting
     */
    public static void InsertSort(int[] sortArray) {
        int temp;
        int j;

        for (int i = 1; i < sortArray.length; i++) {
            temp = sortArray[i];

            for (j = i - 1; (j >= 0) && (temp < sortArray[j]); j--) {
                sortArray[j + 1] = sortArray[j];
            }

            sortArray[j + 1] = temp;
        }
    }

    /**
     * The algorithm for QuickSort.
     *
     * @author Guo QingJun
     * @param    sortArray    an array of integers for sorting
     * @param    left        the left index of sorting range
     * @param    right        the right index of sorting range
     */
    public static void QuickSort(int[] sortArray, int left, int right) {
        int i = left;
        int j = right;
        int temp;

        int midValue = sortArray[(left + right) / 2];

        do {
            while ((midValue > sortArray[i]) && (i < right)) {
                i++;
            }
            while ((midValue < sortArray[j]) && (j > left)) {
                j--;
            }

            if (i <= j) {
                temp = sortArray[i];
                sortArray[i] = sortArray[j];
                sortArray[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (i < right) {
            SortTemplate.QuickSort(sortArray, i, right);
        }
        if (j > left) {
            SortTemplate.QuickSort(sortArray, left, j);
        }
    }
}
