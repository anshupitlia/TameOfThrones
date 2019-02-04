public class Kingdom {
    private final String name;
    private final String emblem;

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
    }

    public String displayName() {
        return name;
    }

    public boolean isAlly(String message) {
        if (message == emblem)
            return true;
        else return false;
    }
}
