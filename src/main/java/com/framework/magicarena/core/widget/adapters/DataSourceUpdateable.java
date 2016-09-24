package com.framework.magicarena.core.widget.adapters;

import java.util.List;

/**
 * <p>To supply basic methods associated about updating date source.</p>
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
 * 			<td>2016-8-27</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 */
public interface DataSourceUpdateable<T> {
    /**
     * Add data source items to existed data list.
     *
     * @param dataSource    items expected to been added
     */
    void addDataSource(List<T> dataSource);

    /**
     * Update data source items with specified data items.
     *
     * @param dataSource    items expected to been updated with
     */
    void updateDataSouce(List<T> dataSource);

    /**
     * Clear all the data source items.
     */
    void clearDataSource();
}
