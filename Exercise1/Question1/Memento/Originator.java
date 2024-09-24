package Question1.Memento;
public class Originator {
    private String state;

    public void setState(String state) {
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null.");
        }
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("Memento cannot be null.");
        }
        state = memento.getState();
    }
}
