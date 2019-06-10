package Controllers;

public class ComboboxItem {
    private String value;
    private int min, max;
    private boolean comment;

    public ComboboxItem(String value, int min, int max, boolean comment) {
        this.value = value;
        this.min = min;
        this.max = max;
        this.comment = comment;
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

    public boolean isComment() {
        return comment;
    }
}
