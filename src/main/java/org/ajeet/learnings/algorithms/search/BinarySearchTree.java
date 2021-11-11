package org.ajeet.learnings.algorithms.search;

public class BinarySearchTree  {
    private Node root;
    private int size = 0;

    public boolean insert(Integer key, Integer value){
        int size1 = size;
        root = _insert(root, key, value);
        return size1 == size;
    }

    public Node _insert(Node node, Integer key, Integer value){
        if(node == null)
            return new Node(key, value);

        if(key <= node.key){
            node.left = _insert(node.left, key, value);
        } else {
            node.right = _insert(node.right, key, value);
        }

        return node;
    }

    public Integer get(Integer key){
        Tuple<Node> tuple = _get(root, null, key);
        return tuple == null ? null : tuple.first.value;
    }

    private Tuple<Node> _get(Node node, Node parent, Integer key){
        if(node == null)
            return null;

        if(key < node.key){
            return _get(node.left, node, key);
        } else if(key > node.key){
            return _get(node.right, node, key);
        } else {
            return new Tuple(node, parent);
        }
    }

    public Integer delete(Integer key){
        if(key == null)
            return null;

        Tuple<Node> NodeToDelete = _get(root,null, key);
        return _delete(NodeToDelete, key);
    }

    private Integer _delete(Tuple<Node> tuple, Integer key) {
        if(tuple == null)
            return null;

        if(tuple.first.left == null && tuple.first.right == null){
            //Both children are null
            if(tuple.second.left == tuple.first)
                tuple.second.left = null;
            else
                tuple.second.right = null;
        } else if (tuple.first.left == null || tuple.first.right == null) {
            //It has only single child
            Node singleChild = tuple.first.left == null ? tuple.first.right : tuple.first.left;
            if(tuple.second.left == tuple.first)
                tuple.second.left = singleChild;
            else
                tuple.second.right = singleChild;
        } else {
            //It has both children
            Node leftmostChild = extractLeftMost(tuple.first, tuple.second);
            leftmostChild.left =  tuple.first.left;
            leftmostChild.right = tuple.first.right;

            if(tuple.second.left == tuple.first)
                tuple.second.left = leftmostChild;
            else
                tuple.second.right = leftmostChild;
        }

        return tuple.first.value;
    }

    private Node extractLeftMost(Node node, Node parent) {
        if(node.left == null){
            parent.left = null;
            return node;
        }
        else
            return extractLeftMost(node.left, node);
    }

    private static class Node {
        private final Integer key;
        private Integer value;

        private Node left;
        private Node right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private static class Tuple<T>{
        private final T first;
        private final T second;

        public Tuple(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1, 1);
        bst.insert(8, 8);
        bst.insert(3, 3);
        bst.insert(2, 2);
        bst.insert(5, 5);
        bst.insert(6, 6);

        System.out.println(bst.delete(3));
        System.out.println(bst.get(5));

    }
}
