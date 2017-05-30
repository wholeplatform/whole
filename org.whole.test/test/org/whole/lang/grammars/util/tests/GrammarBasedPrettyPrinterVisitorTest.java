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
public class GrammarBasedPrettyPrinterVisitorTest extends TestCase {

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
        return GrammarBasedPrettyPrinterVisitorTestTemplateManager.instance().create(templateName);
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
    public void testPrettyPrintWithFragments() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment1");
            assertThat("at /testCases/4/tests/0/body/0", subject, matches(evaluate("fragment2")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testPrettyPrintWithBehavioralLiteral() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment3");
            assertThat("at /testCases/4/tests/1/body/0", subject, matches(evaluate("fragment4")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
