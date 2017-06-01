package org.whole.lang.workflows.visitors.tests;

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
public class WorkflowsTest extends TestCase {

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
        return WorkflowsTestTemplateManager.instance().create(templateName);
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
    public void testJavaActivities() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment1");
            subject = evaluate("fragment2");
            assertThat("at /testCases/0/tests/0/body/1", subject, allOf(equalToEntity(evaluate("fragment3")), equalToEntity(evaluate("fragment4"))));
            subject = evaluate("fragment5");
            assertThat("at /testCases/0/tests/0/body/2", subject, allOf(equalToEntity(evaluate("fragment6")), equalToEntity(evaluate("fragment7"))));
            subject = evaluate("fragment8");
            assertThat("at /testCases/0/tests/0/body/3", subject, allOf(equalToEntity(evaluate("fragment9")), equalToEntity(evaluate("fragment10"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testModelCreationActivities() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment11");
            assertThat("at /testCases/0/tests/1/body/0", subject, allOf(matches(evaluate("fragment12")), matches(evaluate("fragment13"))));
            subject = evaluate("fragment14");
            assertThat("at /testCases/0/tests/1/body/1", subject, allOf(matches(evaluate("fragment15")), matches(evaluate("fragment16"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testLoadModelActivities() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment17");
            assertThat("at /testCases/0/tests/2/body/0", subject, allOf(matches(evaluate("fragment18")), matches(evaluate("fragment19"))));
            evaluateInScope("fragment20");
            subject = evaluate("fragment21");
            assertThat("at /testCases/0/tests/2/body/2", subject, allOf(matches(evaluate("fragment22")), matches(evaluate("fragment23"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testGrammarActivities() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment24");
            subject = evaluate("fragment25");
            assertThat("at /testCases/0/tests/3/body/1", subject, allOf(matches(evaluate("fragment26")), matches(evaluate("fragment27"))));
            subject = evaluate("fragment28");
            assertThat("at /testCases/0/tests/3/body/2", subject, allOf(matches(evaluate("fragment29")), matches(evaluate("fragment30"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
