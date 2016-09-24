/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	RegexOptions.java							</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;


import java.util.regex.Pattern;

/**
 * <p>Provides enumerated values to use to set regular expression options.</p>
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
 * 			<td>2016-6-24</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 */
public enum RegexOptions {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Constructs Instances Of Enumerations*
    //***************************************
    /**
     * @see Pattern#UNIX_LINES
     */
    UnixLines(Pattern.UNIX_LINES),
    /**
     * @see Pattern#CASE_INSENSITIVE
     */
    Insensitive(Pattern.CASE_INSENSITIVE),
    /**
     * @see Pattern#COMMENTS
     */
    Comments(Pattern.COMMENTS),
    /**
     * @see Pattern#MULTILINE
     */
    Multiline(Pattern.MULTILINE),
    /**
     * @see Pattern#LITERAL
     */
    Literal(Pattern.LITERAL),
    /**
     * @see Pattern#DOTALL
     */
    SingleLine(Pattern.DOTALL),
    /**
     * @see Pattern#UNICODE_CASE
     */
    UnicodeCase(Pattern.UNICODE_CASE),
    /**
     * @see Pattern#CANON_EQ
     */
    CanonEq(Pattern.CANON_EQ);
    /**
     * @see Pattern#UNICODE_CHARACTER_CLASS
     */
    //	UnicodeCharacClass(Pattern.UNICODE_CHARACTER_CLASS);

    //***************************************
    //*	Fields								*
    //***************************************
    private int optionCode;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of RegexOptions.
     *
     * @param    optionCode    code for option
     * @param    optionName    name for option
     */
    private RegexOptions(int optionCode) {
        this.optionCode = optionCode;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Returns the value of <code>RegexOptions</code>.
     *
     * @author Guo QingJun
     * @return optionCode of <code>RegexOptions</code>
     */
    public int value() {
        return this.optionCode;
    }
}
