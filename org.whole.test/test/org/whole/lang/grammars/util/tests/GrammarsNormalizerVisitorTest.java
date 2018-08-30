package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class GrammarsNormalizerVisitorTest extends TestCase {

    protected static IEntity create(String templateName) {
        return GrammarsNormalizerVisitorTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    protected static IEntity evaluateInScope(String templateName) {
        return evaluate(create(templateName), false);
    }

    /**
     *
     */
    @Test
    public void testNormalizationRules() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment");
            assertThat("at /testCases/0/tests/0/body/0", subject, matches(evaluate("fragment1")));
            subject = evaluate("fragment2");
            assertThat("at /testCases/0/tests/0/body/1", subject, matches(evaluate("fragment3")));
            subject = evaluate("fragment4");
            assertThat("at /testCases/0/tests/0/body/2", subject, matches(evaluate("fragment5")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeTestGrammar1() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment6");
            assertThat("at /testCases/0/tests/1/body/0", subject, matches(evaluate("fragment7")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeDataTypesGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment8");
            assertThat("at /testCases/0/tests/2/body/0", subject, matches(evaluate("fragment9")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeMessagesGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment10");
            assertThat("at /testCases/0/tests/3/body/0", subject, matches(evaluate("fragment11")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeStateMachineGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment12");
            assertThat("at /testCases/0/tests/4/body/0", subject, matches(evaluate("fragment13")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeStateMachine2Grammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment14");
            assertThat("at /testCases/0/tests/5/body/0", subject, matches(evaluate("fragment15")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeFamilyGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment16");
            assertThat("at /testCases/0/tests/6/body/0", subject, matches(evaluate("fragment17")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeMT3Grammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment18");
            assertThat("at /testCases/0/tests/7/body/0", subject, matches(evaluate("fragment19")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeXmlGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment20");
            assertThat("at /testCases/0/tests/8/body/0", subject, matches(evaluate("fragment21")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeMotoGPCSVGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment22");
            assertThat("at /testCases/0/tests/9/body/0", subject, matches(evaluate("fragment23")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testNormalizeMotoGPFLFGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment24");
            assertThat("at /testCases/0/tests/10/body/0", subject, matches(evaluate("fragment25")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
