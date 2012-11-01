package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class GrammarBasedUnparserVisitorTest extends TestCase {

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
        return GrammarBasedUnparserVisitorTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testUnparseWithFragments() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment1");
        subject = getVariable("toStringFromModelWithFragments");
        assertThat("at /testCases/3/tests/0/body/1", subject, equalToEntity(getVariable("toStringFromModelWithoutFragments")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testUnparseWithBehavioralLiteral() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment2");
        assertThat("at /testCases/3/tests/1/body/0", subject, equalToEntity(create("fragment3")));
        bindings().wExitScope();
    }
}
