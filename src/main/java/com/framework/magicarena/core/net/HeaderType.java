/**
 * <b>ProjectName</b>	:	ArenaSource									</br>
 * <b>FileName</b>    	:	HeaderType.java								</br>
 * <b>PackageName</b>	:	com.MagicArena.Net							</br>									</br>
 * <b>Copyright</b>		:	2016, MagicArena Group All Rights Reserved.	</br>
 */
package com.framework.magicarena.core.net;


/**
 * <b>ClassName</b>		:	HeaderType												</br>
 * <b>Function</b>		: 	To identify the header name of HTTP headers.			</br>
 * <b>Reason</b>		:	To identify the header name of HTTP headers.			</br>
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
 * 			<td>2016-07-16</td>
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
public enum HeaderType {
    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Constructs Instances Of Enumerations*
    //***************************************
    /**
     *	To indicate the cache mechanism that Request
     *	and Response should observe,it may be values below:</br>
     *	</br>
     *  <b>Only for Request:</b></br>
     *	no-cache 	   	:	Don't accept an unvalidated cached response.</br>
     *	no-store 		:	Don't store the server's response in any cache.</br>
     *	max-age	 		:	Sets the maximum age of a cached response.</br>
     *	max-stale		:	Accept cached responses that have exceeded their freshness lifetime by up to maxStale.</br>
     *	min-fresh		:	Sets the minimum number of seconds that a response will continue to be fresh for.</br>
     *	only-if-cached 	:	Only accept the response if it is in the cache.</br>
     *	</br>
     *	<b>Only for Response:</b></br>
     *	public			:	Response body can be cached by any cache buffer. </br>
     *	private			:	Response body can be cached by specified user which means it can't be shared.</br>
     *	no-cache		:	To indicate that the response can't be cached.
     *	no- store		:	Don't store the server's response in any cache.
     *	no-transform	:
     *	must-revalidate	:
     *	proxy-revalidate:
     *	max-age			:	To indicate the maximum age of a cached response.</br>
     */
    COMMON_HEADER_CACHE_CONTROL("Cache-Control"),
    /**
     *	The sending date of the resource that the URL references,
     *	or 0 if not known. The value returned is the number of milliseconds since January 1, 1970 GMT.
     */
    COMMON_HEADER_DATE("Date"),
    /**
     * Used to indicate specified instruction.
     */
    COMMON_HEADER_PRAGMA("Pragma"),
    /**
     *	The MIME types that client can accept.
     */
    REQUEST_HEADER_ACCEPT("Accept"),
    /**
     *	The charsets that client can accept.
     */
    REQUEST_HEADER_ACCEPT_CHARSET("Accept-Charset"),
    /**
     *	The encoding types that client can decode,
     *	among which GZip can be supplied by server.
     */
    REQUEST_HEADER_ACCEPT_ENCODING("Accept-Encoding"),
    /**
     *	The language of resource that client wants to request
     *	which's important for resource by multi-language versions
     */
    REQUEST_HEADER_ACCEPT_LANGUAGE("Accept-Language"),
    /**
     *	The information about authentication of user,
     *	typically in the request corresponded to server response with
     *	a response header <code>WWW-Authenticate</code>.
     */
    REQUEST_HEADER_AUTHORIZATION("Authorization"),
    /**
     *	The email address of sender applied for some special applications.
     */
    REQUEST_HEADER_FROM("From"),
    /**
     *	To indicate the IP address and port of host that must locate the
     *	position of server or gate of URL, otherwise it may end up with exception.
     */
    REQUEST_HEADER_HOST("Host"),
    /**
     *	It indicates a <b>Get</b> condition where resource will be returned only if
     *	its last-modified-timer is later than specified time point;
     *	Otherwise,it will return <code>StatusCode 304��Not Modified)</code>.
     */
    REQUEST_HEADER_IF_MODIFIED_SINCE("if-Modified-Since"),
    /**
     * REQUEST_HEADER_IF_MATCH	:	TODO
     *
     * @since 1.6
     */
    REQUEST_HEADER_IF_MATCH("if-Match"),
    /**
     * REQUEST_HEADER_IF_NONE_MATCH	:	TODO
     *
     * @since 1.6
     */
    REQUEST_HEADER_IF_NONE_MATCH("if-None-Match"),
    /**
     * REQUEST_HEADER_IF_RANGE	:	TODO
     *
     * @since 1.6
     */
    REQUEST_HEADER_IF_RANGE("if-Range"),
    /**
     * REQUEST_HEADER_IF_UNMODIFIED_SINCE	:	TODO
     *
     * @since 1.6
     */
    REQUEST_HEADER_IF_UNMODIFIED_SINCE("if-Unmodified-Since"),
    /**
     * REQUEST_HEADER_MAX_FORWARDS	:	TODO
     *
     * @since 1.6
     */
    REQUEST_HEADER_MAX_FORWARDS("Max-Forwards"),
    /**
     * REQUEST_HEADER_PROXY_AUTHORIZATION	:	TODO
     *
     * @since 1.6
     */
    REQUEST_HEADER_PROXY_AUTHORIZATION("Proxy-Authorization"),
    /**
     * It allows client to specify the one or more subrange of resource.
     * for example, bytes=1-500,600-800 .
     */
    REQUEST_HEADER_RANGE("Range"),
    /**
     *	It allows client to specify the URL that client starts to call a request.
     */
    REQUEST_HEADER_REFERER("Referer"),
    /**
     *	It allows client to specify the information about user,
     *	typically it refers to the browser type that user uses for a request.
     */
    REQUEST_HEADER_USER_AGENT("User-Agent"),
    /**
     * RESPONSE_HEADER_AGE	:	TODO
     *
     * @since 1.6
     */
    RESPONSE_HEADER_AGE("Age"),
    /**
     *	It informs the client to redirect a new URL with the
     *	<code>StatusCode 302��Redirected)</code>
     */
    RESPONSE_HEADER_LOCATION("Location"),
    /**
     * RESPONSE_HEADER_PROXY_AUTHENTICATE	:	TODO
     *
     * @since 1.6
     */
    RESPONSE_HEADER_PROXY_AUTHENTICATE("Proxy-Authenticate"),
    /**
     * RESPONSE_HEADER_PUBLIC	:	TODO
     *
     * @since 1.6
     */
    RESPONSE_HEADER_PUBLIC("Public"),
    /**
     * RESPONSE_HEADER_RETRY_AFTER	:	TODO
     *
     * @since 1.6
     */
    RESPONSE_HEADER_RETRY_AFTER("Retry- After"),
    /**
     *	It includes the information about the server that process the request,
     *	which may contains indications or comments of multiply products order by their importance.
     */
    RESPONSE_HEADER_SERVER("Server"),
    /**
     * RESPONSE_HEADER_VARY	:	TODO
     *
     * @since 1.6
     */
    RESPONSE_HEADER_VARY("Vary"),
    /**
     * RESPONSE_HEADER_WARNING	:	TODO
     *
     * @since 1.6
     */
    RESPONSE_HEADER_WARNING("Warning"),
    /**
     *	It requests the client to supply the authentication of accessing specified resource,
     * 	typically in the form below:</br>
     * 	BASIC realm= \"executives\
     */
    RESPONSE_HEADER_WWW_AUTHENTICATE("WWW-Authenticate"),
    /**
     *	It indicates the validated method that server supports of request.
     */
    ENTITY_HEADER_ALLOW("Allow"),
    /**
     * ENTITY_HEADER_CONTENT_BASE	:	TODO
     *
     * @since 1.6
     */
    ENTITY_HEADER_CONTENT_BASE("Content-Base"),
    /**
     * 	It indicates the encoding of content , can use GZIP if client supports that.
     * 	(It's simply able to identify it using Accept-Encoding header of request.)
     */
    ENTITY_HEADER_CONTENT_ENCODING("Content-Encoding"),
    /**
     * ENTITY_HEADER_CONTENT_LANGUAGE	:	TODO
     *
     * @since 1.6
     */
    ENTITY_HEADER_CONTENT_LANGUAGE("Content-Language"),
    /**
     *	It indicates the length of content after server's computing the size of requested resource.
     */
    ENTITY_HEADER_CONTENT_LENGTH("Content-Length"),
    /**
     * ENTITY_HEADER_CONTENT_LOCATION	:	TODO
     *
     * @since 1.6
     */
    ENTITY_HEADER_CONTENT_LOCATION("Content-Location"),
    /**
     * ENTITY_HEADER_CONTENT_MD5	:	TODO
     *
     * @since 1.6
     */
    ENTITY_HEADER_CONTENT_MD5("Content-MD5"),
    /**
     *	It specifies the range of content in resource typically with the form below:</br>
     *	Content-Range:bytes-unitSPfirst-byte-pos-last-byte-pos/entity-legth
     */
    ENTITY_HEADER_CONTENT_RANGE("Content-Range"),
    /**
     *	It indicates the MIME type of content.
     */
    ENTITY_HEADER_CONTENT_TYPE("Content-Type"),
    /**
     * ENTITY_HEADER_ETAG	:	TODO
     *
     * @since 1.6
     */
    ENTITY_HEADER_ETAG("Etag"),
    /**
     *	To indicates the expired time of content so that it would be cached no longer.
     */
    ENTITY_HEADER_EXPIRES("Expires"),
    /**
     *	It indicates the last modified time of resource.
     */
    ENTITY_HEADER_LAST_MODIFIED("Last-Modified"),
    /**
     * ENTITY_HEADER_EXTENSION_HEADER	:	TODO
     *
     * @since 1.6
     */
    ENTITY_HEADER_EXTENSION_HEADER("Extension-Header");

    //***************************************
    //*	Fields								*
    //***************************************
    private String headerName;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Creates a new instance of HeaderType.
     */
    private HeaderType(String headerName) {
        this.headerName = headerName;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Setters and Getters				*
    //***********************************

    /**
     * HeaderType's property headerName's getter
     *
     * @return the headerName
     */
    public String value() {
        return this.headerName;
    }
}
