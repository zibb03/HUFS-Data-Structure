import java.io.*;
import java.util.Scanner;

class BinarySearchTree {

  class TreeNode {
    String key;
    TreeNode left;
    TreeNode right;
  }

  private TreeNode rootNode;

  public void insert(String x) {
    TreeNode node = new TreeNode();
    node.key = x;
    TreeNode current = rootNode;
    TreeNode parent = null;

    while (current != null) {
      parent = current;
      if (x.compareTo(current.key) < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    if (parent == null) {
      rootNode = node;
    } else if (x.compareTo(parent.key) < 0) {
      parent.left = node;
    } else {
      parent.right = node;
    }
  }

  public void delete(String x) {
    TreeNode current = rootNode;
    TreeNode parent = null;
    boolean isLeftChild = false;

    while (current != null && !current.key.equals(x)) {
      parent = current;
      if (x.compareTo(current.key) < 0) {
        isLeftChild = true;
        current = current.left;
      } else {
        current = current.right;
      }
    }

    if (current == null) {
      return;
    }

    // 자식이 없는 경우
    if (current.left == null && current.right == null) {
      if (parent == null) {
        rootNode = null;
      } else if (isLeftChild) {
        parent.left = null;
      } else {
        parent.right = null;
      }
    }

    // 한 개의 자식이 있는 경우
    else if (current.left == null) {
      if (parent == null) {
        rootNode = current.right;
      } else if (isLeftChild) {
        parent.left = current.right;
      } else {
        parent.right = current.right;
      }
    }
    else if (current.right == null) {
      if (parent == null) {
        rootNode = current.left;
      } else if (isLeftChild) {
        parent.left = current.left;
      } else {
        parent.right = current.left;
      }
    }

    // 두 개의 자식이 있는 경우
    else {
      TreeNode successor = getSuccessor(current);
      if (successor == current.right) {
        successor.left = current.left;
      } else {
        successor.right = current.right;
      }

      if (parent == null) {
        rootNode = successor;
      } else if (isLeftChild) {
        parent.left = successor;
      } else {
        parent.right = successor;
      }
    }
  }

  private TreeNode getSuccessor(TreeNode node) {
    TreeNode successor = node.right;
    TreeNode parent = node;

    while (successor.left != null) {
      parent = successor;
      successor = successor.left;
    }

    if (successor != node.right) {
      parent.left = successor.right;
      successor.right = node.right;
    }

    return successor;
  }

  public void print() {
    printNode(rootNode);
    System.out.println();
  }

  private void printNode(TreeNode node) {
    if (node == null) {
      return;
    }
    
    System.out.print("(");
    printNode(node.left);
    System.out.print(node.key);
    printNode(node.right);
    System.out.print(")");

    // printNode(node.left);
    // System.out.print(node.key);
    // printNode(node.right);
  }

}
	
class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		
		while (scan.hasNext()) {
			String command = scan.next();
			
			if (command.equals("I")) {
				String data = scan.next();
				tree.insert(data);
			} else if (command.equals("P")) {
				tree.print();
			}
		}
		scan.close();
	}
	
}