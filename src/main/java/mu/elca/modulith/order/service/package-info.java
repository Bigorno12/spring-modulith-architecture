@NamedInterface(name = "service-order")
@ApplicationModule(allowedDependencies = {"order::repo-order"})
package mu.elca.modulith.order.service;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;