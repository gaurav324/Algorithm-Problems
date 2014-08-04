/**
 * Given a graph, print the topological sort.
 *
 * In directed acyclic graph, print nodes such that all the dependent nodes occur in the end.
 * If there is an edge going from A->B, C->B, B->D, E->A
 *
 * Ans: E|C, A, B, D.
 *
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedList;

class Graph {
    HashMap<Integer, ArrayList<Integer>> nodes;

    Graph() {
        nodes = new HashMap<Integer, ArrayList<Integer>>();
    }

    void add(int n1, int n2) {
        if (nodes.containsKey(n1)) {
            nodes.get(n1).add(n2);
        } else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(n2);
            nodes.put(n1, temp);
        }
    }
};

public class TopologicalSort {
    Graph g;

    TopologicalSort(Graph g) {
        this.g = g;
    }

    void printSorted() {
        HashMap<Integer, Boolean> isMarked = new HashMap<Integer, Boolean>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        for(Integer key : g.nodes.keySet()) {
            printSortedHelper(key, isMarked, result);
        }

        for (Integer i: result) {
            System.out.println(i);
        }
    }

    void printSortedHelper(int key, HashMap<Integer, Boolean> isMarked, LinkedList<Integer> result) {
        if (isMarked.containsKey(key)) {
            return;
        }

        isMarked.put(key, true);
        if (g.nodes.containsKey(key)) {
            for(Integer child : g.nodes.get(key)) {
                if (isMarked.containsKey(child)) {
                    continue;
                }

                printSortedHelper(child, isMarked, result);
            }
        }
        result.addFirst(key);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.add(1, 2);
        g.add(7, 1);
        g.add(2, 3);
        g.add(3, 4);
        g.add(3, 5);
        g.add(6, 5);
        g.add(1, 6);
        
        TopologicalSort s = new TopologicalSort(g);
        s.printSorted();
    }
}
