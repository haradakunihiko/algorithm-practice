package graph.bst;

//TODO “r’†
public class BST {

	Node node;

	void insert(int o) {
		if (node == null) {
			node = new Node(0);
		} else {
			insert(node, o);
		}
	}

	Node insert(Node node, int o) {
		if (node != null) {
			if (node.val > o) {
				node.left = insert(node.left, o);
			} else {
				node.right = insert(node.right, o);
			}
		} else {
			node = new Node(o);
		}
		return node;
	}

	boolean find(int o) {
		if (node == null) {
			return false;
		} else {
			return find(node, o);
		}
	}

	boolean find(Node node, int o) {
		if (node == null) {
			return false;
		}
		if (node.val == o) {
			return true;
		} else if (node.val > o) {
			return find(node.left, o);
		} else {
			return find(node.right, o);
		}
	}

	Node remove(int o) {
		if (node == null) {
			return null;
		} else {
			return node = remove(node, o);
		}
	}

	Node remove(Node node, int o) {
		if (node.val == o) {
			
		}
	}

	private static class Node {
		Node(int val) {
			this.val = val;
		}

		int val;
		Node left;
		Node right;
	}
}
