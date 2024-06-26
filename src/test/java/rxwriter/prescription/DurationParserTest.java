package rxwriter.prescription;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationParserTest {

    @Test
    public void parseDurationWithValidUnitAndQuantity(){
        assertSame(14, DurationParser.parseDays("2 weeks"));
        assertSame(30, DurationParser.parseDays("1 month"));

    }
    @Test
    public void returnsNullForUnmatchedUnit(){
        assertNull(DurationUnit.getByTextValue("boop"));
    }

}