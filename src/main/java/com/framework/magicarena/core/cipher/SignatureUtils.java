package com.framework.magicarena.core.cipher;


import com.framework.magicarena.core.text.constants.CharsetConstants;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * <p>Tools for signature.</p>
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
public final class SignatureUtils {
    //*******************************************
    //*	Static Area 							*
    //*******************************************
    //***************************************
    //*	Methods								*
    //***************************************

    /**
     * Sign some data by {@linkplain AlgorithmConstants#SIGNATURE_ALGORITHM_ASYMMETRIC_SHA1_WITH_RSA}.
     *
     * @param content       data that is signed for
     * @param privateKey    private key of asymmetric algorithm
     * @param encodeCharset encoding character set of signature in {@linkplain CharsetConstants},null is
     *                      allowed,in this case {@linkplain CharsetConstants#CHARACTER_SET_UTF_8} will be used
     * @return the signature of all updated data
     */
    public static String signBySHA1WithRSA(String content, String privateKey, String encodeCharset) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Algorithm.decode(privateKey));

            //create instance of private key by specified charsquence
            KeyFactory keyf = KeyFactory.getInstance(AlgorithmConstants.CIPHER_ALGORITHM_ASYMMETRIC_RSA);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            //initialize instance of signature by specified private key
            java.security.Signature signature = java.security.Signature.getInstance(AlgorithmConstants.SIGNATURE_ALGORITHM_ASYMMETRIC_SHA1_WITH_RSA);
            signature.initSign(priKey);
            signature.update(content.getBytes(CharsetConstants.CHARACTER_SET_UTF_8));

            byte[] signed = signature.sign();

            return new String(Base64Algorithm.encode(signed), encodeCharset);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
