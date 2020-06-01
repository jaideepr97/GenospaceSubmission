import java.util.*;

 
class DrugOrMechanism {
	String name;
	int id, type;

	public DrugOrMechanism(String name, int id, int type){
		this.name = name;
		this.id = id;
		this.type = type;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public int getType(){
		return type;
	}

	@Override
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            DrugOrMechanism obj = (DrugOrMechanism) object;
            if (this.id == obj.getId() && this.type == obj.getType() && this.name.equals(obj.getName())) {
                result = true;
            }
        }
        return result;
    }

}

class TrieNode {
    char data;     
    LinkedList<TrieNode> children; 
    TrieNode parent;
    boolean isEnd;
    Set<DrugOrMechanism> drugsandmechanismsatthisnode;
 
    public TrieNode(char c) {
    	data = c;
        children = new LinkedList();
        drugsandmechanismsatthisnode = new HashSet<>();
        isEnd = false;        
    }  
    
    public TrieNode getChild(char c) {
        if (children != null)
            for (TrieNode eachChild : children)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }
    
    protected List getWords() {
       List<DrugOrMechanism> list = new ArrayList();      
       if (isEnd) {
    	   list.addAll(drugsandmechanismsatthisnode);
       }
       
       if (children != null) {
	       for (int i=0; i< children.size(); i++) {
	          if (children.get(i) != null) {
	             list.addAll(children.get(i).getWords());
	          }
	       }
       }       
       return list; 
    }
    
}
 
class Trie {
    private TrieNode root;
 
    public Trie() {
        root = new TrieNode(' '); 
    }
 
    public void insert(String word, int id, int type) {

        TrieNode current = root; 
        TrieNode pre ;
        for (char ch : word.toCharArray()) {
        	pre = current;
            TrieNode child = current.getChild(ch);
            if (child != null) {
                current = child;
            } else {
                 current.children.add(new TrieNode(ch));
                 current = current.getChild(ch);
            }
        }

        current.drugsandmechanismsatthisnode.add(new DrugOrMechanism(word, id, type));
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;      
        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else {
                current = current.getChild(ch);    
            }
        }      
        if (current.isEnd == true) {       
            return true;
        }
        return false;
    }
    
    public List autocomplete(String prefix) {     
       TrieNode lastNode = root;
       for (int i = 0; i< prefix.length(); i++) {
	       lastNode = lastNode.getChild(prefix.charAt(i));	     
	       if (lastNode == null) 
	    	   return new ArrayList();      
       }
       
       return lastNode.getWords();
    }
}    
 
public class AutocompleteWithTrie {
	 public static void main(String[] args) {            
            Trie t = new Trie();            
            t.insert("amazon",1,0); 
            t.insert("amazon prime",2,1); 
            t.insert("amazon prime",2,1); 
			t.insert("amazing",3,1); 			 
            t.insert("amazing spider man",4,1); 
            t.insert("amazing spider man",12,0); 
            t.insert("amazed",5,0);
            t.insert("alibaba",6,0);
            t.insert("ali express",7,1);
            t.insert("ebay",8,0);
            t.insert("walmart",9,1);          
			List a= t.autocomplete("amazon");
			for (int i = 0; i < a.size(); i++) {
				DrugOrMechanism d = (DrugOrMechanism)a.get(i); 
				System.out.println(d.getName() );
			}
	  }
}
