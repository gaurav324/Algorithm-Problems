/**
 * A tree is balanced of length of nodes in its left and right don't differ by 1.
 */ 

class Node<Item> {
    public Item t;
    Node<Item> left, right;

    Node(Item t) {
        this.t = t;
    }
}

public class BalancedTree {
    public static int getDiffLeftRight(Node<Integer> root) {
        if (root == null) {
            return 0;
        }

        int l = getDiffLeftRight(root.left);
        int r = getDiffLeftRight(root.right);

        return Math.abs(l-r) + 1;
    }

    public static boolean checkIfBalanced(Node<Integer> root) {
        int len = getDiffLeftRight(root);
        if (len > 2) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(4);
        Node<Integer> n5 = new Node<Integer>(5);

        n1.left = n2;
        n1.right = n4;

        System.out.println(checkIfBalanced(n1));

        n2.right = n3;
        n4.left = n5;

        System.out.println(checkIfBalanced(n1));

        Node<Integer> n6 = new Node<Integer>(6);
        Node<Integer> n7 = new Node<Integer>(7);
        Node<Integer> n8 = new Node<Integer>(8);

        n3.left = n6;
        n4.right = n7;

        System.out.println(checkIfBalanced(n1));

        n2.left = n8;

        System.out.println(checkIfBalanced(n1));
    }
}
