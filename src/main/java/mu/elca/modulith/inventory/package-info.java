@NamedInterface(name = "inventory")
@ApplicationModule(type = ApplicationModule.Type.CLOSED, allowedDependencies = {"order::event-order"})
package mu.elca.modulith.inventory;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;