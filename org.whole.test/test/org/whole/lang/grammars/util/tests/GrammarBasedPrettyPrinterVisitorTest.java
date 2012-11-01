package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

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

    /**
     *
     */
    @Test
    public void testPrettyPrintWithFragments() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment1");
        assertThat("at /testCases/4/tests/0/body/0", subject, matches(create("fragment2")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testPrettyPrintWithBehavioralLiteral() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment3");
        assertThat("at /testCases/4/tests/1/body/0", subject, matches(create("fragment4")));
        bindings().wExitScope();
    }
}
