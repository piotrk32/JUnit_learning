package rxwriter.drug;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrugServiceTest {

    private DrugService drugService;

    @BeforeEach
    void setup() {
        drugService = new DrugService();
    }

    @Test
    void drugsAreReturnedSorted(){

        List<DispensableDrug> foundDrugs = drugService.findDrugsStartingWith("as");
        assertNotNull(foundDrugs);
        assertEquals(2, foundDrugs.size());
        assertEquals("asmanex", foundDrugs.get(0).drugName());
        assertEquals("aspirin", foundDrugs.get(1).drugName());

    }

    @Test
    @DisplayName("when passed a empty string for startingWith")
    void throwsExceptionOnEmptyStartsWith() {
        Exception thrown = assertThrows(IllegalArgumentException.class,
                () -> drugService.findDrugsStartingWith(""));
        System.out.println(thrown.getMessage());
    }

    @Test
    @DisplayName("return dispensable drugs with all properties set correctly from database")
    void setsDrugPropertiesCorrectly() {
        List<DispensableDrug> foundDrugs = drugService.findDrugsStartingWith("aspirin");
        DrugClassification[] expectedClassifications = new DrugClassification[] {
                DrugClassification.ANALGESIC, DrugClassification.PLATELET_AGGREGATION_INHIBITORS
        };
        DispensableDrug drug = foundDrugs.get(0);
        assertAll("DispensableDrug properties",
                () -> assertEquals("aspirin", drug.drugName()),
                () -> assertFalse(drug.isControlled()),
                () -> assertEquals(2, drug.drugClassifications().length),
                () -> assertArrayEquals(expectedClassifications, drug.drugClassifications())
        );
    }

}