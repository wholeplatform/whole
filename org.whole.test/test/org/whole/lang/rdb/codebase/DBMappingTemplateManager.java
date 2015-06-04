package org.whole.lang.rdb.codebase;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class DBMappingTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final DBMappingTemplateManager instance = new DBMappingTemplateManager();
    }

    public static DBMappingTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private DBMappingTemplateManager() {
        put("populateDB", newPopulateDB());
        put("mapAuthorsResults", newMapAuthorsResults());
        put("mapAuthorsQuery", newMapAuthorsQuery());
        put("mapAuthorsQuery2", newMapAuthorsQuery2());
        put("mapAuthorsQuery3", newMapAuthorsQuery3());
        put("mapAuthorsQueryWithNestedVar", newMapAuthorsQueryWithNestedVar());
        put("populateDatatypesDB", newPopulateDatatypesDB());
        put("selectDatatypesDBResults", newSelectDatatypesDBResults());
        put("selectDatatypesDB", newSelectDatatypesDB());
    }

    public ITemplateFactory<IEntity> newPopulateDB() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.sql.builders.ISQLBuilder b0 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b0.SQLStatements_(4);
                b0.Insert_();
                b0.TableName("AUTHOR");
                b0.ColumnNames_(3);
                b0.ColumnName("AUTHOR_ID");
                b0.ColumnName("FIRST_NAME");
                b0.ColumnName("LAST_NAME");
                b0._ColumnNames();
                b0.Values_(1);
                b0.SQLExpressions_(3);
                b0.IntValue(1);
                b0.StringValue("Enrico");
                b0.StringValue("Persiani");
                b0._SQLExpressions();
                b0._Values();
                b0._Insert();
                b0.Insert_();
                b0.TableName("AUTHOR");
                b0.ColumnNames_(3);
                b0.ColumnName("AUTHOR_ID");
                b0.ColumnName("FIRST_NAME");
                b0.ColumnName("LAST_NAME");
                b0._ColumnNames();
                b0.Values_(1);
                b0.SQLExpressions_(3);
                b0.IntValue(0);
                b0.StringValue("Riccardo");
                b0.StringValue("Solmi");
                b0._SQLExpressions();
                b0._Values();
                b0._Insert();
                b0.Insert_();
                b0.TableName("PUBLISHER");
                b0.ColumnNames_(3);
                b0.ColumnName("PUBLISHER_ID");
                b0.ColumnName("PUBSECOND_ID");
                b0.ColumnName("NAME");
                b0._ColumnNames();
                b0.Values_(1);
                b0.SQLExpressions_(3);
                b0.IntValue(0);
                b0.IntValue(0);
                b0.StringValue("Publisher");
                b0._SQLExpressions();
                b0._Values();
                b0._Insert();
                b0.Insert_();
                b0.TableName("BOOK");
                b0.ColumnNames_(6);
                b0.ColumnName("BOOK_ID");
                b0.ColumnName("TITLE");
                b0.ColumnName("ISBN");
                b0.ColumnName("MYPUBLISHER_ID");
                b0.ColumnName("MYPUBSECOND_ID");
                b0.ColumnName("AUTHOR_ID");
                b0._ColumnNames();
                b0.Values_(1);
                b0.SQLExpressions_(6);
                b0.IntValue(0);
                b0.StringValue("Whole Platform Examples");
                b0.StringValue("ISBN_CODE");
                b0.IntValue(0);
                b0.IntValue(0);
                b0.IntValue(1);
                b0._SQLExpressions();
                b0._Values();
                b0._Insert();
                b0._SQLStatements();
            }
        };
    }

    public ITemplateFactory<IEntity> newMapAuthorsResults() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Sequence_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("author");
                b2.Attributes_(2);
                b2.Attribute_();
                b2.Name("first_name");
                b2.Value("Riccardo");
                b2._Attribute();
                b2.Attribute_();
                b2.Name("last_name");
                b2.Value("Solmi");
                b2._Attribute();
                b2._Attributes();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("author");
                b2.Attributes_(2);
                b2.Attribute_();
                b2.Name("first_name");
                b2.Value("Enrico");
                b2._Attribute();
                b2.Attribute_();
                b2.Name("last_name");
                b2.Value("Persiani");
                b2._Attribute();
                b2._Attributes();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newMapAuthorsQuery() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("author");
                b2.Attributes_(2);
                b2.Attribute_();
                b2.Name("first_name");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Xml#Value");
                b1.VarName("fname");
                b1.Quantifier("!");
                b1._Variable();
                b2._Attribute();
                b2.Attribute_();
                b2.Name("last_name");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Xml#Value");
                b1.VarName("lname");
                b1.Quantifier("!");
                b1._Variable();
                b2._Attribute();
                b2._Attributes();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.SameStageFragment_();
                org.whole.lang.sql.builders.ISQLBuilder b3 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b3.Select_();
                b1.Resolver();
                b3.ColumnExpressions_(2);
                b3.ColumnExpression_();
                b3.ColumnName("FIRST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3.ColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3._ColumnExpressions();
                b3.FromClauses_(1);
                b3.SimpleFromClause("AUTHOR");
                b3._FromClauses();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3.OrderByColumnExpressions_(1);
                b3.OrderByColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b3.OrderType("DESC");
                b3._OrderByColumnExpression();
                b3._OrderByColumnExpressions();
                b3._Select();
                b1._SameStageFragment();
                b0.Sequence_(2);
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0.VariableTest("fname");
                b0._And();
                b0._Filter();
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.IndexTest_();
                b0.IntLiteral(1);
                b0._IndexTest();
                b0.VariableTest("lname");
                b0._And();
                b0._Filter();
                b0._Sequence();
                b0._Select();
            }
        };
    }

    public ITemplateFactory<IEntity> newMapAuthorsQuery2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("author");
                b2.Attributes_(2);
                b2.Attribute_();
                b2.Name("first_name");
                b1.StageDownFragment_();
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b1._StageDownFragment();
                b2._Attribute();
                b2.Attribute_();
                b2.Name("last_name");
                b1.StageDownFragment_();
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(1);
                b0._IndexTest();
                b0._Filter();
                b1._StageDownFragment();
                b2._Attribute();
                b2._Attributes();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.SameStageFragment_();
                org.whole.lang.sql.builders.ISQLBuilder b3 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b3.Select_();
                b1.Resolver();
                b3.ColumnExpressions_(2);
                b3.ColumnExpression_();
                b3.ColumnName("FIRST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3.ColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3._ColumnExpressions();
                b3.FromClauses_(1);
                b3.SimpleFromClause("AUTHOR");
                b3._FromClauses();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3.OrderByColumnExpressions_(1);
                b3.OrderByColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b3.OrderType("DESC");
                b3._OrderByColumnExpression();
                b3._OrderByColumnExpressions();
                b3._Select();
                b1._SameStageFragment();
                b1.Resolver();
                b0._Select();
            }
        };
    }

    public ITemplateFactory<IEntity> newMapAuthorsQuery3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("author");
                b2.Attributes_(2);
                b2.Attribute_();
                b2.Name("first_name");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Xml#Value");
                b1.VarName("fname");
                b1.Quantifier("!");
                b1._Variable();
                b2._Attribute();
                b2.Attribute_();
                b2.Name("last_name");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Xml#Value");
                b1.VarName("LAST_NAME");
                b1.Quantifier("!");
                b1._Variable();
                b2._Attribute();
                b2._Attributes();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.SameStageFragment_();
                org.whole.lang.sql.builders.ISQLBuilder b3 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b3.Select_();
                b1.Resolver();
                b3.ColumnExpressions_(2);
                b3.ColumnExpression_();
                b3.ColumnName("FIRST_NAME");
                b3.Alias("fname");
                b3._ColumnExpression();
                b3.ColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3._ColumnExpressions();
                b3.FromClauses_(1);
                b3.SimpleFromClause("AUTHOR");
                b3._FromClauses();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3.OrderByColumnExpressions_(1);
                b3.OrderByColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b3.OrderType("DESC");
                b3._OrderByColumnExpression();
                b3._OrderByColumnExpressions();
                b3._Select();
                b1._SameStageFragment();
                b1.Resolver();
                b0._Select();
            }
        };
    }

    public ITemplateFactory<IEntity> newMapAuthorsQueryWithNestedVar() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.Filter_();
                b0.StringLiteral("Solmi");
                b0.VariableTest("lastName");
                b0._Filter();
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("author");
                b2.Attributes_(2);
                b2.Attribute_();
                b2.Name("first_name");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Xml#Value");
                b1.VarName("fname");
                b1.Quantifier("!");
                b1._Variable();
                b2._Attribute();
                b2.Attribute_();
                b2.Name("last_name");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Xml#Value");
                b1.VarName("lname");
                b1.Quantifier("!");
                b1._Variable();
                b2._Attribute();
                b2._Attributes();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.SameStageFragment_();
                org.whole.lang.sql.builders.ISQLBuilder b3 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b3.Select_();
                b1.Resolver();
                b3.ColumnExpressions_(2);
                b3.ColumnExpression_();
                b3.ColumnName("FIRST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3.ColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b1.Resolver();
                b3._ColumnExpression();
                b3._ColumnExpressions();
                b3.FromClauses_(1);
                b3.SimpleFromClause("AUTHOR");
                b3._FromClauses();
                b3.BooleanBinaryExpression_();
                b3.ColumnName("LAST_NAME");
                b3.BooleanOperator("=");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/SQL#StringValue");
                b1.VarName("lastName");
                b1.Quantifier("!");
                b1._Variable();
                b3._BooleanBinaryExpression();
                b1.Resolver();
                b1.Resolver();
                b3.OrderByColumnExpressions_(1);
                b3.OrderByColumnExpression_();
                b3.ColumnName("LAST_NAME");
                b3.OrderType("DESC");
                b3._OrderByColumnExpression();
                b3._OrderByColumnExpressions();
                b3._Select();
                b1._SameStageFragment();
                b0.Sequence_(2);
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0.VariableTest("fname");
                b0._And();
                b0._Filter();
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.IndexTest_();
                b0.IntLiteral(1);
                b0._IndexTest();
                b0.VariableTest("lname");
                b0._And();
                b0._Filter();
                b0._Sequence();
                b0._Select();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newPopulateDatatypesDB() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.sql.builders.ISQLBuilder b0 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b0.Insert_();
                b0.TableName("DATATABLE");
                b0.ColumnNames_(14);
                b0.ColumnName("ARRAY_COL");
                b0.ColumnName("BOOLEAN_COL");
                b0.ColumnName("TINYINT_COL");
                b0.ColumnName("SMALLINT_COL");
                b0.ColumnName("INT_COL");
                b0.ColumnName("BIGINT_COL");
                b0.ColumnName("DOUBLE_COL");
                b0.ColumnName("REAL_COL");
                b0.ColumnName("DECIMAL_COL");
                b0.ColumnName("STRING_COL");
                b0.ColumnName("BINARY_COL");
                b0.ColumnName("DATE_COL");
                b0.ColumnName("TIME_COL");
                b0.ColumnName("TIMESTAMP_COL");
                b0._ColumnNames();
                b0.Values_(1);
                b0.SQLExpressions_(14);
                b0.ArrayValue("1, 2, 3");
                b0.BooleanValue(false);
                b0.TinyIntValue((byte) 4);
                b0.SmallIntValue((short) 234);
                b0.IntValue(4334);
                b0.BigIntValue(453445l);
                b0.DoubleValue(23440.3434);
                b0.RealValue(3242.37f);
                b0.DecimalValue("48738927493393729");
                b0.StringValue("fdopjfsdaopuhfndsfa9734jndf");
                b0.BinaryValue("3454f140");
                b0.DateValue("2008-07-03");
                b0.TimeValue("19:12:38");
                b0.TimestampValue("2008-07-03 19:12:47.375");
                b0._SQLExpressions();
                b0._Values();
                b0._Insert();
            }
        };
    }

    public ITemplateFactory<IEntity> newSelectDatatypesDBResults() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Tuple_(14);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.sql.builders.ISQLBuilder b2 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b2.ArrayValue("1, 2, 3");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.BooleanValue(false);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.TinyIntValue((byte) 4);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.SmallIntValue((short) 234);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.IntValue(4334);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.BigIntValue(453445l);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.DoubleValue(23440.3434);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.RealValue(3242.37f);
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.DecimalValue("48738927493393729");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.StringValue("fdopjfsdaopuhfndsfa9734jndf");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.BinaryValue("3454f140");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.DateValue("2008-07-03");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.TimeValue("19:12:38");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.TimestampValue("2008-07-03 19:12:47.375");
                b1._StageUpFragment();
                b0._Tuple();
            }
        };
    }

    public ITemplateFactory<IEntity> newSelectDatatypesDB() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(1);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.sql.builders.ISQLBuilder b2 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
                b2.Select_();
                b1.Resolver();
                b2.ColumnExpressions_(14);
                b2.ColumnExpression_();
                b2.ColumnName("ARRAY_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("BOOLEAN_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("TINYINT_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("SMALLINT_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("INT_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("BIGINT_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("DOUBLE_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("REAL_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("DECIMAL_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("STRING_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("BINARY_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("DATE_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("TIME_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2.ColumnExpression_();
                b2.ColumnName("TIMESTAMP_COL");
                b1.Resolver();
                b2._ColumnExpression();
                b2._ColumnExpressions();
                b2.FromClauses_(1);
                b2.SimpleFromClause("DATATABLE");
                b2._FromClauses();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2._Select();
                b1._SameStageFragment();
                b0._Path();
            }
        };
    }
}
