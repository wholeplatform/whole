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
package org.whole.lang.swift.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class SwiftFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int expression_ord = 0;
    public static final int delimiter_ord = 1;
    public static final int expressions_ord = 2;
    public static final int questionOrExclamationMark_ord = 3;
    public static final int identifier_ord = 4;
    public static final int declNameArguments_ord = 5;
    public static final int genericArgumentClause_ord = 6;
    public static final int operatorToken_ord = 7;
    public static final int postfixExpression_ord = 8;
    public static final int throwsToken_ord = 9;
    public static final int label_ord = 10;
    public static final int keyExpression_ord = 11;
    public static final int valueExpression_ord = 12;
    public static final int conditionExpression_ord = 13;
    public static final int firstChoice_ord = 14;
    public static final int secondChoice_ord = 15;
    public static final int base_ord = 16;
    public static final int dot_ord = 17;
    public static final int name_ord = 18;
    public static final int typeName_ord = 19;
    public static final int type_ord = 20;
    public static final int specifier_ord = 21;
    public static final int capture_ord = 22;
    public static final int input_ord = 23;
    public static final int throwsTok_ord = 24;
    public static final int output_ord = 25;
    public static final int signature_ord = 26;
    public static final int statements_ord = 27;
    public static final int pattern_ord = 28;
    public static final int calledExpression_ord = 29;
    public static final int argumentList_ord = 30;
    public static final int trailingClosure_ord = 31;
    public static final int openDelimiter_ord = 32;
    public static final int openQuote_ord = 33;
    public static final int segments_ord = 34;
    public static final int rootExpr_ord = 35;
    public static final int kind_ord = 36;
    public static final int poundIdentifier_ord = 37;
    public static final int arguments_ord = 38;
    public static final int attributes_ord = 39;
    public static final int modifiers_ord = 40;
    public static final int genericParameterClause_ord = 41;
    public static final int initializer_ord = 42;
    public static final int genericWhereClause_ord = 43;
    public static final int inheritanceClause_ord = 44;
    public static final int throwsOrRethrowsKeyword_ord = 45;
    public static final int poundKeyword_ord = 46;
    public static final int condition_ord = 47;
    public static final int elements_ord = 48;
    public static final int message_ord = 49;
    public static final int args_ord = 50;
    public static final int fileArgLabel_ord = 51;
    public static final int fileName_ord = 52;
    public static final int lineArgLabel_ord = 53;
    public static final int lineNumber_ord = 54;
    public static final int detail_ord = 55;
    public static final int members_ord = 56;
    public static final int extendedType_ord = 57;
    public static final int firstName_ord = 58;
    public static final int secondName_ord = 59;
    public static final int ellipsis_ord = 60;
    public static final int defaultArgument_ord = 61;
    public static final int functionIdentifier_ord = 62;
    public static final int body_ord = 63;
    public static final int optionalMark_ord = 64;
    public static final int parameters_ord = 65;
    public static final int indices_ord = 66;
    public static final int result_ord = 67;
    public static final int accessor_ord = 68;
    public static final int modifier_ord = 69;
    public static final int importKind_ord = 70;
    public static final int path_ord = 71;
    public static final int accessorKind_ord = 72;
    public static final int parameter_ord = 73;
    public static final int typeAnnotation_ord = 74;
    public static final int letOrVarKeyword_ord = 75;
    public static final int bindings_ord = 76;
    public static final int associatedValue_ord = 77;
    public static final int rawValue_ord = 78;
    public static final int genericParameters_ord = 79;
    public static final int operatorIdentifier_ord = 80;
    public static final int operatorPrecedenceAndTypes_ord = 81;
    public static final int groupAttributes_ord = 82;
    public static final int higherThanOrLowerThan_ord = 83;
    public static final int otherNames_ord = 84;
    public static final int assignmentKeyword_ord = 85;
    public static final int flag_ord = 86;
    public static final int associativityKeyword_ord = 87;
    public static final int value_ord = 88;
    public static final int attributeName_ord = 89;
    public static final int argument_ord = 90;
    public static final int declBaseName_ord = 91;
    public static final int nameTok_ord = 92;
    public static final int stringOrDeclname_ord = 93;
    public static final int labelName_ord = 94;
    public static final int conditions_ord = 95;
    public static final int unknownAttr_ord = 96;
    public static final int caseKeyword_ord = 97;
    public static final int sequenceExpr_ord = 98;
    public static final int whereClause_ord = 99;
    public static final int cases_ord = 100;
    public static final int catchClauses_ord = 101;
    public static final int yields_ord = 102;
    public static final int availabilitySpec_ord = 103;
    public static final int elseBody_ord = 104;
    public static final int leftTypeIdentifier_ord = 105;
    public static final int equalityToken_ord = 106;
    public static final int rightTypeIdentifier_ord = 107;
    public static final int inheritedType_ord = 108;
    public static final int baseType_ord = 109;
    public static final int period_ord = 110;
    public static final int elementType_ord = 111;
    public static final int keyType_ord = 112;
    public static final int valueType_ord = 113;
    public static final int typeOrProtocol_ord = 114;
    public static final int wrappedType_ord = 115;
    public static final int someSpecifier_ord = 116;
    public static final int ampersand_ord = 117;
    public static final int inOut_ord = 118;
    public static final int returnType_ord = 119;
    public static final int caseName_ord = 120;
    public static final int associatedTuple_ord = 121;
    public static final int subPattern_ord = 122;
    public static final int patternIdentifier_ord = 123;
    public static final int valuePattern_ord = 124;
    public static final int platform_ord = 125;
    public static final int version_ord = 126;
    public static final int majorMinor_ord = 127;
    public static final int patchVersion_ord = 128;
    public static final SwiftFeatureDescriptorEnum instance = new SwiftFeatureDescriptorEnum();
    public static final FeatureDescriptor expression = instance.valueOf(expression_ord);
    public static final FeatureDescriptor delimiter = instance.valueOf(delimiter_ord);
    public static final FeatureDescriptor expressions = instance.valueOf(expressions_ord);
    public static final FeatureDescriptor questionOrExclamationMark = instance.valueOf(questionOrExclamationMark_ord);
    public static final FeatureDescriptor identifier = instance.valueOf(identifier_ord);
    public static final FeatureDescriptor declNameArguments = instance.valueOf(declNameArguments_ord);
    public static final FeatureDescriptor genericArgumentClause = instance.valueOf(genericArgumentClause_ord);
    public static final FeatureDescriptor operatorToken = instance.valueOf(operatorToken_ord);
    public static final FeatureDescriptor postfixExpression = instance.valueOf(postfixExpression_ord);
    public static final FeatureDescriptor throwsToken = instance.valueOf(throwsToken_ord);
    public static final FeatureDescriptor label = instance.valueOf(label_ord);
    public static final FeatureDescriptor keyExpression = instance.valueOf(keyExpression_ord);
    public static final FeatureDescriptor valueExpression = instance.valueOf(valueExpression_ord);
    public static final FeatureDescriptor conditionExpression = instance.valueOf(conditionExpression_ord);
    public static final FeatureDescriptor firstChoice = instance.valueOf(firstChoice_ord);
    public static final FeatureDescriptor secondChoice = instance.valueOf(secondChoice_ord);
    public static final FeatureDescriptor base = instance.valueOf(base_ord);
    public static final FeatureDescriptor dot = instance.valueOf(dot_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor typeName = instance.valueOf(typeName_ord);
    public static final FeatureDescriptor type = instance.valueOf(type_ord);
    public static final FeatureDescriptor specifier = instance.valueOf(specifier_ord);
    public static final FeatureDescriptor capture = instance.valueOf(capture_ord);
    public static final FeatureDescriptor input = instance.valueOf(input_ord);
    public static final FeatureDescriptor throwsTok = instance.valueOf(throwsTok_ord);
    public static final FeatureDescriptor output = instance.valueOf(output_ord);
    public static final FeatureDescriptor signature = instance.valueOf(signature_ord);
    public static final FeatureDescriptor statements = instance.valueOf(statements_ord);
    public static final FeatureDescriptor pattern = instance.valueOf(pattern_ord);
    public static final FeatureDescriptor calledExpression = instance.valueOf(calledExpression_ord);
    public static final FeatureDescriptor argumentList = instance.valueOf(argumentList_ord);
    public static final FeatureDescriptor trailingClosure = instance.valueOf(trailingClosure_ord);
    public static final FeatureDescriptor openDelimiter = instance.valueOf(openDelimiter_ord);
    public static final FeatureDescriptor openQuote = instance.valueOf(openQuote_ord);
    public static final FeatureDescriptor segments = instance.valueOf(segments_ord);
    public static final FeatureDescriptor rootExpr = instance.valueOf(rootExpr_ord);
    public static final FeatureDescriptor kind = instance.valueOf(kind_ord);
    public static final FeatureDescriptor poundIdentifier = instance.valueOf(poundIdentifier_ord);
    public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
    public static final FeatureDescriptor attributes = instance.valueOf(attributes_ord);
    public static final FeatureDescriptor modifiers = instance.valueOf(modifiers_ord);
    public static final FeatureDescriptor genericParameterClause = instance.valueOf(genericParameterClause_ord);
    public static final FeatureDescriptor initializer = instance.valueOf(initializer_ord);
    public static final FeatureDescriptor genericWhereClause = instance.valueOf(genericWhereClause_ord);
    public static final FeatureDescriptor inheritanceClause = instance.valueOf(inheritanceClause_ord);
    public static final FeatureDescriptor throwsOrRethrowsKeyword = instance.valueOf(throwsOrRethrowsKeyword_ord);
    public static final FeatureDescriptor poundKeyword = instance.valueOf(poundKeyword_ord);
    public static final FeatureDescriptor condition = instance.valueOf(condition_ord);
    public static final FeatureDescriptor elements = instance.valueOf(elements_ord);
    public static final FeatureDescriptor message = instance.valueOf(message_ord);
    public static final FeatureDescriptor args = instance.valueOf(args_ord);
    public static final FeatureDescriptor fileArgLabel = instance.valueOf(fileArgLabel_ord);
    public static final FeatureDescriptor fileName = instance.valueOf(fileName_ord);
    public static final FeatureDescriptor lineArgLabel = instance.valueOf(lineArgLabel_ord);
    public static final FeatureDescriptor lineNumber = instance.valueOf(lineNumber_ord);
    public static final FeatureDescriptor detail = instance.valueOf(detail_ord);
    public static final FeatureDescriptor members = instance.valueOf(members_ord);
    public static final FeatureDescriptor extendedType = instance.valueOf(extendedType_ord);
    public static final FeatureDescriptor firstName = instance.valueOf(firstName_ord);
    public static final FeatureDescriptor secondName = instance.valueOf(secondName_ord);
    public static final FeatureDescriptor ellipsis = instance.valueOf(ellipsis_ord);
    public static final FeatureDescriptor defaultArgument = instance.valueOf(defaultArgument_ord);
    public static final FeatureDescriptor functionIdentifier = instance.valueOf(functionIdentifier_ord);
    public static final FeatureDescriptor body = instance.valueOf(body_ord);
    public static final FeatureDescriptor optionalMark = instance.valueOf(optionalMark_ord);
    public static final FeatureDescriptor parameters = instance.valueOf(parameters_ord);
    public static final FeatureDescriptor indices = instance.valueOf(indices_ord);
    public static final FeatureDescriptor result = instance.valueOf(result_ord);
    public static final FeatureDescriptor accessor = instance.valueOf(accessor_ord);
    public static final FeatureDescriptor modifier = instance.valueOf(modifier_ord);
    public static final FeatureDescriptor importKind = instance.valueOf(importKind_ord);
    public static final FeatureDescriptor path = instance.valueOf(path_ord);
    public static final FeatureDescriptor accessorKind = instance.valueOf(accessorKind_ord);
    public static final FeatureDescriptor parameter = instance.valueOf(parameter_ord);
    public static final FeatureDescriptor typeAnnotation = instance.valueOf(typeAnnotation_ord);
    public static final FeatureDescriptor letOrVarKeyword = instance.valueOf(letOrVarKeyword_ord);
    public static final FeatureDescriptor bindings = instance.valueOf(bindings_ord);
    public static final FeatureDescriptor associatedValue = instance.valueOf(associatedValue_ord);
    public static final FeatureDescriptor rawValue = instance.valueOf(rawValue_ord);
    public static final FeatureDescriptor genericParameters = instance.valueOf(genericParameters_ord);
    public static final FeatureDescriptor operatorIdentifier = instance.valueOf(operatorIdentifier_ord);
    public static final FeatureDescriptor operatorPrecedenceAndTypes = instance.valueOf(operatorPrecedenceAndTypes_ord);
    public static final FeatureDescriptor groupAttributes = instance.valueOf(groupAttributes_ord);
    public static final FeatureDescriptor higherThanOrLowerThan = instance.valueOf(higherThanOrLowerThan_ord);
    public static final FeatureDescriptor otherNames = instance.valueOf(otherNames_ord);
    public static final FeatureDescriptor assignmentKeyword = instance.valueOf(assignmentKeyword_ord);
    public static final FeatureDescriptor flag = instance.valueOf(flag_ord);
    public static final FeatureDescriptor associativityKeyword = instance.valueOf(associativityKeyword_ord);
    public static final FeatureDescriptor value = instance.valueOf(value_ord);
    public static final FeatureDescriptor attributeName = instance.valueOf(attributeName_ord);
    public static final FeatureDescriptor argument = instance.valueOf(argument_ord);
    public static final FeatureDescriptor declBaseName = instance.valueOf(declBaseName_ord);
    public static final FeatureDescriptor nameTok = instance.valueOf(nameTok_ord);
    public static final FeatureDescriptor stringOrDeclname = instance.valueOf(stringOrDeclname_ord);
    public static final FeatureDescriptor labelName = instance.valueOf(labelName_ord);
    public static final FeatureDescriptor conditions = instance.valueOf(conditions_ord);
    public static final FeatureDescriptor unknownAttr = instance.valueOf(unknownAttr_ord);
    public static final FeatureDescriptor caseKeyword = instance.valueOf(caseKeyword_ord);
    public static final FeatureDescriptor sequenceExpr = instance.valueOf(sequenceExpr_ord);
    public static final FeatureDescriptor whereClause = instance.valueOf(whereClause_ord);
    public static final FeatureDescriptor cases = instance.valueOf(cases_ord);
    public static final FeatureDescriptor catchClauses = instance.valueOf(catchClauses_ord);
    public static final FeatureDescriptor yields = instance.valueOf(yields_ord);
    public static final FeatureDescriptor availabilitySpec = instance.valueOf(availabilitySpec_ord);
    public static final FeatureDescriptor elseBody = instance.valueOf(elseBody_ord);
    public static final FeatureDescriptor leftTypeIdentifier = instance.valueOf(leftTypeIdentifier_ord);
    public static final FeatureDescriptor equalityToken = instance.valueOf(equalityToken_ord);
    public static final FeatureDescriptor rightTypeIdentifier = instance.valueOf(rightTypeIdentifier_ord);
    public static final FeatureDescriptor inheritedType = instance.valueOf(inheritedType_ord);
    public static final FeatureDescriptor baseType = instance.valueOf(baseType_ord);
    public static final FeatureDescriptor period = instance.valueOf(period_ord);
    public static final FeatureDescriptor elementType = instance.valueOf(elementType_ord);
    public static final FeatureDescriptor keyType = instance.valueOf(keyType_ord);
    public static final FeatureDescriptor valueType = instance.valueOf(valueType_ord);
    public static final FeatureDescriptor typeOrProtocol = instance.valueOf(typeOrProtocol_ord);
    public static final FeatureDescriptor wrappedType = instance.valueOf(wrappedType_ord);
    public static final FeatureDescriptor someSpecifier = instance.valueOf(someSpecifier_ord);
    public static final FeatureDescriptor ampersand = instance.valueOf(ampersand_ord);
    public static final FeatureDescriptor inOut = instance.valueOf(inOut_ord);
    public static final FeatureDescriptor returnType = instance.valueOf(returnType_ord);
    public static final FeatureDescriptor caseName = instance.valueOf(caseName_ord);
    public static final FeatureDescriptor associatedTuple = instance.valueOf(associatedTuple_ord);
    public static final FeatureDescriptor subPattern = instance.valueOf(subPattern_ord);
    public static final FeatureDescriptor patternIdentifier = instance.valueOf(patternIdentifier_ord);
    public static final FeatureDescriptor valuePattern = instance.valueOf(valuePattern_ord);
    public static final FeatureDescriptor platform = instance.valueOf(platform_ord);
    public static final FeatureDescriptor version = instance.valueOf(version_ord);
    public static final FeatureDescriptor majorMinor = instance.valueOf(majorMinor_ord);
    public static final FeatureDescriptor patchVersion = instance.valueOf(patchVersion_ord);

    private SwiftFeatureDescriptorEnum() {
        putFeatureDescriptor(expression_ord, "expression");
        putFeatureDescriptor(delimiter_ord, "delimiter");
        putFeatureDescriptor(expressions_ord, "expressions");
        putFeatureDescriptor(questionOrExclamationMark_ord, "questionOrExclamationMark");
        putFeatureDescriptor(identifier_ord, "identifier");
        putFeatureDescriptor(declNameArguments_ord, "declNameArguments");
        putFeatureDescriptor(genericArgumentClause_ord, "genericArgumentClause");
        putFeatureDescriptor(operatorToken_ord, "operatorToken");
        putFeatureDescriptor(postfixExpression_ord, "postfixExpression");
        putFeatureDescriptor(throwsToken_ord, "throwsToken");
        putFeatureDescriptor(label_ord, "label");
        putFeatureDescriptor(keyExpression_ord, "keyExpression");
        putFeatureDescriptor(valueExpression_ord, "valueExpression");
        putFeatureDescriptor(conditionExpression_ord, "conditionExpression");
        putFeatureDescriptor(firstChoice_ord, "firstChoice");
        putFeatureDescriptor(secondChoice_ord, "secondChoice");
        putFeatureDescriptor(base_ord, "base");
        putFeatureDescriptor(dot_ord, "dot");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(typeName_ord, "typeName");
        putFeatureDescriptor(type_ord, "type");
        putFeatureDescriptor(specifier_ord, "specifier");
        putFeatureDescriptor(capture_ord, "capture");
        putFeatureDescriptor(input_ord, "input");
        putFeatureDescriptor(throwsTok_ord, "throwsTok");
        putFeatureDescriptor(output_ord, "output");
        putFeatureDescriptor(signature_ord, "signature");
        putFeatureDescriptor(statements_ord, "statements");
        putFeatureDescriptor(pattern_ord, "pattern");
        putFeatureDescriptor(calledExpression_ord, "calledExpression");
        putFeatureDescriptor(argumentList_ord, "argumentList");
        putFeatureDescriptor(trailingClosure_ord, "trailingClosure");
        putFeatureDescriptor(openDelimiter_ord, "openDelimiter");
        putFeatureDescriptor(openQuote_ord, "openQuote");
        putFeatureDescriptor(segments_ord, "segments");
        putFeatureDescriptor(rootExpr_ord, "rootExpr");
        putFeatureDescriptor(kind_ord, "kind");
        putFeatureDescriptor(poundIdentifier_ord, "poundIdentifier");
        putFeatureDescriptor(arguments_ord, "arguments");
        putFeatureDescriptor(attributes_ord, "attributes");
        putFeatureDescriptor(modifiers_ord, "modifiers");
        putFeatureDescriptor(genericParameterClause_ord, "genericParameterClause");
        putFeatureDescriptor(initializer_ord, "initializer");
        putFeatureDescriptor(genericWhereClause_ord, "genericWhereClause");
        putFeatureDescriptor(inheritanceClause_ord, "inheritanceClause");
        putFeatureDescriptor(throwsOrRethrowsKeyword_ord, "throwsOrRethrowsKeyword");
        putFeatureDescriptor(poundKeyword_ord, "poundKeyword");
        putFeatureDescriptor(condition_ord, "condition");
        putFeatureDescriptor(elements_ord, "elements");
        putFeatureDescriptor(message_ord, "message");
        putFeatureDescriptor(args_ord, "args");
        putFeatureDescriptor(fileArgLabel_ord, "fileArgLabel");
        putFeatureDescriptor(fileName_ord, "fileName");
        putFeatureDescriptor(lineArgLabel_ord, "lineArgLabel");
        putFeatureDescriptor(lineNumber_ord, "lineNumber");
        putFeatureDescriptor(detail_ord, "detail");
        putFeatureDescriptor(members_ord, "members");
        putFeatureDescriptor(extendedType_ord, "extendedType");
        putFeatureDescriptor(firstName_ord, "firstName");
        putFeatureDescriptor(secondName_ord, "secondName");
        putFeatureDescriptor(ellipsis_ord, "ellipsis");
        putFeatureDescriptor(defaultArgument_ord, "defaultArgument");
        putFeatureDescriptor(functionIdentifier_ord, "functionIdentifier");
        putFeatureDescriptor(body_ord, "body");
        putFeatureDescriptor(optionalMark_ord, "optionalMark");
        putFeatureDescriptor(parameters_ord, "parameters");
        putFeatureDescriptor(indices_ord, "indices");
        putFeatureDescriptor(result_ord, "result");
        putFeatureDescriptor(accessor_ord, "accessor");
        putFeatureDescriptor(modifier_ord, "modifier");
        putFeatureDescriptor(importKind_ord, "importKind");
        putFeatureDescriptor(path_ord, "path");
        putFeatureDescriptor(accessorKind_ord, "accessorKind");
        putFeatureDescriptor(parameter_ord, "parameter");
        putFeatureDescriptor(typeAnnotation_ord, "typeAnnotation");
        putFeatureDescriptor(letOrVarKeyword_ord, "letOrVarKeyword");
        putFeatureDescriptor(bindings_ord, "bindings");
        putFeatureDescriptor(associatedValue_ord, "associatedValue");
        putFeatureDescriptor(rawValue_ord, "rawValue");
        putFeatureDescriptor(genericParameters_ord, "genericParameters");
        putFeatureDescriptor(operatorIdentifier_ord, "operatorIdentifier");
        putFeatureDescriptor(operatorPrecedenceAndTypes_ord, "operatorPrecedenceAndTypes");
        putFeatureDescriptor(groupAttributes_ord, "groupAttributes");
        putFeatureDescriptor(higherThanOrLowerThan_ord, "higherThanOrLowerThan");
        putFeatureDescriptor(otherNames_ord, "otherNames");
        putFeatureDescriptor(assignmentKeyword_ord, "assignmentKeyword");
        putFeatureDescriptor(flag_ord, "flag");
        putFeatureDescriptor(associativityKeyword_ord, "associativityKeyword");
        putFeatureDescriptor(value_ord, "value");
        putFeatureDescriptor(attributeName_ord, "attributeName");
        putFeatureDescriptor(argument_ord, "argument");
        putFeatureDescriptor(declBaseName_ord, "declBaseName");
        putFeatureDescriptor(nameTok_ord, "nameTok");
        putFeatureDescriptor(stringOrDeclname_ord, "stringOrDeclname");
        putFeatureDescriptor(labelName_ord, "labelName");
        putFeatureDescriptor(conditions_ord, "conditions");
        putFeatureDescriptor(unknownAttr_ord, "unknownAttr");
        putFeatureDescriptor(caseKeyword_ord, "caseKeyword");
        putFeatureDescriptor(sequenceExpr_ord, "sequenceExpr");
        putFeatureDescriptor(whereClause_ord, "whereClause");
        putFeatureDescriptor(cases_ord, "cases");
        putFeatureDescriptor(catchClauses_ord, "catchClauses");
        putFeatureDescriptor(yields_ord, "yields");
        putFeatureDescriptor(availabilitySpec_ord, "availabilitySpec");
        putFeatureDescriptor(elseBody_ord, "elseBody");
        putFeatureDescriptor(leftTypeIdentifier_ord, "leftTypeIdentifier");
        putFeatureDescriptor(equalityToken_ord, "equalityToken");
        putFeatureDescriptor(rightTypeIdentifier_ord, "rightTypeIdentifier");
        putFeatureDescriptor(inheritedType_ord, "inheritedType");
        putFeatureDescriptor(baseType_ord, "baseType");
        putFeatureDescriptor(period_ord, "period");
        putFeatureDescriptor(elementType_ord, "elementType");
        putFeatureDescriptor(keyType_ord, "keyType");
        putFeatureDescriptor(valueType_ord, "valueType");
        putFeatureDescriptor(typeOrProtocol_ord, "typeOrProtocol");
        putFeatureDescriptor(wrappedType_ord, "wrappedType");
        putFeatureDescriptor(someSpecifier_ord, "someSpecifier");
        putFeatureDescriptor(ampersand_ord, "ampersand");
        putFeatureDescriptor(inOut_ord, "inOut");
        putFeatureDescriptor(returnType_ord, "returnType");
        putFeatureDescriptor(caseName_ord, "caseName");
        putFeatureDescriptor(associatedTuple_ord, "associatedTuple");
        putFeatureDescriptor(subPattern_ord, "subPattern");
        putFeatureDescriptor(patternIdentifier_ord, "patternIdentifier");
        putFeatureDescriptor(valuePattern_ord, "valuePattern");
        putFeatureDescriptor(platform_ord, "platform");
        putFeatureDescriptor(version_ord, "version");
        putFeatureDescriptor(majorMinor_ord, "majorMinor");
        putFeatureDescriptor(patchVersion_ord, "patchVersion");
    }
    private static final long serialVersionUID = 1;
}
