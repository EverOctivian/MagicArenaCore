/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	Regex.java									</br>
 * <b>PackageName</b>	:	com.magicarena.text.regexp					</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.text.regexp;



import com.framework.magicarena.core.utils.Environment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>ClassName</b>		:	Regex										</br>
 * <b>Function</b>		: 	Represents an immutable regular expression.	</br>
 * <b>Reason</b>		:	To create the same class as C# does.		</br>
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
 * 			<td>2016-6-24</td>
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
public class Regex {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private int regExpOption;
    private String regExpPattern;
    private RegexMatchRng regexMatchRng;
    private MatchOperation matchOperation;
    private String[] groupName;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Initializes a new instance of the Regex class for the specified regular expression.
     *
     * @param    regExpPattern    the regular expression pattern to match
     */
    public Regex(String regExpPattern) {
        super();
        this.regExpPattern = regExpPattern;
        this.regExpOption = 0;
        this.regexMatchRng = RegexMatchRng.Fragment;
    }

    /**
     * Initializes a new instance of the Regex class for the specified regular expression, with options that modify the pattern.
     *
     * @param    regExpPattern    the regular expression pattern to match
     * @param    regExpOption    a bitwise combination of the enumeration values(RegexOptions) that modify the regular expression
     */
    public Regex(String regExpPattern, int regExpOption) {
        super();
        this.regExpPattern = regExpPattern;
        this.regExpOption = regExpOption;
        this.regexMatchRng = RegexMatchRng.Fragment;
    }

