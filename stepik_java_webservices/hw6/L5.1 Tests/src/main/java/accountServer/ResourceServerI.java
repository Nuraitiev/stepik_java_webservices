package accountServer;

import resources.TestResource;

public interface ResourceServerI {

    void setTestResource(TestResource testResource);
    TestResource getTestResource();
    String getName();
    int getAge();
}
