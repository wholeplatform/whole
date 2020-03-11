package org.whole.lang.swift.parsers;

import java.util.HashMap;
import java.util.Map;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.model.*;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;

public class SwiftDataTypeParser extends DefaultDataTypePersistenceParser {

    private static class SingletonHolder {
        private static final SwiftDataTypeParser instance = new SwiftDataTypeParser();
    }

    public static SwiftDataTypeParser instance() {
        return SingletonHolder.instance;
    }

    protected SwiftDataTypeParser() {
    }

    public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
        EnumValue enumValue = null;
        switch (ed.getOrdinal()) {
            case SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum_ord :
            enumValue = parseQuestionOrExclamationMarkEnum(value);
            break;
            case SwiftEntityDescriptorEnum.IdentifierEnum_ord :
            enumValue = parseIdentifierEnum(value);
            break;
            case SwiftEntityDescriptorEnum.DotEnum_ord :
            enumValue = parseDotEnum(value);
            break;
            case SwiftEntityDescriptorEnum.OpenQuoteEnum_ord :
            enumValue = parseOpenQuoteEnum(value);
            break;
            case SwiftEntityDescriptorEnum.KindValue_ord :
            enumValue = parseKindValue(value);
            break;
            case SwiftEntityDescriptorEnum.PoundIdentifierEnum_ord :
            enumValue = parsePoundIdentifierEnum(value);
            break;
            case SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum_ord :
            enumValue = parseThrowsOrRethrowsKeywordEnum(value);
            break;
            case SwiftEntityDescriptorEnum.PoundKeywordEnum_ord :
            enumValue = parsePoundKeywordEnum(value);
            break;
            case SwiftEntityDescriptorEnum.NameValue_ord :
            enumValue = parseNameValue(value);
            break;
            case SwiftEntityDescriptorEnum.OptionalMarkEnum_ord :
            enumValue = parseOptionalMarkEnum(value);
            break;
            case SwiftEntityDescriptorEnum.ImportKindEnum_ord :
            enumValue = parseImportKindEnum(value);
            break;
            case SwiftEntityDescriptorEnum.AccessorKindValue_ord :
            enumValue = parseAccessorKindValue(value);
            break;
            case SwiftEntityDescriptorEnum.LetOrVarKeywordEnum_ord :
            enumValue = parseLetOrVarKeywordEnum(value);
            break;
            case SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue_ord :
            enumValue = parseHigherThanOrLowerThanValue(value);
            break;
            case SwiftEntityDescriptorEnum.FlagEnum_ord :
            enumValue = parseFlagEnum(value);
            break;
            case SwiftEntityDescriptorEnum.ValueValue_ord :
            enumValue = parseValueValue(value);
            break;
            case SwiftEntityDescriptorEnum.NameEnum_ord :
            enumValue = parseNameEnum(value);
            break;
            case SwiftEntityDescriptorEnum.PeriodEnum_ord :
            enumValue = parsePeriodEnum(value);
            break;
            case SwiftEntityDescriptorEnum.TypeOrProtocolValue_ord :
            enumValue = parseTypeOrProtocolValue(value);
            break;
            case SwiftEntityDescriptorEnum.SpecifierValue_ord :
            enumValue = parseSpecifierValue(value);
            break;
        }
        if (enumValue != null)
            return enumValue;
        else
            return super.parseEnumValue(ed, value);
    }

    public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
        switch (ed.getOrdinal()) {
            case SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum_ord :
            return unparseQuestionOrExclamationMarkEnum(value);
            case SwiftEntityDescriptorEnum.IdentifierEnum_ord :
            return unparseIdentifierEnum(value);
            case SwiftEntityDescriptorEnum.DotEnum_ord :
            return unparseDotEnum(value);
            case SwiftEntityDescriptorEnum.OpenQuoteEnum_ord :
            return unparseOpenQuoteEnum(value);
            case SwiftEntityDescriptorEnum.KindValue_ord :
            return unparseKindValue(value);
            case SwiftEntityDescriptorEnum.PoundIdentifierEnum_ord :
            return unparsePoundIdentifierEnum(value);
            case SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum_ord :
            return unparseThrowsOrRethrowsKeywordEnum(value);
            case SwiftEntityDescriptorEnum.PoundKeywordEnum_ord :
            return unparsePoundKeywordEnum(value);
            case SwiftEntityDescriptorEnum.NameValue_ord :
            return unparseNameValue(value);
            case SwiftEntityDescriptorEnum.OptionalMarkEnum_ord :
            return unparseOptionalMarkEnum(value);
            case SwiftEntityDescriptorEnum.ImportKindEnum_ord :
            return unparseImportKindEnum(value);
            case SwiftEntityDescriptorEnum.AccessorKindValue_ord :
            return unparseAccessorKindValue(value);
            case SwiftEntityDescriptorEnum.LetOrVarKeywordEnum_ord :
            return unparseLetOrVarKeywordEnum(value);
            case SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue_ord :
            return unparseHigherThanOrLowerThanValue(value);
            case SwiftEntityDescriptorEnum.FlagEnum_ord :
            return unparseFlagEnum(value);
            case SwiftEntityDescriptorEnum.ValueValue_ord :
            return unparseValueValue(value);
            case SwiftEntityDescriptorEnum.NameEnum_ord :
            return unparseNameEnum(value);
            case SwiftEntityDescriptorEnum.PeriodEnum_ord :
            return unparsePeriodEnum(value);
            case SwiftEntityDescriptorEnum.TypeOrProtocolValue_ord :
            return unparseTypeOrProtocolValue(value);
            case SwiftEntityDescriptorEnum.SpecifierValue_ord :
            return unparseSpecifierValue(value);
            default :
            return super.unparseEnumValue(ed, value);
        }
    }

    public static final String unparseQuestionOrExclamationMarkEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case QuestionOrExclamationMarkEnumEnum.PostfixQuestionMark_ord :
            return "?";
            case QuestionOrExclamationMarkEnumEnum.ExclamationMark_ord :
            return "!";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, QuestionOrExclamationMarkEnumEnum.Value> questionOrExclamationMarkEnumMap;

    public static final QuestionOrExclamationMarkEnumEnum.Value parseQuestionOrExclamationMarkEnum(String value) {
        if (questionOrExclamationMarkEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (questionOrExclamationMarkEnumMap == null) {
                    questionOrExclamationMarkEnumMap = new HashMap<String, QuestionOrExclamationMarkEnumEnum.Value>();
                    questionOrExclamationMarkEnumMap.put("?", QuestionOrExclamationMarkEnumEnum.PostfixQuestionMark);
                    questionOrExclamationMarkEnumMap.put("!", QuestionOrExclamationMarkEnumEnum.ExclamationMark);
                    assert QuestionOrExclamationMarkEnumEnum.instance.size() == questionOrExclamationMarkEnumMap.size();
                }
            }
        }
        return questionOrExclamationMarkEnumMap.get(value);
    }

    public static final String unparseIdentifierEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case IdentifierEnumEnum.Self_ord :
            return "self";
            case IdentifierEnumEnum.CapitalSelf_ord :
            return "Self";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, IdentifierEnumEnum.Value> identifierEnumMap;

    public static final IdentifierEnumEnum.Value parseIdentifierEnum(String value) {
        if (identifierEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (identifierEnumMap == null) {
                    identifierEnumMap = new HashMap<String, IdentifierEnumEnum.Value>();
                    identifierEnumMap.put("self", IdentifierEnumEnum.Self);
                    identifierEnumMap.put("Self", IdentifierEnumEnum.CapitalSelf);
                    assert IdentifierEnumEnum.instance.size() == identifierEnumMap.size();
                }
            }
        }
        return identifierEnumMap.get(value);
    }

    public static final String unparseDotEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case DotEnumEnum.Period_ord :
            return ".";
            case DotEnumEnum.PrefixPeriod_ord :
            return ".";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, DotEnumEnum.Value> dotEnumMap;

    public static final DotEnumEnum.Value parseDotEnum(String value) {
        if (dotEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (dotEnumMap == null) {
                    dotEnumMap = new HashMap<String, DotEnumEnum.Value>();
                    dotEnumMap.put(".", DotEnumEnum.Period);
                    dotEnumMap.put(".", DotEnumEnum.PrefixPeriod);
                    assert DotEnumEnum.instance.size() == dotEnumMap.size();
                }
            }
        }
        return dotEnumMap.get(value);
    }

    public static final String unparseOpenQuoteEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case OpenQuoteEnumEnum.StringQuote_ord :
            return "\"";
            case OpenQuoteEnumEnum.MultilineStringQuote_ord :
            return "\"\"\"";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, OpenQuoteEnumEnum.Value> openQuoteEnumMap;

    public static final OpenQuoteEnumEnum.Value parseOpenQuoteEnum(String value) {
        if (openQuoteEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (openQuoteEnumMap == null) {
                    openQuoteEnumMap = new HashMap<String, OpenQuoteEnumEnum.Value>();
                    openQuoteEnumMap.put("\"", OpenQuoteEnumEnum.StringQuote);
                    openQuoteEnumMap.put("\"\"\"", OpenQuoteEnumEnum.MultilineStringQuote);
                    assert OpenQuoteEnumEnum.instance.size() == openQuoteEnumMap.size();
                }
            }
        }
        return openQuoteEnumMap.get(value);
    }

    public static final String unparseKindValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case KindValueEnum.getter_ord :
            return "getter";
            case KindValueEnum.setter_ord :
            return "setter";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, KindValueEnum.Value> kindValueMap;

    public static final KindValueEnum.Value parseKindValue(String value) {
        if (kindValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (kindValueMap == null) {
                    kindValueMap = new HashMap<String, KindValueEnum.Value>();
                    kindValueMap.put("getter", KindValueEnum.getter);
                    kindValueMap.put("setter", KindValueEnum.setter);
                    assert KindValueEnum.instance.size() == kindValueMap.size();
                }
            }
        }
        return kindValueMap.get(value);
    }

    public static final String unparsePoundIdentifierEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case PoundIdentifierEnumEnum.PoundColorLiteral_ord :
            return "#colorLiteral";
            case PoundIdentifierEnumEnum.PoundFileLiteral_ord :
            return "#fileLiteral";
            case PoundIdentifierEnumEnum.PoundImageLiteral_ord :
            return "#imageLiteral";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, PoundIdentifierEnumEnum.Value> poundIdentifierEnumMap;

    public static final PoundIdentifierEnumEnum.Value parsePoundIdentifierEnum(String value) {
        if (poundIdentifierEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (poundIdentifierEnumMap == null) {
                    poundIdentifierEnumMap = new HashMap<String, PoundIdentifierEnumEnum.Value>();
                    poundIdentifierEnumMap.put("#colorLiteral", PoundIdentifierEnumEnum.PoundColorLiteral);
                    poundIdentifierEnumMap.put("#fileLiteral", PoundIdentifierEnumEnum.PoundFileLiteral);
                    poundIdentifierEnumMap.put("#imageLiteral", PoundIdentifierEnumEnum.PoundImageLiteral);
                    assert PoundIdentifierEnumEnum.instance.size() == poundIdentifierEnumMap.size();
                }
            }
        }
        return poundIdentifierEnumMap.get(value);
    }

    public static final String unparseThrowsOrRethrowsKeywordEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case ThrowsOrRethrowsKeywordEnumEnum.Throws_ord :
            return "throws";
            case ThrowsOrRethrowsKeywordEnumEnum.Rethrows_ord :
            return "rethrows";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, ThrowsOrRethrowsKeywordEnumEnum.Value> throwsOrRethrowsKeywordEnumMap;

    public static final ThrowsOrRethrowsKeywordEnumEnum.Value parseThrowsOrRethrowsKeywordEnum(String value) {
        if (throwsOrRethrowsKeywordEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (throwsOrRethrowsKeywordEnumMap == null) {
                    throwsOrRethrowsKeywordEnumMap = new HashMap<String, ThrowsOrRethrowsKeywordEnumEnum.Value>();
                    throwsOrRethrowsKeywordEnumMap.put("throws", ThrowsOrRethrowsKeywordEnumEnum.Throws);
                    throwsOrRethrowsKeywordEnumMap.put("rethrows", ThrowsOrRethrowsKeywordEnumEnum.Rethrows);
                    assert ThrowsOrRethrowsKeywordEnumEnum.instance.size() == throwsOrRethrowsKeywordEnumMap.size();
                }
            }
        }
        return throwsOrRethrowsKeywordEnumMap.get(value);
    }

    public static final String unparsePoundKeywordEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case PoundKeywordEnumEnum.PoundIf_ord :
            return "#if";
            case PoundKeywordEnumEnum.PoundElseif_ord :
            return "#elseif";
            case PoundKeywordEnumEnum.PoundElse_ord :
            return "#else";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, PoundKeywordEnumEnum.Value> poundKeywordEnumMap;

    public static final PoundKeywordEnumEnum.Value parsePoundKeywordEnum(String value) {
        if (poundKeywordEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (poundKeywordEnumMap == null) {
                    poundKeywordEnumMap = new HashMap<String, PoundKeywordEnumEnum.Value>();
                    poundKeywordEnumMap.put("#if", PoundKeywordEnumEnum.PoundIf);
                    poundKeywordEnumMap.put("#elseif", PoundKeywordEnumEnum.PoundElseif);
                    poundKeywordEnumMap.put("#else", PoundKeywordEnumEnum.PoundElse);
                    assert PoundKeywordEnumEnum.instance.size() == poundKeywordEnumMap.size();
                }
            }
        }
        return poundKeywordEnumMap.get(value);
    }

    public static final String unparseNameValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case NameValueEnum._class_ord :
            return "class";
            case NameValueEnum.convenience_ord :
            return "convenience";
            case NameValueEnum.dynamic_ord :
            return "dynamic";
            case NameValueEnum._final_ord :
            return "final";
            case NameValueEnum.infix_ord :
            return "infix";
            case NameValueEnum.lazy_ord :
            return "lazy";
            case NameValueEnum.optional_ord :
            return "optional";
            case NameValueEnum.override_ord :
            return "override";
            case NameValueEnum.postfix_ord :
            return "postfix";
            case NameValueEnum.prefix_ord :
            return "prefix";
            case NameValueEnum.required_ord :
            return "required";
            case NameValueEnum._static_ord :
            return "static";
            case NameValueEnum.unowned_ord :
            return "unowned";
            case NameValueEnum.weak_ord :
            return "weak";
            case NameValueEnum._private_ord :
            return "private";
            case NameValueEnum.fileprivate_ord :
            return "fileprivate";
            case NameValueEnum.internal_ord :
            return "internal";
            case NameValueEnum._public_ord :
            return "public";
            case NameValueEnum.open_ord :
            return "open";
            case NameValueEnum.mutating_ord :
            return "mutating";
            case NameValueEnum.nonmutating_ord :
            return "nonmutating";
            case NameValueEnum.indirect_ord :
            return "indirect";
            case NameValueEnum.__consuming_ord :
            return "__consuming";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, NameValueEnum.Value> nameValueMap;

    public static final NameValueEnum.Value parseNameValue(String value) {
        if (nameValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (nameValueMap == null) {
                    nameValueMap = new HashMap<String, NameValueEnum.Value>();
                    nameValueMap.put("class", NameValueEnum._class);
                    nameValueMap.put("convenience", NameValueEnum.convenience);
                    nameValueMap.put("dynamic", NameValueEnum.dynamic);
                    nameValueMap.put("final", NameValueEnum._final);
                    nameValueMap.put("infix", NameValueEnum.infix);
                    nameValueMap.put("lazy", NameValueEnum.lazy);
                    nameValueMap.put("optional", NameValueEnum.optional);
                    nameValueMap.put("override", NameValueEnum.override);
                    nameValueMap.put("postfix", NameValueEnum.postfix);
                    nameValueMap.put("prefix", NameValueEnum.prefix);
                    nameValueMap.put("required", NameValueEnum.required);
                    nameValueMap.put("static", NameValueEnum._static);
                    nameValueMap.put("unowned", NameValueEnum.unowned);
                    nameValueMap.put("weak", NameValueEnum.weak);
                    nameValueMap.put("private", NameValueEnum._private);
                    nameValueMap.put("fileprivate", NameValueEnum.fileprivate);
                    nameValueMap.put("internal", NameValueEnum.internal);
                    nameValueMap.put("public", NameValueEnum._public);
                    nameValueMap.put("open", NameValueEnum.open);
                    nameValueMap.put("mutating", NameValueEnum.mutating);
                    nameValueMap.put("nonmutating", NameValueEnum.nonmutating);
                    nameValueMap.put("indirect", NameValueEnum.indirect);
                    nameValueMap.put("__consuming", NameValueEnum.__consuming);
                    assert NameValueEnum.instance.size() == nameValueMap.size();
                }
            }
        }
        return nameValueMap.get(value);
    }

    public static final String unparseOptionalMarkEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case OptionalMarkEnumEnum.PostfixQuestionMark_ord :
            return "?";
            case OptionalMarkEnumEnum.InfixQuestionMark_ord :
            return "?";
            case OptionalMarkEnumEnum.ExclamationMark_ord :
            return "!";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, OptionalMarkEnumEnum.Value> optionalMarkEnumMap;

    public static final OptionalMarkEnumEnum.Value parseOptionalMarkEnum(String value) {
        if (optionalMarkEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (optionalMarkEnumMap == null) {
                    optionalMarkEnumMap = new HashMap<String, OptionalMarkEnumEnum.Value>();
                    optionalMarkEnumMap.put("?", OptionalMarkEnumEnum.PostfixQuestionMark);
                    optionalMarkEnumMap.put("?", OptionalMarkEnumEnum.InfixQuestionMark);
                    optionalMarkEnumMap.put("!", OptionalMarkEnumEnum.ExclamationMark);
                    assert OptionalMarkEnumEnum.instance.size() == optionalMarkEnumMap.size();
                }
            }
        }
        return optionalMarkEnumMap.get(value);
    }

    public static final String unparseImportKindEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case ImportKindEnumEnum.Typealias_ord :
            return "typealias";
            case ImportKindEnumEnum.Struct_ord :
            return "struct";
            case ImportKindEnumEnum.Class_ord :
            return "class";
            case ImportKindEnumEnum.Enum_ord :
            return "enum";
            case ImportKindEnumEnum.Protocol_ord :
            return "protocol";
            case ImportKindEnumEnum.Var_ord :
            return "var";
            case ImportKindEnumEnum.Let_ord :
            return "let";
            case ImportKindEnumEnum.Func_ord :
            return "func";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, ImportKindEnumEnum.Value> importKindEnumMap;

    public static final ImportKindEnumEnum.Value parseImportKindEnum(String value) {
        if (importKindEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (importKindEnumMap == null) {
                    importKindEnumMap = new HashMap<String, ImportKindEnumEnum.Value>();
                    importKindEnumMap.put("typealias", ImportKindEnumEnum.Typealias);
                    importKindEnumMap.put("struct", ImportKindEnumEnum.Struct);
                    importKindEnumMap.put("class", ImportKindEnumEnum.Class);
                    importKindEnumMap.put("enum", ImportKindEnumEnum.Enum);
                    importKindEnumMap.put("protocol", ImportKindEnumEnum.Protocol);
                    importKindEnumMap.put("var", ImportKindEnumEnum.Var);
                    importKindEnumMap.put("let", ImportKindEnumEnum.Let);
                    importKindEnumMap.put("func", ImportKindEnumEnum.Func);
                    assert ImportKindEnumEnum.instance.size() == importKindEnumMap.size();
                }
            }
        }
        return importKindEnumMap.get(value);
    }

    public static final String unparseAccessorKindValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case AccessorKindValueEnum.get_ord :
            return "get";
            case AccessorKindValueEnum.set_ord :
            return "set";
            case AccessorKindValueEnum.didSet_ord :
            return "didSet";
            case AccessorKindValueEnum.willSet_ord :
            return "willSet";
            case AccessorKindValueEnum.unsafeAddress_ord :
            return "unsafeAddress";
            case AccessorKindValueEnum.addressWithOwner_ord :
            return "addressWithOwner";
            case AccessorKindValueEnum.addressWithNativeOwner_ord :
            return "addressWithNativeOwner";
            case AccessorKindValueEnum.unsafeMutableAddress_ord :
            return "unsafeMutableAddress";
            case AccessorKindValueEnum.mutableAddressWithOwner_ord :
            return "mutableAddressWithOwner";
            case AccessorKindValueEnum.mutableAddressWithNativeOwner_ord :
            return "mutableAddressWithNativeOwner";
            case AccessorKindValueEnum._read_ord :
            return "_read";
            case AccessorKindValueEnum._modify_ord :
            return "_modify";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, AccessorKindValueEnum.Value> accessorKindValueMap;

    public static final AccessorKindValueEnum.Value parseAccessorKindValue(String value) {
        if (accessorKindValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (accessorKindValueMap == null) {
                    accessorKindValueMap = new HashMap<String, AccessorKindValueEnum.Value>();
                    accessorKindValueMap.put("get", AccessorKindValueEnum.get);
                    accessorKindValueMap.put("set", AccessorKindValueEnum.set);
                    accessorKindValueMap.put("didSet", AccessorKindValueEnum.didSet);
                    accessorKindValueMap.put("willSet", AccessorKindValueEnum.willSet);
                    accessorKindValueMap.put("unsafeAddress", AccessorKindValueEnum.unsafeAddress);
                    accessorKindValueMap.put("addressWithOwner", AccessorKindValueEnum.addressWithOwner);
                    accessorKindValueMap.put("addressWithNativeOwner", AccessorKindValueEnum.addressWithNativeOwner);
                    accessorKindValueMap.put("unsafeMutableAddress", AccessorKindValueEnum.unsafeMutableAddress);
                    accessorKindValueMap.put("mutableAddressWithOwner", AccessorKindValueEnum.mutableAddressWithOwner);
                    accessorKindValueMap.put("mutableAddressWithNativeOwner", AccessorKindValueEnum.mutableAddressWithNativeOwner);
                    accessorKindValueMap.put("_read", AccessorKindValueEnum._read);
                    accessorKindValueMap.put("_modify", AccessorKindValueEnum._modify);
                    assert AccessorKindValueEnum.instance.size() == accessorKindValueMap.size();
                }
            }
        }
        return accessorKindValueMap.get(value);
    }

    public static final String unparseLetOrVarKeywordEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case LetOrVarKeywordEnumEnum.Let_ord :
            return "let";
            case LetOrVarKeywordEnumEnum.Var_ord :
            return "var";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, LetOrVarKeywordEnumEnum.Value> letOrVarKeywordEnumMap;

    public static final LetOrVarKeywordEnumEnum.Value parseLetOrVarKeywordEnum(String value) {
        if (letOrVarKeywordEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (letOrVarKeywordEnumMap == null) {
                    letOrVarKeywordEnumMap = new HashMap<String, LetOrVarKeywordEnumEnum.Value>();
                    letOrVarKeywordEnumMap.put("let", LetOrVarKeywordEnumEnum.Let);
                    letOrVarKeywordEnumMap.put("var", LetOrVarKeywordEnumEnum.Var);
                    assert LetOrVarKeywordEnumEnum.instance.size() == letOrVarKeywordEnumMap.size();
                }
            }
        }
        return letOrVarKeywordEnumMap.get(value);
    }

    public static final String unparseHigherThanOrLowerThanValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case HigherThanOrLowerThanValueEnum.higherThan_ord :
            return "higherThan";
            case HigherThanOrLowerThanValueEnum.lowerThan_ord :
            return "lowerThan";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, HigherThanOrLowerThanValueEnum.Value> higherThanOrLowerThanValueMap;

    public static final HigherThanOrLowerThanValueEnum.Value parseHigherThanOrLowerThanValue(String value) {
        if (higherThanOrLowerThanValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (higherThanOrLowerThanValueMap == null) {
                    higherThanOrLowerThanValueMap = new HashMap<String, HigherThanOrLowerThanValueEnum.Value>();
                    higherThanOrLowerThanValueMap.put("higherThan", HigherThanOrLowerThanValueEnum.higherThan);
                    higherThanOrLowerThanValueMap.put("lowerThan", HigherThanOrLowerThanValueEnum.lowerThan);
                    assert HigherThanOrLowerThanValueEnum.instance.size() == higherThanOrLowerThanValueMap.size();
                }
            }
        }
        return higherThanOrLowerThanValueMap.get(value);
    }

    public static final String unparseFlagEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case FlagEnumEnum.True_ord :
            return "true";
            case FlagEnumEnum.False_ord :
            return "false";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, FlagEnumEnum.Value> flagEnumMap;

    public static final FlagEnumEnum.Value parseFlagEnum(String value) {
        if (flagEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (flagEnumMap == null) {
                    flagEnumMap = new HashMap<String, FlagEnumEnum.Value>();
                    flagEnumMap.put("true", FlagEnumEnum.True);
                    flagEnumMap.put("false", FlagEnumEnum.False);
                    assert FlagEnumEnum.instance.size() == flagEnumMap.size();
                }
            }
        }
        return flagEnumMap.get(value);
    }

    public static final String unparseValueValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case ValueValueEnum.left_ord :
            return "left";
            case ValueValueEnum.right_ord :
            return "right";
            case ValueValueEnum.none_ord :
            return "none";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, ValueValueEnum.Value> valueValueMap;

    public static final ValueValueEnum.Value parseValueValue(String value) {
        if (valueValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (valueValueMap == null) {
                    valueValueMap = new HashMap<String, ValueValueEnum.Value>();
                    valueValueMap.put("left", ValueValueEnum.left);
                    valueValueMap.put("right", ValueValueEnum.right);
                    valueValueMap.put("none", ValueValueEnum.none);
                    assert ValueValueEnum.instance.size() == valueValueMap.size();
                }
            }
        }
        return valueValueMap.get(value);
    }

    public static final String unparseNameEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case NameEnumEnum.CapitalSelf_ord :
            return "Self";
            case NameEnumEnum.Any_ord :
            return "Any";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, NameEnumEnum.Value> nameEnumMap;

    public static final NameEnumEnum.Value parseNameEnum(String value) {
        if (nameEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (nameEnumMap == null) {
                    nameEnumMap = new HashMap<String, NameEnumEnum.Value>();
                    nameEnumMap.put("Self", NameEnumEnum.CapitalSelf);
                    nameEnumMap.put("Any", NameEnumEnum.Any);
                    assert NameEnumEnum.instance.size() == nameEnumMap.size();
                }
            }
        }
        return nameEnumMap.get(value);
    }

    public static final String unparsePeriodEnum(EnumValue value) {
        switch (value.getOrdinal()) {
            case PeriodEnumEnum.Period_ord :
            return ".";
            case PeriodEnumEnum.PrefixPeriod_ord :
            return ".";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, PeriodEnumEnum.Value> periodEnumMap;

    public static final PeriodEnumEnum.Value parsePeriodEnum(String value) {
        if (periodEnumMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (periodEnumMap == null) {
                    periodEnumMap = new HashMap<String, PeriodEnumEnum.Value>();
                    periodEnumMap.put(".", PeriodEnumEnum.Period);
                    periodEnumMap.put(".", PeriodEnumEnum.PrefixPeriod);
                    assert PeriodEnumEnum.instance.size() == periodEnumMap.size();
                }
            }
        }
        return periodEnumMap.get(value);
    }

    public static final String unparseTypeOrProtocolValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case TypeOrProtocolValueEnum.Type_ord :
            return "Type";
            case TypeOrProtocolValueEnum.Protocol_ord :
            return "Protocol";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, TypeOrProtocolValueEnum.Value> typeOrProtocolValueMap;

    public static final TypeOrProtocolValueEnum.Value parseTypeOrProtocolValue(String value) {
        if (typeOrProtocolValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (typeOrProtocolValueMap == null) {
                    typeOrProtocolValueMap = new HashMap<String, TypeOrProtocolValueEnum.Value>();
                    typeOrProtocolValueMap.put("Type", TypeOrProtocolValueEnum.Type);
                    typeOrProtocolValueMap.put("Protocol", TypeOrProtocolValueEnum.Protocol);
                    assert TypeOrProtocolValueEnum.instance.size() == typeOrProtocolValueMap.size();
                }
            }
        }
        return typeOrProtocolValueMap.get(value);
    }

    public static final String unparseSpecifierValue(EnumValue value) {
        switch (value.getOrdinal()) {
            case SpecifierValueEnum.inout_ord :
            return "inout";
            case SpecifierValueEnum.__shared_ord :
            return "__shared";
            case SpecifierValueEnum.__owned_ord :
            return "__owned";
            default :
            throw new IllegalArgumentException();
        }
    }
    private static volatile Map<String, SpecifierValueEnum.Value> specifierValueMap;

    public static final SpecifierValueEnum.Value parseSpecifierValue(String value) {
        if (specifierValueMap == null) {
            synchronized (SwiftDataTypeParser.class) {
                if (specifierValueMap == null) {
                    specifierValueMap = new HashMap<String, SpecifierValueEnum.Value>();
                    specifierValueMap.put("inout", SpecifierValueEnum.inout);
                    specifierValueMap.put("__shared", SpecifierValueEnum.__shared);
                    specifierValueMap.put("__owned", SpecifierValueEnum.__owned);
                    assert SpecifierValueEnum.instance.size() == specifierValueMap.size();
                }
            }
        }
        return specifierValueMap.get(value);
    }
}
