package m12_active_object.activeobject;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillChar);
    public abstract void displayString(String string);
}
