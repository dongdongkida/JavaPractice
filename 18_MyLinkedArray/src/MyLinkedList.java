
public class MyLinkedList implements Notelist{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            // this list was empty, so this item will be becoming the head of list
            this.root = newItem;
            return true;
        }
        // this list was not empty, compare the items in list with newItem
        ListItem currentItem = this.root;

        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if(comparison < 0) {
                //newItem is greater,move right
                if(currentItem.next() != null) {
                    //it's not the end of list, move right
                   currentItem = currentItem.next();
                } else {
                    //it's end of list, just add newItem to the end.
                    currentItem.setNext(newItem).setPrivious(currentItem);
                    return true;
                }

            } else if (comparison > 0) {
                // newItem is smaller, insert before
                if (currentItem.privious() == null) {
                    //it's the start of list
                    newItem.setNext(this.root).setPrivious(newItem);
                    this.root = newItem;
                } else {
                    (currentItem.privious()).setNext(newItem).setPrivious(currentItem.privious());
                    newItem.setNext(currentItem).setPrivious(newItem);
                }
            return true;
            } else {
                // newItem equals current item
                System.out.println(newItem.getValue() + " is already present, not added" );
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            if(currentItem.compareTo(item) !=0) {
                // did not find item, move right
                currentItem = currentItem.next();
                } else {
                if(currentItem.privious() != null) {
                    // not the start of list
                    if(currentItem.next() != null) {
                        //not the end of list
                        currentItem.privious().setNext(currentItem.next());
                        currentItem.next().setPrivious(currentItem.privious());
                    } else {
                        // it's end of list, just remove last one
                        currentItem.privious().setNext(null);
                    }
                } else {
                    // it's the start of list, just remove the first one
                    this.root = currentItem.next();
                }
                return true;
            }
        }
        System.out.println("Not found " + item.getValue() + " in the list");
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
}
