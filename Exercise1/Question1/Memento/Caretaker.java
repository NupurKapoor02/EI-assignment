package Question1.Memento;

import java.util.ArrayList;
import java.util.List;
public class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        if (memento != null) {
            mementoList.add(memento);
        }
    }

    public Memento getMemento(int index) {
        if (index < 0 || index >= mementoList.size()) {
            return null;
        }
        return mementoList.get(index);
    }

    public int getMementoCount() {
        return mementoList.size();
    }
}
