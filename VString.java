import java.util.Objects;

public class VString implements IValue{
    String value;
    public VString(String value){this.value = value;}

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VString vString = (VString) o;
        return Objects.equals(value, vString.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