    /**
     * Initializes a new instance of the Regex class for the specified regular expression, with options that modify the pattern.
     *
     * @param    regExpPattern    the regular expression pattern to match
     * @param    regExpOption    a bitwise combination of the enumeration values(RegexOptions) that modify the regular expression
     * @param    regexMatchRng    a enumeration for indicating the type of match range
     */
    public Regex(String regExpPattern, int regExpOption,
                 RegexMatchRng regexMatchRng) {
        super();
        this.regExpPattern = regExpPattern;
        this.regExpOption = regExpOption;
        this.regexMatchRng = regexMatchRng;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Returns an array of capturing group names for the regular expression.
     *
     * @author Guo QingJun
     * @return a string array of group names
     */
    public String[] getGroupNames() {
        this.fillGroupNames();

        return this.groupName;
    }

    /**
     * Fills the Regex's property groupName with declared group name in pattern.
     *
     * @author Guo QingJun
     */
    private void fillGroupNames() {
        if (Environment.PROPERTY_JAVA_VERSION.compareTo("1.7.0_25") >= 0) {
            HashSet<String> groupName = new HashSet<String>();

            Regex regex = new Regex("\\(\\?\\<(\\w+)\\>[^\\)]+\\)");

            for (Match match : regex.matches(this.regExpPattern)) {
                groupName.add(match.getGroups().getGroupByIndex(0).getValue());
            }

            System.out.println(groupName);

            this.groupName = groupName.toArray(new String[groupName.size()]);

            regex = null;
            groupName = null;
        }
    }

    /**
     * Indicates whether the regular expression specified in the Regex constructor finds a match in a specified input string.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @return true if the regular expression finds a match; otherwise, false
     */
    public boolean isMatch(String input) {
        return (this.match(input) != null);
    }

    /**
     * Indicates whether the regular expression specified in the Regex constructor finds a match in the specified input string, beginning at the specified starting position in the string.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    startAt    the character position at which to start the search
     * @return true if the regular expression finds a match; otherwise, false
     */
    public boolean isMatch(String input, int startAt) {
        return (this.match(input, startAt) != null);
    }

    /**
     * Searches the specified input string for the first occurrence of the regular expression specified in the Regex constructor.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @return an object that contains information about the match
     */
    public Match match(String input) {
        return this.match(input, MatchOperation.MATCH_BINDEX_DEFAULT);
    }

    /**
     * Searches the input string for the first occurrence of a regular expression, beginning at the specified starting position in the string.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    startAt    the zero-based character position at which to start the search
     * @return an object that contains information about the match
     */
    public Match match(String input, int startAt) {
        return this.match(input, startAt, MatchOperation.MATCH_LENGTH_UNLIMITED);
    }

    /**
     * Searches the input string for the first occurrence of a regular expression, beginning at the specified starting position and searching only the specified number of characters.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    startAt    the zero-based character position at which to start the search
     * @param    length    the number of characters in the substring to include in the search
     * @return an object that contains information about the match
     */
    public Match match(String input, int startAt, int length) {
        //check input parameters
        if ((input == null) || (input.length() == 0) || (startAt < 0) || (length < MatchOperation.MATCH_LENGTH_UNLIMITED)) {
            throw new IllegalArgumentException();
        }

        //create instance of MatchOperation
        this.matchOperation = MatchOperation.getMatchOperation(input, this.regExpPattern, this.regExpOption, this.regexMatchRng, startAt, length);

        //create MatchCollection with all matched Matches
        return this.matchOperation.nextMatch();
    }

    /**
     * Searches the specified input string for all occurrences of a regular expression.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @return a collection of the Match objects found by the search. If no matches are found, the method returns an empty collection object
     */
    public MatchCollection matches(String input) {
        return this.matches(input, MatchOperation.MATCH_BINDEX_DEFAULT);
    }

    /**
     * Searches the specified input string for all occurrences of a regular expression, beginning at the specified starting position in the string.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    startAt    the character position in the input string at which to start the search
     * @return a collection of the Match objects found by the search. If no matches are found, the method returns an empty collection object
     */
    public MatchCollection matches(final String input, int startAt) {
        //check input parameters
        if ((input == null) || (input.length() == 0) || (startAt < 0)) {
            throw new IllegalArgumentException();
        }

        //local variable's declaration
        Match match = null;
        MatchCollection mc = new MatchCollection();

        //create instance of MatchOperation
        this.matchOperation = MatchOperation.getMatchOperation(input, this.regExpPattern, this.regExpOption, this.regexMatchRng, startAt, MatchOperation.MATCH_LENGTH_UNLIMITED);

        //create MatchCollection with all matched Matches
        while ((match = this.matchOperation.nextMatch()) != null) {
            //add a Match to MatchCollection
            mc.addMatch(match);
        }

        return mc;
    }

    /**
     * In a specified input substring, replaces a specified maximum number of strings that match a regular expression pattern with a string returned by a MatchEvaluatable interface callback.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    me        represents the method that is called each time a regular expression match is found during a Replace method operation
     * @return a new string that is identical to the input string, except that a replacement string takes the place of each matched string. If the regular expression pattern is not matched in the current instance, the method returns the current instance unchanged
     */
    public String replace(final String input, MatchEvaluatable me) {
        return this.replace(input, me, MatchOperation.MATCH_TIMES_TRYBEST);
    }

    /**
     * In a specified input substring, replaces a specified maximum number of strings that match a regular expression pattern with a string returned by a MatchEvaluatable callback.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    me        represents the method that is called each time a regular expression match is found during a Replace method operation
     * @param    times    the maximum number of times the replacement will occur
     * @return a new string that is identical to the input string, except that a replacement string takes the place of each matched string. If the regular expression pattern is not matched in the current instance, the method returns the current instance unchanged
     */
    public String replace(final String input, MatchEvaluatable me, int times) {
        return this.replace(input, me, times, MatchOperation.MATCH_BINDEX_DEFAULT);
    }

    /**
     * In a specified input substring, replaces a specified maximum number of strings that match a regular expression pattern with a string returned by a MatchEvaluatable callback.
     *
     * @author Guo QingJun
     * @param    input    the string to search for a match
     * @param    me        represents the method that is called each time a regular expression match is found during a Replace method operation
     * @param    times    the maximum number of times the replacement will occur
     * @param    startAt the character position in the input string where the search begins
     * @return a new string that is completely replaced
     */
    public String replace(final String input, MatchEvaluatable me, int times,
                          int startAt) {
        //check input parameters
        if ((input == null) || (input.length() == 0) || (me == null) || (times < 0) || (startAt < 0)) {
            throw new IllegalArgumentException();
        }

        //create instance of MatchOperation
        this.matchOperation = MatchOperation.getMatchOperation(input, this.regExpPattern, this.regExpOption, this.regexMatchRng, startAt, MatchOperation.MATCH_LENGTH_UNLIMITED);

        return this.matchOperation.replace(me, times);
    }

    /**
     * In a specified input string, replaces all strings that match a regular expression pattern with a specified replacement string.
     *
     * @author Guo QingJun
     * @param    input        the string to search for a match
     * @param    replacement    the replacement string
     * @return a new string that is identical to the input string, except that the replacement string takes the place of each matched string. If the regular expression pattern is not matched in the current instance, the method returns the current instance unchanged
     */
    public String replace(final String input, final String replacement) {
        return this.replace(input, replacement, MatchOperation.MATCH_TIMES_TRYBEST, MatchOperation.MATCH_BINDEX_DEFAULT);
    }

    /**
     * In a specified input string, replaces a specified maximum number of strings that match a regular expression pattern with a specified replacement string.
     *
     * @author Guo QingJun
     * @param    input        the string to search for a match
     * @param    replacement    the replacement string
     * @param    times        maximum number of times the replacement can occur
     * @return a new string that is identical to the input string, except that the replacement string takes the place of each matched string. If the regular expression pattern is not matched in the current instance, the method returns the current instance unchanged
     */
    public String replace(final String input, final String replacement,
                          int times) {
        return this.replace(input, replacement, times, MatchOperation.MATCH_BINDEX_DEFAULT);
    }

    /**
     * In a specified input substring, replaces a specified maximum number of strings that match a regular expression pattern with a specified replacement string.
     *
     * @author Guo QingJun
     * @param    input        the string to search for a match
     * @param    replacement    the replacement string
     * @param    times        maximum number of times the replacement can occur
     * @param    startAt        the character position in the input string where the search begins
     * @return a new string that is identical to the input string, except that the replacement string takes the place of each matched string. If the regular expression pattern is not matched in the current instance, the method returns the current instance unchanged
     */
    public String replace(final String input, final String replacement,
                          int times, int startAt) {
        MatchEvaluatable me = new MatchEvaluatable() {
            @Override
            public String evaluate(Match match) {
                // TODO Auto-generated method stub
                return replacement;
            }
        };

        return this.replace(input, me, times, startAt);
    }

    /**
     * Splits an input string into an array of substrings at the positions defined by a regular expression pattern specified in the Regex constructor..
     *
     * @author Guo QingJun
     * @param    input    the string to be split
     * @return an array of strings
     */
    public String[] split(final String input) {
        return this.split(input, MatchOperation.MATCH_TIMES_TRYBEST);
    }

    /**
     * Splits an input string a specified maximum number of times into an array of substrings, at the positions defined by a regular expression specified in the Regex constructor.
     *
     * @author Guo QingJun
     * @param    input    the string to be split
     * @param    times    the maximum number of times the split can occur
     * @return an array of strings
     */
    public String[] split(final String input, int times) {
        //check input parameters
        if ((input == null) || (input.length() == 0) || (times < 1)) {
            throw new IllegalArgumentException();
        }

        //create instance of MatchOperation
        this.matchOperation = MatchOperation.getMatchOperation(input, this.regExpPattern, this.regExpOption, this.regexMatchRng, MatchOperation.MATCH_BINDEX_DEFAULT, MatchOperation.MATCH_LENGTH_UNLIMITED);

        return this.matchOperation.split(times);
    }

    /**
     * Selects the strings that's matched with the pattern in a specified scope.
     *
     * @author Guo QingJun
     * @param    inputArrays        an array that contains strings in specified scope
     * @return strings that's matched with the pattern
     */
    public String[] grep(String[] inputArrays) {
        ArrayList<String> al = new ArrayList<String>();

        for (String string : al) {
            if (this.isMatch(string)) {
                al.add(string);
            }
        }

        return al.toArray(new String[al.size()]);
    }

    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * Gets the options that were passed into the Regex constructor.
     *
     * @return options that built the Regex Object
     */
    public int getRegExpOption() {
        return this.regExpOption;
    }

    /**
     * Gets the <code>RegexMatchRng</code> options that were passed into the Regex constructor.
     *
     * @return the regexMatchRng
     */
    public RegexMatchRng getRegexMatchRng() {
        return this.regexMatchRng;
    }

    //***********************************
    //*	Nested Class					*
    //***********************************
    static class MatchOperation {
        //*******************************************
        //*	Static Area								*
        //*******************************************
        //***************************************
        //*	Fields								*
        //***************************************
        public final static int MATCH_NOTHING = -1;
        public final static int MATCH_CONTENT = 0;
        public final static int MATCH_LENGTH_UNLIMITED = -1;
        public final static int MATCH_BINDEX_DEFAULT = 0;
        public final static int MATCH_TIMES_TRYBEST = Integer.MAX_VALUE;
        private static MatchOperation mo;

        //***************************************
        //*	Methods								*
        //***************************************
        //***********************************
        //*	Functional Methods				*
        //***********************************

        /**
         * Gets a instance of MatchOperation for operating a Matcher.
         *
         * @author Guo QingJun
         * @param    regExpSource    the string to search for a match
         * @param    regExpPattern    the regular expression pattern to match
         * @param    regExpOption    a bitwise combination of the enumeration values(RegexOptions) that modify the regular expression
         * @param    regExpMatchRng    a enumeration for indicating the type of match range
         * @param    startAt            the character position in the input string where the search begins
         * @param    matchedLength    the number of characters in the substring to include in the search
         * @return a instance of MatchOperation for operating a Matcher
         */
        public static MatchOperation getMatchOperation(String regExpSource,
                                                       String regExpPattern, int regExpOption,
                                                       RegexMatchRng regExpMatchRng, int startAt, int matchedLength) {
            //			if (MatchOperation.mo == null) {
            //				synchronized (MatchOperation.class) {
            //					if (MatchOperation.mo == null) {
            //						MatchOperation.mo = new MatchOperation(regExpMatcher, regexMatchRng);
            //					}
            //				}
            //			}
            MatchOperation.mo = new MatchOperation(regExpSource, regExpPattern, regExpOption, regExpMatchRng, startAt, matchedLength);

            return MatchOperation.mo;
        }

        //*******************************************
        //*	Instance Area							*
        //*******************************************
        //***************************************
        //*	Fields							*
        //***************************************
        private boolean firstMatch;
        private int startAt;
        private int matchedLength;
        private Pattern regExpPatternInstance;
        private Matcher regExpMatcher;
        private RegexMatchRng regExpMatchRng;
        private String regExpSource;

        //***************************************
        //*	Constructors						*
        //***************************************

        /**
         * Creates a new instance of MatchOperation.
         */
        private MatchOperation(String regExpSource, String regExpPattern,
                               int regExpOption, RegexMatchRng regExpMatchRng, int startAt,
                               int matchedLength) {
            super();
            this.regExpSource = regExpSource;
            this.regExpMatchRng = regExpMatchRng;
            this.startAt = startAt;
            this.matchedLength = matchedLength;
            this.regExpPatternInstance = Pattern.compile(regExpPattern, regExpOption);
            this.regExpMatcher = this.regExpPatternInstance.matcher(regExpSource);

            this.resetMatch();
        }

        //***************************************
        //*	Methods								*
        //***************************************
        //***********************************
        //*	Functional Methods				*
        //***********************************

        /**
         * Finds next match and fill the group attributes.
         *
         * @author Guo QingJun
         * @param    startAt     the character position in the input string at which to start the search
         * @return an object that contains information about the match</br>
         * 			not <code>null</code> if matched successfully;<code>null</code> otherwise
         */
        public Match nextMatch() {
            //local variables' declaration
            Match match = null;

            //turn off first match flag
            this.firstMatch = false;

            while (this.moveToNext()) {
                //get a match Group's information
                int matchStartIndex = this.regExpMatcher.start(MatchOperation.MATCH_CONTENT);
                int matchEndIndex = this.regExpMatcher.end(MatchOperation.MATCH_CONTENT);
                String matchValue = this.regExpMatcher.group(MatchOperation.MATCH_CONTENT);

                if ((matchStartIndex != MatchOperation.MATCH_NOTHING) && (matchEndIndex != MatchOperation.MATCH_NOTHING) && (matchValue != null)) {
                    int matchLength = matchEndIndex - matchStartIndex;
                    GroupCollection gc = new GroupCollection();

                    if ((matchLength != this.matchedLength) && (this.matchedLength != MatchOperation.MATCH_LENGTH_UNLIMITED)) {
                        continue;
                    }

                    //create GroupCollection with all matched Groups
                    for (int groupIndex = 1; groupIndex <= this.regExpMatcher.groupCount(); groupIndex++) {
                        Group groupItem = null;

                        //get a single Group's information
                        int groupStartIndex = this.regExpMatcher.start(groupIndex);
                        int groupEndIndex = this.regExpMatcher.end(groupIndex);
                        String groupValue = this.regExpMatcher.group(groupIndex);

                        if ((groupStartIndex != MatchOperation.MATCH_NOTHING) && ((groupEndIndex != MatchOperation.MATCH_NOTHING) && (groupValue != null))) {
                            int groupLength = groupEndIndex - groupStartIndex;
                            groupItem = new Group(groupStartIndex, groupLength, groupValue, true);
                        } else {
                            groupItem = new Group(MatchOperation.MATCH_NOTHING, MatchOperation.MATCH_NOTHING, null, false);
                        }

                        //add a single Group's information to GroupCollection
                        gc.addGroup(groupItem);

                        //clear all the local variables
                        groupItem = null;
                        groupStartIndex = 0;
                        groupEndIndex = 0;
                        groupValue = null;
                    }

                    match = new Match(matchStartIndex, matchLength, matchValue, true, gc, this);

                    //clear all the local variables
                    matchLength = 0;
                    gc = null;
                } else {
                    match = new Match(MatchOperation.MATCH_NOTHING, MatchOperation.MATCH_NOTHING, null, false, null, this);
                }

                //clear all the local variables
                matchStartIndex = 0;
                matchEndIndex = 0;
                matchValue = null;

                break;
            }

            return match;
        }

        /**
         * Try to get next matched substring.
         *
         * @author Guo QingJun
         * @return true if successfully getting next matched substring;false otherwise
         */
        private boolean moveToNext() {
            switch (this.regExpMatchRng) {
                case Fragment:
                    if (this.firstMatch) {
                        return this.regExpMatcher.find(this.startAt);
                    } else {
                        return this.regExpMatcher.find();
                    }
                case Begin:
                    return this.regExpMatcher.lookingAt();
                case Whole:
                    return this.regExpMatcher.matches();
                default:
                    return false;
            }
        }

        /**
         * In a specified input string, replaces all strings that match a specified regular expression with a string returned by a MatchEvaluatable method.
         *
         * @author Guo QingJun
         * @param    me        a object that supplies custom method that examines each match and returns either the original matched string or a replacement string.
         * @param    times    the maximum number of times the replacement will occur
         * @return string that is completely replaced
         */
        public String replace(MatchEvaluatable me, int times) {
            int replaceCount = 0;
            StringBuffer sb = new StringBuffer();
            Match match = null;

            this.resetMatch();

            //create MatchCollection with all matched Matches
            while (((replaceCount++ < times) && ((match = this.nextMatch()) != null))) {
                //implement a non-terminal append-and-replace step
                this.regExpMatcher.appendReplacement(sb, me.evaluate(match));
            }

            //implement a terminal append-and-replace step
            this.regExpMatcher.appendTail(sb);

            return sb.toString();
        }

        /**
         * Splits an input string a specified maximum number of times into an array of substrings, at the positions defined by a regular expression specified in the Regex constructor. The search for the regular expression pattern starts at a specified character position in the input string.
         *
         * @author Guo QingJun
         * @param    times    the maximum number of times the split can occur
         * @return an array of strings
         */
        public String[] split(int times) {
            if (times == MatchOperation.MATCH_TIMES_TRYBEST) {
                return this.regExpPatternInstance.split(this.regExpSource);
            } else {
                return this.regExpPatternInstance.split(this.regExpSource, times);
            }
        }

        /**
         * Resets the matcher index.
         *
         * @author Guo QingJun
         */
        public void resetMatch() {
            this.firstMatch = true;
            this.regExpMatcher.reset();
        }
    }
}
