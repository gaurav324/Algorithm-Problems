/**
 * Write a program to check whether a root forms a BST or not.
 */

class Node<Item> {
    public Item t;
    Node<Item> left, right;

    Node(Item t) {
        this.t = t;
        this.left = null;
        this.right = null;
    }
}

public class IsBST {
    static Integer max = null;
    public static boolean check(Node<Integer> node) {
        if (node == null) { return true; }
        
        boolean l_tree=true, r_tree=true;
        if (node.left != null) {
            l_tree = check(node.left); 
        }
        if (max != null) {
            if (node.t < max) {
                return false;
            } else {
                max = node.t;
                if (node.right != null) {
                    r_tree = check(node.right);
                }
                return l_tree && r_tree;
            }
        } else {
            max = node.t;
            return true;
        }
    }

    public static void main(String[] args) {
        Node<Integer> n5 = new Node<Integer>(5);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n8 = new Node<Integer>(8);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n4 = new Node<Integer>(4);

        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n9 = new Node<Integer>(9);

        n5.left = n3;
        n5.right = n8;
        n3.left = n1;
        n3.right = n4;

        System.out.println(IsBST.check(n5));

        n8.left = n2;
        n8.right = n9;

        System.out.println(IsBST.check(n5));
    }
}

