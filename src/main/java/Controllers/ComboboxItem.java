package Controllers;

public class ComboboxItem {
    private String value;
    private int min, max;

    public ComboboxItem(String value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return value;
    }
}
