class Node{
    Node links[];
    boolean flag=false;
    Node(){
        links=new Node[26];
    }
    public void addLink(char c){
        links[c-'a']=new Node();
    }
    public Node getNext(char c){
        return links[c-'a'];
    }
    public boolean hasNextC(char c){
        return links[c-'a']!=null;
    }
    public boolean setEnd(){
        return flag=true;
    }
    public boolean isEnd(){
        return flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node tr=root;
        for(char c:word.toCharArray()){
            if(!tr.hasNextC(c))
            tr.addLink(c);
            tr=tr.getNext(c);
        }
        tr.setEnd();
    }
    
    public boolean search(String word) {
        Node tr=root;
        for(char c:word.toCharArray()){
            if(!tr.hasNextC(c))
            return false;
            tr=tr.getNext(c);
        }
        return tr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node tr=root;
        for(char c:prefix.toCharArray()){
            if(!tr.hasNextC(c))
            return false;
            tr=tr.getNext(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */