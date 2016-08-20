    private static int[] createArray(String str, int arrayLength)
        {
        int[] array = new int[arrayLength];
        Scanner s = new Scanner(str);
        for(int i=0;i<arrayLength;i++)
            {
            if (s.hasNextInt())
                {
                array[i] = s.nextInt();
            }
            else
                {
                System.out.println("ERROR:ArrayLength is bigger than the array found");
                return null;
            }   
        }
        if (s.hasNextInt())
            {
            System.out.println("ERROR: Input array is larger than ArrayLength");
            return null;
        }
        return array;
    }

    private static int[] createArray(String str, int arrayLength)
        {   
        int[] array = new int[arrayLength];
        String[] split = str.split(" ");
        if (split.length != arrayLength)
        {
            System.out.println("ERROR: ArrayLength is inconsistent with string");
            System.exit(-1);
        }
        for(int i=0;i<arrayLength;i++)
            array[i] = Integer.parseInt(split[i]);
        return array;
    }
    
private static HashSet<Integer> createHashSet(String str, int length)
    {
    HashSet<Integer> set = new HashSet<Integer>();
    Scanner s = new Scanner(str);
    for(int i=0;i<length;i++)
        {
        if(s.hasNextInt())
            set.add(s.nextInt());
        else
            {
            System.out.println("ERROR: length is bigger than the array found. Returning NULL");
            return null;
        }              
        
    }
    if (s.hasNextInt())
        {
        System.out.println("ERROR: Input array is larger than length");
        return null;
    }
    return set;
}

    private static void NOT_REACHED()
        {
        System.out.println("Executed an unreachable statement!");
        System.exit(1);
    }

    private static void printArray(int[] array)
        {
        for(int i=0;i<array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    private static void printList(List<Integer> list)
        {
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
    private static int arrayToInt(Integer[] array, int start, int end)
        {
        int sum = 0;
        for(int i=end;i>=start;i--)
            {
            int power = end-i;
            sum+=array[i] * Math.pow(10, power);
        }
        return sum;
    }

    private static void print2DArray(char[][] matrix, int numRows, int numCols)
        {
        for(int i=0;i<numRows;i++)
            {
            for(int j=0;j<numCols;j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        } 
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

    private static void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void mapPutHelper(TreeMap<Integer, List<Segment>> map, int key, Segment val) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<Segment>());
        List<Segment> list = map.get(key);
        list.add(val);
    }
   
   
    private static void mapPutHelper(HashMap<String, List<String>> map, String key, String val) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<String>());
        List<String> list = map.get(key);
        list.add(val);
    }