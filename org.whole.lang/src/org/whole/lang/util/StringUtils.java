/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class StringUtils {
	private static final int READER_CHUNK_SIZE = 2048;
	private static final int BUFFER_SIZE = 8 * READER_CHUNK_SIZE;

	public static final String CLASS_FILE_EXTENSION = "class";
	public static final String JAVA_FILE_EXTENSION = "java";

	public static final String EOL_CHARS = "\n\r\u2028\u2029\u0085";
	public static final String EOL_REGEXP = "\\r\\n|[\\n\\r\\u2028\\u2029\\u0085]";
	public static final Pattern EOL_PATTERN = Pattern.compile(EOL_REGEXP);

	public static boolean isNewLineChar(char c) {
		return EOL_CHARS.indexOf(c) != -1;
	}

	public static String readAsString(InputStream contentStream, String encoding) throws IOException {
		if (!contentStream.markSupported())
			contentStream = new BufferedInputStream(contentStream);
		// strip BOM if present
		StringUtils.encodingFromBOM(contentStream, null);
		return readAsString(new InputStreamReader(contentStream, encoding));
	}
	public static String readAsString(Reader contentReader) throws IOException {
		BufferedReader reader = new BufferedReader(contentReader, BUFFER_SIZE);
		StringBuilder buffer = new StringBuilder(BUFFER_SIZE);
		char[] readBuffer = new char[READER_CHUNK_SIZE];
		int n = reader.read(readBuffer);
		while (n > 0) {
			buffer.append(readBuffer, 0, n);
			n = reader.read(readBuffer);
		}

		return buffer.toString();
	}

	public static String[] readAsStringRows(InputStream contentStream, String encoding) throws IOException {
		if (!contentStream.markSupported())
			contentStream = new BufferedInputStream(contentStream);
		// strip BOM if present
		StringUtils.encodingFromBOM(contentStream, null);
		return readAsString(contentStream, encoding).split(EOL_REGEXP, -1);
	}

	public static char[] peekChars(Reader reader, int length) throws IOException {
		if (!reader.markSupported())
			return null;

		char[] chars = new char[length];
		reader.mark(chars.length);
		int read = reader.read(chars);
		reader.reset();

		if (read == -1 || read != length)
			return null;

		if (read != length) {
			char[] readChars = new char[read];
			System.arraycopy(chars, 0, readChars, 0, read);
			return readChars;
		} else
			return chars;
	}

	public static byte[] peekBytes(InputStream is, int length, boolean exactLength) throws IOException {
		if (!is.markSupported())
			return null;

		byte[] bytes = new byte[length];
		is.mark(bytes.length);
		int read = is.read(bytes);
		is.reset();

		if (read == -1 || (read != length && exactLength))
			return null;

		if (read != length) {
			byte[] readBytes = new byte[read];
			System.arraycopy(bytes, 0, readBytes, 0, read);
			return readBytes;
		} else
			return bytes;
	}

	public static String encodingFromBOM(InputStream is, String defaultEncoding) {
		String encoding = null;
		try {
			// the BOM algorithm needs the first four bytes
			byte[] bytes = StringUtils.peekBytes(is, 4, true);

			if (bytes != null) {
				int magic = 0;
				for (int i=0; i<bytes.length; i++)
					magic |= (bytes[i] & 0xFF) << (8*(3-i));

				encoding = StringUtils.encodingFromBOM(magic);

				// skip bom length bytes
				is.read(bytes, 0, bomLength(magic));
			}
		} catch (IOException e) {
		}

		return encoding != null ? encoding : defaultEncoding;
	}
	public static int bomLength(int magic) {
		// first check for a byte order mark 4 bytes long
		switch (magic) {
		case 0x0000FEFF:
		case 0xFFFE0000:
		case 0xDD736673:
		case 0x84319533:
		case 0x2B2F7638:
		case 0x2B2F7639:
		case 0x2B2F762B:
		case 0x2B2F762F:
			return 4;
		}

		// then check for a byte order mark 3 bytes long
		switch (magic & 0xFFFFFF00) {
		case 0xEFBBBF00:
		case 0xF7644C00:
		case 0x0EFEFF00:
		case 0xFBEE2800:
			return 3;
		}

		// then check for a byte order mark 2 bytes long
		switch (magic & 0xFFFF0000) {
		case 0xFEFF0000:
		case 0xFFFE0000:
			return 2;
		}
		return 0;
	}
	public static String encodingFromBOM(int magic) {
		// first check for a byte order mark 4 bytes long
		switch (magic) {
		case 0x0000FEFF:
			return "UTF-32BE";
		case 0xFFFE0000:
			return "UTF-32LE";
		case 0xDD736673:
			return "UTF-EBCDIC";
		case 0x84319533:
			return "GB-18030";
		case 0x2B2F7638:
		case 0x2B2F7639:
		case 0x2B2F762B:
		case 0x2B2F762F:
			return "UTF-7";
		}

		// then check for a byte order mark 3 bytes long
		switch (magic & 0xFFFFFF00) {
		case 0xEFBBBF00:
			return "UTF-8";
		case 0xF7644C00:
			return "UTF-1";
		case 0x0EFEFF00:
			return "SCSU";
		case 0xFBEE2800:
			return "BOCU-1";
		}

		// then check for a byte order mark 2 bytes long
		switch (magic & 0xFFFF0000) {
		case 0xFEFF0000:
			return "UTF-16BE";
		case 0xFFFE0000:
			return "UTF-16LE";
		}

		return null;
	}

    public static boolean isWhitespace(CharSequence cs) {
    	int count = 0, length = cs.length();
		while (count < length && Character.isWhitespace(cs.charAt(count)))
			count++;
    	return count == length;
    }
    public static boolean isUpperCap(String str) {
    	return str.length() > 0 && Character.isUpperCase(str.charAt(0));
    }
    public static String toUpperCap(String str) {
		if (str.length() > 1)
			return str.substring(0, 1).toUpperCase()+str.substring(1);
		else
			return str.toUpperCase();			
	}

    public static boolean isLowerCap(String str) {
    	return str.length() > 0 && Character.isLowerCase(str.charAt(0));
    }
	public static String toLowerCap(String str) {
		if (str.length() > 1)
			return str.substring(0, 1).toLowerCase()+str.substring(1);
		else
			return str.toLowerCase();			
	}
	public static StringBuilder toLowerCap(StringBuilder builder) {
		if (builder.length()>0) {
			char ch = builder.charAt(0);
			if (Character.isUpperCase(ch))
				builder.setCharAt(0, Character.toLowerCase(ch));
		}
		return builder;
	}
	public static String toLowerPrefix(String str) {
		return toLowerPrefix(new StringBuilder(str)).toString();
	}
	public static StringBuilder toLowerPrefix(StringBuilder builder) {
		for (int i=0; i<builder.length(); i++) {
			char ch = builder.charAt(i);
			if (Character.isUpperCase(ch))
				builder.setCharAt(i, Character.toLowerCase(ch));
			else if (Character.isLetter(ch)) {
				if (i>1)
					builder.setCharAt(i-1, Character.toUpperCase(builder.charAt(i-1)));
				break;
			}
		}
		return builder;
	}

	public static String camelCaseToUpperCaseWithUnderscores(String ccString) {
		return camelCaseToSeparatedWords(ccString, "_").toUpperCase();
	}
	public static String camelCaseToSpacedWords(String ccString) {
		return camelCaseToSeparatedWords(ccString, " ");
	}
	public static String camelCaseToSeparatedWords(String ccString, String separator) {
		StringBuilder buffer = new StringBuilder(ccString);
		for (int i=ccString.length()-1; i>0; i--)
			if (Character.isUpperCase(ccString.charAt(i)) && Character.isLowerCase(ccString.charAt(i-1)))
				buffer.insert(i, separator);
		return buffer.toString();
	}

	public static String toXMLString(String javaString) {
		char[] charArray = javaString.toCharArray();
		StringBuilder buffer = new StringBuilder();
		
		for (int i=0; i<charArray.length; i++) {
			final char ch = charArray[i];

			switch (ch) {
			case ' ':
				buffer.append(' ');
				break;
			case '<':
				buffer.append("&lt;");
				break;
			case '>':
				buffer.append("&gt;");
				break;
			case '\'':
				buffer.append("&apos;");
				break;
			case '"':
				buffer.append("&quot;");
				break;
			case '&':
				buffer.append("&amp;");
				break;				
			case '\b':
				buffer.append("&#8;");
				break;					
			case '\t':
				buffer.append("&#9;");
				break;				
			case '\n':
				buffer.append("&#10;");
				break;	
			case '\f':
				buffer.append("&#12;");
				break;		
			case '\r':
				buffer.append("&#13;");
				break;
			default:
				if (Character.isISOControl(ch) || Character.isWhitespace(ch)) {
					buffer.append("&#x");
					buffer.append(charToHex(ch));
					buffer.append(';');
				} else
					buffer.append(ch);
				break;
			}
		}
		return buffer.toString();
	}
	public static String toXMLCharData(String javaString) {
		char[] charArray = javaString.toCharArray();
		StringBuilder buffer = new StringBuilder();
		
		for (int i=0; i<charArray.length; i++) {
			final char ch = charArray[i];

			switch (ch) {
			case ' ':
				buffer.append(' ');
				break;
			case '<':
				buffer.append("&lt;");
				break;
			case '>':
				buffer.append("&gt;");
				break;
			case '\'':
				buffer.append("&apos;");
				break;
			case '"':
				buffer.append("&quot;");
				break;
			case '&':
				buffer.append("&amp;");
				break;				
			case '\b':
				buffer.append("&#8;");
				break;					
			case '\t':
			case '\n':
				buffer.append(ch);
				break;	
			case '\f':
				buffer.append("&#12;");
				break;		
			case '\r':
				buffer.append("&#13;");
				break;	
			default:
				if (Character.isISOControl(ch) || Character.isWhitespace(ch)) {
					buffer.append("&#x");
					buffer.append(charToHex(ch));
					buffer.append(';');
				} else
					buffer.append(ch);
				break;
			}
		}
		return buffer.toString();
	}
	public static byte[] cdataFilter;//0 valid; 1 invalid; 2 cdata_end; 3 surrogate
	public static byte cdataFilter(char ch) {
		if (cdataFilter == null) {
			cdataFilter = new byte[65536];
			for (int i=0; i<cdataFilter.length; i++) {
				if (i < 0x0020)
					switch (i) {
					case '\t':
					case '\n':
					case '\r':
						cdataFilter[i]=0;
						break;	
					default:
						cdataFilter[i]=1;
						break;
					}
				else if (i <= 0xd7ff) {
					if (i == ']')
						cdataFilter[i]=2;
					else
						cdataFilter[i]=0;
				} else if (i < 0xe000) {
					cdataFilter[i]=3;
				} else if (i <= 0xfffd)
					cdataFilter[i]=0;
				else
					cdataFilter[i]=1;
			}		
		}
		return cdataFilter[ch];
	}
	public static String toXMLCData(String cdata) {
		char[] charArray = cdata.toCharArray();
		StringBuilder buffer = new StringBuilder();

		for (int i=0; i<charArray.length; i++) {
			final char ch = charArray[i];

			switch (cdataFilter(ch)) {
			case 0:
				buffer.append(ch);
				break;
			case 1:
				break;
			case 2:
				if (charArray[i+1] == ']' && charArray[i+2] == '>') {
					buffer.append("]]]]><![CDATA[>");
					i +=2;
				} else
					buffer.append(ch);
				break;
			case 3:
				if (Character.isSurrogatePair(ch, charArray[i+1]) &&
						Character.isSupplementaryCodePoint(Character.toCodePoint(ch, charArray[i+1]))) {
					buffer.append(ch);
					buffer.append(charArray[++i]);
				}
			}
		}
		return buffer.toString();
	}

	private static final Pattern DOUBLE_DASH = Pattern.compile("--");
	public static String toXMLCommentText(String text) {
    	if (text.length() == 0)
    		return text;

    	if (text.charAt(text.length()-1)  == '-')
    		text = text.substring(0, text.length()-1)+"&#x2d;";
    	
    	if (text.charAt(0) == '-')
    		text = "&#x2d;"+text.substring(1);

        return DOUBLE_DASH.matcher(text).replaceAll("-&#x2d;");
	}
	
	public static String byteToHex(byte b) {
		// Returns hex String representation of byte b
		char hexDigit[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
		return new String(array);
	}

	public static String charToHex(char c) {
		// Returns hex String representation of char c
		byte hi = (byte) (c >>> 8);
		byte lo = (byte) (c & 0xff);
		return byteToHex(hi) + byteToHex(lo);
	}

	public static boolean isQualified(String name) {
		return name.indexOf('.') >= 0;
	}
	public static boolean isQualified2(String name) {
		return name.indexOf('.', name.indexOf('.')) >= 0;
	}
	public static String toPackageName(String qname) {
		int s = qname.lastIndexOf('.');
		return (s == -1) ? qname : qname.substring(0, s);
	}
	public static String toSimpleName(String qname) {
		int s = qname.lastIndexOf('.');
		return (s == -1) ? qname : qname.substring(s+1);
	}
	public static String toPackageQualifiedName(String qname) {
		return toPackageName(toPackageName(qname));
	}
	public static String toSimpleQualifiedName(String qname) {
		int s = qname.lastIndexOf('.');
		if (s == -1)
			return qname;
		else {
			s = qname.lastIndexOf('.', s-1);
			return (s == -1) ? qname : qname.substring(s+1);
		}
	}

	public static String packagePath(String packageName) {
		return packageName.replace('.', File.separatorChar);
	}
	public static String packageURIPath(String packageName) {
		return packageName.replace('.', '/');
	}
	public static String packageName(String packagePath) {
		return packagePath.replace(File.separatorChar, '.');
	}

	public static String toResourceClasspath(String className) {
		return appendFileExtension(className.replace('.', '/'), CLASS_FILE_EXTENSION);
	}
	public static String toClassName(String resourceClasspath) {
		return StringUtils.stripFileExtension(resourceClasspath).replace('/', '.');
	}

	public static boolean inList(String word, String wordList) {
	    return inList(word, wordList, ',');
	}
	public static boolean inList(String word, String wordList, char separator) {
	    int idx = wordList.indexOf(word);
	    if (idx != -1) {
	        int left = idx-1;
	        int right = idx+word.length();
	        return (left == -1 || wordList.charAt(left)==separator) && (right == wordList.length() || wordList.charAt(right)==separator);
	    }
	    return false;
	}

	public static final String transientId(IEntity entity) {
    	return entity.wGetEntityDescriptor() + "@" + System.identityHashCode(entity);
	}
	public static final String simpleId(IEntity entity) {
    	return entity.wGetEntityDescriptor().getName() + "@" + System.identityHashCode(entity);
	}

	private static Map<String, String> wrapperClassNamesMap;
	private static Map<String, String> wrapperClassNamesMap() {
		if (wrapperClassNamesMap == null) {
			wrapperClassNamesMap = new HashMap<String, String>();
			wrapperClassNamesMap.put("Boolean", "boolean");
			wrapperClassNamesMap.put("Byte", "byte");
			wrapperClassNamesMap.put("Character", "char");
			wrapperClassNamesMap.put("Double", "double");
			wrapperClassNamesMap.put("Float", "float");
			wrapperClassNamesMap.put("Integer", "int");
			wrapperClassNamesMap.put("Long", "long");
			wrapperClassNamesMap.put("Short", "short");
			wrapperClassNamesMap.put("java.lang.Boolean", "boolean");
			wrapperClassNamesMap.put("java.lang.Byte", "byte");
			wrapperClassNamesMap.put("java.lang.Character", "char");
			wrapperClassNamesMap.put("java.lang.Double", "double");
			wrapperClassNamesMap.put("java.lang.Float", "float");
			wrapperClassNamesMap.put("java.lang.Integer", "int");
			wrapperClassNamesMap.put("java.lang.Long", "long");
			wrapperClassNamesMap.put("java.lang.Short", "short");
		}
		return wrapperClassNamesMap;
	}
	public static boolean isWrapper(String dataTypeName) {
		return wrapperClassNamesMap().containsKey(dataTypeName);
	}
	public static String unboxFilter(String dataTypeName) {
		String result = wrapperClassNamesMap().get(dataTypeName);
		return result != null ? result : dataTypeName;
	}

	private static Set<String> javaLangTypes;
	private static Set<String> javaLangTypes() {
		if (javaLangTypes == null) {
			javaLangTypes = new HashSet<String>();
			javaLangTypes.addAll(Arrays.<String>asList(new String[] {
					"Package","Class","Object","Runtime","Process","System","Thread","Exception","Error",
					"Boolean","Byte","Character","Double","Float","Integer","Long","Short","String",
					"StringBuffer","StringBuilder","Void","Number","Math","Enum"}));
		}
		return javaLangTypes;
	}
	public static boolean isAmbiguous(String simpleName) {
		return javaLangTypes().contains(simpleName);
	}

	public static boolean isString(String id) {
		return "String".equals(id) || "java.lang.String".equals(id);
	}

	private static Map<String, Class<?>> primitiveTypesMap;
	private static Map<String, Class<?>> primitiveTypesMap() {
		if (primitiveTypesMap == null) {
			primitiveTypesMap = new HashMap<String, Class<?>>();
			primitiveTypesMap.put("boolean", boolean.class);
			primitiveTypesMap.put("byte", byte.class);
			primitiveTypesMap.put("char", char.class);
			primitiveTypesMap.put("double", double.class);
			primitiveTypesMap.put("float", float.class);
			primitiveTypesMap.put("int", int.class);
			primitiveTypesMap.put("long", long.class);
			primitiveTypesMap.put("short", short.class);
			primitiveTypesMap.put("void", void.class);
		}
		return primitiveTypesMap;
	}
	public static boolean isPrimitive(String id) {
		return primitiveTypesMap().containsKey(id);
	}
	public static Class<?> primitiveClass(String id) {
		return primitiveTypesMap().get(id);
	}

	private static Map<String, Class<?>> javaTypesMap;
	private static Map<String, Class<?>> javaTypesMap() {
		if (javaTypesMap == null) {
			javaTypesMap = new HashMap<String, Class<?>>();
			javaTypesMap.putAll(primitiveTypesMap());
			javaTypesMap.put("String", String.class);
			javaTypesMap.put("java.lang.String", String.class);
		}
		return javaTypesMap;
	}
	public static boolean isPrimitiveOrString(String id) {
		return javaTypesMap().containsKey(id);
	}
	public static Class<?> primitiveOrStringClass(String id) {
		return javaTypesMap().get(id);
	}

	private static Set<String> javaKeywords;
	private static Set<String> javaKeywords() {
		if (javaKeywords == null) {
			javaKeywords = new HashSet<String>();
			javaKeywords.addAll(Arrays.<String>asList(new String[] {
					"default","final","finally","interface","class","package","private","protected","public",
					"static","transient","native","volatile","abstract","synchronized","this","super",
					"catch","try","throw","throws","if","else","switch","case","for","while","do","import",
					"true", "false", "null", "implements", "extends", "const", "goto", "enum" }));
			javaKeywords.addAll(primitiveTypesMap().keySet());
		}
		return javaKeywords;
	}
	public static boolean isJavaKeyword(String id) {
		return javaKeywords().contains(id);
	}
	public static String javaKeywordFilter(String id) {
		return isJavaKeyword(id) ? "_"+id : id;
	}
	public static String fieldName(String accessorName) {
	    if (accessorName.startsWith("is"))
	        return toLowerCap(accessorName.substring(2));
	    if (accessorName.startsWith("get"))
	        return toLowerCap(accessorName.substring(3));
	    if (accessorName.startsWith("set"))
	        return toLowerCap(accessorName.substring(3));
        return accessorName;
	}
	public static String getterName(String type, String field) {
		return (type.equals("boolean") ? "is" : "get")+toUpperCap(field);
	}
	public static String getterName(String field) {
		return "get"+toUpperCap(field);
	}
	public static String setterName(String field) {
		return "set"+toUpperCap(field);
	}
	
	public static int commonPrefix(String str1, String str2) {
		int index = 0;
		int minLength = Math.min(str1.length(), str2.length());
		while (index < minLength && str1.charAt(index) == str2.charAt(index))
				index++;
		return index;
	}
	public static String camelPrefix(String str, int prefixSize) {
		return prefixSize+1 >= str.length() ? str :
			Character.isUpperCase(str.charAt(prefixSize)) ? str.substring(0, prefixSize+2)+"\u2026" :
				str.substring(0, prefixSize+1)+"\u2026";		
	}

	public static String removePrefix(String str, String prefix) {
	    return str.startsWith(prefix) ? str.substring(prefix.length()) : str;
	}
	public static String removeSuffix(String str, String suffix) {
        int index = str.lastIndexOf(suffix);
        return index > -1 ? str.substring(0, index) : str;
	}

	public static Pattern regexPattern; //chars: \|([{.^$?*+
	public static String quoteRegex(String regex) {
		if (regexPattern == null)
			regexPattern = Pattern.compile("[\\\\|\\(\\)\\[\\{\\.\\^\\$\\?\\*\\+]");
		
		if (regexPattern.matcher(regex).find())
			return Pattern.quote(regex);
		else
			return regex;
	}

	public static String escapeString(String t, boolean escapeDoubleQuotes, boolean escapeSingleQuotes) {
		StringBuilder r = new StringBuilder();
		for (int j=0; j<t.length(); ++j) {
			char c = t.charAt(j);
			if (c==' ')
				r.append(' ');
			else if (c=='\n')
				r.append("\\n");
			else if (c=='\r')
				r.append("\\r");
			else if (c=='"' && escapeDoubleQuotes)
				r.append("\\\"");
			else if (c=='\'' && escapeSingleQuotes)
				r.append("\\\'");
			else if (c=='\t')
				r.append("\\t");
			else if (c=='\b')
				r.append("\\b");
			else if (c=='\f')
				r.append("\\f");
			else if (c=='\\')
				r.append("\\\\");
			else if (Character.isISOControl(c) || Character.isWhitespace(c)) {
				r.append("\\u");
				r.append(charToHex(c));
			} else
				r.append(c);
		}
		return r.toString();
	}

	public static String unescapeString(String t) {
		StringBuilder r = new StringBuilder();
		int length = t.length();
		int j=0;
		while (j<length) {
			char c = t.charAt(j);
			if (c=='\\') {
				c = t.charAt(++j);
				switch (c) {
				case 'n':
					r.append('\n');
					break;
				case 't':
					r.append('\t');
					break;
				case 'b':
					r.append('\b');
					break;
				case 'r':
					r.append('\r');
					break;
				case 'f':
					r.append('\f');
					break;
				case '\\':
					r.append('\\');
					break;
				case '\'':
					r.append('\'');
					break;
				case '"':
					r.append('"');
					break;
				case 'x':
					r.append((char) Integer.parseInt(t.substring(j+1, j+3), 16));
					j += 2;
					break;
				case 'u':
					r.append((char) Integer.parseInt(t.substring(j+1, j+5), 16));
					j += 4;
					break;
				default:
					if (Character.isDigit(c)) {
						r.append((char) Integer.parseInt(t.substring(j, j+3), 8));
						j += 2;
					} else
						throw new IllegalArgumentException("Bad escaped string: "+t);	
				}
			} else
				r.append(c);
			j++;
		}
		return r.toString();
	}

	public static String escapeCharacter(char c) {
		return escapeString(Character.toString(c), false, true);
	}

	public static String quoteString(String t) {
		return "\""+escapeString(t, true, false)+"\"";
	}

	public static String INTEGER_PATTERN_STRING = "(([-+]?\\d+)|(0x[\\da-f]+))l?";
	public static Pattern INTEGER_PATTERN = Pattern.compile(INTEGER_PATTERN_STRING, Pattern.CASE_INSENSITIVE);
	public static boolean isJavaIntegerLiteral(String literal) {
		return INTEGER_PATTERN.matcher(literal).matches();
	}
	public static long parseJavaIntegerLiteralType(String literal) {
		// remove type suffix as needed
		int length = literal.length();
		char lastCharacter = literal.charAt(length -1);
		if (lastCharacter == 'l' || lastCharacter == 'L') {
			literal = literal.substring(0, length-1);
			length --;
		}
		
		if (length > 1 && literal.charAt(0) == '0') {
			if (literal.charAt(1) == 'x')
				return new BigInteger(literal.substring(2), 16).longValue();//Long.parseLong(literal.substring(2), 16);
			else
				return new BigInteger(literal.substring(1), 8).longValue();//Long.parseLong(literal.substring(1), 8);
		} else
			return new BigInteger(literal).longValue();//Long.parseLong(literal);
	}

	public static String collapse(String t) {
		for (int i=0, length=t.length(); i<length; i++)
			if (!Character.isWhitespace(t.charAt(i)))
				for (int j=length-1; j>=i; j--)
					if (!Character.isWhitespace(t.charAt(j)))
						return
							(i>0 ? " " : "") +
							t.substring(i, j+1) +
							(j<length-1 ? " " : "");
		return "";
	}

	public static String strip(String t) {
		for (int i=0, length=t.length(); i<length; i++)
			if (!Character.isWhitespace(t.charAt(i)))
				for (int j=length-1; j>=i; j--)
					if (!Character.isWhitespace(t.charAt(j)))
						return t.substring(i, j+1);
		return "";
	}

	public static String stripLeading(String t) {
		for (int i=0, length=t.length(); i<length; i++)
			if (!Character.isWhitespace(t.charAt(i)))
				return t.substring(i, length);
		return "";
	}

	public static String stripTrailing(String t) {
		for (int i=t.length()-1; i>=0; i--)
			if (!Character.isWhitespace(t.charAt(i)))
				return t.substring(0, i+1);
		return "";
	}
	
	public static String stripFileExtension(String fileName) {
		return toPackageName(fileName);
	}
	public static String appendFileExtension(String fileName, String fileExtension) {
		return fileName+'.'+fileExtension;
	}
	public static String getFileExtension(String qname) {
		int s = qname.lastIndexOf('.');
		return (s == -1) ? "" : qname.substring(s+1);
	}
	public static String getFileName(String qname) {
		int s = qname.lastIndexOf(File.separatorChar);
		return (s == -1) ? qname : qname.substring(s+1);
	}
	public static String getFilePath(String qname) {
		int s = qname.lastIndexOf(File.separatorChar);
		return (s == -1) ? "" : qname.substring(0, s);
	}

	public static String stripUpperPrefix(String t) {
		for (int i=0, length=t.length(); i<length; i++)
			if (!Character.isUpperCase(t.charAt(i)))
				return i>0 ? t.substring(i-1, length) : t;
		return "";
	}

	public static String replaceExtension(String name, String newExtension) {
		int index = name.lastIndexOf('.');
		if (index >= 0)
			name = name.substring(0, index);
		return name + "." + newExtension;
	}
	
	public static DateFormat basicISO8601DateTimeFormatter = new SimpleDateFormat("yyyyMMdd'T'HHmm'Z'");
	public static DateFormat extendedISO8601DateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	static {
		basicISO8601DateTimeFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		extendedISO8601DateTimeFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	public static String toBasicISO8601DateTime(Date value) {
		synchronized (basicISO8601DateTimeFormatter) {
			return basicISO8601DateTimeFormatter.format(value);
		}
	}
	public static Date fromBasicISO8601DateTime(String value) {
		synchronized (basicISO8601DateTimeFormatter) {
			try {
				return basicISO8601DateTimeFormatter.parse(value);
			} catch (ParseException e) {
				throw new IllegalArgumentException("ParseException: "+e.getMessage());
			}
		}
	}
	public static String toExtendedISO8601DateTime(Date value) {
		synchronized (extendedISO8601DateTimeFormatter) {
			return extendedISO8601DateTimeFormatter.format(value);
		}
	}
	public static Date fromExtendedISO8601DateTime(String value) {
		synchronized (extendedISO8601DateTimeFormatter) {
			try {
				return extendedISO8601DateTimeFormatter.parse(value);
			} catch (ParseException e) {
				throw new IllegalArgumentException("ParseException: "+e.getMessage());
			}
		}
	}

	private static String[] ORDINAL_SUFFIX = {"st","nd","rd","th","th","th","th","th","th","th"};
	public static String toOrdinal(int value) {
		if (value <= 0)
			throw new IllegalArgumentException();
		else if (value == 11)
			return "11th";
		else
			return value+ORDINAL_SUFFIX[(value-1) % 10];
	}

	public static boolean isValidEntityName(String name) {
		if (!isValidJavaIdentifier(name))
			return false;

		char first = name.charAt(0);
		return (Character.isUpperCase(first) || first == '_');	
	}
	public static boolean isValidFeatureName(String name) {
		if (!isValidJavaIdentifier(name))
			return false;

		char first = name.charAt(0);
		return (Character.isLowerCase(first) || first == '_');
	}
	public static boolean isValidEnumLiteralName(String baseName) {
		return isValidJavaIdentifier(baseName);
	}
	public static boolean isValidJavaIdentifier(String name) {
		if (name.length() == 0 || isJavaKeyword(name))
			return false;
		
		char[] chars = name.toCharArray();

		if (!Character.isJavaIdentifierStart(chars[0]))
			return false;

		for (int i=1; i<chars.length; i++)
			if (!Character.isJavaIdentifierPart(chars[i]))
				return false;

		return true;
	}
	public static String toEntityName(String baseName) {
		String entityName;
		if (isJavaKeyword(toLowerCap(baseName)))
			entityName = baseName;
		else
			entityName = toFeatureName(baseName);

		int length = entityName.length();

		if (!isUpperCap(entityName)) {
			if (length > 0 && Character.isLetter(entityName.charAt(0)))
				entityName = toUpperCap(entityName);
			else if (length == 0 || entityName.charAt(0) != '_')
				entityName = "_"+entityName;
		}

		return entityName;
	}
	public static String toFeatureName(String baseName) {
		if (baseName.length() == 0)
			return "_";

		if (isJavaKeyword(toLowerCap(baseName)))
			return "_"+toLowerCap(baseName);

		int index = 0;
		StringBuilder builder = new StringBuilder();

		char current = baseName.charAt(index++);
		if (!Character.isJavaIdentifierStart(current)) {
			builder.append('_');
			if (Character.isJavaIdentifierPart(current))
				builder.append(current);
		} else
			builder.append(current);

		while (index < baseName.length()) {
			current = baseName.charAt(index++);
			if (Character.isJavaIdentifierPart(current) && current != '$')
				builder.append(current);
			else
				builder.append('_');
		}
		return toLowerCap(builder.toString());
	}
	public static String toEnumLiteralName(String baseName) {
		if (baseName.length() == 0)
			return "_";
		if (isJavaKeyword(toLowerCap(baseName)))
			return "_"+baseName;
		if (baseName.equals("instance"))
			return "_instance";

		int index = 0;
		StringBuilder builder = new StringBuilder();

		char current = baseName.charAt(index++);
		if (!Character.isJavaIdentifierStart(current)) {
			builder.append('_');
			if (Character.isJavaIdentifierPart(current))
				builder.append(current);
		} else
			builder.append(current);

		while (index < baseName.length()) {
			current = baseName.charAt(index++);
			if (Character.isJavaIdentifierPart(current))
				builder.append(current);
			else
				builder.append('_');
		}
		return builder.toString();
	}

	public static String errorMessage(Throwable t) {
		String msg = t.getLocalizedMessage();
		while (msg == null && t.getCause() != null) {
			t = t.getCause();
			msg = t.getLocalizedMessage();
		}
		if (msg == null)
			msg = t.toString();
		return msg;
	}
}
