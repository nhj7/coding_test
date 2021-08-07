package contest.m04;

public class Solution_1022 {
	public int sumRootToLeaf(TreeNode root) {
		return 0;
	}
	
	public static void recursiveNode( TreeNode node, int depth, int position, int[] input ){
		
		node.left = new TreeNode(input[depth*2+1]);
		node.right = new TreeNode(input[depth*2+2]);
	}
	
	public static void main(String[] args) {
		
		System.out.println(Math.pow(2, 3));
		System.out.println( 8 ^ 2 );
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}