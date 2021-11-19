package APIFunctions;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:${env}.properties" // mention the property file name	
})
public interface environment extends Config{
	String url();
}
