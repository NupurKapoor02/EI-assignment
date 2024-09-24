package Question1.Memento;
public class Memento {
    private final String state;

    public Memento(String state) {
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null.");
        }
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
