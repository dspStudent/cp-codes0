//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList <Integer> res = new ArrayList <Integer>(0);
        if (root == null)
            return res; 
 
        //initializing a variable 'hd' with 0 for the root element.
        int hd = 0;
 
        //TreeMap which stores key value pair sorted on key value.
        Map<Integer, Integer> map = new TreeMap<>();
 
        //Queue to store tree nodes in level order traversal.
        Queue<Node> queue = new LinkedList<Node>();
 
        //assigning initialized horizontal distance value to 
        //root node and adding it to the queue.
        root.hd = hd;
        queue.add(root);
 
        while (!queue.isEmpty())
        {
            Node temp = queue.remove();
 
            //extracting the horizontal distance value from dequeued tree node.
            hd = temp.hd;
 
            //putting the dequeued tree node to TreeMap having key as  
            //horizontal distance. Every time we find a node having same
            //horizontal distance we need to replace the data in the map.
            map.put(hd, temp.data);
 
            //if the dequeued node has a left child, adding it to 
            //the queue with a horizontal distance hd-1.
            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            //if the dequeued node has a right child adding it to 
            //the queue with a horizontal distance hd+1.
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
 
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
 
        //traversing the map elements and storing nodes in the list.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            res.add(me.getValue());
        }
        //returning the output list.
        return res;
    }
}