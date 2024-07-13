import java.util.Arrays;

class trieNode{
    trieNode[] childNodes;
    boolean lastChar = false;
    trieNode(){
        childNodes = new trieNode[26];
        Arrays.fill(childNodes,null);
    }

    public trieNode get(char ch) {
        return childNodes[ch-'a'];
    }
    void put(char ch, trieNode node){
        childNodes[ch-'a']=node;
    }
    boolean contains(char ch){
        return  childNodes[ch-'a']!=null;
    }
}
class trie_fun{
    trieNode root;
    trie_fun(){
        root=new trieNode();
    }
    void insert(String word){
        trieNode node = root;
        for(int i=0;i<word.length();i++){
            if(!node.contains(word.charAt(i))){
                node.put(word.charAt(i),new trieNode());
            }
            node=node.get(word.charAt(i));
        }
        node.lastChar=true;
    }
    boolean search(String word){
        trieNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return  false;
            }
        }
        return node.lastChar;
    }
    boolean startsWith(String prefix){
        trieNode node = root;
        for(int i=0;i<prefix.length();i++){
            if(node.contains(prefix.charAt(i))){
                node = node.get(prefix.charAt(i));
            }
            else{
                return  false;
            }
        }
        return true;
    }
}
public class Trie {
    public static void main(String[] args) {
        trie_fun obj = new trie_fun();
        obj.insert("apps");
        obj.insert("apple");
        obj.insert("apples");
        System.out.println(obj.search("apps"));
        System.out.println(obj.search("appl"));
        System.out.println(obj.startsWith("appl"));

    }
}
