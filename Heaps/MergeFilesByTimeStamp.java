import java.lang.Integer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

class Line implements Comparable<Line> {
    int timestamp;
    String line;

    Line(String l) {
        String[] parts = l.split(" ");
        this.timestamp = Integer.parseInt(parts[0]);
        this.line = l;
    }

    public int compareTo(Line other) {
        return (timestamp < other.timestamp) ? -1 : ((timestamp == other.timestamp) ? 0 : 1);
    }

    public String toString() {
        return line;
    }
}

public class MergeFilesByTimeStamp {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Line> pq = new PriorityQueue<Line>();
        Scanner file1 = new Scanner(new File("file1.txt"));
        Scanner file2 = new Scanner(new File("file2.txt"));
        Scanner file3 = new Scanner(new File("file3.txt"));
        ArrayList<Scanner> inputs = new ArrayList<Scanner>();
        inputs.add(file1);
        inputs.add(file2);
        inputs.add(file3);

        BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
        while(true) {
            Line max = null;
            boolean stillOneLeft = false;
            for (Scanner in : inputs) {
                if (in.hasNextLine()) {
                    stillOneLeft = true;
                } else {
                   continue;
                }

                Line temp = new Line(in.nextLine());
                pq.offer(temp);
                if (max == null) {
                    max = temp;
                } else {
                    if (temp.compareTo(max) > 0) {
                        max = temp;
                    }
                }
            }
            
            Line newMax = max;
            for (Scanner in: inputs) {
                while(in.hasNextLine()) {
                    Line temp = new Line(in.nextLine());
                    pq.offer(temp);
                    if (temp.compareTo(max) > 0) {
                        if (temp.compareTo(newMax) > 0) {
                            newMax = temp;
                        }
                        break;
                    }
                }
            }
            
            while(pq.peek() != null && max != null && pq.peek().compareTo(max) < 0) {
                bw.write(pq.poll().toString());
                bw.write("\n");
            }
            max = newMax;

            if (!stillOneLeft) {
                break;
            }
        }
        bw.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
