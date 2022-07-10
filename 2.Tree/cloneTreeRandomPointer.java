class cloneTreeRandomPointer {
   class Tree{
        int data;
        Tree left,right,random;
        Tree(int d){
            data=d;
            left=null;
            right=null;
            random=null;
        }
	}

    public Tree cloneTree(Tree tree){
       createDuplicates(tree);
       setRandoms(tree);
       Tree dup = removeDuplicates(tree);
       return dup;
    }
    
    //post-order working
    public void createDuplicates(Tree node){
       if(node == null) return;
       
       createDuplicates(node.left);
       createDuplicates(node.right);
       
       Tree duplicate = new Tree(node.data);
       duplicate.right = null;
       duplicate.left = node.left;
       node.left = duplicate;
    }
    
    //post-order working
    public void setRandoms(Tree original){
        if(original == null) return;
        
        setRandoms(original.left.left);
        setRandoms(original.right);
        
        if(original.random != null){
            original.left.random = original.random.left;
        }
        
    }
    
    //post-order working
    public Tree removeDuplicates(Tree node){
        if(node == null) return null;
        
        Tree leftDup = removeDuplicates(node.left.left);
        Tree rightDup = removeDuplicates(node.right);
        
        Tree dup = node.left;
        node.left = node.left.left;
        dup.left = leftDup;
        dup.right= rightDup;
        
        return dup;
    }
}

