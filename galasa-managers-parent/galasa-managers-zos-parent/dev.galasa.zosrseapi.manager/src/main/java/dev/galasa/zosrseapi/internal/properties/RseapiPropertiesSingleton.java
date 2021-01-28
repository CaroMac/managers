/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.zosrseapi.internal.properties;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import dev.galasa.framework.spi.IConfigurationPropertyStoreService;
import dev.galasa.zosrseapi.RseapiManagerException;

@Component(service=RseapiPropertiesSingleton.class, immediate=true)
public class RseapiPropertiesSingleton {
    
    private static RseapiPropertiesSingleton singletonInstance;
    private static void setInstance(RseapiPropertiesSingleton instance) {
        singletonInstance = instance;
    }
    
    private IConfigurationPropertyStoreService cps;
    
    @Activate
    public void activate() {
        setInstance(this);
    }
    
    @Deactivate
    public void deacivate() {
        setInstance(null);
    }
    
    public static IConfigurationPropertyStoreService cps() throws RseapiManagerException {
        if (singletonInstance != null) {
            return singletonInstance.cps;
        }
        
        throw new RseapiManagerException("Attempt to access manager CPS before it has been initialised");
    }
    
    public static void setCps(IConfigurationPropertyStoreService cps) throws RseapiManagerException {
        if (singletonInstance != null) {
            singletonInstance.cps = cps;
            return;
        }
        
        throw new RseapiManagerException("Attempt to set manager CPS before instance created");
    }
}
