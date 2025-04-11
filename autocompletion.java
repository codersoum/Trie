import java.util.*;

class Trie {
    Trie[] ch;
    int wc;
    boolean ended;

    Trie() 
    {
        ch = new Trie[26];
        wc = 0;
        ended = false;
    }
}

public class Main {
    
    public static void insert(Trie root, String s) {
        Trie trie = root;
        for (char c : s.toCharArray()) 
        {
            int ind = c - 'a';
            if (trie.ch[ind] == null) 
            {
                trie.ch[ind] = new Trie();
            }
            trie = trie.ch[ind];
            trie.wc++;
        }
        trie.ended = true;
    }

    public static void getAllWords(Trie root, ArrayList<String> list, String current) {
        if (root.ended) 
        {
           list.add(current);
        }
        for (int i = 0; i < 26; i++) 
        {
            if (root.ch[i] != null)
            {
                char ch = (char) (i + 'a');
                getAllWords(root.ch[i], list, current + ch);
            }
        }
    }

    public static boolean searchWords(Trie root, String word) {
        Trie trie = root;
        for (char c : word.toCharArray()) 
        {
            int ind = c - 'a';
            if (trie.ch[ind] == null) 
            {
                return false;
            }
            trie = trie.ch[ind];
        }
        return trie.ended;
    }

    public static void getAllWordsWithPrefix(Trie root, ArrayList<String> list, String prefix) 
    {
        Trie trie = root;
        for (char c : prefix.toCharArray()) 
        {
            int index = c - 'a';
            if (trie.ch[index] == null)
                return; 
            trie = trie.ch[index];
        }
        getAllWords(trie, list, prefix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie root = new Trie();
        while(true)
       {
        int n = sc.nextInt();
        sc.nextLine();
        switch (n) 
        {
            case 1: 
            {
                String s = sc.nextLine();
                insert(root, s);
                System.out.println("Inserted.");
                break;
            }
            case 2: 
            {
                ArrayList<String> list = new ArrayList<>();
                getAllWords(root, list, "");
                System.out.println("Words in Trie: " + list);
                break;
            }
            case 3: 
            {
                String word = sc.nextLine();
                boolean found = searchWords(root, word);
                System.out.println("Found? " + found);
                break;
            }
            case 4: 
            {
                ArrayList<String> list = new ArrayList<>();
                String prefix = sc.nextLine();
                getAllWordsWithPrefix(root, list, prefix);
                System.out.println("Words with prefix \"" + prefix + "\": " + list);
                break;
            }
            default:
             {
                 System.out.println("Invalid option.");
                 System.exit(0);
             }
        }
       }
    }
}
