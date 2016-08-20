	public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        Integer numops = Integer.parseInt(c.readLine());
        while(numops > 0)
            {
            //operations here
            numops--;
        }  
    }


	private static int charToIntLowercase(char c)
        {
        if (c >= 'a' && c<='z')
            return c-'a';
        return -1;
    }

    private static int[] generateFrequencyTable(String s)
        {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++)
            {
            int index = charToIntLowercase(s.charAt(i));
            if (index!=-1)
                freq[index]++;
        }
        return freq;
    }

    private static boolean[] generateBooleanTable(String s)
        {
        boolean[] table = new boolean[26];
        for(int i=0;i<s.length();i++)
            {
            int index = charToIntLowercase(s.charAt(i));
            if (index != -1)
                table[index] = true;
        }
        return table;
    }

    private static int[] generateFrequencyTableASCII(String s)
        {
        int[] freq = new int[128];
        for(int i=0;i<s.length();i++)
            {
            int index = s.charAt(i);
            freq[index]++;
        }
        return freq;
    }