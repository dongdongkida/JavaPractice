public abstract class ListItem {

    protected ListItem leftlink = null;
    protected ListItem rightlink = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem privious();
    abstract ListItem setNext(ListItem listItem);
    abstract ListItem setPrivious(ListItem listItem);

    abstract int compareTo(ListItem listItem);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
