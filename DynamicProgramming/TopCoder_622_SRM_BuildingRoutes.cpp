/**
 * We have n cities in a form of clique. There is a road from city i to j and from j to i.
 * We have to find shortest distance from each city to every other city.
 * In the process, we need to find out which roads are a part of shortest path more than T times.
 * Finally add the lengths of all such paths and print.
 */

#include <iostream>
#include <string>
#include <vector>
#include <queue>

#define INT_MAX 99999999

using namespace std;

typedef std::pair<int, int> wn;

int build(vector<string> sdist, int T) {
    
    int count[20][20];
    for (int i=0; i<sdist.size();++i)
        for (int j=0;j<sdist[i].size();++j)
            count[i][j] = 0;

    // For each city, we would compute the shortest distance 
    // to all the cities.
    for (int i=0; i < sdist.size(); ++i) {
    
        // Run Dijkstra for i.
        // This would set shortest distance from the current node 
        // to all other nodes.
        std::vector<int> dist;
        std::vector<int> prev;
        for (int j=0; j < sdist[i].size(); ++j) {
            dist.push_back(INT_MAX);
            prev.push_back(INT_MAX);
        }
        dist[i] = 0;
        prev[i] = i;

        // Let us create a priority queue of pairs.
        // First element in the pair is distance of the node and second
        // element is the node itself.
        std::priority_queue<wn, std::vector<wn>, std::greater<wn> > Q;
        Q.push(wn(0, i));

        // Dijkstra runs on the principle that we always pick out 
        // the node whose distance from the source is the shortest.
        while(!Q.empty()) {
            wn top_node = Q.top();
            Q.pop();

            int weight = top_node.first;
            int node = top_node.second;

            // This might have become obsolete by now as we would have found a shorter path.
            // This check ensures that we have the shortest path node, and we have not updated with something bigger.
            // As you can see, this is just an improvement to make it faster, nothing more.
            if (weight <= dist[node]) {
                // Add all the reachable nodes.
                for (int j=0; j < sdist[node].size(); ++j) {
                    if (node != j) {
                        int new_weight = dist[node] + sdist[node][j] - '0';
                        if  (new_weight < dist[j]) {
                            dist[j] = new_weight;
                            prev[j] = node;
                            Q.push(wn(dist[j], j));
                        }
                    }
                }
            }
        }

         
        for (int j=0; j < sdist[i].size(); ++j) {
            int jj = j;
            int parent = prev[jj];
            while (i != jj) {
                count[parent][jj] += 1;
                jj = parent;
                parent = prev[parent];
            }
        }
    }
    
    int TotalPath = 0;
    for (int i=0; i<sdist.size(); ++i) {
        for(int j=0; j<sdist[i].size(); ++j) {
            cout << count[i][j] << "\t";
            if (count[i][j] >= T)
                TotalPath += sdist[i][j] - '0';
        }
        cout << endl;
    }
    return TotalPath;
}

int main() {
    cout << build({"011", "101", "110"}, 1) << endl;
    cout << build({"033", "309", "390"}, 1) << endl;
    cout << build({"0123", "1023", "1203", "1230"}, 2) << endl;
    cout << build({"05789654", "10347583", "65085479", "55602398", "76590934", "57939045", "12345608", "68647640"}, 3) << endl;
}
