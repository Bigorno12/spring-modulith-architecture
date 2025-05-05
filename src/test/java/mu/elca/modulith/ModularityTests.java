package mu.elca.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {

    static ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);

    @Test
    void verifyModularity() {
        modules.verify();
    }

    @Test
    void generateDiagrams() {
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

    @Test
    void generateAsciidoc() {
        var canvasOption = Documenter.CanvasOptions
                .defaults();

        var docOptions = Documenter.DiagramOptions
                .defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.UML);

        new Documenter(modules)
                .writeDocumentation(docOptions, canvasOption);
    }
}
