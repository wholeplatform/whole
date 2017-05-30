package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;
import org.whole.test.SlowTests;

@Category(SlowTests.class)
public class GenericPredictiveParserTest extends TestCase {

    @BeforeClass
    public static void wholeDeploy() {
        ReflectionFactory.deploy(new Deployer());
    }

    @AfterClass
    public static void wholeUndeploy() {
        ReflectionFactory.undeploy(new Deployer());
    }

    protected static class Deployer extends org.whole.lang.reflect.AbstractContributionDeployer {

        public void deploy(ReflectionFactory platform) {
            evaluate("fragment");
        }
    }

    protected static IEntity create(String templateName) {
        return GenericPredictiveParserTestTemplateManager.instance().create(templateName);
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
    public void testParseDataTypesGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment1");
            subject = evaluate("fragment2");
            assertThat("at /testCases/2/tests/0/body/1", subject, matches(evaluate("fragment3")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseMessagesGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment4");
            subject = evaluate("fragment5");
            assertThat("at /testCases/2/tests/1/body/1", subject, matches(evaluate("fragment6")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseStateMachineGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment7");
            subject = evaluate("fragment8");
            assertThat("at /testCases/2/tests/2/body/1", subject, matches(evaluate("fragment9")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseStateMachine2Grammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment10");
            subject = evaluate("fragment11");
            assertThat("at /testCases/2/tests/3/body/1", subject, matches(evaluate("fragment12")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseFamilyGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment13");
            subject = evaluate("fragment14");
            assertThat("at /testCases/2/tests/4/body/1", subject, matches(evaluate("fragment15")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseMT3Grammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment16");
            subject = evaluate("fragment17");
            assertThat("at /testCases/2/tests/5/body/1", subject, matches(evaluate("fragment18")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseDTAUSGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment19");
            subject = evaluate("fragment20");
            assertThat("at /testCases/2/tests/6/body/1", subject, matches(evaluate("fragment21")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseMotoGPCSVGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment22");
            subject = evaluate("fragment23");
            assertThat("at /testCases/2/tests/7/body/1", subject, matches(evaluate("fragment24")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testParseMotoGPFLFGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment25");
            subject = evaluate("fragment26");
            assertThat("at /testCases/2/tests/8/body/1", subject, matches(evaluate("fragment27")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
