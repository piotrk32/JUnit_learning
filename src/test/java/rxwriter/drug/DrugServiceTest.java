package rxwriter.drug;

import org.junit.jupiter.api.BeforeEach;
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

}