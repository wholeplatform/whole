
NULL = 
NAME = Schemer

JFLAGS = -O2

SOURCES = \
  SchemeException.java \
  SchemeSyntaxError.java \
  SchemeValue.java \
  SchemePairValue.java \
  SchemeEnvironment.java \
  SchemeExpression.java \
  SchemeDefinition.java \
  SchemeBranch.java \
  SchemeFactory.java \
  SchemeScanner.java \
  SchemeParser.java \
  SchemeValueImpl.java \
  SchemeBoolValueImpl.java \
  SchemeIntValueImpl.java \
  SchemeStringValueImpl.java \
  SchemeClosureValueImpl.java \
  SchemePairValueImpl.java \
  SchemeEnvironmentImpl.java \
  SchemeEnvironmentImpl2.java \
  SchemeBranchImpl.java \
  SchemeDefinitionImpl.java \
  SchemeConstExpressionImpl.java \
  SchemeIdExpressionImpl.java \
  SchemeAndExpressionImpl.java \
  SchemeOrExpressionImpl.java \
  SchemeLambdaExpressionImpl.java \
  SchemeApplyExpressionImpl.java \
  SchemeCondExpressionImpl.java \
  SchemeLocalExpressionImpl.java \
  SchemeFactoryImpl.java \
  SchemeBuiltins.java \
  Schemer.java \
  $(NULL)

OBJS = $(SOURCES:%.java=%.o)
CLASSES = $(SOURCES:%.java=%.class)

$(NAME): $(OBJS)
	gcj -o $@ --main=Schemer $^

$(NAME).jar: $(CLASSES)
	jar cvf $@ *.class

%.o: %.java
	gcj $(JFLAGS) -c $<

$(CLASSES): $(SOURCES)
	javac $^

clean:
	rm -f *.o *.class $(NAME) $(NAME).jar

depend:
	gcj -M $(SOURCES) >.depend

wc:
	@wc -l $(SOURCES) | tail -n 1

dist:
	tar cvfz $(NAME).tar.gz $(SOURCES) init.scm Makefile

.PHONY: clean depend wc dist

include .depend
