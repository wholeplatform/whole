/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.swiftsyntax.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class TokenKindEnum extends EnumType<TokenKindEnum.Value> {
    public static final int eof_ord = 0;
    public static final int associatedtypeKeyword_ord = 1;
    public static final int classKeyword_ord = 2;
    public static final int deinitKeyword_ord = 3;
    public static final int enumKeyword_ord = 4;
    public static final int extensionKeyword_ord = 5;
    public static final int funcKeyword_ord = 6;
    public static final int importKeyword_ord = 7;
    public static final int initKeyword_ord = 8;
    public static final int inoutKeyword_ord = 9;
    public static final int letKeyword_ord = 10;
    public static final int operatorKeyword_ord = 11;
    public static final int precedencegroupKeyword_ord = 12;
    public static final int protocolKeyword_ord = 13;
    public static final int structKeyword_ord = 14;
    public static final int subscriptKeyword_ord = 15;
    public static final int typealiasKeyword_ord = 16;
    public static final int varKeyword_ord = 17;
    public static final int fileprivateKeyword_ord = 18;
    public static final int internalKeyword_ord = 19;
    public static final int privateKeyword_ord = 20;
    public static final int publicKeyword_ord = 21;
    public static final int staticKeyword_ord = 22;
    public static final int deferKeyword_ord = 23;
    public static final int ifKeyword_ord = 24;
    public static final int guardKeyword_ord = 25;
    public static final int doKeyword_ord = 26;
    public static final int repeatKeyword_ord = 27;
    public static final int elseKeyword_ord = 28;
    public static final int forKeyword_ord = 29;
    public static final int inKeyword_ord = 30;
    public static final int whileKeyword_ord = 31;
    public static final int returnKeyword_ord = 32;
    public static final int breakKeyword_ord = 33;
    public static final int continueKeyword_ord = 34;
    public static final int fallthroughKeyword_ord = 35;
    public static final int switchKeyword_ord = 36;
    public static final int caseKeyword_ord = 37;
    public static final int defaultKeyword_ord = 38;
    public static final int whereKeyword_ord = 39;
    public static final int catchKeyword_ord = 40;
    public static final int throwKeyword_ord = 41;
    public static final int asKeyword_ord = 42;
    public static final int anyKeyword_ord = 43;
    public static final int falseKeyword_ord = 44;
    public static final int isKeyword_ord = 45;
    public static final int nilKeyword_ord = 46;
    public static final int rethrowsKeyword_ord = 47;
    public static final int superKeyword_ord = 48;
    public static final int selfKeyword_ord = 49;
    public static final int capitalSelfKeyword_ord = 50;
    public static final int trueKeyword_ord = 51;
    public static final int tryKeyword_ord = 52;
    public static final int throwsKeyword_ord = 53;
    public static final int __file__Keyword_ord = 54;
    public static final int __line__Keyword_ord = 55;
    public static final int __column__Keyword_ord = 56;
    public static final int __function__Keyword_ord = 57;
    public static final int __dso_handle__Keyword_ord = 58;
    public static final int wildcardKeyword_ord = 59;
    public static final int leftParen_ord = 60;
    public static final int rightParen_ord = 61;
    public static final int leftBrace_ord = 62;
    public static final int rightBrace_ord = 63;
    public static final int leftSquareBracket_ord = 64;
    public static final int rightSquareBracket_ord = 65;
    public static final int leftAngle_ord = 66;
    public static final int rightAngle_ord = 67;
    public static final int period_ord = 68;
    public static final int prefixPeriod_ord = 69;
    public static final int comma_ord = 70;
    public static final int ellipsis_ord = 71;
    public static final int colon_ord = 72;
    public static final int semicolon_ord = 73;
    public static final int equal_ord = 74;
    public static final int atSign_ord = 75;
    public static final int pound_ord = 76;
    public static final int prefixAmpersand_ord = 77;
    public static final int arrow_ord = 78;
    public static final int backtick_ord = 79;
    public static final int backslash_ord = 80;
    public static final int exclamationMark_ord = 81;
    public static final int postfixQuestionMark_ord = 82;
    public static final int infixQuestionMark_ord = 83;
    public static final int stringQuote_ord = 84;
    public static final int singleQuote_ord = 85;
    public static final int multilineStringQuote_ord = 86;
    public static final int poundKeyPathKeyword_ord = 87;
    public static final int poundLineKeyword_ord = 88;
    public static final int poundSelectorKeyword_ord = 89;
    public static final int poundFileKeyword_ord = 90;
    public static final int poundColumnKeyword_ord = 91;
    public static final int poundFunctionKeyword_ord = 92;
    public static final int poundDsohandleKeyword_ord = 93;
    public static final int poundAssertKeyword_ord = 94;
    public static final int poundSourceLocationKeyword_ord = 95;
    public static final int poundWarningKeyword_ord = 96;
    public static final int poundErrorKeyword_ord = 97;
    public static final int poundIfKeyword_ord = 98;
    public static final int poundElseKeyword_ord = 99;
    public static final int poundElseifKeyword_ord = 100;
    public static final int poundEndifKeyword_ord = 101;
    public static final int poundAvailableKeyword_ord = 102;
    public static final int poundFileLiteralKeyword_ord = 103;
    public static final int poundImageLiteralKeyword_ord = 104;
    public static final int poundColorLiteralKeyword_ord = 105;
    public static final int integerLiteral_ord = 106;
    public static final int floatingLiteral_ord = 107;
    public static final int stringLiteral_ord = 108;
    public static final int unknown_ord = 109;
    public static final int identifier_ord = 110;
    public static final int unspacedBinaryOperator_ord = 111;
    public static final int spacedBinaryOperator_ord = 112;
    public static final int postfixOperator_ord = 113;
    public static final int prefixOperator_ord = 114;
    public static final int dollarIdentifier_ord = 115;
    public static final int contextualKeyword_ord = 116;
    public static final int rawStringDelimiter_ord = 117;
    public static final int stringSegment_ord = 118;
    public static final int stringInterpolationAnchor_ord = 119;
    public static final int yield_ord = 120;
    public static final TokenKindEnum instance = new TokenKindEnum();
    public static final Value eof = instance.valueOf(eof_ord);
    public static final Value associatedtypeKeyword = instance.valueOf(associatedtypeKeyword_ord);
    public static final Value classKeyword = instance.valueOf(classKeyword_ord);
    public static final Value deinitKeyword = instance.valueOf(deinitKeyword_ord);
    public static final Value enumKeyword = instance.valueOf(enumKeyword_ord);
    public static final Value extensionKeyword = instance.valueOf(extensionKeyword_ord);
    public static final Value funcKeyword = instance.valueOf(funcKeyword_ord);
    public static final Value importKeyword = instance.valueOf(importKeyword_ord);
    public static final Value initKeyword = instance.valueOf(initKeyword_ord);
    public static final Value inoutKeyword = instance.valueOf(inoutKeyword_ord);
    public static final Value letKeyword = instance.valueOf(letKeyword_ord);
    public static final Value operatorKeyword = instance.valueOf(operatorKeyword_ord);
    public static final Value precedencegroupKeyword = instance.valueOf(precedencegroupKeyword_ord);
    public static final Value protocolKeyword = instance.valueOf(protocolKeyword_ord);
    public static final Value structKeyword = instance.valueOf(structKeyword_ord);
    public static final Value subscriptKeyword = instance.valueOf(subscriptKeyword_ord);
    public static final Value typealiasKeyword = instance.valueOf(typealiasKeyword_ord);
    public static final Value varKeyword = instance.valueOf(varKeyword_ord);
    public static final Value fileprivateKeyword = instance.valueOf(fileprivateKeyword_ord);
    public static final Value internalKeyword = instance.valueOf(internalKeyword_ord);
    public static final Value privateKeyword = instance.valueOf(privateKeyword_ord);
    public static final Value publicKeyword = instance.valueOf(publicKeyword_ord);
    public static final Value staticKeyword = instance.valueOf(staticKeyword_ord);
    public static final Value deferKeyword = instance.valueOf(deferKeyword_ord);
    public static final Value ifKeyword = instance.valueOf(ifKeyword_ord);
    public static final Value guardKeyword = instance.valueOf(guardKeyword_ord);
    public static final Value doKeyword = instance.valueOf(doKeyword_ord);
    public static final Value repeatKeyword = instance.valueOf(repeatKeyword_ord);
    public static final Value elseKeyword = instance.valueOf(elseKeyword_ord);
    public static final Value forKeyword = instance.valueOf(forKeyword_ord);
    public static final Value inKeyword = instance.valueOf(inKeyword_ord);
    public static final Value whileKeyword = instance.valueOf(whileKeyword_ord);
    public static final Value returnKeyword = instance.valueOf(returnKeyword_ord);
    public static final Value breakKeyword = instance.valueOf(breakKeyword_ord);
    public static final Value continueKeyword = instance.valueOf(continueKeyword_ord);
    public static final Value fallthroughKeyword = instance.valueOf(fallthroughKeyword_ord);
    public static final Value switchKeyword = instance.valueOf(switchKeyword_ord);
    public static final Value caseKeyword = instance.valueOf(caseKeyword_ord);
    public static final Value defaultKeyword = instance.valueOf(defaultKeyword_ord);
    public static final Value whereKeyword = instance.valueOf(whereKeyword_ord);
    public static final Value catchKeyword = instance.valueOf(catchKeyword_ord);
    public static final Value throwKeyword = instance.valueOf(throwKeyword_ord);
    public static final Value asKeyword = instance.valueOf(asKeyword_ord);
    public static final Value anyKeyword = instance.valueOf(anyKeyword_ord);
    public static final Value falseKeyword = instance.valueOf(falseKeyword_ord);
    public static final Value isKeyword = instance.valueOf(isKeyword_ord);
    public static final Value nilKeyword = instance.valueOf(nilKeyword_ord);
    public static final Value rethrowsKeyword = instance.valueOf(rethrowsKeyword_ord);
    public static final Value superKeyword = instance.valueOf(superKeyword_ord);
    public static final Value selfKeyword = instance.valueOf(selfKeyword_ord);
    public static final Value capitalSelfKeyword = instance.valueOf(capitalSelfKeyword_ord);
    public static final Value trueKeyword = instance.valueOf(trueKeyword_ord);
    public static final Value tryKeyword = instance.valueOf(tryKeyword_ord);
    public static final Value throwsKeyword = instance.valueOf(throwsKeyword_ord);
    public static final Value __file__Keyword = instance.valueOf(__file__Keyword_ord);
    public static final Value __line__Keyword = instance.valueOf(__line__Keyword_ord);
    public static final Value __column__Keyword = instance.valueOf(__column__Keyword_ord);
    public static final Value __function__Keyword = instance.valueOf(__function__Keyword_ord);
    public static final Value __dso_handle__Keyword = instance.valueOf(__dso_handle__Keyword_ord);
    public static final Value wildcardKeyword = instance.valueOf(wildcardKeyword_ord);
    public static final Value leftParen = instance.valueOf(leftParen_ord);
    public static final Value rightParen = instance.valueOf(rightParen_ord);
    public static final Value leftBrace = instance.valueOf(leftBrace_ord);
    public static final Value rightBrace = instance.valueOf(rightBrace_ord);
    public static final Value leftSquareBracket = instance.valueOf(leftSquareBracket_ord);
    public static final Value rightSquareBracket = instance.valueOf(rightSquareBracket_ord);
    public static final Value leftAngle = instance.valueOf(leftAngle_ord);
    public static final Value rightAngle = instance.valueOf(rightAngle_ord);
    public static final Value period = instance.valueOf(period_ord);
    public static final Value prefixPeriod = instance.valueOf(prefixPeriod_ord);
    public static final Value comma = instance.valueOf(comma_ord);
    public static final Value ellipsis = instance.valueOf(ellipsis_ord);
    public static final Value colon = instance.valueOf(colon_ord);
    public static final Value semicolon = instance.valueOf(semicolon_ord);
    public static final Value equal = instance.valueOf(equal_ord);
    public static final Value atSign = instance.valueOf(atSign_ord);
    public static final Value pound = instance.valueOf(pound_ord);
    public static final Value prefixAmpersand = instance.valueOf(prefixAmpersand_ord);
    public static final Value arrow = instance.valueOf(arrow_ord);
    public static final Value backtick = instance.valueOf(backtick_ord);
    public static final Value backslash = instance.valueOf(backslash_ord);
    public static final Value exclamationMark = instance.valueOf(exclamationMark_ord);
    public static final Value postfixQuestionMark = instance.valueOf(postfixQuestionMark_ord);
    public static final Value infixQuestionMark = instance.valueOf(infixQuestionMark_ord);
    public static final Value stringQuote = instance.valueOf(stringQuote_ord);
    public static final Value singleQuote = instance.valueOf(singleQuote_ord);
    public static final Value multilineStringQuote = instance.valueOf(multilineStringQuote_ord);
    public static final Value poundKeyPathKeyword = instance.valueOf(poundKeyPathKeyword_ord);
    public static final Value poundLineKeyword = instance.valueOf(poundLineKeyword_ord);
    public static final Value poundSelectorKeyword = instance.valueOf(poundSelectorKeyword_ord);
    public static final Value poundFileKeyword = instance.valueOf(poundFileKeyword_ord);
    public static final Value poundColumnKeyword = instance.valueOf(poundColumnKeyword_ord);
    public static final Value poundFunctionKeyword = instance.valueOf(poundFunctionKeyword_ord);
    public static final Value poundDsohandleKeyword = instance.valueOf(poundDsohandleKeyword_ord);
    public static final Value poundAssertKeyword = instance.valueOf(poundAssertKeyword_ord);
    public static final Value poundSourceLocationKeyword = instance.valueOf(poundSourceLocationKeyword_ord);
    public static final Value poundWarningKeyword = instance.valueOf(poundWarningKeyword_ord);
    public static final Value poundErrorKeyword = instance.valueOf(poundErrorKeyword_ord);
    public static final Value poundIfKeyword = instance.valueOf(poundIfKeyword_ord);
    public static final Value poundElseKeyword = instance.valueOf(poundElseKeyword_ord);
    public static final Value poundElseifKeyword = instance.valueOf(poundElseifKeyword_ord);
    public static final Value poundEndifKeyword = instance.valueOf(poundEndifKeyword_ord);
    public static final Value poundAvailableKeyword = instance.valueOf(poundAvailableKeyword_ord);
    public static final Value poundFileLiteralKeyword = instance.valueOf(poundFileLiteralKeyword_ord);
    public static final Value poundImageLiteralKeyword = instance.valueOf(poundImageLiteralKeyword_ord);
    public static final Value poundColorLiteralKeyword = instance.valueOf(poundColorLiteralKeyword_ord);
    public static final Value integerLiteral = instance.valueOf(integerLiteral_ord);
    public static final Value floatingLiteral = instance.valueOf(floatingLiteral_ord);
    public static final Value stringLiteral = instance.valueOf(stringLiteral_ord);
    public static final Value unknown = instance.valueOf(unknown_ord);
    public static final Value identifier = instance.valueOf(identifier_ord);
    public static final Value unspacedBinaryOperator = instance.valueOf(unspacedBinaryOperator_ord);
    public static final Value spacedBinaryOperator = instance.valueOf(spacedBinaryOperator_ord);
    public static final Value postfixOperator = instance.valueOf(postfixOperator_ord);
    public static final Value prefixOperator = instance.valueOf(prefixOperator_ord);
    public static final Value dollarIdentifier = instance.valueOf(dollarIdentifier_ord);
    public static final Value contextualKeyword = instance.valueOf(contextualKeyword_ord);
    public static final Value rawStringDelimiter = instance.valueOf(rawStringDelimiter_ord);
    public static final Value stringSegment = instance.valueOf(stringSegment_ord);
    public static final Value stringInterpolationAnchor = instance.valueOf(stringInterpolationAnchor_ord);
    public static final Value yield = instance.valueOf(yield_ord);

    private TokenKindEnum() {
        enumValue(eof_ord, "eof");
        enumValue(associatedtypeKeyword_ord, "associatedtypeKeyword");
        enumValue(classKeyword_ord, "classKeyword");
        enumValue(deinitKeyword_ord, "deinitKeyword");
        enumValue(enumKeyword_ord, "enumKeyword");
        enumValue(extensionKeyword_ord, "extensionKeyword");
        enumValue(funcKeyword_ord, "funcKeyword");
        enumValue(importKeyword_ord, "importKeyword");
        enumValue(initKeyword_ord, "initKeyword");
        enumValue(inoutKeyword_ord, "inoutKeyword");
        enumValue(letKeyword_ord, "letKeyword");
        enumValue(operatorKeyword_ord, "operatorKeyword");
        enumValue(precedencegroupKeyword_ord, "precedencegroupKeyword");
        enumValue(protocolKeyword_ord, "protocolKeyword");
        enumValue(structKeyword_ord, "structKeyword");
        enumValue(subscriptKeyword_ord, "subscriptKeyword");
        enumValue(typealiasKeyword_ord, "typealiasKeyword");
        enumValue(varKeyword_ord, "varKeyword");
        enumValue(fileprivateKeyword_ord, "fileprivateKeyword");
        enumValue(internalKeyword_ord, "internalKeyword");
        enumValue(privateKeyword_ord, "privateKeyword");
        enumValue(publicKeyword_ord, "publicKeyword");
        enumValue(staticKeyword_ord, "staticKeyword");
        enumValue(deferKeyword_ord, "deferKeyword");
        enumValue(ifKeyword_ord, "ifKeyword");
        enumValue(guardKeyword_ord, "guardKeyword");
        enumValue(doKeyword_ord, "doKeyword");
        enumValue(repeatKeyword_ord, "repeatKeyword");
        enumValue(elseKeyword_ord, "elseKeyword");
        enumValue(forKeyword_ord, "forKeyword");
        enumValue(inKeyword_ord, "inKeyword");
        enumValue(whileKeyword_ord, "whileKeyword");
        enumValue(returnKeyword_ord, "returnKeyword");
        enumValue(breakKeyword_ord, "breakKeyword");
        enumValue(continueKeyword_ord, "continueKeyword");
        enumValue(fallthroughKeyword_ord, "fallthroughKeyword");
        enumValue(switchKeyword_ord, "switchKeyword");
        enumValue(caseKeyword_ord, "caseKeyword");
        enumValue(defaultKeyword_ord, "defaultKeyword");
        enumValue(whereKeyword_ord, "whereKeyword");
        enumValue(catchKeyword_ord, "catchKeyword");
        enumValue(throwKeyword_ord, "throwKeyword");
        enumValue(asKeyword_ord, "asKeyword");
        enumValue(anyKeyword_ord, "anyKeyword");
        enumValue(falseKeyword_ord, "falseKeyword");
        enumValue(isKeyword_ord, "isKeyword");
        enumValue(nilKeyword_ord, "nilKeyword");
        enumValue(rethrowsKeyword_ord, "rethrowsKeyword");
        enumValue(superKeyword_ord, "superKeyword");
        enumValue(selfKeyword_ord, "selfKeyword");
        enumValue(capitalSelfKeyword_ord, "capitalSelfKeyword");
        enumValue(trueKeyword_ord, "trueKeyword");
        enumValue(tryKeyword_ord, "tryKeyword");
        enumValue(throwsKeyword_ord, "throwsKeyword");
        enumValue(__file__Keyword_ord, "__file__Keyword");
        enumValue(__line__Keyword_ord, "__line__Keyword");
        enumValue(__column__Keyword_ord, "__column__Keyword");
        enumValue(__function__Keyword_ord, "__function__Keyword");
        enumValue(__dso_handle__Keyword_ord, "__dso_handle__Keyword");
        enumValue(wildcardKeyword_ord, "wildcardKeyword");
        enumValue(leftParen_ord, "leftParen");
        enumValue(rightParen_ord, "rightParen");
        enumValue(leftBrace_ord, "leftBrace");
        enumValue(rightBrace_ord, "rightBrace");
        enumValue(leftSquareBracket_ord, "leftSquareBracket");
        enumValue(rightSquareBracket_ord, "rightSquareBracket");
        enumValue(leftAngle_ord, "leftAngle");
        enumValue(rightAngle_ord, "rightAngle");
        enumValue(period_ord, "period");
        enumValue(prefixPeriod_ord, "prefixPeriod");
        enumValue(comma_ord, "comma");
        enumValue(ellipsis_ord, "ellipsis");
        enumValue(colon_ord, "colon");
        enumValue(semicolon_ord, "semicolon");
        enumValue(equal_ord, "equal");
        enumValue(atSign_ord, "atSign");
        enumValue(pound_ord, "pound");
        enumValue(prefixAmpersand_ord, "prefixAmpersand");
        enumValue(arrow_ord, "arrow");
        enumValue(backtick_ord, "backtick");
        enumValue(backslash_ord, "backslash");
        enumValue(exclamationMark_ord, "exclamationMark");
        enumValue(postfixQuestionMark_ord, "postfixQuestionMark");
        enumValue(infixQuestionMark_ord, "infixQuestionMark");
        enumValue(stringQuote_ord, "stringQuote");
        enumValue(singleQuote_ord, "singleQuote");
        enumValue(multilineStringQuote_ord, "multilineStringQuote");
        enumValue(poundKeyPathKeyword_ord, "poundKeyPathKeyword");
        enumValue(poundLineKeyword_ord, "poundLineKeyword");
        enumValue(poundSelectorKeyword_ord, "poundSelectorKeyword");
        enumValue(poundFileKeyword_ord, "poundFileKeyword");
        enumValue(poundColumnKeyword_ord, "poundColumnKeyword");
        enumValue(poundFunctionKeyword_ord, "poundFunctionKeyword");
        enumValue(poundDsohandleKeyword_ord, "poundDsohandleKeyword");
        enumValue(poundAssertKeyword_ord, "poundAssertKeyword");
        enumValue(poundSourceLocationKeyword_ord, "poundSourceLocationKeyword");
        enumValue(poundWarningKeyword_ord, "poundWarningKeyword");
        enumValue(poundErrorKeyword_ord, "poundErrorKeyword");
        enumValue(poundIfKeyword_ord, "poundIfKeyword");
        enumValue(poundElseKeyword_ord, "poundElseKeyword");
        enumValue(poundElseifKeyword_ord, "poundElseifKeyword");
        enumValue(poundEndifKeyword_ord, "poundEndifKeyword");
        enumValue(poundAvailableKeyword_ord, "poundAvailableKeyword");
        enumValue(poundFileLiteralKeyword_ord, "poundFileLiteralKeyword");
        enumValue(poundImageLiteralKeyword_ord, "poundImageLiteralKeyword");
        enumValue(poundColorLiteralKeyword_ord, "poundColorLiteralKeyword");
        enumValue(integerLiteral_ord, "integerLiteral");
        enumValue(floatingLiteral_ord, "floatingLiteral");
        enumValue(stringLiteral_ord, "stringLiteral");
        enumValue(unknown_ord, "unknown");
        enumValue(identifier_ord, "identifier");
        enumValue(unspacedBinaryOperator_ord, "unspacedBinaryOperator");
        enumValue(spacedBinaryOperator_ord, "spacedBinaryOperator");
        enumValue(postfixOperator_ord, "postfixOperator");
        enumValue(prefixOperator_ord, "prefixOperator");
        enumValue(dollarIdentifier_ord, "dollarIdentifier");
        enumValue(contextualKeyword_ord, "contextualKeyword");
        enumValue(rawStringDelimiter_ord, "rawStringDelimiter");
        enumValue(stringSegment_ord, "stringSegment");
        enumValue(stringInterpolationAnchor_ord, "stringInterpolationAnchor");
        enumValue(yield_ord, "yield");
    }
    private static final long serialVersionUID = 1;

    protected void enumValue(int ordinal, String name) {
        if (valueOf(name) == null)
            putEnumValue(new Value(ordinal, name));
    }

    protected void enumValue(int ordinal, String name, String implName) {
        if (valueOf(name) == null)
            putEnumValue(new Value(ordinal, name, implName));
    }

    public static class Value extends EnumValueImpl {
        private static final long serialVersionUID = 1;

        public Value() {
            super();
        }

        public Value(int ordinal, String name) {
            super(ordinal, name);
        }

        public Value(int ordinal, String name, String implName) {
            super(ordinal, name, implName);
        }
    }
}
