import java.util.Objects;

public class VCell implements IValue{
    IValue value;

    public VCell(IValue value){this.value = value;}
    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VCell vCell = (VCell) o;
        return Objects.equals(value, vCell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
