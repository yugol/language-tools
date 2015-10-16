package impiegato.engine;

import java.util.ArrayList;
import java.util.List;

public class TestSet {

    private final List<TestItem> items = new ArrayList<>();

    public int size() {
        return items.size();
    }

    public void add(final TestItem item) {
        items.add(item);
    }

    public TestItem get(final int index) {
        return items.get(index);
    }

}
