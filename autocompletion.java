import java.util.*;
import java.lang.*;

class Trie{
    Trie ()
    {
        Trie [] ch=new Trie[26];
        int wc=0;
        boolean ended=false;
    }
}
public class Main
{
    public static void insert(Trie root,String s)
    {
       Trie trie=root;
       for(char c: s.toCharArray())
       {
           int ind=c-'a';
           if(te.ch[ind]==null)
           {
               te.ch[ind]=new Trie();
           }
           te=te.ch[ind];
           te.wc++;
       }
       te.ended=true;
    }
    public static void getallwords(Trie root,ArrayList<String> li,String te)
    {
      if(root.ended==true)
      li.add(te);
      for(int i=0;i<26;i++)
      {
        if(root.ch[i]!=null)
        char ch=(char)(i+'a');
        getallwords(root.ch[i],li,te+ch);
      }
    }
     public static boolean searchwords(Trie root,String te)
    {
      Trie trie=root;
      for(char c:te.toCharArray())
      {
        int ind=c-'a';
        if(trie.ch[ind]==null)
        {
         return false;
        }
        te=te.ch[ind];
      }
      return te.ended;
    }
     public static void getallwordswithPrefix(Trie root,ArrayList<String>li,String te)
    {
      Trie trie=root;
      for(char c:te.toCharArray())
      {
        int ind=c-'a';
        if(trie.ch[ind]==null)
        {
         return false;
        }
        if(trie.ch[index]==null){
                return;
            }
            trie=trie.ch[index];
        }
        getAllWords(trie,li,te);
    }
	public static void main(String[] args) 
	{
	  Scanner sc= new Scanner(System.in);
	  Trie root=new Trie();
	  int n=sc.nextInt();
	  sc.nextLine();
	  switch(n)
	  {
	    case 1: String s=sc.nextLine();
	            insert(root,s);
	            break;
	   case 2:ArrayList<String>li=new ArrayList<>();
	          String te=sc.nextLine();
	          getallwords(root,li,te);
	          break;
	   case 3:String te=sc.nextLine();
	          searchwords(root,te);
	          break;
	   case 4:ArrayList<String>li=new ArrayList<>();
	         String te=sc.nextLine();
	         getallwordswithPrefix(root,li,te);
	         break;
	  } 
	}
}