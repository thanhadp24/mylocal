package view1;

import bean.TreeNode;

/**
	Given a binary search tree (BST), find the lowest common ancestor (LCA) node 
	of two given nodes in the BST.
	
	According to the definition of LCA on Wikipedia: 
	“The lowest common ancestor is defined between two nodes p and q as the lowest node 
	in T that has both p and q as descendants (where we allow a node to be 
	a descendant of itself).”
	
	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	Output: 6
	Explanation: The LCA of nodes 2 and 8 is 6.
 
 */

public class Ex10LCA {
	public static void main(String[] args) {
		TreeNode bst = new TreeNode(6);
		bst.addRecursive(bst, 2);
		bst.addRecursive(bst, 8);
		bst.addRecursive(bst, 0);
		bst.addRecursive(bst, 4);
		bst.addRecursive(bst, 7);
		bst.addRecursive(bst, 9);
		bst.addRecursive(bst, 3);
		bst.addRecursive(bst, 5);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		TreeNode result = getLCA(bst, p, q);
		System.out.println(result.val);
		
	}
	
	private static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return root;
		}
		
		int pVal = p.val;
		int qVal = q.val;
		int rVal = root.val;
		
		if (qVal < rVal && pVal > rVal || qVal > rVal && pVal < rVal ) {
			return root;
		}
		
		if (qVal < rVal && pVal < rVal) {
			return getLCA(root.left, p, q);
		}
		
		if (qVal > rVal && pVal > rVal) {
			return getLCA(root.right, p, q);
		}
		
		return root;
	}
}
