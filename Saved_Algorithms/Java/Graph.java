    class Edge implements Comparable<Edge>{
        int a, b, cost;
        Edge(int a, int b, int cost){
            this.cost = cost; this.a = a; this.b =b;
        }
    
        public int compareTo(Edge x){
            return Integer.compare(this.cost, x.cost);
        }
    }

    private static class Node implements Comparable<Node>{
        private int num;
        private HashMap<Integer, Integer> map;
        private int cost;
        
        public Node(int num)
            {
            this.num = num;
            map = new HashMap<Integer, Integer>();
        }
        
        public int getNum()
            {
            return this.num;
        }
        
        public int getCost()
            {
            return this.cost;
        }
        //Adds an edge from this node to "to", unless an edge with a shorter
        //distance was found
        public boolean addEdge(int to, int distance)
            {
            if (map.get(to) == null)
                {
                map.put(to, distance);
                return true;
            }
            else
                {
                int oldDist = map.get(to);
                if (distance < oldDist)
                    {
                    map.put(to, distance);
                    return true;
                }
                else
                    {
                    return false;
                }
            }
        }
        
        public boolean removeEdge(int to)
            {
            if (map.get(to) == null)
                return false;
            map.remove(to);
            return true;
        }
       
        //returns the key (dest) of the smallest edge, or -1 if there are no edges
        public int findSmallestEdge()
            {
            int smallest = Integer.MAX_VALUE;
            int key = -1;
            Iterator iter = getMapIterator();
            while(iter.hasNext())
                {
                Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>)iter.next();
                if (pair.getValue() < smallest)
                    {
                    smallest = pair.getValue();
                    key = pair.getKey();
                }
                    
            }
            return key;
        }
        
        public int getEdge(int to)
            {
            if (map.get(to) != null)
                return map.get(to);
            return -1;
        }
        @Override
        public int compareTo(Node node2)
            {
            if (this.cost < node2.cost)
                return -1;
            else if (this.cost > node2.cost)
                return 1;
            else
                return 0;
        }
        
        public void setCost(int cost)
            {
            this.cost = cost;
        }
        public Iterator getMapIterator()
            {
            Iterator iter = this.map.entrySet().iterator();
            return iter;
        }
        
        public HashMap<Integer,Integer> getMap()
            {
            return this.map;
        }
    }

    private static void parseEdges(String s, Node[] nodeList)
        {
        String temp[] = s.split(" ");
        int node1 = Integer.parseInt(temp[0]);
        int node2 = Integer.parseInt(temp[1]);
        int dist = Integer.parseInt(temp[2]);
        assert(node1 > 0 && node1<nodeList.length);
        assert(node2 > 0 && node2<nodeList.length);
        Node n1 = nodeList[node1];
        Node n2 = nodeList[node2];
        n1.addEdge(node2, dist);
        n2.addEdge(node1, dist);
    }

    private static Node[] createNodeList(int numNodes)
        {
        Node[] nodeList = new Node[numNodes+1];
        for(int i=1;i<numNodes+1;i++)
            nodeList[i] = new Node(i);
        return nodeList;
    }

    private static boolean isInteresting(int i, int j, boolean[][] visited, int[][] matrix, int numRows, int numCols)
        {
        if (i < 0 || i >= numRows)
            return false;
        if (j < 0 || j >= numCols)
            return false;
        if (visited[i][j] == true)
            return false;
        if (matrix[i][j] == 0)
            return false;
        return true;
    }

    private static char[][] create2DArray(int numRows, int numCols, BufferedReader c) throws IOException
        {
        char[][] matrix = new char[numRows][numCols];
        for(int i=0;i<numRows;i++)
            {
            String s = c.readLine();
            for(int j=0;j<numCols;j++)
                {
                matrix[i][j] = s.charAt(j);
            }
        }
        return matrix;
    }