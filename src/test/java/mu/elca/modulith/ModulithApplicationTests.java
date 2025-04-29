package mu.elca.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModulithApplicationTests {

    ApplicationModules applicationModules = ApplicationModules.of(ModulithApplication.class);

    @Test
    void ver() {
        applicationModules.verify();
    }

}
