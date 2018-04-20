package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesPatternMatchingTest extends TestCase {

    @BeforeClass
    public static void wholeDeploy() {
        ReflectionFactory.deploy(new Deployer());
        bindTestArtifact();
    }

    @AfterClass
    public static void wholeUndeploy() {
        ReflectionFactory.undeploy(new Deployer());
    }

    protected static class Deployer extends org.whole.lang.reflect.AbstractContributionDeployer {

        public void deploy(ReflectionFactory platform) {
        }
    }

    protected static IEntity create(String templateName) {
        return QueriesPatternMatchingTestTemplateManager.instance().create(templateName);
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
    static public void bindTestArtifact() {
        evaluateInScope("fragment");
    }

    /**
     *
     */
    @Test
    public void testMatchTest() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment1");
            assertThat("at /testCases/6/tests/0/body/0", subject, matches(evaluate("fragment2")));
            subject = evaluate("fragment3");
            assertThat("at /testCases/6/tests/0/body/1", subject, matches(evaluate("fragment4")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
