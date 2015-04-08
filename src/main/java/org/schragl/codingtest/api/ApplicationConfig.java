/*
 */
package org.schragl.codingtest.api;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Configures the web services API of this application.
 * 
 * @author dan
 */
@javax.ws.rs.ApplicationPath("/api/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.schragl.codingtest.api.CrossOriginResourceSharingFilter.class);
        resources.add(org.schragl.codingtest.api.ExpenseFacadeREST.class);
    }    
}
