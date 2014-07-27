public class PercolationStats {
    private double []estimate;
    public PercolationStats(int N, int T) {
        // perform T independent computational experiments on an N-by-N grid
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("N or T <=0.");
        }
        estimate = new double[T];
        for (int i = 0; i < T; ++i) {
            Percolation test = new Percolation(N);
            int count = 0;
            while (!test.percolates()) {
                int x = StdRandom.uniform(N);
                int y = StdRandom.uniform(N);
                if (!test.isOpen(x+1, y+1)) {
                    test.open(x+1, y+1);
                    ++count;
                }
            }
            estimate[i] = count * 1.0 /(N*N);
        }
    }
       public double mean() {
           // sample mean of percolation threshold
           return StdStats.mean(estimate);
       }
       public double stddev() {
           // sample standard deviation of percolation threshold
           return StdStats.stddev(estimate);
       }
       public double confidenceLo() {
           // returns lower bound of the 95% confidence interval
           return mean() - 1.96 * stddev() / Math.sqrt(estimate.length);
       }
       public double confidenceHi() {
           // returns upper bound of the 95% confidence interval
           return mean() + 1.96 * stddev() / Math.sqrt(estimate.length);
       }
       public static void main(String[] args) {
           // test client, described below
           int N = Integer.parseInt(args[0]);
           int T = Integer.parseInt(args[1]);
           
           PercolationStats ps = new PercolationStats(N, T);
           System.out.println("mean                    = " + ps.mean());
           System.out.println("stddev                  = " + ps.stddev());
           System.out.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
       }
}