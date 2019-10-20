public class Main {

    public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList(null);
    list.traverse(list.getRoot());

    String stringData = "Darwin Brisbane Perth Melbourne Melbourne Canberra Adelaide Sydney";
    String[] data = stringData.split(" ");
    for(String city: data) {
        list.addItem(new Node(city));
    }

    list.traverse(list.getRoot());
    list.removeItem(new Node("Melbourne"));
    list.traverse(list.getRoot());

    list.addItem(new Node("1"));
//    list.traverse(list.getRoot());

    BinarySearchTree searchTree = new BinarySearchTree(null);
    searchTree.traverse(searchTree.getRoot());
    for (String s : data) {
        searchTree.addItem( new Node(s));
    }
    searchTree.traverse(searchTree.getRoot());

    }
}
