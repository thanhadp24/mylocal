package view1;

import bean.TreeNode;

/**
 * Given the root of a binary tree, invert(đối xứng từ root) the tree, and
 * return its root.
 * 
 * Input: root = [4,2,7,1,3,6,9] 
 * Output: [4,7,2,9,6,3,1]
 */

public class Ex06InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode bst = new TreeNode(4);
		bst.addRecursive(bst, 2);
		bst.addRecursive(bst, 7);
		bst.addRecursive(bst, 1);
		bst.addRecursive(bst, 3);
		bst.addRecursive(bst, 6);
		bst.addRecursive(bst, 9);

		TreeNode invert = invertTree(bst);
		invert.printFromLeftToRight(invert);		
	}

	private static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}


