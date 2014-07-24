package org.whole.lang.workflows.visitors.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;
import org.whole.test.SlowTests;

@Category(SlowTests.class)
public class WorkflowsStagingTest extends TestCase {

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
        return WorkflowsStagingTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testJavaActivities() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment1");
        assertThat("at /testCases/0/tests/0/body/0", subject, allOf(equalToEntity(evaluate("fragment2")), equalToEntity(evaluate("fragment3"))));
        subject = evaluate("fragment4");
        assertThat("at /testCases/0/tests/0/body/1", subject, allOf(equalToEntity(evaluate("fragment5")), equalToEntity(evaluate("fragment6"))));
        subject = evaluate("fragment7");
        assertThat("at /testCases/0/tests/0/body/2", subject, allOf(equalToEntity(evaluate("fragment8")), equalToEntity(evaluate("fragment9"))));
        bindings().wExitScope();
    }

    /**
     *
     */
	@Test
    public void testModelCreationActivities() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment10");
        assertThat("at /testCases/0/tests/1/body/0", subject, allOf(matches(evaluate("fragment11")), matches(evaluate("fragment12"))));
        subject = evaluate("fragment13");
        assertThat("at /testCases/0/tests/1/body/1", subject, allOf(matches(evaluate("fragment14")), matches(evaluate("fragment15"))));
        bindings().wExitScope();
    }

    /**
     *
     */
	@Test
    public void testLoadModelActivities() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment17");
        assertThat("at /testCases/0/tests/2/body/0", subject, allOf(matches(evaluate("fragment18")), matches(evaluate("fragment19"))));
        evaluate("fragment16");
        subject = evaluate("fragment20");
        assertThat("at /testCases/0/tests/2/body/2", subject, allOf(matches(evaluate("fragment21")), matches(evaluate("fragment22"))));
        bindings().wExitScope();
    }

    /**
     *
     */
	@Test
    public void testGrammarActivities() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment23");
        assertThat("at /testCases/0/tests/3/body/0", subject, allOf(matches(evaluate("fragment24")), matches(evaluate("fragment25"))));
        subject = evaluate("fragment26");
        assertThat("at /testCases/0/tests/3/body/1", subject, allOf(matches(evaluate("fragment27")), matches(evaluate("fragment28"))));
        bindings().wExitScope();
    }
}
