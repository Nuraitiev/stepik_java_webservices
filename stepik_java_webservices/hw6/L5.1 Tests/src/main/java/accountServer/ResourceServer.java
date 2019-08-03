package accountServer;

import resources.TestResource;

public class ResourceServer implements ResourceServerI{

    TestResource testResource;


    public ResourceServer(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public TestResource getTestResource() {
        return testResource;
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }
}
