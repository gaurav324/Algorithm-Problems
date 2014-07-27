/**
 * http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 *
 * This algorithm does not handle the case when water does percolate but 
 * some cell down there is not Full, that it is not connected from top 
 * row, but connected to virtual bottom.
 */

public class Percolation {
    private WeightedQuickUnionUF uf;
    private site [] grid;
    private int N;
    
    private enum site {
        OPEN,
        BLOCKED,
    };

    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("N or T <=0.");
        }
    	
        this.N = N;
        uf = new WeightedQuickUnionUF(N * N + 2);
        grid = new site[N*N];
        for (int i = 0; i < N*N; ++i) {
            grid[i] = site.BLOCKED;
        }
    }
    
    private int index(int i, int j) { 
        if (i < 1 || j < 1 || i > N || j > N) { throw new java.lang.IndexOutOfBoundsException("OutofBounds."); }
        return (i-1) * N + (j-1); 
    }
    
    public void open(int i, int j) {
        // open site (row i, column j) if it is not already
        if (i - 1 > 0 && grid[index(i-1, j)] == site.OPEN) {
            uf.union(index(i, j), index(i-1, j));
        }
        if (j - 1 > 0 && grid[index(i, j-1)] == site.OPEN) {
            uf.union(index(i, j), index(i, j-1));
        }	
        if (j + 1 <= N && grid[index(i, j+1)] == site.OPEN) {
            uf.union(index(i, j), index(i, j+1));
        }	
        if (i + 1 <= N && grid[index(i+1, j)] == site.OPEN) {
            uf.union(index(i, j), index(i+1, j));
        }
        	
        grid[index(i, j)] = site.OPEN;

        // Connect virtually.
        if (i == 1) { uf.union(index(i, j), N*N); }
        if (i == N) { uf.union(index(i, j), N*N + 1); }
    }
    public boolean isOpen(int i, int j) {
        // is site (row i, column j) open?
        return grid[index(i, j)] == site.OPEN;
    }
    public boolean isFull(int i, int j) {
        // is site (row i, column j) full?
        if (grid[index(i, j)] == site.OPEN) {
            return uf.connected(N*N, index(i, j));
        } else {
            return false;
        }
    }
    public boolean percolates() {
        // does the system percolate?
        return uf.connected(N*N, N*N+1);
    }
}
