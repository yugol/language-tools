package impiegato.engine.tests.espressioni;

import impiegato.engine.TestItem;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestSpec;

import java.util.List;

public class EspressioniTestData extends TestData {

    public EspressioniTestData(TestSpec testSpec) {
        super(testSpec);
    }

    @Override
    protected TestItem processRecord(String record, List<TestItem> items) {
        EspressioneItem item = new EspressioneItem(record);
        return item;
    }
}
