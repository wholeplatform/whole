package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesIncludeSelfTest extends TestCase {

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
        return QueriesIncludeSelfTestTemplateManager.instance().create(templateName);
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
    public void testIncludeSelf() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment1");
            assertThat("at /testCases/3/tests/0/body/0", subject, matches(evaluate("fragment2")));
            subject = evaluate("fragment3");
            assertThat("at /testCases/3/tests/0/body/1", subject, matches(evaluate("fragment4")));
            subject = evaluate("fragment5");
            assertThat("at /testCases/3/tests/0/body/2", subject, matches(evaluate("fragment6")));
            subject = evaluate("fragment7");
            assertThat("at /testCases/3/tests/0/body/3", subject, matches(evaluate("fragment8")));
            subject = evaluate("fragment9");
            assertThat("at /testCases/3/tests/0/body/4", subject, matches(evaluate("fragment10")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
