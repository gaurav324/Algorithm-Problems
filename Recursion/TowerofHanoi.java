/*
 * Standard Tower of hanoi problem, which gives an idea of the power of recursion.
 *
 * How simple it becomes to visualize a fairly complex problem.
 */ 

class TowerofHanoi {
    public void move(int n, int from, int to, int helper) {
        if (n == 0) {
            return;
        }
        move(n-1, from, helper, to);
        System.out.println("Moving " + n + " from " + from + " to " + to);
        move(n-1, helper, to, from);
    }

    public static void main(String [] args) {
        TowerofHanoi tower = new TowerofHanoi();
        tower.move(4, 1, 2, 3);
    }
}
