import java.util.Objects;

public class VBool implements IValue{
    Boolean value;
    public VBool(boolean value){this.value = value;}

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VBool vBool = (VBool) o;
        return Objects.equals(value, vBool.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
