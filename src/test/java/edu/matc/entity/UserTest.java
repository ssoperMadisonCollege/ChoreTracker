package edu.matc.entity;

public class UserTest extends AbstractJavaBeanTest<User> {
    @Override
    protected User getBeanInstance() {
        return new User();
    }
}
