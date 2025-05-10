@NamedInterface(name = "product")
@ApplicationModule(type = ApplicationModule.Type.CLOSED, allowedDependencies = {"inventory::service-inventory"})
package mu.elca.modulith.product;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;