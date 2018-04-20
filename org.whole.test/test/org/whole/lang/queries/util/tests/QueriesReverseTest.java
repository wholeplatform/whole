package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesReverseTest extends TestCase {

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
        return QueriesReverseTestTemplateManager.instance().create(templateName);
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
    public void testReverse() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment1");
            assertThat("at /testCases/4/tests/0/body/0", subject, matches(evaluate("fragment2")));
            subject = evaluate("fragment3");
            assertThat("at /testCases/4/tests/0/body/1", subject, matches(evaluate("fragment4")));
            subject = evaluate("fragment5");
            assertThat("at /testCases/4/tests/0/body/2", subject, matches(evaluate("fragment6")));
            subject = evaluate("fragment7");
            assertThat("at /testCases/4/tests/0/body/3", subject, matches(evaluate("fragment8")));
            subject = evaluate("fragment9");
            assertThat("at /testCases/4/tests/0/body/4", subject, matches(evaluate("fragment10")));
            subject = evaluate("fragment11");
            assertThat("at /testCases/4/tests/0/body/5", subject, matches(evaluate("fragment12")));
            subject = evaluate("fragment13");
            assertThat("at /testCases/4/tests/0/body/6", subject, matches(evaluate("fragment14")));
            subject = evaluate("fragment15");
            assertThat("at /testCases/4/tests/0/body/7", subject, matches(evaluate("fragment16")));
            subject = evaluate("fragment17");
            assertThat("at /testCases/4/tests/0/body/8", subject, matches(evaluate("fragment18")));
            subject = evaluate("fragment19");
            assertThat("at /testCases/4/tests/0/body/9", subject, matches(evaluate("fragment20")));
            subject = evaluate("fragment21");
            assertThat("at /testCases/4/tests/0/body/10", subject, matches(evaluate("fragment22")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
