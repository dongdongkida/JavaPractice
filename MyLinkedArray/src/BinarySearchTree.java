public class BinarySearchTree implements Notelist {
    private ListItem root = null;

    public BinarySearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            this.root = newItem;
            return true;
        } else {
            ListItem currentItem = this.root;
            sorting(currentItem, newItem);
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem newItem) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if ( root == null) {
            System.out.println("This list is empty list");
        } else {
            System.out.print("{ ");
            while(root != null) {
                System.out.print(root.getValue() + " ");
                root = root.next();
            }
            System.out.print("}\n");
        }
    }

    private boolean sorting(ListItem currentItem, ListItem newItem ) {
        int comparison = currentItem.compareTo(newItem);
        if(comparison == 0){
            System.out.println(newItem.getValue() + " already present in the list, add failed.");
            return false;
        } else if (comparison <0 ) {
            //newItem is greater
            if(currentItem.next() == null) {
                currentItem.setNext(newItem).setPrivious(currentItem);
            } else{
                currentItem = currentItem.next();
                sorting(currentItem, newItem);
            }
            return true;
        } else {
            // newItem is less
            if(currentItem.privious() == null){
                newItem.setNext(currentItem).setPrivious(newItem);
                this.root = newItem;
            } else {
                newItem.setPrivious(currentItem.privious()).setNext(newItem);
                currentItem.setPrivious(newItem).setNext(currentItem);
            }
            System.out.println(newItem.getValue() + " added successfully");
            return true;
        }
    }
}
