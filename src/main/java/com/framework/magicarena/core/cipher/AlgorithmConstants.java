package com.framework.magicarena.core.cipher;

/**
 * Constants for algorithm for purpose below:
 * <ul>
 *      <li>cipher</li>
 *      <li>signature</li>
 * </ul>
 *
 * <b>Maintenance History</b>:
 * <table>
 * 		<tr>
 * 			<th>Date</th>
 * 			<th>Developer</th>
 * 			<th>Target</th>
 * 			<th>Content</th>
 * 		</tr>
 * 		<tr>
 * 			<td>2016-6-25</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 */
public interface AlgorithmConstants {
    String CIPHER_ALGORITHM_ASYMMETRIC_RSA = "RSA";

    String SIGNATURE_ALGORITHM_ASYMMETRIC_SHA1_WITH_RSA = "SHA1WithRSA";
}
