package edu.matc.entity;

/**
 * The User test.
 */
public class UserTest extends AbstractJavaBeanTest<User> {
    @Override
    protected User getBeanInstance() {
        return new User();
    }
}
