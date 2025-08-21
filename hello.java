// Simple binary search tree implementation.
class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Inserts a value into the tree.
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    // Deletes a value from the tree if it exists.
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            Node smallest = findSmallest(current.right);
            current.value = smallest.value;
            current.right = deleteRecursive(current.right, smallest.value);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }
        return current;
    }

    private Node findSmallest(Node current) {
        return current.left == null ? current : findSmallest(current.left);
    }

    // Searches for a value in the tree and returns true if found.
    public boolean search(int value) {
        return searchRecursive(root, value) != null;
    }

    private Node searchRecursive(Node current, int value) {
        if (current == null || current.value == value) {
            return current;
        }
        return value < current.value
            ? searchRecursive(current.left, value)
            : searchRecursive(current.right, value);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}

