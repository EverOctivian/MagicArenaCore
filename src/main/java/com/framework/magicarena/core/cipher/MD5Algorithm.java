package com.framework.magicarena.core.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Tools for generating hash code.</p>
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
public final class MD5Algorithm {
    /**
     *  Generate MD5 serial number with specified string sequence.
     *
     * @param   source  source that serial number is generated from
     * @return generated serial number
     */
    private static String createMD5(String source) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(source.getBytes());
            byte[] digest = md5.digest();

            return new String(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
