package org.whole.lang.workflows.visitors.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

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
    public void testLoadModelActivities() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment11");
            assertThat("at /testCases/0/tests/1/body/0", subject, allOf(matches(evaluate("fragment12")), matches(evaluate("fragment13"))));
            evaluateInScope("fragment14");
            subject = evaluate("fragment15");
            assertThat("at /testCases/0/tests/1/body/2", subject, allOf(matches(evaluate("fragment16")), matches(evaluate("fragment17"))));
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
            evaluateInScope("fragment18");
            subject = evaluate("fragment19");
            assertThat("at /testCases/0/tests/2/body/1", subject, allOf(matches(evaluate("fragment20")), matches(evaluate("fragment21"))));
            subject = evaluate("fragment22");
            assertThat("at /testCases/0/tests/2/body/2", subject, allOf(matches(evaluate("fragment23")), matches(evaluate("fragment24"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
