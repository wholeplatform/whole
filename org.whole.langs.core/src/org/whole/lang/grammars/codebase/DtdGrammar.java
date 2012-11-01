package org.whole.lang.grammars.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class DtdGrammar extends AbstractTemplateFactory<org.whole.lang.grammars.model.Grammar> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.grammars.builders.IGrammarsBuilder b0 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
        b0.Grammar_();
        b0.Name("DtdGrammar");
        b0.URI("http://lang.whole.org/examples/Dtd");
        b0.NonTerminal("Dtd");
        b0.LiteralTerminal_();
        b0.RegExp("[ \\t\\r\\n]*");
        b0.Category("SEPARATOR");
        b0.Literal("");
        b0._LiteralTerminal();
        b0.Productions_(3);
        b0.Production_();
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0.Empty_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.SameStageFragment_();
        org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b2.Choose_(2);
        b2.If_();
        b2.ExpressionTest_();
        b1.SameStageFragment_();
        org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
        b3.InvokeJavaInstanceMethod_();
        b3.Text("contains double quotes?");
        b1.Resolver();
        b3.Variable("self");
        b1.Resolver();
        b3.StringLiteral("java.lang.String");
        b3.StringLiteral("contains(java.lang.CharSequence)");
        b3.Expressions_(1);
        b3.StringLiteral("\"");
        b3._Expressions();
        b3._InvokeJavaInstanceMethod();
        b1._SameStageFragment();
        b2._ExpressionTest();
        b2.StringLiteral("'");
        b2._If();
        b2.Do_();
        b2.StringLiteral("\"");
        b2._Do();
        b2._Choose();
        b1._SameStageFragment();
        b0._Empty();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("CHAR");
        b0.LiteralTerminal_();
        b0.RegExp("[\\t\\r\\n\\u0020-\\uD7FF]+");
        b0.Category("DELIMITER");
        b0.Literal(" ");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("STRING");
        b0.DataTerminal_();
        b0.RegExp("(?s).*");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b1.Resolver();
        b0._Production();
        b0._Productions();
        b0.Productions_(14);
        b0.Production_();
        b0.NonTerminal("Dtd");
        b0.Production_();
        b0.NonTerminal("Declarations");
        b0.Repeat_();
        b0.Size(0);
        b0.Unbounded();
        b0.NewLine();
        b0.Production_();
        b0.NonTerminal("DeclarationOrPEReference");
        b0.Choose_(2);
        b0.NonTerminal("PEReference");
        b0.Production_();
        b0.NonTerminal("Declaration");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("<!");
        b0.Category("DELIMITER");
        b0.Literal("<!");
        b0._LiteralTerminal();
        b0.Choose_(4);
        b0.Production_();
        b0.NonTerminal("Comment");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("--");
        b0.Category("DELIMITER");
        b0.Literal("--");
        b0._LiteralTerminal();
        b0.Split_();
        b0.ByDelimiter_();
        b0.RegExp("-->");
        b0._ByDelimiter();
        b0.DataTerminal_();
        b0.RegExp("(([^-][-]?)*[^-])|([^-]?)");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0._Split();
        b0.LiteralTerminal_();
        b0.RegExp("--");
        b0.Category("DELIMITER");
        b0.Literal("--");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Element");
        b0.Concatenate_(5);
        b0.LiteralTerminal_();
        b0.RegExp("ELEMENT");
        b0.Category("DELIMITER");
        b0.Literal("ELEMENT");
        b0._LiteralTerminal();
        b0.Space();
        b0.NonTerminal("Name");
        b0.Space();
        b0.NonTerminal("ContentSpec");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("AttList");
        b0.Concatenate_(5);
        b0.LiteralTerminal_();
        b0.RegExp("ATTLIST");
        b0.Category("DELIMITER");
        b0.Literal("ATTLIST");
        b0._LiteralTerminal();
        b0.Space();
        b0.NonTerminal("Name");
        b0.Space();
        b0.Production_();
        b0.NonTerminal("AttDefs");
        b0.Repeat_();
        b0.Size(0);
        b0.Unbounded();
        b1.Resolver();
        b0.Concatenate_(3);
        b0.NewLine();
        b0.Indent();
        b0.NonTerminal("AttDefOrPEReference");
        b0._Concatenate();
        b0._Repeat();
        b1.Resolver();
        b0._Production();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Entity");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("ENTITY");
        b0.Category("DELIMITER");
        b0.Literal("ENTITY");
        b0._LiteralTerminal();
        b0.Space();
        b0.NonTerminal("EntityDecl");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b0.LiteralTerminal_();
        b0.RegExp(">");
        b0.Category("DELIMITER");
        b0.Literal(">");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Repeat();
        b1.Resolver();
        b0._Production();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ContentSpec");
        b0.Choose_(6);
        b0.NonTerminal("PEReference");
        b0.Production_();
        b0.NonTerminal("Empty");
        b0.LiteralTerminal_();
        b0.RegExp("EMPTY");
        b0.Category("DELIMITER");
        b0.Literal("EMPTY");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Any");
        b0.LiteralTerminal_();
        b0.RegExp("ANY");
        b0.Category("DELIMITER");
        b0.Literal("ANY");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("PCData");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("#PCDATA");
        b0.Category("DELIMITER");
        b0.Literal("#PCDATA");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q)\\E");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Mixed");
        b0.Concatenate_(5);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("#PCDATA");
        b0.Category("DELIMITER");
        b0.Literal("#PCDATA");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q|\\E");
        b0.Category("DELIMITER");
        b0.Literal("|");
        b0._LiteralTerminal();
        b0.Production_();
        b0.NonTerminal("MixedParticles");
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q|\\E");
        b0.Category("DELIMITER");
        b0.Literal("|");
        b0._LiteralTerminal();
        b0.NonTerminal("NameOrPEReference");
        b0._Repeat();
        b1.Resolver();
        b0._Production();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q)*\\E");
        b0.Category("DELIMITER");
        b0.Literal(")*");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Children");
        b0.Concatenate_(2);
        b0.NonTerminal("Particle");
        b0.Optional_();
        b0.NonTerminal("Quantifier");
        b0._Optional();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("NameOrPEReference");
        b0.Choose_(2);
        b0.NonTerminal("PEReference");
        b0.NonTerminal("Name");
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("AttDefOrPEReference");
        b0.Choose_(2);
        b0.NonTerminal("PEReference");
        b0.Production_();
        b0.NonTerminal("AttDef");
        b0.Concatenate_(5);
        b0.NonTerminal("Name");
        b0.Space();
        b0.Production_();
        b0.NonTerminal("AttTypeOrEntityRef");
        b0.Choose_(2);
        b0.NonTerminal("PEReference");
        b0.Production_();
        b0.NonTerminal("AttType");
        b0.Choose_(4);
        b0.NonTerminal("TokenizedType");
        b0.Production_();
        b0.NonTerminal("StringType");
        b0.LiteralTerminal_();
        b0.RegExp("CDATA");
        b0.Category("DELIMITER");
        b0.Literal("CDATA");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("NotationType");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("NOTATION");
        b0.Category("DELIMITER");
        b0.Literal("NOTATION");
        b0._LiteralTerminal();
        b0.Space();
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q|\\E");
        b0.Category("DELIMITER");
        b0.Literal("|");
        b0._LiteralTerminal();
        b0.NonTerminal("Name");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q)\\E");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Enumeration");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q|\\E");
        b0.Category("DELIMITER");
        b0.Literal("|");
        b0._LiteralTerminal();
        b0.NonTerminal("Nmtoken");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q)\\E");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Space();
        b0.Production_();
        b0.NonTerminal("DefaultDecl");
        b0.Choose_(2);
        b0.Production_();
        b0.NonTerminal("SimpleDefaultDecl");
        b0.Choose_(2);
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("#IMPLIED");
        b0.Category("DELIMITER");
        b0.Literal("#IMPLIED");
        b0._LiteralTerminal();
        b0.Name("IMPLIED");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("#REQUIRED");
        b0.Category("DELIMITER");
        b0.Literal("#REQUIRED");
        b0._LiteralTerminal();
        b0.Name("REQUIRED");
        b0._As();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("FixedDefaultDecl");
        b0.Concatenate_(3);
        b0.Optional_();
        b0.LiteralTerminal_();
        b0.RegExp("#FIXED");
        b0.Category("DELIMITER");
        b0.Literal("#FIXED");
        b0._LiteralTerminal();
        b0._Optional();
        b0.Space();
        b0.NonTerminal("AttValue");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("TokenizedType");
        b0.Choose_(7);
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("IDREFS");
        b0.Category("DELIMITER");
        b0.Literal("IDREFS");
        b0._LiteralTerminal();
        b0.Name("IDREFS");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("IDREF");
        b0.Category("DELIMITER");
        b0.Literal("IDREF");
        b0._LiteralTerminal();
        b0.Name("IDREF");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("ID");
        b0.Category("DELIMITER");
        b0.Literal("ID");
        b0._LiteralTerminal();
        b0.Name("ID");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("ENTITIES");
        b0.Category("DELIMITER");
        b0.Literal("ENTITIES");
        b0._LiteralTerminal();
        b0.Name("ENTITIES");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("ENTITY");
        b0.Category("DELIMITER");
        b0.Literal("ENTITY");
        b0._LiteralTerminal();
        b0.Name("ENTITY");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("NMTOKENS");
        b0.Category("DELIMITER");
        b0.Literal("NMTOKENS");
        b0._LiteralTerminal();
        b0.Name("NMTOKENS");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("NMTOKEN");
        b0.Category("DELIMITER");
        b0.Literal("NMTOKEN");
        b0._LiteralTerminal();
        b0.Name("NMTOKEN");
        b0._As();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ContentParticle");
        b0.Concatenate_(2);
        b0.Production_();
        b0.NonTerminal("ParticleOrContent");
        b0.Choose_(2);
        b0.Production_();
        b0.NonTerminal("Particle");
        b0.Choose_(2);
        b0.Production_();
        b0.NonTerminal("Choice");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q|\\E");
        b0.Category("DELIMITER");
        b0.Literal("|");
        b0._LiteralTerminal();
        b0.NonTerminal("ContentParticle");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q)\\E");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Sequence");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(2);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp(",");
        b0.Category("DELIMITER");
        b0.Literal(",");
        b0._LiteralTerminal();
        b0.NonTerminal("ContentParticle");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q)\\E");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.NonTerminal("NameOrPEReference");
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Optional_();
        b0.Production_();
        b0.NonTerminal("Quantifier");
        b0.Choose_(3);
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q?\\E");
        b0.Category("DELIMITER");
        b0.Literal("?");
        b0._LiteralTerminal();
        b0.Name("OPTIONAL");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q*\\E");
        b0.Category("DELIMITER");
        b0.Literal("*");
        b0._LiteralTerminal();
        b0.Name("ZERO_OR_MORE");
        b0._As();
        b0.As_();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q+\\E");
        b0.Category("DELIMITER");
        b0.Literal("+");
        b0._LiteralTerminal();
        b0.Name("ONE_OR_MORE");
        b0._As();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Optional();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("EntityDecl");
        b0.Choose_(2);
        b0.Production_();
        b0.NonTerminal("PEDecl");
        b0.Concatenate_(5);
        b0.LiteralTerminal_();
        b0.RegExp("%");
        b0.Category("DELIMITER");
        b0.Literal("%");
        b0._LiteralTerminal();
        b0.Space();
        b0.NonTerminal("Name");
        b0.Space();
        b0.Production_();
        b0.NonTerminal("PEDef");
        b0.Choose_(2);
        b0.NonTerminal("EntityValue");
        b0.Production_();
        b0.NonTerminal("ExternalID");
        b0.Choose_(2);
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("SYSTEM");
        b0.Category("DELIMITER");
        b0.Literal("SYSTEM");
        b0._LiteralTerminal();
        b0.Space();
        b0.NonTerminal("SystemLiteral");
        b0._Concatenate();
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("PUBLIC");
        b0.Category("DELIMITER");
        b0.Literal("PUBLIC");
        b0._LiteralTerminal();
        b0.Space();
        b0.Production_();
        b0.NonTerminal("PublicID");
        b0.Concatenate_(3);
        b0.NonTerminal("PubidLiteral");
        b0.Space();
        b0.NonTerminal("SystemLiteral");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Concatenate();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("GEDecl");
        b0.Concatenate_(3);
        b0.NonTerminal("Name");
        b0.Space();
        b0.Production_();
        b0.NonTerminal("EntityDef");
        b0.Choose_(2);
        b0.NonTerminal("EntityValue");
        b0.Production_();
        b0.NonTerminal("ExtendedExternalID");
        b0.Concatenate_(2);
        b0.NonTerminal("ExternalID");
        b0.Optional_();
        b0.Production_();
        b0.NonTerminal("NDataDecl");
        b0.Concatenate_(4);
        b0.Space();
        b0.LiteralTerminal_();
        b0.RegExp("NDATA");
        b0.Category("DELIMITER");
        b0.Literal("NDATA");
        b0._LiteralTerminal();
        b0.Space();
        b0.NonTerminal("Name");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Optional();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Name");
        b0.DataTerminal_();
        b0.RegExp("[_:a-zA-Z\\u00C0-\\u00D6\\u00D8-\\u00F6][-\\._:a-zA-Z\\u00C0-\\u00D6\\u00D8-\\u00F60-9\\u00B7]*");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("PEReference");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("%");
        b0.Category("DELIMITER");
        b0.Literal("%");
        b0._LiteralTerminal();
        b0.NonTerminal("Name");
        b0.LiteralTerminal_();
        b0.RegExp(";");
        b0.Category("DELIMITER");
        b0.Literal(";");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Nmtoken");
        b0.DataTerminal_();
        b0.RegExp("[-\\._:a-zA-Z\\u00C0-\\u00D6\\u00D8-\\u00F60-9\\u00B7]+");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("AttValue");
        b0.Concatenate_(3);
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0.DataTerminal_();
        b0.RegExp("(?:\"([^\"]*)\")|(?:'([^']*)')");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("EntityValue");
        b0.Concatenate_(3);
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0.DataTerminal_();
        b0.RegExp("(?:\"([^\"]*)\")|(?:'([^']*)')");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("SystemLiteral");
        b0.Concatenate_(3);
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0.DataTerminal_();
        b0.RegExp("(?:\"([^\"]*)\")|(?:'([^']*)')");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("PubidLiteral");
        b0.Concatenate_(3);
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0.DataTerminal_();
        b0.RegExp("(?:\"([^\"]*)\")|(?:'([^']*)')");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0.NonTerminal("CONDITIONAL_QUOTE");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Productions();
        b0.URI("http://examples.whole.org/DtdGrammar");
        b0.Namespace("org.whole.examples.dtdgrammar");
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0._Grammar();
    }
}
