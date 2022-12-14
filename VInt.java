import java.util.Objects;

public class VInt implements IValue{
    Integer value;
    public VInt(int value){this.value = value;}

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VInt vInt = (VInt) o;
        return Objects.equals(value, vInt.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
