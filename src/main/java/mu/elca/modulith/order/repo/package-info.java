@NamedInterface(name = "repo-order")
@ApplicationModule(allowedDependencies = {"order::model-order"})
package mu.elca.modulith.order.repo;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;