package mu.elca.modulith;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_TESTS;

public class ArchUnitTest {
    private static final JavaClasses PROJECT_CLASSES = new ClassFileImporter()
            .withImportOption(DO_NOT_INCLUDE_TESTS)
            .importPackages("mu.elca.modulith.");


    @Test
    public void noCycles() {
        var cycles = SlicesRuleDefinition.slices()
                .matching("mu.elca.modulith.(*).*")
                .should()
                .beFreeOfCycles()
                .evaluate(PROJECT_CLASSES)
                .getFailureReport()
                .getDetails();

        Assertions.assertThat(cycles).isEmpty();
    }

}
