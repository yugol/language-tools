package impiegato.engine.tests.vocabolario;

import impiegato.engine.TestSpec;
import impiegato.engine.tests.TestData;
import impiegato.engine.tests.TestItem;

import java.util.List;

public class VocabolarioTestData extends TestData {

    public VocabolarioTestData(TestSpec testSpec) {
        super(testSpec);
    }

    @Override
    protected TestItem processRecord(String record, List<TestItem> items) {
        String[] word = record.split("=");
        String ro = word[0].trim();
        String it = word[1].trim();
        VocabolarioItem item = new VocabolarioItem(ro, it);
        return item;
    }
}
