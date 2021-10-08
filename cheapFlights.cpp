#include <bits/stdc++.h>
using namespace std;

struct Pair
{
    int nbr;
    int weight;
    Pair(int nbr, int weight)
    {
        this->nbr = nbr;
        this->weight = weight;
    }
};

int findCheapestPrice(int n, vector<vector<int>> &flights, int src, int dst, int k)
{

    vector<vector<pair<int, int>>> graph(n);

    for (auto &&i : flights)
    {
        graph[i[0]].push_back({i[1], i[2]});
    }

    vector<pair<int, int>> path;
    vector<int> dist(n, INT_MAX);

    path.push_back({src, 0});
    dist[src] = 0;
    int stops = 0;
    while (!path.empty())
    {

        if (stops++ > k)
        {
            break;
        }
        for (int i = 0; i < path.size(); i++)
        {
            pair<int, int> temp = path.front();
            path.pop_back();

            for (auto &&i : graph[temp.first])
            {
                if (dist[i.first] > dist[temp.first] + i.second)
                {
                    dist[i.first] = dist[temp.first] + i.second;
                    path.push_back({i.first, i.second});
                }
            }
        }
    }

    return dist[dst] == INT_MAX ? -1 : dist[dst];
}