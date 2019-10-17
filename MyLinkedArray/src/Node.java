public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightlink;
    }

    @Override
    ListItem privious() {
        return this.leftlink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightlink = item;
        return this.rightlink;
    }

    @Override
    ListItem setPrivious(ListItem item) {
        this.leftlink = item;
        return this.leftlink;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null) {
            return ((String)super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}
