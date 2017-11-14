package edu.matc.entity;

/**
 * The House test.
 */
public class HouseTest extends AbstractJavaBeanTest<House> {
    @Override
    protected House getBeanInstance() {
        return new House();
    }
}
