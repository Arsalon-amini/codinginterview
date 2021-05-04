public class GetYoungestCommonAncestor {
    //O(d) time where d is the depth of the lower ancestor (deeper of the two)
    //O(1) space
    public static AncestralNode getYoungestCommonAncestor(
            AncestralNode topAncestor, AncestralNode descendantOne, AncestralNode descendantTwo){

        //return depths of each target node
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);


        if(depthOne > depthTwo)
            return iterateUpAncestorTree(descendantOne, descendantTwo, depthOne - depthTwo);
        else
            return iterateUpAncestorTree(descendantTwo, descendantOne, depthTwo - depthOne);
    }

    public static int getDescendantDepth(AncestralNode descendant, AncestralNode topAncestor){
       //calculates depth from leaf to root
        int depth = 0;
       while(descendant != topAncestor){
           depth++;
           descendant = descendant.ancestor;
       }
       return depth;
   }

   public static AncestralNode iterateUpAncestorTree(
           AncestralNode lowerDescendant, AncestralNode upperDescendant, int diff){
        //iterate up from lower descendant to upper descendant
        while(diff > 0){
            lowerDescendant = lowerDescendant.ancestor;
            diff--;
        }
        //iterate up until both lower and upper descendant nodes are pointing to same node
       //return this node as youngest common ancestor
        while(lowerDescendant != upperDescendant){
            lowerDescendant = lowerDescendant.ancestor;
            upperDescendant = upperDescendant.ancestor;
        }
        return lowerDescendant;
   }

    static class AncestralNode{
        public char name;
        public AncestralNode ancestor;

        AncestralNode(char name){
            this.name = name;
            this.ancestor = null;
        }
    }
}
